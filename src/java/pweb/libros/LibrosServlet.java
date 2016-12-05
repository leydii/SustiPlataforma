package pweb.libros;

import com.sun.xml.ws.tx.coord.common.PendingRequestManager;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pweb.business.Libro;
import pweb.business.Usuario;
import pweb.business.Venta;
import pweb.data.LibroDB;
import pweb.data.VentaDB;

public class LibrosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "";            
        String message = "";
        
        // reuperar accion actual 
        String action = request.getParameter("action");
        
        if (action == null) 
        {
            url = "index.jsp";
            action = "";  
        }

        // realizar accion y establecer la URL a una pagina apropiada
        if (action.equals("login")) 
        {
            // obteniendo parametros
            String user = request.getParameter("user");        
            String pass  = request.getParameter("pass");   
            
            Usuario usuario = new Usuario();
            usuario.setUsuario(user);
            usuario.setPassword(pass);
            
            if (pweb.data.UsuarioDB.Validar(usuario)) 
            {                           
                if (user.equalsIgnoreCase("user")) 
                {                       
                   ArrayList<Libro> listaLibros = LibroDB.selectLibros();
                request.setAttribute("listaLibros", listaLibros);                
                url = "/libros.jsp";           
                }
                else if (user.equalsIgnoreCase("admin")) 
                {               
                    ArrayList<Venta> listaVentas = VentaDB.selectVentas();
                request.setAttribute("listaVentas", listaVentas); 
                    url = "/ventas.jsp";                                
                }                                    
            }
            else
            {
                url = "/index.jsp";    
                message = "Usuario o contraseña incorrecta, por favor ingrese de nuevo.";                        
                request.setAttribute("message", message);
            }            
        }
        else if(action.equals("comprar"))
        {    
            String codigo = request.getParameter("codigo");
            request.setAttribute("codigo", codigo);
            url = "/pago.jsp";
        }
        else if(action.equals("pagar"))
        {    
             String codigo = request.getParameter("codigo");                                   
            String nombres = request.getParameter("nombres");
            String numtarjeta = request.getParameter("numtarjeta");            
            
            Libro libro = LibroDB.selectLibro(codigo);   
            
            Venta venta = new Venta();            
            venta.setCodigoLibro(codigo);
            venta.setTitularTarjeta(nombres);
            venta.setNumeroTarjeta(numtarjeta);
            venta.setTotalVenta(libro.getPrecio());                                
            VentaDB.insert(venta);            
            
            request.setAttribute("libro", libro);
            request.setAttribute("nombres", nombres);
            request.setAttribute("numtarjeta", "************" + numtarjeta.substring(12));
            url = "/confirmacion.jsp";                        
        }        
        else if (action.equals("ventas"))
        {   
            ArrayList<Venta> listaVentas = VentaDB.selectVentas();
            request.setAttribute("listaVentas", listaVentas);
            url = "/ventas.jsp";
        }
        else if (action.equals("resumen"))
        {   
            String codventa = request.getParameter("codigoVenta");                                   
            Venta venta = VentaDB.selectVenta(codventa);
            Libro libro = LibroDB.selectLibro(venta.getCodigoLibro());
            
            String numTarjeta = venta.getNumeroTarjeta();
            numTarjeta = "************" + numTarjeta.substring(12);
            venta.setNumeroTarjeta(numTarjeta);
            
            request.setAttribute("libro", libro);
            request.setAttribute("venta", venta);
            
            url = "/resumen.jsp";   
        }
        
        // forward request and response objects to specified URL
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);  
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
