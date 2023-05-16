/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author DAYPER PERU
 */
public class ClsEntidadDetalleCompra extends ClsEntidadCompra{
    private String StrTipoImpuesto;

    public String getStrTipoImpuesto() {
        return StrTipoImpuesto;
    }

    public void setStrTipoImpuesto(String StrTipoImpuesto) {
        this.StrTipoImpuesto = StrTipoImpuesto;
    }
    private String strIdCompra;
    private String strIdProducto;
    private String strCantidadDet;
    private String strPrecioDet;
    private String strTotalDet;
    private Double StrCostoSin;
    private Double StrTotal2;
       // private String StrCostoSin;
           // private Double StrCostoSin;
private Double TotalSin;

private Double StrFracc;

    public Double getStrCostoSin() {
        return StrCostoSin;
    }

    public void setStrCostoSin(Double StrCostoSin) {
        this.StrCostoSin = StrCostoSin;
    }

    public Double getTotalSin() {
        return TotalSin;
    }

    public void setTotalSin(Double TotalSin) {
        this.TotalSin = TotalSin;
    }

    private String strContenedor;
    private String strTunidad;
    private String strNombreProducto;
    public double getStrFracc() {
        return StrFracc;
    }

    public void setStrFracc(double StrFracc) {
        this.StrFracc = StrFracc;
    }
      

    public String getStrNombreProducto() {
        return strNombreProducto;
    }

    public void setStrNombreProducto(String strNombreProducto) {
        this.strNombreProducto = strNombreProducto;
    }

    public String getStrTunidad() {
        return strTunidad;
    }

    public void setStrTunidad(String strTunidad) {
        this.strTunidad = strTunidad;
    }

    public String getStrContenedor() {
        return strContenedor;
    }

    public void setStrContenedor(String strContenedor) {
        this.strContenedor = strContenedor;
    }

    public String getStrIdCompra() {
        return strIdCompra;
    }

    public void setStrIdCompra(String strIdCompra) {
        this.strIdCompra = strIdCompra;
    }

    public String getStrIdProducto() {
        return strIdProducto;
    }

    public void setStrIdProducto(String strIdProducto) {
        this.strIdProducto = strIdProducto;
    }

    public String getStrCantidadDet() {
        return strCantidadDet;
    }

    public void setStrCantidadDet(String strCantidadDet) {
        this.strCantidadDet = strCantidadDet;
    }

    public String getStrPrecioDet() {
        return strPrecioDet;
    }

    public void setStrPrecioDet(String strPrecioDet) {
        this.strPrecioDet = strPrecioDet;
    }

    public String getStrTotalDet() {
        return strTotalDet;
    }

    public void setStrTotalDet(String strTotalDet) {
        this.strTotalDet = strTotalDet;
    }
public Double getStrTotal2() {
        return StrTotal2;
    }

    public void setStrTotal2(Double StrTotal2) {
        this.StrTotal2 = StrTotal2;
    }
}
