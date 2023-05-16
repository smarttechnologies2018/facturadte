package Negocio;

import Conexion.*;
import Entidad.*;
import ds.desktop.notify.DesktopNotify;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public final class ClsCompra {
public ResultSet listartrasladoslinea(String nombre, String Documento) throws Exception {
        Connection connection = new ClsConexionup().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CompraPorProveedorDocumentoT(?,?)}");

            statement.setString("pnombre", nombre);
            statement.setString("pdocumento", Documento);

            rs = statement.executeQuery();
            return rs;

        } catch (SQLException SQLex) {
            System.out.println(SQLex);
            throw SQLex;
        }

    }
    

    public void agregarCompra(ClsEntidadCompra Compra) {
        Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Compra(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
                    + ",?,?,?,?,?,?,?,?)}");
            statement.setString("pidtipodocumento", Compra.getStrIdTipoDocumento());
            statement.setInt("pidproveedor", Compra.getStrIdProveedor());
            statement.setString("pidempleado", Compra.getStrIdEmpleado());
            statement.setString("pnumero", Compra.getStrNumeroCompra());
            statement.setDate("pfecha", new java.sql.Date(Compra.getStrFechaCompra().getTime()));
            statement.setString("psubtotal", Compra.getStrSubTotalCompra());
            statement.setString("pigv", Compra.getStrIgvCompra());
            statement.setString("ptotal", Compra.getStrTotalCompra());
            statement.setString("pestado", Compra.getStrEstadoCompra());
            statement.setString("ptipotrans", Compra.getStrTipoTrans());
            statement.setString("pndocumento", Compra.getStrNDocumento());
            statement.setString("ptipocompra", Compra.getStrTipoCompra2());
            statement.setString("pestadocuenta", Compra.getStrEstado_Cuenta());
            statement.setString("pidempresa", Compra.getStrIdEmpresa());
            statement.setString("pidCorrelativo", Compra.getStrIdCorrelativo());
            statement.setInt("pIdCaja", Compra.getIntIdCaja());
            statement.setString("pretencion", Compra.getStrRetencion());
            statement.setString("ppercepcion", Compra.getStrPersepcion());
            statement.setString("pcompra_idempresa_origen", Compra.getStrIdEmpresa());
            statement.setString("pobservacion", Compra.getStrObervacion());

            statement.setDouble("pdescuento", Compra.getStrDescuento());
            statement.setDouble("pnosujeta", Compra.getStrNoSujeta());
            statement.setDouble("pexenta", Compra.getStrExenta());
            statement.setDouble("pfovial", Compra.getStrfovial());
            statement.setDouble("pcotrans", Compra.getStrCotrans());

            statement.setString("pserieret", Compra.getStrserieret());
            statement.setString("pnumeroret", Compra.getStrnumeroret());
            statement.setString("pserie", Compra.getStrSerie());

            DesktopNotify.showDesktopMessage("", "" + "   COMPRA REALIZADA", DesktopNotify.SUCCESS, 5551);
            statement.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "agregar compra");
        }
    }

    public void agregarnota(ClsEntidadCompra Compra) {
        Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_GenerarNota(?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidtipodocumento", Compra.getStrIdTipoDocumento());
            statement.setString("pidempleado", Compra.getStrIdEmpleado());
            statement.setString("pndocumento", Compra.getStrNDocumento());
            statement.setDate("pfecha", new java.sql.Date(Compra.getStrFechaCompra().getTime()));
            statement.setString("pidempresa", Compra.getStrIdEmpresa());
            statement.setString("pidCorrelativo", Compra.getStrIdCorrelativo());
            statement.setInt("pIdCaja", Compra.getIntIdCaja());
            statement.setString("pcompra_idempresa_origen", Compra.getStrIdEmpresa());
            statement.setString("pobservacion", Compra.getStrObervacion());
             statement.setString("ptotal", Compra.getStrTotalCompra());

            DesktopNotify.showDesktopMessage("", "" + "   Datos Guardados", DesktopNotify.SUCCESS, 5551);
            statement.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "agregar compra");
        }
    }

    public void agregarretencon(ClsEntidadCompra Compra) {
        Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Retencion(?,?,?,?,?,?,?,?,?)}");

            statement.setDate("pfecha", new java.sql.Date(Compra.getStrFechaCompra().getTime()));
            statement.setDate("pfecha2", new java.sql.Date(Compra.getDateFecha2().getTime()));
            statement.setInt("pidproveedor", Compra.getStrIdProveedor());
            statement.setString("pndocumento", Compra.getStrNDocumento());
            statement.setString("psubtotal", Compra.getStrSubTotalCompra());
            statement.setString("pigv", Compra.getStrIgvCompra());
            statement.setString("pretencion", Compra.getStrRetencion());
            statement.setString("pidCorrelativo", Compra.getStrIdCorrelativo());
            System.out.println(Compra.getStrIdCorrelativo());
            statement.setString("pidtipodocumento", Compra.getStrIdTipoDocumento());

            DesktopNotify.showDesktopMessage("", "" + "   RETENCION REALIZADA", DesktopNotify.SUCCESS, 5551);
            statement.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void agregartraslado(ClsEntidadCompra Compra) {
        Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Traslado(?,?,?,?,?"
                    + ",?,?,?,?,?"
                    + ",?,?,?,?,?"
                    + ",?,?"
                    + ",?)}");
            statement.setString("pidtipodocumento", Compra.getStrIdTipoDocumento());//1
            statement.setString("pidempleado", Compra.getStrIdEmpleado());//2
            statement.setDate("pfecha", new java.sql.Date(Compra.getStrFechaCompra().getTime()));//3
            statement.setString("psubtotal", Compra.getStrSubTotalCompra());//4
            statement.setString("pigv", Compra.getStrIgvCompra());//5
            statement.setString("ptotal", Compra.getStrTotalCompra());//6
            statement.setString("pestado", Compra.getStrEstadoCompra());//7
            statement.setString("ptipotrans", Compra.getStrTipoTrans());//8
            statement.setString("pndocumento", Compra.getStrNDocumento());//9           
            statement.setString("pidempresa", Compra.getStrIdEmpresa());//10
            statement.setString("pidCorrelativo", Compra.getStrIdCorrelativo());//11
            statement.setInt("pIdCaja", Compra.getIntIdCaja());//12
            statement.setString("pcompra_idempresa_origen", Compra.getStridempresaorigen());//13
            statement.setString("pobservacion", Compra.getStrObervacion());//14
            statement.setDouble("precargo", Compra.getStrRecargo());//15
            statement.setDouble("pporcentaje", Compra.getStrporcentaje());//16
            statement.setDouble("plimite", Compra.getStrLimite());//17
            statement.setInt("pdestino", Compra.getStrDestino());//18

            DesktopNotify.showDesktopMessage("", "" + "   COMPRA REALIZADA", DesktopNotify.SUCCESS, 5551);
            statement.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "agregar compra");
        }
    }

    public void agregarCompraorden(ClsEntidadCompra Compra) {
        Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_CompraOrden(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
                    + ",?,?,?,?,?,?)}");
            statement.setString("pidtipodocumento", Compra.getStrIdTipoDocumento());
            statement.setInt("pidproveedor", Compra.getStrIdProveedor());
            statement.setString("pidempleado", Compra.getStrIdEmpleado());
            statement.setString("pnumero", Compra.getStrNumeroCompra());
            statement.setDate("pfecha", new java.sql.Date(Compra.getStrFechaCompra().getTime()));
            statement.setString("psubtotal", Compra.getStrSubTotalCompra());
            statement.setString("pigv", Compra.getStrIgvCompra());
            statement.setString("ptotal", Compra.getStrTotalCompra());
            statement.setString("pestado", Compra.getStrEstadoCompra());
            statement.setString("ptipotrans", Compra.getStrTipoTrans());
            statement.setString("pndocumento", Compra.getStrNDocumento());
            statement.setString("ptipocompra", Compra.getStrTipoCompra2());
            statement.setString("pestadocuenta", null);
            statement.setString("pidempresa", Compra.getStrIdEmpresa());
            statement.setString("pidCorrelativo", Compra.getStrIdCorrelativo());
            statement.setInt("pIdCaja", Compra.getIntIdCaja());
            statement.setString("pretencion", null);
            statement.setString("ppercepcion", null);
            statement.setString("pcompra_idempresa_origen", Compra.getStrIdEmpresa());
            statement.setString("pobservacion", Compra.getStrObervacion());

            statement.setDouble("pdescuento", 0.00);
            statement.setDouble("pnosujeta", 0.00);
            statement.setDouble("pexenta", 0.00);
            statement.setDouble("pfovial", 0.00);
            statement.setDouble("pcotrans", 0.00);
            statement.setInt("pidvendedor", Compra.getStrIntIdVendedor());

            DesktopNotify.showDesktopMessage("", "" + "   COMPRA REALIZADA", DesktopNotify.SUCCESS, 5551);
            statement.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "agregar compra");
        }
    }

    public void agregarCompraIVA(ClsEntidadCompra Compra) {
        Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_CompraIVA2(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidtipodocumento", Compra.getStrIdTipoDocumento());
            statement.setInt("pidproveedor", Compra.getStrIdProveedor());
            statement.setString("pidempleado", Compra.getStrIdEmpleado());
            statement.setString("pnumero", Compra.getStrNumeroCompra());
            statement.setDate("pfecha", new java.sql.Date(Compra.getStrFechaCompra().getTime()));
            statement.setDate("pfecha2", new java.sql.Date(Compra.getDateFecha2().getTime()));
            statement.setString("psubtotal", Compra.getStrSubTotalCompra());
            statement.setString("pigv", Compra.getStrIgvCompra());
            statement.setString("ptotal", Compra.getStrTotalCompra());
            statement.setString("pestado", Compra.getStrEstadoCompra());
            statement.setString("ptipotrans", Compra.getStrTipoTrans());
            statement.setString("pndocumento", Compra.getStrNDocumento());
            statement.setString("ptipocompra", Compra.getStrTipoCompra2());
            statement.setString("pestadocuenta", Compra.getStrEstado_Cuenta());
            statement.setString("pidempresa", Compra.getStrIdEmpresa());
            statement.setString("pidCorrelativo", Compra.getStrIdCorrelativo());
            statement.setInt("pIdCaja", Compra.getIntIdCaja());
            statement.setString("pretencion", Compra.getStrRetencion());
            statement.setString("ppercepcion", Compra.getStrPersepcion());
            statement.setString("pcompra_idempresa_origen", Compra.getStrIdEmpresa());
            statement.setString("pTipoVexternInter", Compra.getStrTipoVexternInter());
            statement.setString("psalfech", Compra.getStrSalFec());
            statement.setString("pserie", Compra.getStrSerie());
             statement.setString("pCompra_Ret2", Compra.getStrRet2());
              statement.setDouble("pfovial", Compra.getStrfovial());
               statement.setDouble("pcotrans", Compra.getStrCotrans());

            DesktopNotify.showDesktopMessage("", "OK" + " REALIZADO", DesktopNotify.SUCCESS, 5551);
            
             DesktopNotify.showDesktopMessage("", "NUMERO: " + Compra.getStrNumeroCompra(), DesktopNotify.INFORMATION, 9000);
            statement.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void agregarCompraSinDetalle(ClsEntidadCompra Compra) {
        Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_CompraSinDetalle(?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidtipodocumento", Compra.getStrIdTipoDocumento());
            statement.setInt("pidproveedor", Compra.getStrIdProveedor());
            statement.setString("pidempleado", Compra.getStrIdEmpleado());
            statement.setString("pnumero", Compra.getStrNumeroCompra());
            statement.setDate("pfecha", new java.sql.Date(Compra.getStrFechaCompra().getTime()));
            statement.setDate("pfecha2", new java.sql.Date(Compra.getDateFecha2().getTime()));
            statement.setString("psubtotal", Compra.getStrSubTotalCompra());
            statement.setString("pigv", Compra.getStrIgvCompra());
            statement.setString("ptotal", Compra.getStrTotalCompra());
            statement.setString("pestado", Compra.getStrEstadoCompra());

            statement.setString("ptipotrans", Compra.getStrTipoTrans());
            statement.setString("pndocumento", Compra.getStrNDocumento());
            statement.setString("ptipocompra", Compra.getStrTipoCompra2());
            statement.setString("pestadocuenta", Compra.getStrEstado_Cuenta());
            statement.setString("pidempresa", Compra.getStrIdEmpresa());
            statement.setString("pidCorrelativo", Compra.getStrIdCorrelativo());
            statement.setInt("pIdCaja", Compra.getIntIdCaja());
            statement.setString("pretencion", Compra.getStrRetencion());
            statement.setString("ppercepcion", Compra.getStrPersepcion());
            statement.setString("pcompra_idempresa_origen", Compra.getStrIdEmpresa());

            statement.setString("pTipoVexternInter", Compra.getStrTipoVexternInter());
            statement.setString("psalfech", Compra.getStrSalFec());
            statement.setDouble("pdescuento", Compra.getStrDescuento());
            statement.setDouble("pfovial", Compra.getStrfovial());
            statement.setDouble("pcotrans", Compra.getStrCotrans());
            statement.setDouble("pnosujeta", Compra.getStrNoSujeta());
            statement.setString("pserie", Compra.getStrSerie());
            statement.setString("pnret", Compra.getStrnumeroret());
            statement.setString("psret", Compra.getStrserieret());

            DesktopNotify.showDesktopMessage("", "OK" + " REALIZADO", DesktopNotify.SUCCESS, 5551);
            statement.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void eliminarCompra(String codigo) {
        Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_D_Compra(?)}");
            statement.setString("pidcompra", codigo);

            statement.executeUpdate();
            DesktopNotify.showDesktopMessage("", " ACTUALIZANDO", DesktopNotify.SUCCESS, 5551);
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            DesktopNotify.showDesktopMessage("", " ERROR" + ex, DesktopNotify.ERROR, 5551);
        }
    }

    public void modificarCompra(String codigo, ClsEntidadCompra Compra) {
        Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Compra(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidtipodocumento", Compra.getStrIdTipoDocumento());
            statement.setInt("pidproveedor", Compra.getStrIdProveedor());
            statement.setString("pidempleado", Compra.getStrIdEmpleado());
            statement.setString("pnumero", Compra.getStrNumeroCompra());
            statement.setDate("pfecha", new java.sql.Date(Compra.getStrFechaCompra().getTime()));
            statement.setString("psubtotal", Compra.getStrSubTotalCompra());
            statement.setString("pigv", Compra.getStrIgvCompra());
            statement.setString("ptotal", Compra.getStrTotalCompra());
            statement.setString("pestado", Compra.getStrEstadoCompra());
            statement.setString("ptipotrans", Compra.getStrTipoTrans());
            statement.setString("pndocumento", Compra.getStrNDocumento());
            statement.setString("ptipocompra", Compra.getStrTipoCompra2());
            statement.setString("pestadocuenta", Compra.getStrEstado_Cuenta());
            statement.setString("pidempresa", Compra.getStrIdEmpresa());
            statement.setString("ppersepcion", Compra.getStrPersepcion());
            statement.setString("pretencion", Compra.getStrRetencion());
            statement.setString("pidcompra", codigo);
            statement.executeUpdate();
            DesktopNotify.showDesktopMessage("", "   COMPRA ACTUALIZADA", DesktopNotify.SUCCESS, 5551);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex + "actualizar compra");
        }

//        Jtconsola.append("¡Compra Actualizada!");
    }

    public void Enumerar_Compras(String codigo, ClsEntidadCompra Compra) {
        Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_CompraIva(?,?,?,?,?)}");
            statement.setString("pnumero", Compra.getStrNumeroCompra());
            statement.setString("pperiodo", Compra.getStrSalFec());
            statement.setString("pidcompra", codigo);
            statement.setString("pserie", Compra.getStrSerie());
            statement.setString("pnumeroret", Compra.getStrnumeroret());
             

            statement.executeUpdate();
            DesktopNotify.showDesktopMessage("", "   COMPRA ACTUALIZADA", DesktopNotify.SUCCESS, 5551);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex + "actualizar compra");
        }

