package Entidad;

/**
 *
 * @author JoseRamos
 */
public class ClsEntidadKardexProducto {
    
    private String StrDetalle;
    private String StrNombreProducto;
    private int StrCantidad;
    private double DoublePrecio;
    private double DoubleTotal;

    public String getStrDetalle() {
        return StrDetalle;
    }

    public void setStrDetalle(String StrDetalle) {
        this.StrDetalle = StrDetalle;
    }

    public String getStrNombreProducto() {
        return StrNombreProducto;
    }

    public void setStrNombreProducto(String StrNombreProducto) {
        this.StrNombreProducto = StrNombreProducto;
    }

    public int getStrCantidad() {
        return StrCantidad;
    }

    public void setStrCantidad(int StrCantidad) {
        this.StrCantidad = StrCantidad;
    }

    public double getDoublePrecio() {
        return DoublePrecio;
    }

    public void setDoublePrecio(double DoublePrecio) {
        this.DoublePrecio = DoublePrecio;
    }

    public double getDoubleTotal() {
        return DoubleTotal;
    }

    public void setDoubleTotal(double DoubleTotal) {
        this.DoubleTotal = DoubleTotal;
    }
}