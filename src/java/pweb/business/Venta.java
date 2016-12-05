package pweb.business;

import java.io.Serializable;

public class Venta implements Serializable {
    
    private int CodigoVenta;
    private String CodigoLibro;
    private String TitularTarjeta;
    private String NumeroTarjeta;
    private double TotalVenta;

    public Venta() {
        this.CodigoVenta = 0;
        this.CodigoLibro = "";
        this.TitularTarjeta = "";
        this.NumeroTarjeta = "";
        this.TotalVenta = 0;        
    }

    public Venta(String CodigoLibro, String TitularTarjeta, String NumeroTarjeta, double TotalVenta) {
        this.CodigoVenta = 0;
        this.CodigoLibro = CodigoLibro;
        this.TitularTarjeta = TitularTarjeta;
        this.NumeroTarjeta = NumeroTarjeta;
        this.TotalVenta = TotalVenta;
    }

    public int getCodigoVenta() {
        return CodigoVenta;
    }

    public void setCodigoVenta(int CodigoVenta) {
        this.CodigoVenta = CodigoVenta;
    }

    public String getCodigoLibro() {
        return CodigoLibro;
    }

    public void setCodigoLibro(String CodigoLibro) {
        this.CodigoLibro = CodigoLibro;
    }

    public String getTitularTarjeta() {
        return TitularTarjeta;
    }

    public void setTitularTarjeta(String TitularTarjeta) {
        this.TitularTarjeta = TitularTarjeta;
    }

    public String getNumeroTarjeta() {
        return NumeroTarjeta;
    }

    public void setNumeroTarjeta(String NumeroTarjeta) {
        this.NumeroTarjeta = NumeroTarjeta;
    }

    public double getTotalVenta() {
        return TotalVenta;
    }

    public void setTotalVenta(double TotalVenta) {
        this.TotalVenta = TotalVenta;
    }    
}
