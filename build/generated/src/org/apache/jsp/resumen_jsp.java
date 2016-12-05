package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class resumen_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>Plataforma Web - Examen Final</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles/main.css\" type=\"text/css\"/>    \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <br>               \n");
      out.write("        <h2>RESUMEN DE VENTA</h2>\n");
      out.write("        <label>Titulo:</label>\n");
      out.write("        <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${libro.titulo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span><br>\n");
      out.write("\n");
      out.write("        <label>Autor:</label>\n");
      out.write("        <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${libro.autor}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span><br>   \n");
      out.write("\n");
      out.write("        <label>Genero:</label>\n");
      out.write("        <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${libro.genero}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span><br><br>          \n");
      out.write("\n");
      out.write("        <h2>INFORMACION DE PAGO</h2>\n");
      out.write("        <label>Titular:</label>\n");
      out.write("        <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${venta.titularTarjeta}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span><br>       \n");
      out.write("\n");
      out.write("        <label>Num. Tarjeta:</label>\n");
      out.write("        <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${venta.numeroTarjeta}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span><br>     \n");
      out.write("\n");
      out.write("        <label>Total:</label>\n");
      out.write("        <span>$");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${libro.precio}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span><br>\n");
      out.write("        \n");
      out.write("        <p>Para volver a la pagina anterior, dale click en el\n");
      out.write("        boton regresar en el explorador o el boton Regresar \n");
      out.write("        que se muestra debajo.</p>\n");
      out.write("\n");
      out.write("        <form action=\"\" method=\"post\">\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"back\">\n");
      out.write("            <input type=\"submit\" value=\"Regresar\">\n");
      out.write("    </form>    \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
