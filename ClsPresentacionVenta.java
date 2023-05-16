package Negocio;

import Conexion.*;
import Entidad.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author HenryG.Castro
 */
public class ClsPresentacionVenta {

    private final Connection connection = new ClsConexionLocal().getConection();
    private final String sSQL = "";

    public ArrayList<ClsEntidadSVenta> listarProductoActivo(String cod) {
        ArrayList<ClsEntidadSVenta> productosVenta = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_medida(?)}");
            statement.setString("Id", cod);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadSVenta producto = new ClsEntidadSVenta();
                producto.setStrsCodigo(resultSet.getString("Codigo"));
                producto.setIdmMedida(resultSet.getString("idmedida"));
                producto.setIdProducto(resultSet.getString("idProducto"));
                producto.setContenedor(resultSet.getString("contenedor"));
                producto.setNombre(resultSet.getString("Nombre"));
                producto.setStock(resultSet.getString("Stock"));
                producto.setUnidades(resultSet.getString("unidades"));
                producto.setPrecioUnidad(resultSet.getString("precio2"));
                producto.setDescuento(resultSet.getString("porcentaje"));
                producto.setTotal(resultSet.getString("precio2"));
                producto.setBarra(resultSet.getString("barra"));
                // Descuento no existe en el procedimiento almacenado ("revisar") a la verga pendejo f.henry
                producto.setStrDescuento2(resultSet.getString("descuento"));
                producto.setStrCosto(resultSet.getString("costo"));
                producto.setStrUtilidad(resultSet.getString("utilidad"));
                productosVenta.add(producto);
            }
            return productosVenta;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    
    
    public ArrayList<ClsEntidadSVenta> listarProductoprecio(String cod) {
        ArrayList<ClsEntidadSVenta> productosVenta = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_medidaprecio(?)}");
            statement.setString("Id", cod);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadSVenta producto = new ClsEntidadSVenta();
                producto.setStrsCodigo(resultSet.getString("Codigo"));
                producto.setIdmMedida(resultSet.getString("idprecio"));
                producto.setIdProducto(resultSet.getString("producto_IdProducto"));
                producto.setContenedor(resultSet.getString("contenedor"));
                producto.setNombre(resultSet.getString("Nombre"));
                producto.setStock(resultSet.getString("Stock"));
                producto.setUnidades(resultSet.getString("unidades"));
                producto.setPrecioUnidad(resultSet.getString("punidad"));
                producto.setDescuento(resultSet.getString("porcentaje"));
                producto.setTotal(resultSet.getString("precio2"));
                producto.setBarra(resultSet.getString("idprecio"));
                // Descuento no existe en el procedimiento almacenado ("revisar") a la verga pendejo f.henry
                producto.setStrDescuento2(resultSet.getString("descuento"));
                producto.setStrCosto(resultSet.getString("costo"));
                producto.setStrUtilidad(resultSet.getString("utilidad"));
                producto.setGrupo(resultSet.getString("grupo_idgrupo"));
                producto.setStroferta(resultSet.getString("ofs.Oferta_IdProducto"));
                 producto.setStroferta2(resultSet.getString("of2.Oferta_IdProducto"));
                producto.setStrcontrol(resultSet.getString("producto_ultima_med"));
                  producto.setStrccontrol(resultSet.getString("Producto_ccontrolado"));
                productosVenta.add(producto);
                
            }
            resultSet.close();
