/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author Usuario
 */
public class ClsDteReceptor {
      private String codActividad;
    private String correo;
    private String descActividad;
    private String nit;
    private String nombre;
    private String nombreComercial;
    private String nrc;
    private String telefono;
    private ClsDireccion direccion;

    public ClsDteReceptor(String codActividad, String correo, String descActividad, String nit, String nombre, String nombreComercial, String nrc, String telefono, ClsDireccion direccion) {
        this.codActividad = codActividad;
        this.correo = correo;
        this.descActividad = descActividad;
        this.nit = nit;
        this.nombre = nombre;
        this.nombreComercial = nombreComercial;
        this.nrc = nrc;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getCodActividad() {
        return codActividad;
    }

    public void setCodActividad(String codActividad) {
        this.codActividad = codActividad;
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

    public ClsDireccion getDireccion() {
        return direccion;
    }

    public void setDireccion(ClsDireccion direccion) {
        this.direccion = direccion;
    }
    
    
}
