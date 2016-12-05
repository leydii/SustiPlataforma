package pweb.business;

import java.io.Serializable;

public class Usuario implements Serializable {
    
    private String Usuario;
    private String Password;

    public Usuario() 
    {
        this.Usuario = "";
        this.Password = "";
    }

    public Usuario(String Usuario, String Password) {
        this.Usuario = Usuario;
        this.Password = Password;
    }    

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
