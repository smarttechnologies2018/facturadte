package Entidad;

import java.sql.Blob;
import java.util.Date;
import java.io.InputStream;

/**
 *
 * @author ZEUS
 */
public class ClsEntidadProducto {

    private String strIdProducto;
    private String strCodigoProducto;
    private String strNombreProducto;
    private String strDescripcionProducto;
    private String strStockProducto;
    private String strStockMinProducto;
    private String strPrecioCostoProducto;
    private String strPrecioVentaProducto;
    private String strUtilidadProducto;
    private String strEstadoProducto;
    private String strIdCategoria;
 private String strExterno;
    public String getStrExterno() {
        return strExterno;
    }

    public void setStrExterno(String strExterno) {
        this.strExterno = strExterno;
    }
       
    private String strDescripcionCategoria;
 private String strupdate;
    public String getStrupdate() {
        return strupdate;
    }

    public void setStrupdate(String strupdate) {
        this.strupdate = strupdate;
    }
    

    private String strIdProveedor;
    private String strNombreProveedor;

    private String strContenedorProducto;
    private String strCantidadContenidaProducto;
    private String strContenedorProducto1;
    private String strCantidadContenidaProducto1;
    private String strContenedorProducto2;
    private String strCantidadContenidaProducto2;
    private String strIdGrupo;
    private String strNombreGrupo;
    private InputStream imagen;

    public InputStream getImagen() {
        return imagen;
    }

    public void setImagen(InputStream imagen) {
        this.imagen = imagen;
    }

    private String strPrecioTotal;

    private String strCantidadVenta;
    private String strDescuento;
    private Blob strimagen;

    private String strCodBarra;
    private String caja;
    private Date strVencimiento;
    private String strVencimientoConsulta;
    private String strcontrol;
    private String strProducto_ultima_med;
    private String strUltimaVenta;
    private String strpush;
    private String StrImpuesto;
    private String StrIva;
    private String StrFovial;
    private String StrCotrans;

    public String getStrImpuesto() {
        return StrImpuesto;
    }

    public void setStrImpuesto(String StrImpuesto) {
        this.StrImpuesto = StrImpuesto;
    }

    public String getStrIva() {
        return StrIva;
    }

    public void setStrIva(String StrIva) {
        this.StrIva = StrIva;
    }

    public String getStrFovial() {
        return StrFovial;
    }

    public void setStrFovial(String StrFovial) {
        this.StrFovial = StrFovial;
    }

    public String getStrCotrans() {
        return StrCotrans;
    }

    public void setStrCotrans(String StrCotrans) {
        this.StrCotrans = StrCotrans;
    }

    public Blob getStrimagen() {
        return strimagen;
    }

    public void setStrimagen(Blob strimagen) {
        this.strimagen = strimagen;
    }

    public String getStrpush() {
        return strpush;
    }

    public void setStrpush(String strpush) {
        this.strpush = strpush;
    }

    public String getStrUltimaVenta() {
        return strUltimaVenta;
    }

    public void setStrUltimaVenta(String strUltimaVenta) {
        this.strUltimaVenta = strUltimaVenta;
    }

    public String getStrcontrol() {
        return strcontrol;
    }

