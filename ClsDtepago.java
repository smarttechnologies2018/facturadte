package Entidad;
public class ClsDtepago {
    private String codigo;
    private double montoPago;
    private int periodo;
    private String plazo;
    private String referencia;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(double montoPago) {
        this.montoPago = montoPago;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public ClsDtepago(String codigo, double montoPago, int periodo, String plazo, String referencia) {
        this.codigo = codigo;
        this.montoPago = montoPago;
        this.periodo = periodo;
        this.plazo = plazo;
        this.referencia = referencia;
    }

}