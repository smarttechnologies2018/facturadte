package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadCuentas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan H.Castro
 */
public class ClsCuentasBancos {

    private final Connection connection = new ClsConexionLocal().getConection();

    public ArrayList<ClsEntidadCuentas> listarDescuentosPorId(String Id) {
        ArrayList<ClsEntidadCuentas> descuentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_PrecioPorId(?)}");
            statement.setString("pIdProducto", Id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadCuentas descuento = new ClsEntidadCuentas();

                descuentos.add(descuento);
            }
            return descuentos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }
}
