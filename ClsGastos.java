package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadGastosVarios;
import ds.desktop.notify.DesktopNotify;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ramos
 */
public class ClsGastos {

    private final Connection connection = new ClsConexionLocal().getConection();

    public void agregarGasto(ClsEntidadGastosVarios Gastos) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Gasto(?,?,?,?,?,?,?,?,?,?,?)}");

            statement.setString("p_Valor", Gastos.getStrValor());
            statement.setString("p_Detalle", Gastos.getStrDetalle());
            statement.setString("p_IdCaja", Gastos.getStrIdCaja());
            statement.setString("p_TipoTransaccion", Gastos.getStrTipoTransaccion());
            statement.setString("p_Observacion", Gastos.getStrObservacion());
            statement.setString("p_Empresa", Gastos.getStrEmpresa());
            statement.setString("p_IdTipoGasto", Gastos.getStrIdTipoGasto());
            statement.setString("p_Estado", Gastos.getStrEstado());
            statement.setString("p_idcorrelativo", Gastos.getIdCorrelativo());
            statement.setString("p_corte", Gastos.getStrCorte());
            statement.setDate("p_Fecha", new java.sql.Date(Gastos.getStrFecha().getTime()));

            statement.execute();

            DesktopNotify.showDesktopMessage("", "" + "Gasto Agregado ", DesktopNotify.SUCCESS, 4444);
//            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex + "alv ");
        }
    }

    public void agregarGastocompra(ClsEntidadGastosVarios Gastos) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Gastocproveedor(?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            statement.setString("p_Valor", Gastos.getStrValor());
            statement.setString("p_Detalle", Gastos.getStrDetalle());
            statement.setString("p_IdCaja", Gastos.getStrIdCaja());
            statement.setString("p_TipoTransaccion", Gastos.getStrTipoTransaccion());
            statement.setString("p_Observacion", Gastos.getStrObservacion());
            statement.setString("p_Empresa", Gastos.getStrEmpresa());
            statement.setString("p_IdTipoGasto", Gastos.getStrIdTipoGasto());
            statement.setString("p_Estado", Gastos.getStrEstado());
            statement.setString("p_idcorrelativo", Gastos.getIdCorrelativo());
            statement.setString("p_corte", Gastos.getStrCorte());
            statement.setDate("p_Fecha", new java.sql.Date(Gastos.getStrFecha().getTime()));
            statement.setString("pnumerofacturas", Gastos.getStrnumfacturas());
             statement.setString("pnumeroletra", Gastos.getStrmontoletra());

            statement.execute();

            DesktopNotify.showDesktopMessage("", "" + "Datos Guardados", DesktopNotify.SUCCESS, 4444);
//            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex + "alv ");
        }
    }

    public void agregarGastoventa(ClsEntidadGastosVarios Gastos) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_GastoVenta(?,?,?,?,?,?,?,?,?,?,?,?)}");

            statement.setDate("p_Fecha", new java.sql.Date(Gastos.getStrFecha().getTime()));
            statement.setString("p_Valor", Gastos.getStrValor());
            statement.setString("p_Detalle", Gastos.getStrDetalle());
            statement.setString("p_IdCaja", Gastos.getStrIdCaja());
            statement.setString("p_TipoTransaccion", Gastos.getStrTipoTransaccion());
            statement.setString("p_Observacion", Gastos.getStrObservacion());
            statement.setString("p_Empresa", Gastos.getStrEmpresa());
            statement.setString("p_IdTipoGasto", Gastos.getStrIdTipoGasto());
            statement.setString("p_Estado", Gastos.getStrEstado());
            statement.setString("p_idcorrelativo", Gastos.getIdCorrelativo());
            statement.setString("p_corte", Gastos.getStrCorte());
            statement.setString("pidventa", Gastos.getIdventa());

            statement.execute();

            DesktopNotify.showDesktopMessage("", "" + "Gasto Agregado ", DesktopNotify.SUCCESS, 4444);
