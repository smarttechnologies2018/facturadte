/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import java.util.List;
import java.util.List;
import Entidad.ClsDtttributo;

/**
 *
 * @author Usuario
 */
public class ClsDteresumen {
    private int condicionOperacion;
    private double descuExenta;
    private double descuGravada;
    private double descuNoSuj;
    private double ivaPerci1;
    private double ivaRete1;
    private double montoTotalOperacion;
    private String numPagoElectronico;
    private double porcentajeDescuento;
    private double reteRenta;
    private double saldoFavor;
    private double subTotal;
    private double subTotalVentas;
    private double totalDescu;
    private double totalExenta;
    private double totalGravada;
    private String totalLetras;
    private double totalNoGravado;
    private double totalNoSuj;
    private double totalPagar;
    private List<ClsDtttributo> tributos;
    private List<ClsDtepago> pagos;

    public ClsDteresumen(int condicionOperacion, double descuExenta, double descuGravada, double descuNoSuj, double ivaPerci1, double ivaRete1, double montoTotalOperacion, String numPagoElectronico, double porcentajeDescuento, double reteRenta, double saldoFavor, double subTotal, double subTotalVentas, double totalDescu, double totalExenta, double totalGravada, String totalLetras, double totalNoGravado, double totalNoSuj, double totalPagar, List<ClsDtttributo> tributos, List<ClsDtepago> pagos) {
        this.condicionOperacion = condicionOperacion;
        this.descuExenta = descuExenta;
        this.descuGravada = descuGravada;
        this.descuNoSuj = descuNoSuj;
        this.ivaPerci1 = ivaPerci1;
        this.ivaRete1 = ivaRete1;
        this.montoTotalOperacion = montoTotalOperacion;
        this.numPagoElectronico = numPagoElectronico;
        this.porcentajeDescuento = porcentajeDescuento;
        this.reteRenta = reteRenta;
        this.saldoFavor = saldoFavor;
        this.subTotal = subTotal;
        this.subTotalVentas = subTotalVentas;
        this.totalDescu = totalDescu;
        this.totalExenta = totalExenta;
        this.totalGravada = totalGravada;
        this.totalLetras = totalLetras;
        this.totalNoGravado = totalNoGravado;
        this.totalNoSuj = totalNoSuj;
        this.totalPagar = totalPagar;
        this.tributos = tributos;
        this.pagos = pagos;
    }

    public int getCondicionOperacion() {
        return condicionOperacion;
    }

    public void setCondicionOperacion(int condicionOperacion) {
        this.condicionOperacion = condicionOperacion;
    }

    public double getDescuExenta() {
        return descuExenta;
    }

    public void setDescuExenta(double descuExenta) {
        this.descuExenta = descuExenta;
    }

    public double getDescuGravada() {
        return descuGravada;
    }

    public void setDescuGravada(double descuGravada) {
        this.descuGravada = descuGravada;
    }

    public double getDescuNoSuj() {
        return descuNoSuj;
    }

    public void setDescuNoSuj(double descuNoSuj) {
        this.descuNoSuj = descuNoSuj;
    }

    public double getIvaPerci1() {
        return ivaPerci1;
    }

    public void setIvaPerci1(double ivaPerci1) {
        this.ivaPerci1 = ivaPerci1;
    }

    public double getIvaRete1() {
        return ivaRete1;
    }

    public void setIvaRete1(double ivaRete1) {
        this.ivaRete1 = ivaRete1;
    }

    public double getMontoTotalOperacion() {
        return montoTotalOperacion;
    }

    public void setMontoTotalOperacion(double montoTotalOperacion) {
        this.montoTotalOperacion = montoTotalOperacion;
    }

    public String getNumPagoElectronico() {
        return numPagoElectronico;
    }

    public void setNumPagoElectronico(String numPagoElectronico) {
        this.numPagoElectronico = numPagoElectronico;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getReteRenta() {
        return reteRenta;
    }

    public void setReteRenta(double reteRenta) {
        this.reteRenta = reteRenta;
    }

    public double getSaldoFavor() {
        return saldoFavor;
    }

    public void setSaldoFavor(double saldoFavor) {
        this.saldoFavor = saldoFavor;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getSubTotalVentas() {
        return subTotalVentas;
    }

    public void setSubTotalVentas(double subTotalVentas) {
        this.subTotalVentas = subTotalVentas;
    }

    public double getTotalDescu() {
        return totalDescu;
    }

    public void setTotalDescu(double totalDescu) {
        this.totalDescu = totalDescu;
    }

    public double getTotalExenta() {
        return totalExenta;
    }

    public void setTotalExenta(double totalExenta) {
        this.totalExenta = totalExenta;
    }

    public double getTotalGravada() {
        return totalGravada;
    }

    public void setTotalGravada(double totalGravada) {
        this.totalGravada = totalGravada;
    }

    public String getTotalLetras() {
        return totalLetras;
    }

    public void setTotalLetras(String totalLetras) {
        this.totalLetras = totalLetras;
    }

    public double getTotalNoGravado() {
        return totalNoGravado;
    }

    public void setTotalNoGravado(double totalNoGravado) {
        this.totalNoGravado = totalNoGravado;
    }

    public double getTotalNoSuj() {
        return totalNoSuj;
    }

    public void setTotalNoSuj(double totalNoSuj) {
        this.totalNoSuj = totalNoSuj;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public List<ClsDtttributo> getTributos() {
        return tributos;
    }

    public void setTributos(List<ClsDtttributo> tributos) {
        this.tributos = tributos;
    }

    public List<ClsDtepago> getPagos() {
        return pagos;
    }

    public void setPagos(List<ClsDtepago> pagos) {
        this.pagos = pagos;
    }
    
    
    
}
