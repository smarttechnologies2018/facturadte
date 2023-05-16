package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadAgregarPresentacion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author WILLIAM
 */
public class ClsAgregarPresentacion {

    private final Connection connection = new ClsConexionLocal().getConection();

    public ArrayList<ClsEntidadAgregarPresentacion> listarProductoActivo(String cod) {
        ArrayList<ClsEntidadAgregarPresentacion> presentaciones = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_medida(?)}");
            statement.setString("Id", cod);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadAgregarPresentacion presentacion = new ClsEntidadAgregarPresentacion();
                presentacion.setStrIdMedida(resultSet.getString("idmedida"));
                presentacion.setStrIdProducto(resultSet.getString("idProducto"));
                presentacion.setStrIdProducto(resultSet.getString("idProducto"));
                presentacion.setStrNombre(resultSet.getString("Nombre"));
                presentacion.setStrUnidades(resultSet.getString("unidades"));
                presentacion.setStrpUnidades(resultSet.getString("punidad"));
                presentacion.setStrPrecioContenedor(resultSet.getString("preciocontenedor"));
                presentacion.setStrCPorcentaje(resultSet.getString("porcentaje"));
                presentacion.setStrCPrecio2(resultSet.getString("precio2"));
            }
            return presentaciones;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }
}