    public void setStrcontrol(String strcontrol) {
        this.strcontrol = strcontrol;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public String getStrCodBarra() {
        return strCodBarra;
    }

    public void setStrCodBarra(String strCodBarra) {
        this.strCodBarra = strCodBarra;
    }

    public String getStrIdProducto() {
        return strIdProducto;
    }

    public void setStrIdProducto(String strIdProducto) {
        this.strIdProducto = strIdProducto;
    }

    public String getStrCodigoProducto() {
        return strCodigoProducto;
    }

    public void setStrCodigoProducto(String strCodigoProducto) {
        this.strCodigoProducto = strCodigoProducto;
    }

    public String getStrNombreProducto() {
        return strNombreProducto;
    }

    public void setStrNombreProducto(String strNombreProducto) {
        this.strNombreProducto = strNombreProducto;
    }

    public String getStrDescripcionProducto() {
        return strDescripcionProducto;
    }

    public void setStrDescripcionProducto(String strDescripcionProducto) {
        this.strDescripcionProducto = strDescripcionProducto;
    }

    public String getStrStockProducto() {
        return strStockProducto;
    }

    public void setStrStockProducto(String strStockProducto) {
        this.strStockProducto = strStockProducto;
    }

    public String getStrStockMinProducto() {
        return strStockMinProducto;
    }

    public void setStrStockMinProducto(String strStockMinProducto) {
        this.strStockMinProducto = strStockMinProducto;
    }

    public String getStrPrecioCostoProducto() {
        return strPrecioCostoProducto;
    }

    public void setStrPrecioCostoProducto(String strPrecioCostoProducto) {
        this.strPrecioCostoProducto = strPrecioCostoProducto;
    }

    public String getStrPrecioVentaProducto() {
        return strPrecioVentaProducto;
    }

    public void setStrPrecioVentaProducto(String strPrecioVentaProducto) {
        this.strPrecioVentaProducto = strPrecioVentaProducto;
    }

    public String getStrUtilidadProducto() {
        return strUtilidadProducto;
    }

    public void setStrUtilidadProducto(String strUtilidadProducto) {
        this.strUtilidadProducto = strUtilidadProducto;
    }

    public String getStrEstadoProducto() {
        return strEstadoProducto;
    }

    public void setStrEstadoProducto(String strEstadoProducto) {
        this.strEstadoProducto = strEstadoProducto;
    }

    public String getStrIdCategoria() {
        return strIdCategoria;
    }

    public void setStrIdCategoria(String strIdCategoria) {
        this.strIdCategoria = strIdCategoria;
    }

    public String getStrDescripcionCategoria() {
        return strDescripcionCategoria;
    }

    public void setStrDescripcionCategoria(String strDescripcionCategoria) {
        this.strDescripcionCategoria = strDescripcionCategoria;
    }

    public String getStrContenedorProducto() {
        return strContenedorProducto;
    }

    public void setStrContenedorProducto(String strContenedorProducto) {
        this.strContenedorProducto = strContenedorProducto;
    }

    public String getStrCantidadContenidaProducto() {
        return strCantidadContenidaProducto;
    }

    public void setStrCantidadContenidaProducto(String strCantidadContenidaProducto) {
        this.strCantidadContenidaProducto = strCantidadContenidaProducto;
    }

    public String getStrPrecioTotal() {
        return strPrecioTotal;
    }

    public void setStrPrecioTotal(String strPrecioTotal) {
        this.strPrecioTotal = strPrecioTotal;
    }

    public String getStrIdGrupo() {
        return strIdGrupo;
    }

    public void setStrIdGrupo(String strIdGrupo) {
        this.strIdGrupo = strIdGrupo;
    }

    public String getStrNombreGrupo() {
        return strNombreGrupo;
    }

    public void setStrNombreGrupo(String strNombreGrupo) {
        this.strNombreGrupo = strNombreGrupo;
    }

    public String getStrCantidadVenta() {
        return strCantidadVenta;
    }

    public void setStrCantidadVenta(String strCantidadVenta) {
        this.strCantidadVenta = strCantidadVenta;
    }

    public String getStrDescuento() {
        return strDescuento;
    }

    public void setStrDescuento(String strDescuento) {
        this.strDescuento = strDescuento;
    }

    public String getStrIdProveedor() {
        return strIdProveedor;
    }

    public void setStrIdProveedor(String strIdProveedor) {
        this.strIdProveedor = strIdProveedor;
    }

    public String getStrNombreProveedor() {
        return strNombreProveedor;
    }

    public void setStrNombreProveedor(String strNombreProveedor) {
        this.strNombreProveedor = strNombreProveedor;
    }

    public String getStrContenedorProducto1() {
        return strContenedorProducto1;
    }

    public void setStrContenedorProducto1(String strContenedorProducto1) {
        this.strContenedorProducto1 = strContenedorProducto1;
    }

    public String getStrCantidadContenidaProducto1() {
        return strCantidadContenidaProducto1;
    }

    public void setStrCantidadContenidaProducto1(String strCantidadContenidaProducto1) {
        this.strCantidadContenidaProducto1 = strCantidadContenidaProducto1;
    }

    public String getStrContenedorProducto2() {
        return strContenedorProducto2;
    }

    public void setStrContenedorProducto2(String strContenedorProducto2) {
        this.strContenedorProducto2 = strContenedorProducto2;
    }

    public String getStrCantidadContenidaProducto2() {
        return strCantidadContenidaProducto2;
    }

    public void setStrCantidadContenidaProducto2(String strCantidadContenidaProducto2) {
        this.strCantidadContenidaProducto2 = strCantidadContenidaProducto2;
    }

    public Date getStrVencimiento() {
        return strVencimiento;
    }

    public void setStrVencimiento(Date strVencimiento) {
        this.strVencimiento = strVencimiento;
    }

    public String getStrVencimientoConsulta() {
        return strVencimientoConsulta;
    }

    public void setStrVencimientoConsulta(String strVencimientoConsulta) {
        this.strVencimientoConsulta = strVencimientoConsulta;
    }

    public String getStrProducto_ultima_med() {
        return strProducto_ultima_med;
    }

    public void setStrProducto_ultima_med(String strProducto_ultima_med) {
        this.strProducto_ultima_med = strProducto_ultima_med;
    }
}
