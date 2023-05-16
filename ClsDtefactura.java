/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class ClsDtefactura {

    public ClsDteReceptor getReceptor() {
        return receptor;
    }

    public void setReceptor(ClsDteReceptor receptor) {
        this.receptor = receptor;
    }

    public ClsDteEmisor getEmisor() {
        return emisor;
    }

    public void setEmisor(ClsDteEmisor emisor) {
        this.emisor = emisor;
    }

    public ClsDteDocumento[] getCuerpoDocumento() {
        return cuerpoDocumento;
    }

    public void setCuerpoDocumento(ClsDteDocumento[] cuerpoDocumento) {
        this.cuerpoDocumento = cuerpoDocumento;
    }

    public ClsDteDocumentoIva getIva() {
        return iva;
    }

    public void setIva(ClsDteDocumentoIva iva) {
        this.iva = iva;
    }

    public ClsDteresumen getResumen() {
        return resumen;
    }

    public void setResumen(ClsDteresumen resumen) {
        this.resumen = resumen;
    }

    public ClsDteTotales getTotales() {
        return totales;
    }

    public void setTotales(ClsDteTotales totales) {
        this.totales = totales;
    }

    public List<ClsDtttributo> getTributos() {
        return tributos;
    }

    public void setTributos(List<ClsDtttributo> tributos) {
        this.tributos = tributos;
    }

    public ClsDteitentificacion getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(ClsDteitentificacion identificacion) {
        this.identificacion = identificacion;
    }

    public ClsDteExtension getExtension() {
        return extension;
    }

    public void setExtension(ClsDteExtension extension) {
        this.extension = extension;
    }

    public ClsDtefactura(ClsDteReceptor receptor, ClsDteEmisor emisor, ClsDteDocumento[] cuerpoDocumento, ClsDteDocumentoIva iva, ClsDteresumen resumen, ClsDteTotales totales, List<ClsDtttributo> tributos, ClsDteitentificacion identificacion, ClsDteExtension extension) {
        this.receptor = receptor;
        this.emisor = emisor;
        this.cuerpoDocumento = cuerpoDocumento;
        this.iva = iva;
        this.resumen = resumen;
        this.totales = totales;
        this.tributos = tributos;
        this.identificacion = identificacion;
        this.extension = extension;
    }
        private ClsDteReceptor receptor;
    private ClsDteEmisor emisor;
    private ClsDteDocumento[] cuerpoDocumento;
    private ClsDteDocumentoIva iva;
    private ClsDteresumen resumen;
    private ClsDteTotales totales;
    private List<ClsDtttributo> tributos;
    private ClsDteitentificacion identificacion;
    private ClsDteExtension extension;

   

   
}
