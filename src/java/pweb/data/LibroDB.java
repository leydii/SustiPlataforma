package pweb.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pweb.business.Libro;

public class LibroDB {         
    
    public static Libro selectLibro(String codigo) 
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
            String query = "SELECT * FROM LIBROS "
                         + "WHERE CODIGO = ?";
            
            ps = connection.prepareStatement(query);
            ps.setString(1, codigo);            
            rs = ps.executeQuery();
            
            Libro libro = null;
            
            if (rs.next()) {
                libro = new Libro();
                libro.setCodigo(rs.getString("CODIGO"));
                libro.setTitulo(rs.getString("TITULO"));
                libro.setAutor(rs.getString("AUTOR"));
                libro.setGenero(rs.getString("GENERO"));
                libro.setPrecio(rs.getDouble("PRECIO"));                               
            }
            return libro;            
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
    
    public static ArrayList<Libro> selectLibros() 
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
            String query = "SELECT * FROM LIBROS";            
            ps = connection.prepareStatement(query);            
            rs = ps.executeQuery();            
            
            ArrayList<Libro> libros = new ArrayList<Libro>();
            Libro libro = null;            
            
            while (rs.next()) {                
                libro = new Libro();
                libro.setCodigo(rs.getString("CODIGO"));
                libro.setTitulo(rs.getString("TITULO"));
                libro.setAutor(rs.getString("AUTOR"));
                libro.setGenero(rs.getString("GENERO"));
                libro.setPrecio(rs.getDouble("PRECIO"));                               
                libros.add(libro);
            }
            return libros;            
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
