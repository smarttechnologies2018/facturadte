/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author Usuario
 */
public class ClsDteDocumentoIva {
    private Double iva;
    private Double monto;
    private Double ivaNoRetenido;

    public ClsDteDocumentoIva(Double iva, Double monto, Double ivaNoRetenido) {
        this.iva = iva;
        this.monto = monto;
        this.ivaNoRetenido = ivaNoRetenido;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getIvaNoRetenido() {
        return ivaNoRetenido;
    }

    public void setIvaNoRetenido(Double ivaNoRetenido) {
        this.ivaNoRetenido = ivaNoRetenido;
    }
    
}
