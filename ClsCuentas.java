package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadCuentas;
import ds.desktop.notify.DesktopNotify;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author servidor
 */
public class ClsCuentas {

    private final Connection connection = new ClsConexionLocal().getConection();

    public ResultSet ConsultarCuentas(String id) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Cuentasbancos(?)}");
            statement.setString("id", id);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet ConsultarCuentaspago(String pnombre) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CuentasPago(?)}");
            statement.setString("pnombre", pnombre);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;

        }
    }

    public ResultSet IdPago() throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_IDPago()}");

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public void agregarCuentas(ClsEntidadCuentas Cuentas) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Cuenta(?,?,?,?)}");
            statement.setString("pnumerocuenta", Cuentas.getStrNumeroCuenta());
            statement.setInt("pidbanco", Cuentas.getStrIdban());
            statement.setString("ptitular", Cuentas.getStrDescripcion());
            statement.setString("pestado", Cuentas.getStrEstado());
            statement.execute();
            DesktopNotify.showDesktopMessage("", "" + "Cuenta Guardada", DesktopNotify.SUCCESS, 4444);
            //  connection.close();
        } catch (SQLException ex) {
            System.err.println("Error al insertar: " + ex);
        }
    }

    public void agregarpago(ClsEntidadCuentas Cuentas) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Pago(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("ppago_id", Cuentas.getStrcorrelativo());
            statement.setInt("ppago_idproveedor", Cuentas.getStrIdproveedor());
            statement.setInt("ppago_idcuenta", Cuentas.getStrIdCuenta());
            statement.setInt("ppago_iddocumento", Cuentas.getStrIdocumento());

            statement.setString("ppago_numero", Cuentas.getStrnumerodoc());
            statement.setInt("ppago_idempresa", Cuentas.getStridempresa());
            statement.setDouble("ppago_abono", Cuentas.getStrabono());
            statement.setDouble("ppago_cargo", Cuentas.getStrCargo());

            statement.setDouble("ppago_desc1", Cuentas.getStrdesc1());
            statement.setString("ppago_decrip1", Cuentas.getStrDescripcion());
            statement.setDouble("ppago_desc2", Cuentas.getStrdesc2());
            statement.setString("ppago_descrip2", Cuentas.getStrDescripcion2());

            statement.setInt("ppago_idususario", Cuentas.getStridusuario());
            statement.setDate("ppago_fechapago", new java.sql.Date(Cuentas.getStrfecha().getTime()));

            statement.execute();
            DesktopNotify.showDesktopMessage("", "" + "Datos Guardados", DesktopNotify.SUCCESS, 4444);
            //  connection.close();
        } catch (SQLException ex) {
            System.err.println("Error al insertar: " + ex);
        }
    }

    public void modificaBanco(ClsEntidadCuentas Cuenta) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Cuenta(?,?,?,?,?)}");
            statement.setInt("pidcuenta", Cuenta.getStrIdCuenta());
            statement.setString("pnumerocuenta", Cuenta.getStrNumeroCuenta());
            statement.setInt("pidbanco", Cuenta.getStrIdban());
            statement.setString("ptitular", Cuenta.getStrDescripcion());
            statement.setString("pestado", Cuenta.getStrEstado());
            statement.executeUpdate();

            DesktopNotify.showDesktopMessage("", "" + "Cuenta Actualizada", DesktopNotify.SUCCESS, 4444);
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
        //JOptionPane.showMessageDialog(null, "¡Producto Actualizado!", "Mensaje del Sistema", 1);
    }

    public ResultSet ConsultarDepositosaCuentas(String id) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call sp_s_Desposito_Cuentas(?)}");
            statement.setString("pIdCuenta", id);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet Ver_Cuentas(String nombre) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CuentasPago(?)}");
            statement.setString("pnombre", nombre);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public void EliminarDeposito(int codigo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_D_EliminarTransaccion(?)}");
            statement.setInt("pIdDeposito", codigo);
            boolean resp = statement.execute();
            if (resp == true) {
                JOptionPane.showMessageDialog(null, "¡Ocurrio un error al agregado el Deposito!", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
            } else {
                Banco.FrmDeposito.Actualizar("E");
                JOptionPane.showMessageDialog(null, "¡Deposito Agregado con éxito!", "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
            Banco.FrmDeposito.BuscarCuentas();
            //  connection.close();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public void SumarSaldoCuentas(ClsEntidadCuentas Cuenta, String criterio) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_SumarSaldoCuentas(?,?,?)}");
            statement.setString("pCriterio", criterio);
            statement.setInt("pidCuenta", Cuenta.getStrIdCuenta());
            statement.setDouble("psaldo", Cuenta.getDoubleSaldo());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
        //JOptionPane.showMessageDialog(null, "¡Producto Actualizado!", "Mensaje del Sistema", 1);
    }
}
