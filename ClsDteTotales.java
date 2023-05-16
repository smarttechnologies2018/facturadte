/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author Usuario
 */
public class ClsDteTotales {
    private Double montoTotal;
    private Double montoGravado;
    private Double montoExento;
    private Double montoIva;
    private Double montoDescuento;

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Double getMontoGravado() {
        return montoGravado;
    }

    public void setMontoGravado(Double montoGravado) {
        this.montoGravado = montoGravado;
    }

    public Double getMontoExento() {
        return montoExento;
    }

    public void setMontoExento(Double montoExento) {
        this.montoExento = montoExento;
    }

    public Double getMontoIva() {
        return montoIva;
    }

    public void setMontoIva(Double montoIva) {
        this.montoIva = montoIva;
    }

    public Double getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(Double montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    public ClsDteTotales(Double montoTotal, Double montoGravado, Double montoExento, Double montoIva, Double montoDescuento) {
        this.montoTotal = montoTotal;
        this.montoGravado = montoGravado;
        this.montoExento = montoExento;
        this.montoIva = montoIva;
        this.montoDescuento = montoDescuento;
    }
    
}