//            connection.close();
            return productosVenta;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }
    
     public ArrayList<ClsEntidadSVenta> listarProductopreciobarra(String cod) {
        ArrayList<ClsEntidadSVenta> productosVenta = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_medidaprecioabrir2(?)}");
            statement.setString("Id", cod);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadSVenta producto = new ClsEntidadSVenta();
                producto.setStrsCodigo(resultSet.getString("Codigo"));
                producto.setIdmMedida(resultSet.getString("idprecio"));
                producto.setIdProducto(resultSet.getString("producto_IdProducto"));
                producto.setContenedor(resultSet.getString("contenedor"));
                producto.setNombre(resultSet.getString("Nombre"));
                producto.setStock(resultSet.getString("Stock"));
                producto.setUnidades(resultSet.getString("unidades"));
                producto.setPrecioUnidad(resultSet.getString("punidad"));
                producto.setDescuento(resultSet.getString("porcentaje"));
                producto.setTotal(resultSet.getString("precio2"));
                producto.setBarra(resultSet.getString("idprecio"));
                // Descuento no existe en el procedimiento almacenado ("revisar") a la verga pendejo f.henry
                producto.setStrDescuento2(resultSet.getString("descuento"));
                producto.setStrCosto(resultSet.getString("costo"));
                producto.setStrUtilidad(resultSet.getString("utilidad"));
                producto.setGrupo(resultSet.getString("grupo_idgrupo"));
                producto.setStroferta(resultSet.getString("ofs.Oferta_IdProducto"));
                 producto.setStroferta2(resultSet.getString("of2.Oferta_IdProducto"));
                producto.setStrcontrol(resultSet.getString("producto_ultima_med"));
                productosVenta.add(producto);
                
            }
            resultSet.close();
