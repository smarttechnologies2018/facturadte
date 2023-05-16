/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author Usuario
 */
public class ClsDteExtension {
       private String docuEntrega;
    private String docuRecibe;
    private String nombEntrega;
    private String nombRecibe;
    private String observaciones;
    private String placaVehiculo;

    public ClsDteExtension(String docuEntrega, String docuRecibe, String nombEntrega, String nombRecibe, String observaciones, String placaVehiculo) {
        this.docuEntrega = docuEntrega;
        this.docuRecibe = docuRecibe;
        this.nombEntrega = nombEntrega;
        this.nombRecibe = nombRecibe;
        this.observaciones = observaciones;
        this.placaVehiculo = placaVehiculo;
    }

    public String getDocuEntrega() {
        return docuEntrega;
    }

    public void setDocuEntrega(String docuEntrega) {
        this.docuEntrega = docuEntrega;
    }

    public String getDocuRecibe() {
        return docuRecibe;
    }

    public void setDocuRecibe(String docuRecibe) {
        this.docuRecibe = docuRecibe;
    }

    public String getNombEntrega() {
        return nombEntrega;
    }

    public void setNombEntrega(String nombEntrega) {
        this.nombEntrega = nombEntrega;
    }

    public String getNombRecibe() {
        return nombRecibe;
    }

    public void setNombRecibe(String nombRecibe) {
        this.nombRecibe = nombRecibe;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }
  
    
}
