package Negocio;

import Conexion.*;
import Entidad.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClsTipoUsuario {

    private final Connection connection = new ClsConexionLocal().getConection();

    public void agregarTipoUsuario(ClsEntidadTipoUsuario TipoUsuario) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_TipoUsuario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pdescripcion", TipoUsuario.getStrDescripcionTipoUsuario());
            
            statement.setString("pproducto", TipoUsuario.getP_producto());
            statement.setString("pcliente", TipoUsuario.getP_cliente());
            statement.setString("pproveedor", TipoUsuario.getP_proveedor());
            statement.setString("pempleado", TipoUsuario.getP_empleado());
            statement.setString("porden", TipoUsuario.getP_ordendecompra());
            
            statement.setString("pventaRealizada", TipoUsuario.getP_ventaRealizada());
            statement.setString("pventaDetallada", TipoUsuario.getP_ventaDetallada());
            statement.setString("pestadisticaMensual", TipoUsuario.getP_estadisticaMensual());
            statement.setString("pcompraRealizada", TipoUsuario.getP_compraRealizada());
            statement.setString("pcompraDetallada", TipoUsuario.getP_compraDetallada());
            statement.setString("pinventarioInicialReporte", TipoUsuario.getP_inventarioInicialReporte());
            
            statement.setString("pcategoria", TipoUsuario.getP_categoria());
            statement.setString("ptipoDocumento", TipoUsuario.getP_tipoDocumento());
            statement.setString("ptipoUsuario", TipoUsuario.getP_tipoUsuario());
            statement.setString("pdatosEmpresa", TipoUsuario.getP_datosEmpresa());
            statement.setString("pcajas", TipoUsuario.getP_cajas());
            statement.setString("pgastos", TipoUsuario.getP_gastos());
            statement.setString("prutas", TipoUsuario.getP_rutas());
            statement.setString("pbancos", TipoUsuario.getP_bancos());
            statement.setString("pofertas", TipoUsuario.getP_ofertas());
            
            statement.setString("pcompra", TipoUsuario.getP_compra());
            statement.setString("pactualizarDB", TipoUsuario.getP_actualizarDB());
            statement.setString("pinventarioInicial", TipoUsuario.getP_inventarioInicial());
            statement.setString("pfinalizarInventario", TipoUsuario.getP_finalizarInventario());
            statement.setString("penvioVentaCompra", TipoUsuario.getP_envioVentaCompra());
            
            statement.setString("ppuntoVenta", TipoUsuario.getP_puntoVenta());
            statement.setString("pdevolucionVenta", TipoUsuario.getP_devolucionVenta());
            statement.setString("pdocumentos", TipoUsuario.getP_documentos());
            statement.setString("pcorteX", TipoUsuario.getP_corteX());
            statement.setString("pcorteZ", TipoUsuario.getP_corteZ());
            
            statement.setString("ptomaPedidos", TipoUsuario.getP_tomaPedidos());
            statement.setString("pdocumentosPendientes", TipoUsuario.getP_documentosPendientes());
            statement.setString("pdocumentosEmitidos", TipoUsuario.getP_documentosEmitidos());
            statement.setString("pcuentasPorCobrar", TipoUsuario.getP_cuentasPorCobrar());
            
            statement.setString("pverCuentas", TipoUsuario.getP_verCuentas());
            
            statement.setString("pverLiquidacion", TipoUsuario.getP_verLiquidacion());
            
            statement.setString("panularVenta", TipoUsuario.getP_anularVenta());
            statement.setString("panularCompra", TipoUsuario.getP_anularCompra());
            
            statement.setString("pactualizarLibroCompra", TipoUsuario.getP_actualizarLibroCompra());
            statement.setString("preporteLibroCompra", TipoUsuario.getP_reporteLibroCompra());
            
            statement.setString("pcambiarContrasenia", TipoUsuario.getP_cambiarContrasenia());
            statement.setString("prespaldarDB", TipoUsuario.getP_respaldarDB());
            statement.setString("prestaurarDB", TipoUsuario.getP_restaurarDB());
            
            statement.setString("pcajaDinero", TipoUsuario.getP_cajaDinero());
            statement.setString("pestado", TipoUsuario.getP_estado());
            
            //informe
            statement.setString("preporteLibroVenta", TipoUsuario.getP_ReporteLibroVentas());
            statement.setString("pkardex", TipoUsuario.getP_kardex());
            statement.setString("pservicio", TipoUsuario.getP_servicios());
            statement.setString("pActualizarLibroVenta", TipoUsuario.getP_ActualizarLibroVenta());
            statement.execute();
            JOptionPane.showMessageDialog(null, "¡Tipo de Usuario Agregado con éxito!", "Mensaje del Sistema", 1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void modificarTipoUsuario(ClsEntidadTipoUsuario TipoUsuario) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_TipoUsuario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidtipousuario", TipoUsuario.getStrIdTipoUsuario());
             statement.setString("porden", TipoUsuario.getP_ordendecompra());
            
            statement.setString("pdescripcion", TipoUsuario.getStrDescripcionTipoUsuario());
            
            statement.setString("pproducto", TipoUsuario.getP_producto());
            statement.setString("pcliente", TipoUsuario.getP_cliente());
            statement.setString("pproveedor", TipoUsuario.getP_proveedor());
            statement.setString("pempleado", TipoUsuario.getP_empleado());
            
            statement.setString("pventaRealizada", TipoUsuario.getP_ventaRealizada());
            statement.setString("pventaDetallada", TipoUsuario.getP_ventaDetallada());
            statement.setString("pestadisticaMensual", TipoUsuario.getP_estadisticaMensual());
            statement.setString("pcompraRealizada", TipoUsuario.getP_compraRealizada());
            statement.setString("pcompraDetallada", TipoUsuario.getP_compraDetallada());
            statement.setString("pinventarioInicialReporte", TipoUsuario.getP_inventarioInicialReporte());
            
            statement.setString("pcategoria", TipoUsuario.getP_categoria());
            statement.setString("ptipoDocumento", TipoUsuario.getP_tipoDocumento());
            statement.setString("ptipoUsuario", TipoUsuario.getP_tipoUsuario());
            statement.setString("pdatosEmpresa", TipoUsuario.getP_datosEmpresa());
            statement.setString("pcajas", TipoUsuario.getP_cajas());
            statement.setString("pgastos", TipoUsuario.getP_gastos());
            statement.setString("prutas", TipoUsuario.getP_rutas());
            statement.setString("pbancos", TipoUsuario.getP_bancos());
            statement.setString("pofertas", TipoUsuario.getP_ofertas());
            
            statement.setString("pcompra", TipoUsuario.getP_compra());
            statement.setString("pactualizarDB", TipoUsuario.getP_actualizarDB());
            statement.setString("pinventarioInicial", TipoUsuario.getP_inventarioInicial());
            statement.setString("pfinalizarInventario", TipoUsuario.getP_finalizarInventario());
            statement.setString("penvioVentaCompra", TipoUsuario.getP_envioVentaCompra());
            
            statement.setString("ppuntoVenta", TipoUsuario.getP_puntoVenta());
            statement.setString("pdevolucionVenta", TipoUsuario.getP_devolucionVenta());
            statement.setString("pdocumentos", TipoUsuario.getP_documentos());
            statement.setString("pcorteX", TipoUsuario.getP_corteX());
            statement.setString("pcorteZ", TipoUsuario.getP_corteZ());
            
            statement.setString("ptomaPedidos", TipoUsuario.getP_tomaPedidos());
            statement.setString("pdocumentosPendientes", TipoUsuario.getP_documentosPendientes());
            statement.setString("pdocumentosEmitidos", TipoUsuario.getP_documentosEmitidos());
            statement.setString("pcuentasPorCobrar", TipoUsuario.getP_cuentasPorCobrar());
            
            statement.setString("pverCuentas", TipoUsuario.getP_verCuentas());
            
            statement.setString("pverLiquidacion", TipoUsuario.getP_verLiquidacion());
            
            statement.setString("panularVenta", TipoUsuario.getP_anularVenta());
            statement.setString("panularCompra", TipoUsuario.getP_anularCompra());
            
            statement.setString("pactualizarLibroCompra", TipoUsuario.getP_actualizarLibroCompra());
            statement.setString("preporteLibroCompra", TipoUsuario.getP_reporteLibroCompra());
            
            statement.setString("pcambiarContrasenia", TipoUsuario.getP_cambiarContrasenia());
            statement.setString("prespaldarDB", TipoUsuario.getP_respaldarDB());
            statement.setString("prestaurarDB", TipoUsuario.getP_restaurarDB());
            
            statement.setString("pcajaDinero", TipoUsuario.getP_cajaDinero());
            statement.setString("pestado", TipoUsuario.getP_estado());
            
           //nuevos
            statement.setString("preporteLibroVenta", TipoUsuario.getP_ReporteLibroVentas());
            statement.setString("pkardex", TipoUsuario.getP_kardex());
            statement.setString("pservicio", TipoUsuario.getP_servicios());
            statement.setString("pActualizarLibroVenta", TipoUsuario.getP_ActualizarLibroVenta());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(null, "¡Tipo de Usuario Actualizado!", "Mensaje del Sistema", 1);
    }

    public void modificarTipoUsuarioLocal(ClsEntidadTipoUsuario TipoUsuario) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_TipoUsuario("
                    + "?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?"
                    + ",?,?,?,?,?,?,?,?,?,?"
                    + ",?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidtipousuario", TipoUsuario.getStrIdTipoUsuario());            
            statement.setString("pdescripcion", TipoUsuario.getStrDescripcionTipoUsuario());            
            statement.setString("pproducto", TipoUsuario.getP_producto());
            statement.setString("pcliente", TipoUsuario.getP_cliente());
            statement.setString("pproveedor", TipoUsuario.getP_proveedor());
            
            statement.setString("pempleado", TipoUsuario.getP_empleado());            
            statement.setString("pventaRealizada", TipoUsuario.getP_ventaRealizada());
            statement.setString("pventaDetallada", TipoUsuario.getP_ventaDetallada());
            statement.setString("pestadisticaMensual", TipoUsuario.getP_estadisticaMensual());            
            statement.setString("pcompraRealizada", TipoUsuario.getP_compraRealizada());
            
            statement.setString("pcompraDetallada", TipoUsuario.getP_compraDetallada());
            statement.setString("pinventarioInicialReporte", TipoUsuario.getP_inventarioInicialReporte());            
            statement.setString("pcategoria", TipoUsuario.getP_categoria());
            statement.setString("ptipoDocumento", TipoUsuario.getP_tipoDocumento());
            statement.setString("ptipoUsuario", TipoUsuario.getP_tipoUsuario());
            
            statement.setString("pdatosEmpresa", TipoUsuario.getP_datosEmpresa());
            statement.setString("pcajas", TipoUsuario.getP_cajas());
            statement.setString("pgastos", TipoUsuario.getP_gastos());
            statement.setString("prutas", TipoUsuario.getP_rutas());
            statement.setString("pbancos", TipoUsuario.getP_bancos());
            
            
            
            statement.setString("pofertas", TipoUsuario.getP_ofertas());            
            statement.setString("pcompra", TipoUsuario.getP_compra());
            statement.setString("pactualizarDB", TipoUsuario.getP_actualizarDB());
            statement.setString("pinventarioInicial", TipoUsuario.getP_inventarioInicial());
            statement.setString("pfinalizarInventario", TipoUsuario.getP_finalizarInventario());
            
            statement.setString("penvioVentaCompra", TipoUsuario.getP_envioVentaCompra());            
            statement.setString("ppuntoVenta", TipoUsuario.getP_puntoVenta());
            statement.setString("pdevolucionVenta", TipoUsuario.getP_devolucionVenta());
            statement.setString("pdocumentos", TipoUsuario.getP_documentos());
            statement.setString("pcorteX", TipoUsuario.getP_corteX());
            
            
            
            statement.setString("pcorteZ", TipoUsuario.getP_corteZ());            
            statement.setString("ptomaPedidos", TipoUsuario.getP_tomaPedidos());
            statement.setString("pdocumentosPendientes", TipoUsuario.getP_documentosPendientes());
            statement.setString("pdocumentosEmitidos", TipoUsuario.getP_documentosEmitidos());
            statement.setString("pcuentasPorCobrar", TipoUsuario.getP_cuentasPorCobrar());    
            
            statement.setString("pverCuentas", TipoUsuario.getP_verCuentas());            
            statement.setString("pverLiquidacion", TipoUsuario.getP_verLiquidacion());     
             statement.setString("porden", TipoUsuario.getP_ordendecompra());
            statement.setString("panularVenta", TipoUsuario.getP_anularVenta());
            statement.setString("panularCompra", TipoUsuario.getP_anularCompra());            
            statement.setString("pactualizarLibroCompra", TipoUsuario.getP_actualizarLibroCompra());
            
            
            statement.setString("preporteLibroCompra", TipoUsuario.getP_reporteLibroCompra());            
            statement.setString("pcambiarContrasenia", TipoUsuario.getP_cambiarContrasenia());
            statement.setString("prespaldarDB", TipoUsuario.getP_respaldarDB());
            statement.setString("prestaurarDB", TipoUsuario.getP_restaurarDB());            
            statement.setString("pcajaDinero", TipoUsuario.getP_cajaDinero());
            statement.setString("pestado", TipoUsuario.getP_estado());        
            statement.setString("preporteLibroVenta", TipoUsuario.getP_ReporteLibroVentas());
            statement.setString("pkardex", TipoUsuario.getP_kardex());
            statement.setString("pservicio", TipoUsuario.getP_servicios());
            statement.setString("pActualizarLibroVenta", TipoUsuario.getP_ActualizarLibroVenta());
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<ClsEntidadTipoUsuario> listarTipoUsuario() {
        ArrayList<ClsEntidadTipoUsuario> tipousuariousuarios = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_TipoUsuario}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadTipoUsuario tipousuario = new ClsEntidadTipoUsuario();
                tipousuario.setStrIdTipoUsuario(resultSet.getString("IdTipoUsuario"));
                tipousuario.setStrDescripcionTipoUsuario(resultSet.getString("Descripcion"));
             
                tipousuariousuarios.add(tipousuario);
            }
            return tipousuariousuarios;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
       }
    }

    public ResultSet listarTipoUsuarioPorParametro(String criterio, String busqueda) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_TipoUsuarioPorParametro(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet consultarLoginPermisos(String nomuser, String tipouser) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_LoginPermisos(?,?)}");
            statement.setString("pnombre_usuario", nomuser);
            System.out.println(nomuser);
             System.out.println(tipouser);
            statement.setString("pdescripcion_tipousuario", tipouser);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
}