//            connection.close();
            return productosVenta;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadSVenta> listarProductoActivoEgreso(String cod) {
        ArrayList<ClsEntidadSVenta> productosVenta = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_medidaEgreso(?)}");
            statement.setString("Id", cod);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadSVenta producto = new ClsEntidadSVenta();
                producto.setStrsCodigo(resultSet.getString("Codigo"));
                producto.setIdmMedida(resultSet.getString("idmedida"));
                producto.setIdProducto(resultSet.getString("idProducto"));
                producto.setContenedor(resultSet.getString("contenedor"));
                producto.setNombre(resultSet.getString("Nombre"));
                producto.setStock(resultSet.getString("Stock"));
                producto.setUnidades(resultSet.getString("unidades"));
                producto.setPrecioUnidad(resultSet.getString("precio2"));
                producto.setDescuento(resultSet.getString("porcentaje"));
                producto.setTotal(resultSet.getString("precio2"));
                producto.setBarra(resultSet.getString("barra"));
                // Descuento no existe en el procedimiento almacenado ("revisar") a la verga pendejo f.henry
                producto.setStrDescuento2(resultSet.getString("descuento"));
                producto.setStrCosto(resultSet.getString("costo"));
                producto.setStrUtilidad(resultSet.getString("utilidad"));
                productosVenta.add(producto);
            }
            return productosVenta;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadSVenta> listarProductoActivoS(String cod) {
        ArrayList<ClsEntidadSVenta> productosVenta = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_medidaSinDescuento(?)}");
            statement.setString("Id", cod);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadSVenta producto = new ClsEntidadSVenta();
                producto.setStrsCodigo(resultSet.getString("Codigo"));
                producto.setIdmMedida(resultSet.getString("idmedida"));
                producto.setIdProducto(resultSet.getString("idProducto"));
                producto.setContenedor(resultSet.getString("contenedor"));
                producto.setNombre(resultSet.getString("Nombre"));
                producto.setStock(resultSet.getString("Stock"));
                producto.setUnidades(resultSet.getString("unidades"));
                producto.setPrecioUnidad(resultSet.getString("punidad"));
                producto.setDescuento(resultSet.getString("porcentaje"));
                producto.setTotal(resultSet.getString("precio2"));
                producto.setBarra(resultSet.getString("barra"));
                // Descuento no existe en el procedimiento almacenado ("revisar") a la verga pendejo f.henry
                producto.setStrDescuento2(resultSet.getString("descuento"));
                producto.setStrCosto(resultSet.getString("costo"));
                producto.setStrUtilidad(resultSet.getString("utilidad"));
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
                producto.setIdProducto(resultSet.getString("idProducto"));
                producto.setStrsCodigo(resultSet.getString("Codigo"));
                producto.setIdmMedida(resultSet.getString("idmedida"));
                producto.setContenedor(resultSet.getString("contenedor"));
                producto.setNombre(resultSet.getString("Nombre"));
                producto.setUnidades(resultSet.getString("unidades"));
                producto.setPrecioUnidad(resultSet.getString("punidad"));
                producto.setPreciocontenedor(resultSet.getString("preciocontenedor"));
                producto.setDescuento(resultSet.getString("porcentaje"));
                producto.setTotal(resultSet.getString("precio2"));
                producto.setBarra(resultSet.getString("barra"));
                producto.setStock(resultSet.getString("Stock"));
                producto.setStrDescuento2(resultSet.getString("descuento"));
                productosVenta.add(producto);
            }
            return productosVenta;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadSVenta> listarProductoActivoUnidadS(String cod) {
        ArrayList<ClsEntidadSVenta> productosVenta = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_medidaUnidadSinDescuento(?)}");
            statement.setString("Id", cod);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadSVenta producto = new ClsEntidadSVenta();
                producto.setIdProducto(resultSet.getString("idProducto"));
                producto.setStrsCodigo(resultSet.getString("Codigo"));
                producto.setIdmMedida(resultSet.getString("idmedida"));
                producto.setContenedor(resultSet.getString("contenedor"));
                producto.setNombre(resultSet.getString("Nombre"));
                producto.setUnidades(resultSet.getString("unidades"));
                producto.setPrecioUnidad(resultSet.getString("punidad"));
                producto.setPreciocontenedor(resultSet.getString("preciocontenedor"));
                producto.setDescuento(resultSet.getString("porcentaje"));
                producto.setTotal(resultSet.getString("precio2"));
                producto.setBarra(resultSet.getString("barra"));
                producto.setStock(resultSet.getString("Stock"));
                producto.setStrDescuento2(resultSet.getString("descuento"));
                producto.setGrupo(resultSet.getString("grupo_idgrupo"));
                producto.setStrCosto(resultSet.getString("costo"));
                producto.setStrUtilidad(resultSet.getString("utilidad"));
                productosVenta.add(producto);
            }
            return productosVenta;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadSVenta> listarProductoActivoPresentacionDos(String Id, int Cantidad) {
        ArrayList<ClsEntidadSVenta> productosVenta = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_medidaDesdeJtable(?,?)}");
            statement.setString("Id", Id);
            statement.setInt("cantidad", Cantidad);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadSVenta producto = new ClsEntidadSVenta();
                producto.setStrDescuento2(resultSet.getString("descuento"));
                productosVenta.add(producto);
            }
            return productosVenta;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadSVenta> listarProductoActivoPresentacionDosS(String Id, double Cantidad) {
        ArrayList<ClsEntidadSVenta> productosVenta = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_medidaDesdeJtableSinDescuento(?,?)}");
            statement.setString("Id", Id);
            statement.setDouble("cantidad", Cantidad);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadSVenta producto = new ClsEntidadSVenta();
                producto.setStrDescuento2(resultSet.getString("descuento"));
                productosVenta.add(producto);
            }
            return productosVenta;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    String titulos[] = {"ID", "CODIGO", "PRODUCTO", "CONTENEDOR", "CANTIDAD", "PRECIO", "DESCUENTO%", "TOTAL", "T. UNIDADES", "TOTALUNIDADES", "PRECIO2", "STOCK", "TDESCUENTO", "ODESCUENTO"};

    public ArrayList<ClsEntidadSVenta> listarProductoActivoPresentacion(String cod) {
        ArrayList<ClsEntidadSVenta> productosVenta = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_medidaporbarra(?)}");
            statement.setString("Id", cod);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadSVenta producto = new ClsEntidadSVenta();
                producto.setIdProducto(resultSet.getString("idProducto"));
                producto.setStrsCodigo(resultSet.getString("Codigo"));
                producto.setIdmMedida(resultSet.getString("idmedida"));
                producto.setContenedor(resultSet.getString("contenedor"));
                producto.setNombre(resultSet.getString("Nombre"));
                producto.setUnidades(resultSet.getString("unidades"));
                producto.setPrecioUnidad(resultSet.getString("punidad"));
                producto.setPreciocontenedor(resultSet.getString("preciocontenedor"));
                producto.setDescuento(resultSet.getString("porcentaje"));
                producto.setTotal(resultSet.getString("precio2"));
                producto.setBarra(resultSet.getString("barra"));
                producto.setStock(resultSet.getString("Stock"));
                producto.setStrDescuento2(resultSet.getString("descuento"));
                productosVenta.add(producto);
            }
            return productosVenta;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadSVenta> listarProductoActivoPresentacionCompra(String cod) {
        ArrayList<ClsEntidadSVenta> productosVenta = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_medidaporbarraCompra(?)}");
            statement.setString("Id", cod);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadSVenta producto = new ClsEntidadSVenta();
                producto.setIdProducto(resultSet.getString("idProducto"));
                producto.setStrsCodigo(resultSet.getString("Codigo"));
                producto.setIdmMedida(resultSet.getString("idmedida"));
                producto.setContenedor(resultSet.getString("contenedor"));
                producto.setNombre(resultSet.getString("Nombre"));
                producto.setUnidades(resultSet.getString("unidades"));
                producto.setPrecioUnidad(resultSet.getString("punidad"));
                producto.setPreciocontenedor(resultSet.getString("preciocontenedor"));
                producto.setDescuento(resultSet.getString("porcentaje"));
                producto.setTotal(resultSet.getString("precio2"));
                producto.setBarra(resultSet.getString("barra"));
                producto.setStock(resultSet.getString("Stock"));
                producto.setStrDescuento2(resultSet.getString("descuento"));
                productosVenta.add(producto);
            }
            return productosVenta;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    
    
    
      
    
    
    
    
    public ArrayList<ClsEntidadSVenta> listarProductoActivoPresentacionS(String cod) throws SQLException {
        ArrayList<ClsEntidadSVenta> productosVenta = new ArrayList<>();
         
        try {
          
      //  connection.
           // connection.isReadOnly();
            CallableStatement statement = connection.prepareCall("{call SP_S_medidaporbarra(?)}");
            statement.setString("Id", cod);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadSVenta producto = new ClsEntidadSVenta();
                producto.setIdProducto(resultSet.getString("idProducto"));
                producto.setStrsCodigo(resultSet.getString("Codigo"));
                producto.setIdmMedida(resultSet.getString("idmedida"));
                producto.setContenedor(resultSet.getString("contenedor"));
                producto.setNombre(resultSet.getString("Nombre"));
                producto.setUnidades(resultSet.getString("unidades"));
                producto.setPrecioUnidad(resultSet.getString("punidad"));
                producto.setPreciocontenedor(resultSet.getString("preciocontenedor"));
                producto.setDescuento(resultSet.getString("porcentaje"));
                producto.setTotal(resultSet.getString("precio2"));
                producto.setBarra(resultSet.getString("barra"));
                producto.setStock(resultSet.getString("Stock"));
                producto.setStrDescuento2(resultSet.getString("descuento"));
                producto.setGrupo(resultSet.getString("grupo_idgrupo"));
                producto.setStrCosto(resultSet.getString("costo"));
                producto.setStrUtilidad(resultSet.getString("utilidad"));
                
                productosVenta.add(producto);
            }
            return productosVenta;
           
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
       
    }

    public ArrayList<ClsEntidadSVenta> listarProductoPorCodigodeBarraCompra(String cod) {
        ArrayList<ClsEntidadSVenta> productosVenta = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_PresentacionCompraPorBarCode(?)}");
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
                producto.setPreciocontenedor(resultSet.getString("preciocontenedor"));
                producto.setDescuento(resultSet.getString("porcentaje"));
                producto.setTotal(resultSet.getString("precio2"));
                producto.setBarra(resultSet.getString("barra"));
                producto.setStrIdProveedor(resultSet.getString("IdProveedor"));
                producto.setStrNombreProveedor(resultSet.getString("proveedor"));
                producto.setIntProducto_ultim_med(resultSet.getInt("producto_ultima_med"));
                producto.setIntUnidades(resultSet.getInt("unidades"));
                productosVenta.add(producto);
            }
            return productosVenta;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }
}
