package Negocio;

import Conexion.*;
import Entidad.*;
import ds.desktop.notify.DesktopNotify;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClsPresentacion {

   
    private final String sSQL = "";

    public void agregarPrecioporgrupo(ClsEntidadPresentacion Presentacion) {
        Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_PrecioPorGrupo(?,?)}");
            statement.setString("pIdProducto", Presentacion.getStrCodigo());
           
            
            statement.setInt("pIdGrupo", Presentacion.getGrupo());
           
            statement.execute();
           DesktopNotify.showDesktopMessage("", "" + "PRECIOS AGREGADOS", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            DesktopNotify.showDesktopMessage("", " " + "ERROR", DesktopNotify.ERROR, 10000);
            JOptionPane.showMessageDialog(null, " error en insertado precio grupo cls  "+ex);
            
        }
    }
    
    public void agregarProducto(ClsEntidadPresentacion Presentacion) {
        Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Presentacion(?,?,?,?,?)}");
            statement.setString("pidproducto", Presentacion.getStrCodigo());
            statement.setString("pnombre", Presentacion.getStrproducto());
            statement.setString("pcontenedor", Presentacion.getStrContenedor());
            statement.setString("punidades", Presentacion.getStrUnidades());
            statement.setString("pbarra", Presentacion.getStrBarra());
            statement.execute();
            DesktopNotify.showDesktopMessage("", " " + "PRESENTACION AGREGADA", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
           DesktopNotify.showDesktopMessage("", " " + ex, DesktopNotify.ERROR, 10000);
        }
    }

    public void agregarProducto2(ClsEntidadPresentacion Presentacion) {
        Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Presentacion(?,?,?,?,?)}");
            statement.setString("pidproducto", Presentacion.getStrCodigo());
            statement.setString("pnombre", Presentacion.getStrproducto());
            statement.setString("pcontenedor", Presentacion.getStrContenedor());
            statement.setString("punidades", Presentacion.getStrUnidades());
            statement.setString("pbarra", Presentacion.getStrBarra());
            statement.execute();
            DesktopNotify.showDesktopMessage("", " " + "PRESENTACION AGREGADA", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
             DesktopNotify.showDesktopMessage("", " " + ex, DesktopNotify.ERROR, 10000);
        }
    }

    public int ContarPresentaciones(String dato) {
        Connection connection = new ClsConexionLocal().getConection();
        try {
            int codigo = 0;
            CallableStatement statement = connection.prepareCall("{call SP_S_CountPresentaciones(?)}");
            statement.setString("pbusqueda", dato);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("Existe");
            }
            return codigo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }

    public void modificarProducto(String codigo, ClsEntidadPresentacion Producto) {
        Connection connection = new ClsConexionLocal().getConection();
//        try {
//            CallableStatement statement = connection.prepareCall("{call SP_U_Producto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
//            statement.setString("pidproducto", codigo);
//            statement.setString("pcodigo", Producto.getStrCodigoProducto());
//            statement.setString("pnombre", Producto.getStrNombreProducto());
//            statement.setString("pdescripcion", Producto.getStrDescripcionProducto());
//            statement.setString("pstock", Producto.getStrStockProducto());
//            statement.setString("pstockmin", Producto.getStrStockMinProducto());
//            statement.setString("ppreciocosto", Producto.getStrPrecioCostoProducto());
//            statement.setString("pprecioventa", Producto.getStrPrecioVentaProducto());
//            statement.setString("putilidad", Producto.getStrUtilidadProducto());
//            statement.setString("pestado", Producto.getStrEstadoProducto());
//            statement.setString("pidcategoria", Producto.getStrIdCategoria());
//            statement.setString("ptipocontenedor", Producto.getStrContenedorProducto());
//            statement.setString("pcantidadencontenedor", Producto.getStrCantidadContenidaProducto());
//            statement.setString("pgrupo", Producto.getStrIdGrupo());
//            statement.setString("pidproveedor", Producto.getStrIdProveedor());
//            statement.setString("ptipocontenedor1", Producto.getStrContenedorProducto1());
//            statement.setString("pcantidadencontenedor1", Producto.getStrCantidadContenidaProducto1());
//            statement.setString("ptipocontenedor2", Producto.getStrContenedorProducto2());
//            statement.setString("pcantidadencontenedor2", Producto.getStrCantidadContenidaProducto2());
//            statement.executeUpdate();
//            FrmProducto.cargarGrupos();
//        } catch (SQLException ex) {
//            System.err.println("Error : " + ex);
//        }
//        JOptionPane.showMessageDialog(null, "¡Producto Actualizado!", "Mensaje del Sistema", 1);
    }

    public ArrayList<ClsEntidadPresentacion> listarProductoActivo(String cod) {
        Connection connection = new ClsConexionLocal().getConection();
        ArrayList<ClsEntidadPresentacion> productos = new ArrayList<ClsEntidadPresentacion>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ProductoVenta(?)}");
            statement.setString("pbusqueda", cod);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadPresentacion producto = new ClsEntidadPresentacion();
                producto.setStrCodigo(resultSet.getString("idProducto"));
                producto.setStrproducto(resultSet.getString("nombre"));
                producto.setStrContenedor(resultSet.getString("contenedor"));
                producto.setStrUnidades(resultSet.getString("unidades"));
                producto.setStrBarra(resultSet.getString("barra"));
                productos.add(producto);
            }
            return productos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadProducto> listarProductoActivoPorMayor() {
        Connection connection = new ClsConexionLocal().getConection();
        ArrayList<ClsEntidadProducto> productos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ProductoActivoPorMayor}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadProducto producto = new ClsEntidadProducto();
                producto.setStrIdProducto(resultSet.getString("IdProducto"));
                producto.setStrCodigoProducto(resultSet.getString("Codigo"));
                producto.setStrNombreProducto(resultSet.getString("Nombre"));
                producto.setStrDescripcionProducto(resultSet.getString("Descripcion"));
                producto.setStrStockProducto(resultSet.getString("Stock"));
                producto.setStrStockMinProducto(resultSet.getString("StockMin"));
                producto.setStrPrecioCostoProducto(resultSet.getString("PrecioCosto"));
                //producto.setStrPrecioVentaProducto(resultSet.getString("PrecioVenta"));
                producto.setStrUtilidadProducto(resultSet.getString("Utilidad"));
                producto.setStrEstadoProducto(resultSet.getString("Estado"));
                producto.setStrDescripcionCategoria(resultSet.getString("categoria"));
                producto.setStrContenedorProducto(resultSet.getString("contenedor"));
                producto.setStrCantidadContenidaProducto(resultSet.getString("cantidadcontenida"));
                producto.setStrPrecioTotal(resultSet.getString("PrecioTotal"));
                producto.setStrCantidadVenta(resultSet.getString("venta"));
                producto.setStrDescuento(resultSet.getString("descuento"));
                productos.add(producto);
            }
            return productos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ResultSet listarProductoPorParametro(String criterio, String busqueda) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ProductoPorParametro(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ArrayList<ClsEntidadProducto> listarProductoCantidadGrupo(String busqueda) {
        Connection connection = new ClsConexionLocal().getConection();
        ArrayList<ClsEntidadProducto> productos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ProductoActivoPorParametro(?,?)}");
            statement.setString("pbusqueda", busqueda);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadProducto producto = new ClsEntidadProducto();
                producto.setStrIdProducto(resultSet.getString("IdProducto"));
                producto.setStrCodigoProducto(resultSet.getString("Codigo"));
                producto.setStrNombreProducto(resultSet.getString("Nombre"));
                producto.setStrDescripcionProducto(resultSet.getString("Descripcion"));
                producto.setStrPrecioCostoProducto(resultSet.getString("PrecioCosto"));
                producto.setStrPrecioVentaProducto(resultSet.getString("PrecioVenta"));
                producto.setStrDescripcionCategoria(resultSet.getString("categoria"));
                productos.add(producto);
            }
            return productos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ResultSet listarProductoActivoPorParametro(String criterio, String busqueda) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ProductoActivoPorParametro(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listarProductotextbox(String criterio, String busqueda) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ProductoTextbox(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet verificarCodigoBar(String busqueda) throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ProductoVerificarCodigoBar(?)}");
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet obtenerUltimoIdProducto() throws Exception {
        Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_UltimoIdProducto()}");
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
    
}