//        Jtconsola.append("¡Compra Actualizada!");
    }

    public void actualizarstock(String idcompra, ClsEntidadCompra Compra) {
        Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_UStockCompra(?)}");

            statement.setString("pidcompra", idcompra);
            statement.executeUpdate();
            DesktopNotify.showDesktopMessage("", "   ACTUALIZANDO INVENTARIO", DesktopNotify.SUCCESS, 5551);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            DesktopNotify.showDesktopMessage("", "   " + ex, DesktopNotify.INFORMATION, 5551);
        }

    }

    public void actualizarstockNota(String idcompra, ClsEntidadCompra Compra) {
        Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_UStockCompraNotaCredito(?)}");

            statement.setString("pidcompra", idcompra);
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

//       Jtconsola.append("Stock Actualizado!");
    }

    public ArrayList<ClsEntidadCompra> listarCompra() {
        Connection connection = new ClsConexionLocal().getConection();
        ArrayList<ClsEntidadCompra> compras = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Compra}");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ClsEntidadCompra compra = new ClsEntidadCompra();
                compra.setStrIdCompra(resultSet.getString("IdCompra"));
                compra.setStrTipoDocumento(resultSet.getString("TipoDocumento"));
                compra.setStrProveedor(resultSet.getString("Proveedor"));
                compra.setStrEmpleado(resultSet.getString("Empleado"));
                compra.setStrNumeroCompra(resultSet.getString("Numero"));
                compra.setStrFechaCompra(resultSet.getDate("Fecha"));
                compra.setStrSubTotalCompra(resultSet.getString("SubTotal"));
                compra.setStrIgvCompra(resultSet.getString("Igv"));
                compra.setStrTotalCompra(resultSet.getString("Total"));
                compra.setStrEstadoCompra(resultSet.getString("Estado"));
                compras.add(compra);
            }
            return compras;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
    }

    public ResultSet listarCompraPorParametro(String criterio, String busqueda) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CompraPorParametro(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet LiastarTrasladosPorSala(int idsala, Date criterio, Date criterio2) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_RptEnvios(?,?,?)}");
            statement.setInt("pidsucursal", idsala);
            statement.setDate("pfecha", new java.sql.Date(criterio.getTime()));
            statement.setDate("pfecha2", new java.sql.Date(criterio2.getTime()));

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listarcomprasindetalle(String idcompra) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_comprasindetalle2(?)}");
            statement.setString("pidcompra", idcompra);

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listarCompraPorParametroexportar(String criterio) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_RptCompraiva(?)}");
            statement.setString("pcriterio", criterio);

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
    
    public ResultSet listargasto(Date fecha1,Date fecha2) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ExPortargastos(?)}");
            statement.setDate("pfecha", new java.sql.Date(fecha1.getTime()));
            statement.setDate("pfecha2", new java.sql.Date(fecha2.getTime()));

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
    
    

    public ResultSet ListarVentaConsumidorFinal(String criterio) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_RptVentaConsumidor(?)}");
            statement.setString("pcriterio", criterio);

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet ListarVentaContribuyente(String criterio) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_RptVentaContribuyente(?)}");
            statement.setString("pcriterio", criterio);

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet ListarLibroRetencion(String criterio) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_RptCompraIvaRetencion(?)}");
            statement.setString("pcriterio", criterio);

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
    
      public ResultSet ListarLibropercepcion(String criterio) throws Exception {
          Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_RptVentaContribuyentePer(?)}");
            statement.setString("pcriterio", criterio);

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet obtenerUltimoIdCompra() throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_UltimoIdCompra()}");
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet obtenerUltimoIvaCompra(Date criterio) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_GenerarCodigoIVA(?)}");
            statement.setDate("pfecha", new java.sql.Date(criterio.getTime()));
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listarCompraPorFecha(String criterio, String nombre) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CompraPorProveedor(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pnombre", nombre);

            rs = statement.executeQuery();
            return rs;

        } catch (SQLException SQLex) {
            throw SQLex;
        }

    }

    public ResultSet listarCompraPorFechaDocumento(String nombre, String Documento) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CompraPorProveedorDocumento(?,?)}");

            statement.setString("pnombre", nombre);
            statement.setString("pdocumento", Documento);

            rs = statement.executeQuery();
            return rs;

        } catch (SQLException SQLex) {
            System.out.println(SQLex);
            throw SQLex;
        }

    }

    public ResultSet listartraslados(String nombre, String Documento) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CompraPorProveedorDocumentoT(?,?)}");

            statement.setString("pnombre", nombre);
            statement.setString("pdocumento", Documento);

            rs = statement.executeQuery();
            return rs;

        } catch (SQLException SQLex) {
            System.out.println(SQLex);
            throw SQLex;
        }

    }

    public ResultSet listarCompraPorFechaOrden(String criterio, String nombre) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CompraPorProveedorOrden(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pnombre", nombre);

            rs = statement.executeQuery();
            return rs;

        } catch (SQLException SQLex) {
            throw SQLex;
        }

    }

    public ResultSet listarCompraPorFechaIva(String nombre, String dato, String Salfec) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CompraPorProveedorIva(?,?,?)}");

            statement.setString("pnombre", nombre);
            statement.setString("psalfec", Salfec);

            statement.setString("pdato", dato);

            rs = statement.executeQuery();
            return rs;

        } catch (SQLException SQLex) {
            throw SQLex;
        }

    }

    public ResultSet listarCompraPorFechasin(String nombre, int sucursal) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CompraPorProveedorsin(?,?)}");

            statement.setString("pnombre", nombre);
            statement.setInt("pidempresa", sucursal);

            rs = statement.executeQuery();
            return rs;

        } catch (SQLException SQLex) {
            throw SQLex;
        }

    }

    public ResultSet obtenerserieproveedor(int idproveedor) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Obtenerserieproveedor(?)}");

            statement.setInt("pidproveedor", idproveedor);

            rs = statement.executeQuery();
            return rs;

        } catch (SQLException SQLex) {
            throw SQLex;
        }

    }

    public ResultSet obtenerseriedoc() throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Obtenerserieret()}");

            rs = statement.executeQuery();
            return rs;

        } catch (SQLException SQLex) {
            throw SQLex;
        }

    }

    public ResultSet listarCompraPago(int idproveedor) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ComprasPago(?)}");

            statement.setInt("pidproveedor", idproveedor);

            rs = statement.executeQuery();
            return rs;

        } catch (SQLException SQLex) {
            throw SQLex;
        }

    }

    public ArrayList<ClsEntidadCompra> listarCompraCredito(String criterio, String busqueda) {
        Connection connection = new ClsConexionLocal().getConection();
        ArrayList<ClsEntidadCompra> compras = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CompraCreditoPorParametro(?,?)}");
            statement.setString("pcriterio", criterio);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ClsEntidadCompra compra = new ClsEntidadCompra();
                compra.setStrIdCompra(resultSet.getString("IdCompra"));
                compra.setStrProveedor(resultSet.getString("Nombre"));
                compra.setStrTipoDocumento(resultSet.getString("ndocumento"));
                compra.setStrDocumento(resultSet.getString("Descripcion"));

                compra.setStrFechaCompra(resultSet.getDate("Fecha"));
                compra.setStrSubTotalCompra(resultSet.getString("SubTotal"));
                compra.setStrIgvCompra(resultSet.getString("Igv"));
                compra.setStrTotalCompra(resultSet.getString("Total"));

                compras.add(compra);
            }
            return compras;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadCompra> ListarCompraExportar(String criterio) {
        Connection connection = new ClsConexionLocal().getConection();
        ArrayList<ClsEntidadCompra> compras = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CompraCreditoPorParametro(?,?)}");
            statement.setString("psalfec", criterio);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ClsEntidadCompra compra = new ClsEntidadCompra();
                compra.setStrFechaCompra(resultSet.getDate("Fecha"));
                compra.setStrRegistro(resultSet.getString("registro"));
                compra.setStrNDocumento(resultSet.getString("numerodocumento"));
                compra.setStrProveedor(resultSet.getString("proveedor"));

                compra.setStrDocumento(resultSet.getString("tipodocumento"));

                compra.setStrCompraExenta(resultSet.getString("exenta"));

                compra.setStrSubTotalCompra(resultSet.getString("SubTotal"));
                compra.setStrIgvCompra(resultSet.getString("iva"));
                compra.setStrTotalCompra(resultSet.getString("Total"));
                compra.setStrRetencion(resultSet.getString("retencion"));
                compra.setStrPersepcion(resultSet.getString("persepion"));
                compra.setStrNit(resultSet.getString("nit"));

                compras.add(compra);
            }
            return compras;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
    }

    public ResultSet listarCompraCredio(String criterio, String busqueda) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CompraCreditoPorParametro(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public void actualizarCompraEstado(String codigo, ClsEntidadCompra Compra) {
        Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_ActualizarCompraEstado(?,?)}");
            statement.setString("pidcompra", codigo);
            statement.setString("pestado", Compra.getStrEstadoCompra());
            statement.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public ResultSet listarCompraPorDetalle(String criterio, Date fechaini, Date fechafin) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CompraPorDetalle(?,?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setDate("pfechaini", new java.sql.Date(fechaini.getTime()));
            statement.setDate("pfechafin", new java.sql.Date(fechafin.getTime()));
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public void AgregarPagoACompra(ClsEntidadCompra Compra) {
        Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_AgregarPagoACompra(?,?,?)}");
            statement.setString("pIdCompra", Compra.getStrIdCompra());
            statement.setString("pEstado", "CERRADO");
            statement.setInt("pIdPago", Compra.getIntIdPago());
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void QuitarPagoACompra(ClsEntidadCompra Compra) {
        Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_AgregarPagoACompra(?,?,?)}");
            statement.setString("pIdCompra", Compra.getStrIdCompra());
            statement.setString("pEstado", "ABIERTO");
            statement.setInt("pIdPago", 0);
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void Actualizar_Estado_Detalle_Compra(Date fechaini, Date fechafin) {
        Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{SP_U_EstadoCompraDetalle(?)}");
            // statement.setDate("pfecha", new java.sql.Date(fechaini.getTime()));
            statement.setDate("p_IdPc", new java.sql.Date(fechafin.getTime()));

            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public ResultSet obtenerUltimoCorrelativocompra(String criterio) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call obtenerUltimoCorrelativo(?)}");
            statement.setString("pidcaja", criterio);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet obtenerUltimoCorrelativret(String criterio) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call obtenerUltimoCorrelativoret(?)}");
            statement.setString("pidcaja", criterio);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet obtenerperiodocontable() throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call obtenerperiodocontable()}");

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet verificarcorrelativocompra(String criterio) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ComprobarIdCompra(?)}");
            statement.setString("pcorrelativo", criterio);
            System.out.println("comprobando");
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet obtenerUltimonumeroiva(int periodo) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call obtenerUltimoNumeroIva(?)}");
            statement.setInt("pperiodo", periodo);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet ListarCompraDetalle(Date ini, Date fin) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            System.out.println(ini);
            System.out.println(fin);
            CallableStatement statement = connection.prepareCall("{call SP_S_CompraPorFechasEnvio(?,?)}");
            statement.setDate("pfecha_ini", new java.sql.Date(ini.getTime()));
            statement.setDate("pfecha_fin", new java.sql.Date(fin.getTime()));
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            JOptionPane.showMessageDialog(null, SQLex);

            throw SQLex;
        }
    }

    public ResultSet ListarCompraDetalle2(Date ini, Date fin) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            System.out.println(ini);
            System.out.println(fin);
            CallableStatement statement = connection.prepareCall("{call SP_S_CompraPorFechasEnvioDetalle(?,?)}");
            statement.setDate("pfecha_ini", new java.sql.Date(ini.getTime()));
            statement.setDate("pfecha_fin", new java.sql.Date(fin.getTime()));
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            JOptionPane.showMessageDialog(null, SQLex);

            throw SQLex;
        }
    }

    public ArrayList<ClsEntidadDetalleCompra> listarCompraEnvioDetalle(String idcompra) {
        Connection connection = new ClsConexionLocal().getConection();
        
        ArrayList<ClsEntidadDetalleCompra> compras = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CompraPorFechasEnvioDetalle(?)}");
            statement.setString("pidcompra", idcompra);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ClsEntidadDetalleCompra compra = new ClsEntidadDetalleCompra();

                // /-------/
                compra.setStrIdCompra(resultSet.getString("idcompra"));
                compra.setStrIdProducto(resultSet.getString("idproducto"));

                System.out.println(compra.getStrIdProducto());
                compra.setStrContenedor(resultSet.getString("contenedor"));
                compra.setStrCantidadDet(resultSet.getString("Cantidad"));
                compra.setStrPrecioDet(resultSet.getString("precio"));
                compra.setStrTotalDet(resultSet.getString("total"));
                compra.setStrTunidad(resultSet.getString("tunidad"));
                compra.setStrNombreProducto(resultSet.getString("nombreproducto"));

                compras.add(compra);

                System.out.println(compra.getStrIdCompra());
                System.out.println(compra.getStrIdProducto());
                System.out.println(compra.getStrNombreProducto());
                System.out.println(compra.getStrPrecioDet());

            }
            return compras;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
    }

}
