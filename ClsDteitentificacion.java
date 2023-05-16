/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author Usuario
 */
public class ClsDteitentificacion {
   
    private String ambiente;
    private String codigoGeneracion;
    private String fecEmi;
    private String horEmi;
    private String motivoContin;
    private String numeroControl;
    private String tipoContingencia;
    private String tipoDte;
    private int tipoModelo;
    private String tipoMoneda;
    private int tipoOperacion;
    private int version;

    public ClsDteitentificacion(String ambiente, String codigoGeneracion, String fecEmi, String horEmi, String motivoContin, String numeroControl, String tipoContingencia, String tipoDte, int tipoModelo, String tipoMoneda, int tipoOperacion, int version) {
        this.ambiente = ambiente;
        this.codigoGeneracion = codigoGeneracion;
        this.fecEmi = fecEmi;
        this.horEmi = horEmi;
        this.motivoContin = motivoContin;
        this.numeroControl = numeroControl;
        this.tipoContingencia = tipoContingencia;
        this.tipoDte = tipoDte;
        this.tipoModelo = tipoModelo;
        this.tipoMoneda = tipoMoneda;
        this.tipoOperacion = tipoOperacion;
        this.version = version;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getCodigoGeneracion() {
        return codigoGeneracion;
    }

    public void setCodigoGeneracion(String codigoGeneracion) {
        this.codigoGeneracion = codigoGeneracion;
    }

    public String getFecEmi() {
        return fecEmi;
    }

    public void setFecEmi(String fecEmi) {
        this.fecEmi = fecEmi;
    }

    public String getHorEmi() {
        return horEmi;
    }

    public void setHorEmi(String horEmi) {
        this.horEmi = horEmi;
    }

    public String getMotivoContin() {
        return motivoContin;
    }

    public void setMotivoContin(String motivoContin) {
        this.motivoContin = motivoContin;
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public String getTipoContingencia() {
        return tipoContingencia;
    }

    public void setTipoContingencia(String tipoContingencia) {
        this.tipoContingencia = tipoContingencia;
    }

    public String getTipoDte() {
        return tipoDte;
    }

    public void setTipoDte(String tipoDte) {
        this.tipoDte = tipoDte;
    }

    public int getTipoModelo() {
        return tipoModelo;
    }

    public void setTipoModelo(int tipoModelo) {
        this.tipoModelo = tipoModelo;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public int getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(int tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
    
}
