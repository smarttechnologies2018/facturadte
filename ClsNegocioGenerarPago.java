package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadGenerarPago;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;

/**
 *
 * @author JoseRamos
 */
public class ClsNegocioGenerarPago {

    private final Connection connection = new ClsConexionLocal().getConection();

    public void agregarPago(ClsEntidadGenerarPago Pago) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_GenerarPago(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setInt("pIdTipoDocumento", Pago.getIntIdTipoDocumento());
            statement.setInt("pIdChequera", Pago.getIntIdChequera());
            statement.setString("pNumerocheque", Pago.getStrNumeroCheque());
            statement.setInt("pIdProveedor", Pago.getIntIdProveedor());
            statement.setDouble("pSubTotal", Pago.getDoubleSubTotal());
            statement.setDouble("pDescuento1", Pago.getDoubleDescuento1());
            statement.setString("pConcepto1", Pago.getStrConcepto1());
            statement.setDouble("pDescuento2", Pago.getDoubleDescuento2());
            statement.setString("pConcepto2", Pago.getStrConcepto2());
            statement.setDouble("pDescuento3", Pago.getDoubleDescuento3());
            statement.setString("pConcepto3", Pago.getStrConcepto3());
            statement.setDouble("pTotal", Pago.getDoubleTotal());
            statement.setString("pValorEnLetras", Pago.getStrValorEnLetras());
            statement.setDate("pFecha", new java.sql.Date(Pago.getDateFecha().getTime()));
            statement.setInt("pIdEmpresa", Pago.getIntIdEmpresa());
            statement.setString("pOperacion", Pago.getStrOperacion());
            statement.setString("pTransaccion", Pago.getStrNTransaccion());
            statement.registerOutParameter("out_id", Types.INTEGER);
            boolean resp = statement.execute();
            final ResultSet rs = statement.getResultSet();
            while (rs.next()) {
            }
            int outputValue = statement.getInt("out_id");
            
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }
    }
    
    public void agregarDeposito(ClsEntidadGenerarPago Pago) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_GenerarDeposito(?,?,?,?,?,?,?,?,?)}");
            statement.setInt("pIdTipoDocumento", Pago.getIntIdTipoDocumento());
            statement.setInt("pIdChequera", Pago.getIntIdChequera());
            statement.setString("pNumerocheque", Pago.getStrNumeroCheque());
            statement.setDouble("pTotal", Pago.getDoubleTotal());
            statement.setString("pValorEnLetras", Pago.getStrValorEnLetras());
            statement.setDate("pFecha", new java.sql.Date(Pago.getDateFecha().getTime()));
            statement.setInt("pIdEmpresa", Pago.getIntIdEmpresa());
            statement.setString("pOperacion", Pago.getStrOperacion());
            statement.setString("pTransaccion", Pago.getStrNTransaccion());
            boolean resp = statement.execute();

            if (resp == true) {
                JOptionPane.showMessageDialog(null, "¡Ocurrio un error al agregado el Deposito!", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
            } else {
                Banco.FrmDeposito.Actualizar("I");
                JOptionPane.showMessageDialog(null, "¡Deposito Agregado con éxito!", "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }
    }
}
