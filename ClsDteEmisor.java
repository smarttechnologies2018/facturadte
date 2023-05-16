/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author Usuario
 */
public class ClsDteEmisor {
    private String codActividad;
    private String codEstable;
    private String codEstableMH;
    private String codPuntoVenta;
    private String codPuntoVentaMH;
    private String correo;
    private String descActividad;
    private String nit;
    private String nombre;
    private String nombreComercial;
    private String nrc;
    private String telefono;
    private String tipoEstablecimiento;
    private ClsDireccion direccion;

    public String getCodActividad() {
        return codActividad;
    }

    public void setCodActividad(String codActividad) {
        this.codActividad = codActividad;
    }

    public String getCodEstable() {
        return codEstable;
    }

    public void setCodEstable(String codEstable) {
        this.codEstable = codEstable;
    }

    public String getCodEstableMH() {
        return codEstableMH;
    }

    public void setCodEstableMH(String codEstableMH) {
        this.codEstableMH = codEstableMH;
    }

    public String getCodPuntoVenta() {
        return codPuntoVenta;
    }

    public void setCodPuntoVenta(String codPuntoVenta) {
        this.codPuntoVenta = codPuntoVenta;
    }

    public String getCodPuntoVentaMH() {
        return codPuntoVentaMH;
    }

    public void setCodPuntoVentaMH(String codPuntoVentaMH) {
        this.codPuntoVentaMH = codPuntoVentaMH;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescActividad() {
        return descActividad;
    }

    public void setDescActividad(String descActividad) {
        this.descActividad = descActividad;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoEstablecimiento() {
        return tipoEstablecimiento;
    }

    public void setTipoEstablecimiento(String tipoEstablecimiento) {
        this.tipoEstablecimiento = tipoEstablecimiento;
    }

    public ClsDireccion getDireccion() {
        return direccion;
    }

    public void setDireccion(ClsDireccion direccion) {
        this.direccion = direccion;
    }

    public ClsDteEmisor(String codActividad, String codEstable, String codEstableMH, String codPuntoVenta, String codPuntoVentaMH, String correo, String descActividad, String nit, String nombre, String nombreComercial, String nrc, String telefono, String tipoEstablecimiento, ClsDireccion direccion) {
        this.codActividad = codActividad;
        this.codEstable = codEstable;
        this.codEstableMH = codEstableMH;
        this.codPuntoVenta = codPuntoVenta;
        this.codPuntoVentaMH = codPuntoVentaMH;
        this.correo = correo;
        this.descActividad = descActividad;
        this.nit = nit;
        this.nombre = nombre;
        this.nombreComercial = nombreComercial;
        this.nrc = nrc;
        this.telefono = telefono;
        this.tipoEstablecimiento = tipoEstablecimiento;
        this.direccion = direccion;
    }
     
   
    
}
