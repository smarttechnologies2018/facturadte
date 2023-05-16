/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import Negocio.ClsVenta;
import java.util.Date;

/**
 *
 * @author henry
 */
public class ClsEntidadDetalleVenta extends ClsEntidadVenta{

    private String strIdVenta;
     private int StrCodinv;

    public int getStrCodinv() {
        return StrCodinv;
    }

    public void setStrCodinv(int StrCodinv) {
        this.StrCodinv = StrCodinv;
    }
    private String strIdProducto;
    private String strCantidadDet;
    private String strCostoDet;
    private String strPrecioDet;
    private String strTotalDet;
    private String strContenedor;
    private String strUtilidad;
    private String strNombre;
    private String StrSubPrecio;

    public String getStrControl() {
        return StrControl;
    }

    public void setStrControl(String StrControl) {
        this.StrControl = StrControl;
    }
        private String StrControl;
    public String getStrSubPrecio() {
        return StrSubPrecio;
    }

    public void setStrSubPrecio(String StrSubPrecio) {
        this.StrSubPrecio = StrSubPrecio;
    }
       
    private Date StrDetalleFechaVenta;

    private String idempleado;
 private String StrtTipoImpuesto;
    public String getStrtTipoImpuesto() {
        return StrtTipoImpuesto;
    }

    public void setStrtTipoImpuesto(String StrtTipoImpuesto) {
        this.StrtTipoImpuesto = StrtTipoImpuesto;
    }
       
    

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    

    public Date getStrDetalleFechaVenta() {
        return StrDetalleFechaVenta;
    }

    public void setStrDetalleFechaVenta(Date StrDetalleFechaVenta) {
        this.StrDetalleFechaVenta = StrDetalleFechaVenta;
    }

    public String getStrNombre() {
        return strNombre;
    }

    public void setStrNombre(String strNombre) {
        this.strNombre = strNombre;
    }

    public String getStrUtilidad() {
        return strUtilidad;
    }

    public void setStrUtilidad(String strUtilidad) {
        this.strUtilidad = strUtilidad;
    }

    public String getStrContenedor() {
        return strContenedor;
    }

    public void setStrContenedor(String strContenedor) {
        this.strContenedor = strContenedor;
    }

    private String strTcant;

    public String getStrTcant() {
        return strTcant;
    }

    public void setStrTcant(String strTcant) {
        this.strTcant = strTcant;
    }

    public String getStrIdVenta() {
        return strIdVenta;
    }

    public void setStrIdVenta(String strIdVenta) {
        this.strIdVenta = strIdVenta;
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

    public String getStrCostoDet() {
        return strCostoDet;
    }

    public void setStrCostoDet(String strCostoDet) {
        this.strCostoDet = strCostoDet;
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

}
