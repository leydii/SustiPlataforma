package pweb.business;

import java.io.Serializable;

public class Libro implements Serializable {

    private String Codigo;
    private String Titulo;
    private String Autor;
    private String Genero;
    private double Precio;

    public Libro() {
        this.Codigo = "";
        this.Titulo = "";
        this.Autor = "";
        this.Genero = "";
        this.Precio = 0;
    }

    public Libro(String Codigo, String Titulo, String Autor, String Genero, double Precio) {
        this.Codigo = Codigo;
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Genero = Genero;
        this.Precio = Precio;
    }
    
    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }    
}
