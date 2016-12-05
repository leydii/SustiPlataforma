package pweb.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pweb.business.Libro;
import pweb.business.Venta;

import pweb.business.Venta;

public class VentaDB {
    
    public static int insert(Venta venta) 
    {
        Connection connection = null;
        PreparedStatement ps = null;        

        try 
        {
            // cargar el controlador
            Class.forName("org.sqlite.JDBC");

            // crear una conexion             
            String dbURL = "jdbc:sqlite:D:/db/LibrosDB.db";
            connection = DriverManager.getConnection(dbURL);      

            String query = "INSERT INTO " 
                         + "VENTAS (CODLIBRO, TITULAR, NUMTARJETA, TOTAL) "
                         + "VALUES (?, ?, ?, ?)";

            ps = connection.prepareStatement(query);                        
            ps.setString(1, venta.getCodigoLibro());
            ps.setString(2, venta.getTitularTarjeta());
            ps.setString(3, venta.getNumeroTarjeta());
            ps.setDouble(4, venta.getTotalVenta());

            return ps.executeUpdate();            
        } 
        catch (ClassNotFoundException e) {
            System.out.println(e);
            return 0;
        }         
        catch (SQLException e) {
            System.out.println(e);
            return 0;
        } 
        finally {
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(connection);            
        }
    }    
    
    public static Venta selectVenta(String codigo) 
    {
        Connection connection = null;
        PreparedStatement ps = null;             
        ResultSet rs = null;
        
        try 
        {
            // cargar el controlador
            Class.forName("org.sqlite.JDBC");

            // crear una conexion             
            String dbURL = "jdbc:sqlite:D:/db/LibrosDB.db";
            connection = DriverManager.getConnection(dbURL); 
            
            // crear consulta
            String query = "SELECT * FROM VENTAS "
                         + "WHERE CODIGO = ?";
            
            ps = connection.prepareStatement(query);
            ps.setString(1, codigo);            
            rs = ps.executeQuery();
            
            Venta venta = null;
            
            if (rs.next()) {
                venta = new Venta();
                venta.setCodigoVenta(rs.getInt("CODIGO"));
                venta.setCodigoLibro(rs.getString("CODLIBRO"));
                venta.setTitularTarjeta(rs.getString("TITULAR"));
                venta.setNumeroTarjeta(rs.getString("NUMTARJETA"));
                venta.setTotalVenta(rs.getDouble("TOTAL"));
                                              
            }
            return venta;            
        } 
        catch (ClassNotFoundException e) {
            System.out.println(e);
            return null;
        }         
        catch (SQLException e) {
            System.out.println(e);
            return null;
        }             
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(connection);  
        }    
    }   
    
    public static ArrayList<Venta> selectVentas() 
    {
         Connection connection = null;
        PreparedStatement ps = null;             
        ResultSet rs = null;
        
        try 
        {
            // cargar el controlador
            Class.forName("org.sqlite.JDBC");

            // crear una conexion             
            String dbURL = "jdbc:sqlite:D:/db/LibrosDB.db";
            connection = DriverManager.getConnection(dbURL);

            // crear consulta
            String query = "SELECT * FROM VENTAS";            
            ps = connection.prepareStatement(query);            
            rs = ps.executeQuery();            
            
            ArrayList<Venta> ventas = new ArrayList<Venta>();
            Venta venta = null;            
            
            while (rs.next()) {                
                venta = new Venta();
                
                venta.setCodigoVenta(rs.getInt("CODIGO"));
                venta.setCodigoLibro(rs.getString("CODLIBRO"));
                venta.setTitularTarjeta(rs.getString("TITULAR"));
                venta.setNumeroTarjeta(rs.getString("NUMTARJETA"));
                venta.setTotalVenta(rs.getDouble("TOTAL"));
                ventas.add(venta);
            }
            return ventas;            
        } 
        catch (ClassNotFoundException e) {
            System.out.println(e);
            return null;
        }         
        catch (SQLException e) {
            System.out.println(e);
            return null;
        }             
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(connection);  
        }
    } 

    
}
