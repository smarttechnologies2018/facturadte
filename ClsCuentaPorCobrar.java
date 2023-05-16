package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadCuentaPorCobrar;
import Liquidaciones.FrmLiquidacionesVisorAsignados;
import ds.desktop.notify.DesktopNotify;
import java.math.BigInteger;
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
public class ClsCuentaPorCobrar {

    public ResultSet listarCompraPorFecha(String criterio, Date fechaini, Date fechafin, String doc) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CompraPorFecha(?)}");
            statement.setString("pcriterio", criterio);

            rs = statement.executeQuery();
            //connection.close();

            return rs;

        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    private final Connection connection = new ClsConexionLocal().getConection();

    public void GenerarCuentaPorCobrar(ClsEntidadCuentaPorCobrar Cuenta) {
        try {
           
            CallableStatement statement = connection.prepareCall("{call SP_I_CuentaPorCobrar(?,?,?,?,?,?)}");
            statement.setString("pIdCliente", Cuenta.getStrIdCliente());
            statement.setString("pCargo", Cuenta.getStrCargo());
            statement.setString("pAbono", Cuenta.getStrAbono());
              statement.setString("ptotal", Cuenta.getStrTotal());
            
            statement.setString("pconcepto", Cuenta.getStrConcepto());
            statement.setDate("pfecha", new java.sql.Date(Cuenta.getStrFechaDate().getTime()));
           

            statement.execute();
            

         
              DesktopNotify.showDesktopMessage("", " " + "AGREAGADO", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            System.out.println("error " + ex);
        }
    }
    
    public void AnularAbonoLiq(int idliquidacion, String cliente) {
        try {
           
            CallableStatement statement = connection.prepareCall("{call SP_D_EliminarAbonoLiq(?,?)}");
            statement.setInt("pidliquidacion", idliquidacion);
            statement.setString("pIdCliente", cliente);
            
           

            statement.execute();
            

         
              DesktopNotify.showDesktopMessage("", " " + "Abono Anulado", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            System.out.println("error " + ex);
        }
    }
    
    public void AnularcreditoLiq(int idliquidacion, String cliente) {
        try {
           
            CallableStatement statement = connection.prepareCall("{call SP_D_EliminarCreditoLiq(?,?)}");
            statement.setInt("pidliquidacion", idliquidacion);
            statement.setString("pIdCliente", cliente);
            
           

            statement.execute();
            

         
              DesktopNotify.showDesktopMessage("", " " + "Abono Anulado", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            System.out.println("error " + ex);
        }
    }
    
     public void GenerarCuentaPorCobrarLiq(ClsEntidadCuentaPorCobrar Cuenta) {
        try {
           
            CallableStatement statement = connection.prepareCall("{call SP_I_CuentaPorCobrarLiq(?,?,?,?,?,?)}");
            statement.setString("pIdCliente", Cuenta.getStrIdCliente());
            statement.setString("pCargo", Cuenta.getStrCargo());
            statement.setString("pAbono", Cuenta.getStrAbono());
              statement.setString("ptotal", Cuenta.getStrTotal());
            
            statement.setString("pconcepto", Cuenta.getStrConcepto());
            statement.setInt("pliq", Cuenta.getStrIdLiquidacion());
            
           

            statement.execute();
            

         
              DesktopNotify.showDesktopMessage("", " " + "AGREAGADO", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            System.out.println("error " + ex);
        }
    }

    public void GenerarCuentaPorCobrarVenta(ClsEntidadCuentaPorCobrar Cuenta) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_CuentaPorCobrar(?,?,?,?,?,?,?)}");
            statement.setString("pIdCliente", Cuenta.getStrIdCliente());
            statement.setString("pCargo", Cuenta.getStrCargo());
            statement.setString("pAbono", Cuenta.getStrAbono());

            statement.setInt("pIdEmpleado", Cuenta.getStrIdEmpleado());
            statement.setString("pconcepto", Cuenta.getStrConcepto());

            statement.setString("pIdVenta", Cuenta.getStrIdVenta());
            statement.setString("pEstado", Cuenta.getStrEstado());

            statement.execute();

            JOptionPane.showMessageDialog(null, "¡Generado con Exito!", "Mensaje del Sistema", 1);
           // connection.close();
        } catch (SQLException ex) {
            System.out.println("error " + ex);
        }
    }

    public void GenerarCuentasPorCobrar() {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_CuentaPorCobrarGeneral()}");

            statement.execute();

            DesktopNotify.showDesktopMessage("", " " + "Cuentas Actualizadas", DesktopNotify.SUCCESS, 5000);
//            connection.close();
        } catch (SQLException ex) {
            System.out.println("error " + ex);
        }
    }

    public void GenerarCuentaPorCobrarLiquidacion(ClsEntidadCuentaPorCobrar Cuenta) {
         try {
            CallableStatement statement = connection.prepareCall("{call SP_I_CuentaPorCobrarLiquidacion(?,?,?,?,?,?,?,?)}");
            statement.setString("pIdCliente", Cuenta.getStrIdCliente());
            statement.setString("pCargo", Cuenta.getStrCargo());
            statement.setString("pAbono", Cuenta.getStrAbono());
            statement.setInt("pIdEmpleado", Cuenta.getStrIdEmpleado());
            statement.setString("pconcepto", Cuenta.getStrConcepto());
            statement.setString("pEstado_Cuenta", Cuenta.getStrCuenta_Estado());
            statement.setString("pIdCorrelativo", Cuenta.getStrIdCorrelativo());
               statement.setInt("pIdliquidacion", Cuenta.getStrIdLiquidacion());
            statement.execute();
            

          //  connection.close();
              DesktopNotify.showDesktopMessage("", " " + "AGREAGADO", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            System.out.println("error " + ex);
        }
    }

    public ArrayList<ClsEntidadCuentaPorCobrar> listarCuentasPorCobrarSinLiquidacion(String Id) {
        ArrayList<ClsEntidadCuentaPorCobrar> Cuentas = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CuentasPorCobrarSinLiquidacionPorParametro(?)}");
            statement.setString("pcriterio", Id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadCuentaPorCobrar Cuenta = new ClsEntidadCuentaPorCobrar();
                Cuenta.setStrIdCuenta(resultSet.getString("idCuentaPorCobrar"));

                Cuenta.setStrFechacuenta(resultSet.getString("fechacuenta"));
               
                Cuenta.setStrAbono(resultSet.getString("abono"));
                Cuenta.setStrConcepto(resultSet.getString("concepto"));
                Cuenta.setStrEmpleado(resultSet.getString("Nombre"));

                Cuentas.add(Cuenta);

            }
           // connection.close();
            return Cuentas;

        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadCuentaPorCobrar> listarCuentasPorCobrarLiquidacion(String Id, String Id2) {
        ArrayList<ClsEntidadCuentaPorCobrar> Cuentas = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CuentasPorCobrarLiquidacionPorParametro(?,?)}");
            statement.setString("pcriterio", Id);
            statement.setString("pcriterio2", Id2);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadCuentaPorCobrar Cuenta = new ClsEntidadCuentaPorCobrar();
                Cuenta.setStrIdCuenta(resultSet.getString("idCuentaPorCobrar"));

                Cuenta.setStrFechacuenta(resultSet.getString("fechacuenta"));
                Cuenta.setStrCargo(resultSet.getString("cargo"));
                Cuenta.setStrAbono(resultSet.getString("abono"));
              
                Cuenta.setStrConcepto(resultSet.getString("concepto"));
                Cuenta.setStrEmpleado(resultSet.getString("Nombre"));

                Cuentas.add(Cuenta);

            }
          //  connection.close();
            return Cuentas;

        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    
    public ArrayList<ClsEntidadCuentaPorCobrar> listarCuentasPorCobrarSinLiquidacionSum(String busqueda) {
        ArrayList<ClsEntidadCuentaPorCobrar> Cuentas = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CuentasPorCliente(?)}");
            statement.setString("pcriterio", busqueda);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadCuentaPorCobrar Cuenta = new ClsEntidadCuentaPorCobrar();
              Cuenta.setStrIdCuenta(resultSet.getString("codigo_cobrar"));
                Cuenta.setStrIdCliente(resultSet.getString("idcliente"));
                Cuenta.setStrNombreCliente(resultSet.getString("nombre"));
                Cuenta.setStrFechacuenta(resultSet.getString("fecha_cobrar"));
               
                Cuenta.setStrCargo(resultSet.getString("monto_cuota"));
                Cuenta.setStrAbono(resultSet.getString("monto_amortizacion"));
                  Cuenta.setStrTotal(resultSet.getString("saldofinal"));
             
                      Cuenta.setStrConcepto(resultSet.getString("concepto"));
                Cuentas.add(Cuenta);
            }
           // connection.close();
            return Cuentas;

        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }
    
       public ArrayList<ClsEntidadCuentaPorCobrar> listarCuentasPorCobrarDetallado(String busqueda) {
        ArrayList<ClsEntidadCuentaPorCobrar> Cuentas = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CuentasPorCobrarDetallado(?)}");
            statement.setString("pcriterio", busqueda);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadCuentaPorCobrar Cuenta = new ClsEntidadCuentaPorCobrar();
              Cuenta.setStrIdCuenta(resultSet.getString("idventa"));
                Cuenta.setStrIdCliente(resultSet.getString("IdCliente"));
                Cuenta.setStrNombreCliente(resultSet.getString("Nombre"));
                Cuenta.setStrFechacuenta(resultSet.getString("fecha"));
                Cuenta.setStrTipoVenta(resultSet.getString("TipoVenta"));
                Cuenta.setStrDescripcionVenta(resultSet.getString("descripcion"));
                Cuenta.setStrCargo(resultSet.getString("Cargo"));
                Cuenta.setStrAbono(resultSet.getString("abono"));
                Cuenta.setStrTotal(resultSet.getString("saldo"));
                Cuenta.setStrCuenta_Estado(resultSet.getString("Estado_Cuenta"));
                Cuenta.setStrIdCorrelativo(resultSet.getString("venta_idcuenta"));
                   Cuenta.setStrtipodoc(resultSet.getString("Descripcion"));
                      Cuenta.setStrNumerodoc(resultSet.getString("numero"));
                Cuentas.add(Cuenta);
            }
          //  connection.close();
            return Cuentas;

        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

   

    public ArrayList<ClsEntidadCuentaPorCobrar> listarCuentasPorPagar() {
        ArrayList<ClsEntidadCuentaPorCobrar> Cuentas = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CuentasPorPagarPrueba}");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadCuentaPorCobrar Cuenta = new ClsEntidadCuentaPorCobrar();
                Cuenta.setStrIdVenta(resultSet.getString("IdCompra"));
                Cuenta.setStrIdCuenta(resultSet.getString("idtb_pago"));
                Cuenta.setStrIdCliente(resultSet.getString("IdProveedor"));
                Cuenta.setStrNombreCliente(resultSet.getString("Nombre"));
                Cuenta.setStrFechacuenta(resultSet.getString("Fecha"));
                Cuenta.setStrTipoVenta(resultSet.getString("TipoCompra"));
                Cuenta.setStrTotal(resultSet.getString("saldo"));
                Cuenta.setStrDescripcionVenta(resultSet.getString("Descripcion"));
                Cuenta.setStrAbono(resultSet.getString("abono"));
                Cuenta.setStrPendiente(resultSet.getString("pendiente"));
                Cuenta.setStrCuenta_Estado(resultSet.getString("Estado_Cuenta"));
                Cuentas.add(Cuenta);
            }
            //connection.close();
            return Cuentas;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadCuentaPorCobrar> listarCuentasPorCobrar(int Id) {
        ArrayList<ClsEntidadCuentaPorCobrar> Cuentas = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CuentasPorCobrarLiquidacion(?)}");
            statement.setInt("pcriterio", Id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadCuentaPorCobrar Cuenta = new ClsEntidadCuentaPorCobrar();
                Cuenta.setStrIdCuenta(resultSet.getString("idCuentaPorCobrar"));
                Cuenta.setStrIdCliente(resultSet.getString("IdCliente"));
                Cuenta.setStrNombreCliente(resultSet.getString("nombre"));
                Cuenta.setStrFechacuenta(resultSet.getString("fechacuenta"));
                Cuenta.setStrCargo(resultSet.getString("cargo"));
                Cuenta.setStrAbono(resultSet.getString("abono"));
                Cuenta.setStrTotal(resultSet.getString("Saldo"));
                Cuentas.add(Cuenta);

            }
           // connection.close();
            return Cuentas;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public void EliminarCuentaPorCobrar(String codigo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_D_CuentaPorCobrar(?)}");
            statement.setString("pIdCuenta", codigo);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Pago Cancelado!", "Mensaje del Sistema", 1);
            //CuentasPorCobrar.FrmVerCuentasPorCobrar.BuscarCuentasPorCobrar();
           // connection.close();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public void LiberarCuentaPorPagar(String codigo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_R_CuentaPorPagar(?)}");
            statement.setString("pIdCuenta", codigo);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Cuenta Eliminada!", "Mensaje del Sistema", 1);
           // connection.close();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public ResultSet obtenerUltimaTransaccion() throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_UltimaTransaccion()}");
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet obtenerUltimaCuenta() throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_UltimaCuentaPorCobrar()}");
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
}
