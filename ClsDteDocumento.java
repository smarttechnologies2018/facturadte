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
public class ClsDteDocumento {
     private int cantidad;
    private String codTributo;
    private String codigo;
    private String descripcion;
    private double montoDescu;
    private double noGravado;
    private int numItem;
    private String numeroDocumento;
    private double precioUni;
    private double psv;
    private int tipoItem;
    private int uniMedida;
    private double ventaExenta;
    private double ventaGravada;
    private double ventaNoSuj;
    private List<String> tributos;

    public ClsDteDocumento(int cantidad, String codTributo, String codigo, String descripcion, double montoDescu, double noGravado, int numItem, String numeroDocumento, double precioUni, double psv, int tipoItem, int uniMedida, double ventaExenta, double ventaGravada, double ventaNoSuj, List<String> tributos) {
        this.cantidad = cantidad;
        this.codTributo = codTributo;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.montoDescu = montoDescu;
        this.noGravado = noGravado;
        this.numItem = numItem;
        this.numeroDocumento = numeroDocumento;
        this.precioUni = precioUni;
        this.psv = psv;
        this.tipoItem = tipoItem;
        this.uniMedida = uniMedida;
        this.ventaExenta = ventaExenta;
        this.ventaGravada = ventaGravada;
        this.ventaNoSuj = ventaNoSuj;
        this.tributos = tributos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodTributo() {
        return codTributo;
    }

    public void setCodTributo(String codTributo) {
        this.codTributo = codTributo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMontoDescu() {
        return montoDescu;
    }

    public void setMontoDescu(double montoDescu) {
        this.montoDescu = montoDescu;
    }

    public double getNoGravado() {
        return noGravado;
    }

    public void setNoGravado(double noGravado) {
        this.noGravado = noGravado;
    }

    public int getNumItem() {
        return numItem;
    }

    public void setNumItem(int numItem) {
        this.numItem = numItem;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public double getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(double precioUni) {
        this.precioUni = precioUni;
    }

    public double getPsv() {
        return psv;
    }

    public void setPsv(double psv) {
        this.psv = psv;
    }

    public int getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(int tipoItem) {
        this.tipoItem = tipoItem;
    }

    public int getUniMedida() {
        return uniMedida;
    }

    public void setUniMedida(int uniMedida) {
        this.uniMedida = uniMedida;
    }

    public double getVentaExenta() {
        return ventaExenta;
    }

    public void setVentaExenta(double ventaExenta) {
        this.ventaExenta = ventaExenta;
    }

    public double getVentaGravada() {
        return ventaGravada;
    }

    public void setVentaGravada(double ventaGravada) {
        this.ventaGravada = ventaGravada;
    }

    public double getVentaNoSuj() {
        return ventaNoSuj;
    }

    public void setVentaNoSuj(double ventaNoSuj) {
        this.ventaNoSuj = ventaNoSuj;
    }

    public List<String> getTributos() {
        return tributos;
    }

    public void setTributos(List<String> tributos) {
        this.tributos = tributos;
    }
    
    
}