//            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex + "error en gasto ");
        }
    }

    public ResultSet obtenerUltimoIdGasto(String pidempresa) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ObtenerIdGasto(?)}");
            statement.setString("pidempresa", pidempresa);
            rs = statement.executeQuery();

            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet comprobarcorte(int idcaja, int cortez) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CompobarCorte(?,?)}");
            statement.setInt("pidcaja", idcaja);
            statement.setInt("pcortez", cortez);
            rs = statement.executeQuery();

            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet comprobar_id_gasto(String idcorrelativo) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ComprobarIdGasto(?)}");
            statement.setString("pidcorreltivo", idcorrelativo);
            rs = statement.executeQuery();

            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public void agregarGastoLiquidacion(ClsEntidadGastosVarios Gastos) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_GastoPorLiquidacionZeus(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
//            statement.setDate("p_Fecha", new java.sql.Date(Gastos.getStrFecha().getTime()));
            statement.setString("p_Valor", Gastos.getStrValor());
            statement.setString("p_Detalle", Gastos.getStrDetalle());
            statement.setString("p_TipoTransaccion", Gastos.getStrTipoTransaccion());
            statement.setString("p_Observacion", Gastos.getStrObservacion());
            statement.setString("p_Empresa", Gastos.getStrEmpresa());
            statement.setString("p_IdTipoGasto", Gastos.getStrIdTipoGasto());
            statement.setString("p_Estado", Gastos.getStrEstado());
            statement.setString("p_IdLiquidacion", Gastos.getStrIdLiquidacion());
            statement.setString("p_IdCorrelativo", Gastos.getIdCorrelativo());

            statement.setInt("p100", Gastos.getS100());
            statement.setInt("p50", Gastos.getS50());
            statement.setInt("p20", Gastos.getS20());
            statement.setInt("p10", Gastos.getS10());
            statement.setInt("p5", Gastos.getS5());
            statement.setInt("p1", Gastos.getS1());
            statement.execute();
            DesktopNotify.showDesktopMessage("", "" + "Gasto Agregado ", DesktopNotify.SUCCESS, 4444);
//            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex + "aqui");
        }
    }

    public void modificarGasto(String Id, ClsEntidadGastosVarios Gastos) throws SQLException {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Gasto(?,?,?,?,?,?,?,?,?)}");
            statement.setString("p_Id", Id);
            statement.setDate("p_Fecha", new java.sql.Date(Gastos.getStrFecha().getTime()));
            statement.setString("p_Valor", Gastos.getStrValor());
            statement.setString("p_Detalle", Gastos.getStrDetalle());
            statement.setString("p_IdCaja", Gastos.getStrIdCaja());
            statement.setString("p_TipoTransaccion", Gastos.getStrTipoTransaccion());
            statement.setString("p_Observacion", Gastos.getStrObservacion());
            //statement.setString("p_Empresa",Gastos.getStrEmpresa());
            statement.setString("p_IdTipoGasto", Gastos.getStrIdTipoGasto());
            statement.setString("p_Estado", Gastos.getStrEstado());
            statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //   connection.close();
        JOptionPane.showMessageDialog(null, "¡Gasto Actualizado!", "Mensaje del Sistema", 1);

    }

    public void aumentar_id_gasto(int Idempresa) throws SQLException {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_IdGasto_Empresa(?)}");
            statement.setInt("pidempresa", Idempresa);

            statement.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "¡ERROR EN IDGASTO!", "Mensaje del Sistema", 1);
            System.out.println(ex);
        }
        //   connection.close();

    }

    public ResultSet listarGastoPorFecha(String criterio, Date fechaini, int idempresa) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_GastosPorFecha(?,?,?)}");
            statement.setString("pCriterio", criterio);
            statement.setInt("pIdempresa", idempresa);
            statement.setDate("pFecha", new java.sql.Date(fechaini.getTime()));
            rs = statement.executeQuery();
            return rs;

        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ArrayList<ClsEntidadGastosVarios> listarGastoPorLiquidacion(Integer Id) {
        ArrayList<ClsEntidadGastosVarios> Cuentas = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_GastosPorLiquidacion(?)}");
            statement.setInt("pCriterio", Id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadGastosVarios Cuenta = new ClsEntidadGastosVarios();
                Cuenta.setStrIdTipoGasto(resultSet.getString("Id"));
                Cuenta.setStrDetalle(resultSet.getString("concepto"));
                Cuenta.setMonto(resultSet.getDouble("monto"));
                Cuenta.setStrTotal(resultSet.getString("total"));
                Cuenta.setStrTipoTransaccion(resultSet.getString("dato"));
                Cuenta.setStrIdGasto(resultSet.getInt("idg"));
                Cuenta.setStrtipotrans(resultSet.getString("tipo"));
                Cuentas.add(Cuenta);
            }
