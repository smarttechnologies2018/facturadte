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
public class ClsPresentacionCompra {

    private final Connection connection = new ClsConexionLocal().getConection();
    private final String sSQL = "";

    public ArrayList<ClsEntidadSCompra> listarProductoActivo(String cod) {
        ArrayList<ClsEntidadSCompra> productosCompra = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_medidaCompraCod(?)}");
            statement.setString("Id", cod);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadSCompra producto = new ClsEntidadSCompra();
                producto.setStrsCodigo(resultSet.getString("Codigo"));
                producto.setIdmMedida(resultSet.getString("idmedida"));
                producto.setIdProducto(resultSet.getString("idProducto"));
                producto.setContenedor(resultSet.getString("contenedor"));
                producto.setNombre(resultSet.getString("Nombre"));
                producto.setUnidades(resultSet.getString("unidades"));
                producto.setPrecioUnidad(resultSet.getString("punidad"));
                producto.setTotal(resultSet.getString("Total"));
                  producto.setControl(resultSet.getString("Control"));

                productosCompra.add(producto);
                
              //  System.out.println(producto+"producto");
            }
            return productosCompra;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }
    
    public ArrayList<ClsEntidadSCompra> listarProductoActivoBarra(String cod) {
        ArrayList<ClsEntidadSCompra> productosCompra = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_medidaCompraBarra(?)}");
            statement.setString("Id", cod);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadSCompra producto = new ClsEntidadSCompra();
                producto.setStrsCodigo(resultSet.getString("Codigo"));
                producto.setIdmMedida(resultSet.getString("idmedida"));
                producto.setIdProducto(resultSet.getString("idProducto"));
                producto.setContenedor(resultSet.getString("contenedor"));
                producto.setNombre(resultSet.getString("Nombre"));
                producto.setUnidades(resultSet.getString("unidades"));
                producto.setPrecioUnidad(resultSet.getString("punidad"));
                producto.setTotal(resultSet.getString("Total"));
                  producto.setControl(resultSet.getString("Control"));

                productosCompra.add(producto);
                
              //  System.out.println(producto+"producto");
            }
            return productosCompra;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }
    
       public ResultSet listarIdProductoPorParametro() throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_GetIdProducto()}");
           

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
    
    
}
