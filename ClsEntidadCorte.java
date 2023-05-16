package Entidad;

/**
 *
 * @author JoseRamos
 */
public class ClsEntidadCorte {
    private int IntIdCategoria;
    private String StrDescripcion;
    private int Intunidades;
    private double DoubleTotal;
    private String StrFecha;

    public String getStrFecha() {
        return StrFecha;
    }

    public void setStrFecha(String StrFecha) {
        this.StrFecha = StrFecha;
    }

    public int getIntIdCategoria() {
        return IntIdCategoria;
    }

    public void setIntIdCategoria(int IntIdCategoria) {
        this.IntIdCategoria = IntIdCategoria;
    }

    public String getStrDescripcion() {
        return StrDescripcion;
    }

    public void setStrDescripcion(String StrDescripcion) {
        this.StrDescripcion = StrDescripcion;
    }

    public int getIntunidades() {
        return Intunidades;
    }

    public void setIntunidades(int Intunidades) {
        this.Intunidades = Intunidades;
    }

    public double getDoubleTotal() {
        return DoubleTotal;
    }

    public void setDoubleTotal(double DoubleTotal) {
        this.DoubleTotal = DoubleTotal;
    }
    //CORTE

    //DesdeHasta
    private String StrDescripcionDocumento;
    private int IntCantidadDocumento;
    private String StrDesdeDocumento;
    private String StrHastaDocumento;
    private String StrTotalVentaDocumento;

    public String getStrDescripcionDocumento() {
        return StrDescripcionDocumento;
    }

    public void setStrDescripcionDocumento(String StrDescripcionDocumento) {
        this.StrDescripcionDocumento = StrDescripcionDocumento;
    }

    public int getIntCantidadDocumento() {
        return IntCantidadDocumento;
    }

    public void setIntCantidadDocumento(int IntCantidadDocumento) {
        this.IntCantidadDocumento = IntCantidadDocumento;
    }

    public String getStrDesdeDocumento() {
        return StrDesdeDocumento;
    }

    public void setStrDesdeDocumento(String StrDesdeDocumento) {
        this.StrDesdeDocumento = StrDesdeDocumento;
    }

    public String getStrHastaDocumento() {
        return StrHastaDocumento;
    }

    public void setStrHastaDocumento(String StrHastaDocumento) {
        this.StrHastaDocumento = StrHastaDocumento;
    }

    public String getStrTotalVentaDocumento() {
        return StrTotalVentaDocumento;
    }

    public void setStrTotalVentaDocumento(String StrTotalVentaDocumento) {
        this.StrTotalVentaDocumento = StrTotalVentaDocumento;
    }
    //DesdeHasta
}
