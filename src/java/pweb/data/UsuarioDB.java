package pweb.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pweb.business.Usuario;

public class UsuarioDB
{   
    public static boolean Validar(Usuario usuario) 
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
            
            String query = "SELECT * FROM USUARIOS "
                         + "WHERE USUARIO = ? AND PASSWORD = ?";
            
            ps = connection.prepareStatement(query);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPassword());
            rs = ps.executeQuery();
            return rs.next();
        } 
        catch (ClassNotFoundException e) {
            System.out.println(e);
            return false;
        }         
        catch (SQLException e) {
            System.out.println(e);
            return false;
        }             
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(connection);  
        }     
    }    
}
