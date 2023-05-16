package Negocio;

import Conexion.*;
import Entidad.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HenryG.Castro
 */
public class ClsPresentacionVentabarra {

    private final Connection connection = new ClsConexionLocal().getConection();
    private final String sSQL = "";

    
    public ArrayList<ClsEntidadSVenta> listarProductoActivo(String cod) {
        ArrayList<ClsEntidadSVenta> productosVenta = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_medidabarra(?)}");
            statement.setString("Id", cod);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadSVenta producto = new ClsEntidadSVenta();
                producto.setStrsCodigo(resultSet.getString("Codigo"));
                producto.setIdmMedida(resultSet.getString("idmedida"));
                producto.setIdProducto(resultSet.getString("idProducto"));
                producto.setContenedor(resultSet.getString("contenedor"));
                producto.setNombre(resultSet.getString("Nombre"));
                producto.setUnidades(resultSet.getString("unidades"));
                producto.setPrecioUnidad(resultSet.getString("punidad"));
                producto.setDescuento(resultSet.getString("porcentaje"));
                producto.setTotal(resultSet.getString("precio2"));
                producto.setBarra(resultSet.getString("barra"));
                productosVenta.add(producto);
            }
            return productosVenta;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }
    
    public ArrayList<ClsEntidadSVenta> listarProductoActivoUnidad(String cod) {
        ArrayList<ClsEntidadSVenta> productosVenta = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_medidaUnidad(?)}");
            statement.setString("Id", cod);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadSVenta producto = new ClsEntidadSVenta();
                producto.setStrsCodigo(resultSet.getString("Codigo"));
                producto.setIdmMedida(resultSet.getString("idmedida"));
                producto.setIdProducto(resultSet.getString("idProducto"));
                producto.setContenedor(resultSet.getString("contenedor"));
                producto.setNombre(resultSet.getString("Nombre"));
                producto.setUnidades(resultSet.getString("unidades"));
                producto.setPrecioUnidad(resultSet.getString("punidad"));
                producto.setDescuento(resultSet.getString("porcentaje"));
                producto.setTotal(resultSet.getString("precio2"));
                producto.setBarra(resultSet.getString("barra"));
                productosVenta.add(producto);
            }
            return productosVenta;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }
}