//            connection.close();
            return Cuentas;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ResultSet listarGastoPorFechaCaja(Date fecha, String idcaja, String Corte) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_GastosPorFechaCaja(?,?,?)}");

            statement.setDate("pFecha", new java.sql.Date(fecha.getTime()));
            statement.setString("pIdCaja", idcaja);
            statement.setString("pcorte", Corte);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listarGastosSalidas(Date fecha) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_SumSalidas(?)}");
            statement.setDate("pFecha", new java.sql.Date(fecha.getTime()));
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public void actualizarGastoEstado(String Id) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_ActualizarGastoEstado(?)}");
            statement.setString("pIdGasto", Id);

            statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        DesktopNotify.showDesktopMessage("", "" + "GASTO ANULADO", DesktopNotify.SUCCESS, 4444);
    }

    public void CierreCaja(ClsEntidadGastosVarios Gastos) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Gasto(?,?,?,?,?,?,?,?,?)}");
            statement.setDate("p_Fecha", new java.sql.Date(Gastos.getStrFecha().getTime()));
            statement.setString("p_Valor", Gastos.getStrValor());
            statement.setString("p_Detalle", Gastos.getStrDetalle());
            statement.setString("p_IdCaja", Gastos.getStrIdCaja());
            statement.setString("p_TipoTransaccion", Gastos.getStrTipoTransaccion());
            statement.setString("p_Observacion", Gastos.getStrObservacion());
            statement.setString("p_Empresa", Gastos.getStrEmpresa());
            statement.setString("p_IdTipoGasto", Gastos.getStrIdTipoGasto());
            statement.setString("p_Estado", Gastos.getStrEstado());
            statement.execute();
            JOptionPane.showMessageDialog(null, "¡Cerrado!", "Mensaje del Sistema", 1);
            // connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public int ConsultarCierre(Date fecha, String Estado) {
        ResultSet rs = null;
        try {
            int Existe = 0;
            CallableStatement statement = connection.prepareCall("{call SP_S_CountCierreCajaPorFecha(?,?)}");
            statement.setDate("pFecha", new java.sql.Date(fecha.getTime()));
            statement.setString("pEstado", Estado);
            rs = statement.executeQuery();
            while (rs.next()) {
                Existe = rs.getInt("ExisteCierre");
            }
            // connection.close();
            return Existe;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }

    public void borrarCierre(ClsEntidadGastosVarios Gastos) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_D_Cierre(?,?)}");
            statement.setDate("pfecha", new java.sql.Date(Gastos.getStrFecha().getTime()));
            statement.setString("pEstado", Gastos.getStrEstado());
            statement.executeUpdate();
            //  connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(null, "¡Caja Abierta!", "Mensaje del Sistema", 1);
    }

    public void agregarCierre(ClsEntidadGastosVarios Gastos) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Gasto(?,?,?,?,?,?,?,?,?)}");
            statement.setDate("p_Fecha", new java.sql.Date(Gastos.getStrFecha().getTime()));
            statement.setString("p_Valor", Gastos.getStrValor());
            statement.setString("p_Detalle", Gastos.getStrDetalle());
            statement.setString("p_IdCaja", Gastos.getStrIdCaja());
            statement.setString("p_TipoTransaccion", Gastos.getStrTipoTransaccion());
            statement.setString("p_Observacion", Gastos.getStrObservacion());
            statement.setString("p_Empresa", Gastos.getStrEmpresa());
            statement.setString("p_IdTipoGasto", Gastos.getStrIdTipoGasto());
            statement.setString("p_Estado", Gastos.getStrEstado());
            statement.execute();

            JOptionPane.showMessageDialog(null, "¡Dia Cerrado con Exito!", "Mensaje del Sistema", 1);
            //  connection.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ResultSet ListarGastosEnvio(Date ini, Date fin) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_GastosPorFechaEnvio(?,?)}");
            statement.setDate("pfecha_ini", new java.sql.Date(ini.getTime()));
            statement.setDate("pfecha_fin", new java.sql.Date(fin.getTime()));
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            JOptionPane.showMessageDialog(null, SQLex);
            throw SQLex;
        }
    }
}
