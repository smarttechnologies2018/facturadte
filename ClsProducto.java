package Negocio;

import Conexion.*;
import Entidad.*;
import ds.desktop.notify.DesktopNotify;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClsProducto {

    String sSQL = "";
    static PreparedStatement ps;
    private static final Connection connection = new ClsConexionLocal().getConection();

    public void agregarProducto(ClsEntidadProducto Producto) {
        try {

            CallableStatement statement = connection.prepareCall("{call SP_I_Producto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
             statement.setString("pidproducto", Producto.getStrIdProducto());
            statement.setString("pcodigo", Producto.getStrCodigoProducto());
            statement.setString("pnombre", Producto.getStrNombreProducto());
            statement.setString("pdescripcion", Producto.getStrDescripcionProducto());

            // statement.setString("ppreciocosto", Producto.getStrPrecioCostoProducto());
            // statement.setString("pprecioventa", Producto.getStrPrecioVentaProducto());
            // statement.setString("putilidad", Producto.getStrUtilidadProducto());
            statement.setString("pestado", Producto.getStrEstadoProducto());
            statement.setString("pidcategoria", Producto.getStrIdCategoria());
            statement.setString("pidproveedor", Producto.getStrIdProveedor());

            statement.setString("pgrupo", Producto.getStrIdGrupo());
            statement.setString("pcontrol", Producto.getStrcontrol());
            statement.setString("ppush", Producto.getStrpush());
            statement.setBlob("pimage", Producto.getImagen());

            statement.setString("pimpuesto", Producto.getStrImpuesto());
            statement.setString("piva", Producto.getStrIva());
            statement.setString("pcotrans", Producto.getStrCotrans());
             statement.setString("pfovial", Producto.getStrFovial());
              statement.setString("pexterno", Producto.getStrExterno());
             
            statement.execute();
            DesktopNotify.showDesktopMessage("", "" + "PRODUCTO AGREGADO", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            System.err.println("Error al insertar: " + ex);
            System.out.println(Producto.getStrIdGrupo() + "cague");
            JOptionPane.showMessageDialog(null,ex+"EL PRODUCTO NO SE GUARDO" );
        }
    }
    
     public static int[] getIdProducto(String producto) {
        int idproducto = 0, idgrupo = 0,unidades=0;
        try {
            String sql = "SELECT idproducto,grupo_idgrupo,producto_ultima_med FROM producto WHERE Producto_Externo = ?";
             ps = connection.prepareStatement(sql);
            ps.setString(1, producto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idproducto = rs.getInt("idproducto");
                idgrupo = rs.getInt("grupo_idgrupo");
                unidades = rs.getInt("producto_ultima_med");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        int[] result = {idproducto, idgrupo,unidades};
        return result;
    }
     
     
     public static Map<String, Object> getprecioscambio() {
    Map<String, Object> result = new HashMap<>();

    try {
        String sql = "SELECT pr.producto_IdProducto, p.Nombre, p.producto_costo as costo, ((p.producto_costo * pr.utilidad)) as PrecioVenta, venta as cantidad," +
                "pr.utilidad as porcentaje, (p.producto_costo * pr.utilidad) as precio2, Contenedor, pr.Carga, ((p.producto_costo * pr.venta)) as totalcosto," +
                "((pr.costo * pr.utilidad * pr.venta)) as total from precio as pr left JOIN producto as p on pr.producto_IdProducto = p.IdProducto WHERE p.producto_costo != 0" +
                " order by producto_IdProducto, pr.venta asc;";
        ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            result.put("contenedor", rs.getString("Contenedor"));
            result.put("unidades", rs.getInt("venta"));
            result.put("costo", rs.getFloat("costo"));
            result.put("precio", rs.getFloat("PrecioVenta"));
            result.put("tcosto", rs.getFloat("totalcosto"));
            result.put("tprecio", rs.getFloat("total"));
            result.put("utilidad", rs.getFloat("utilidad"));
            result.put("carga", rs.getString("carga"));
        }
        rs.close();
        ps.close();
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }

    return result;
}
     
      public static int[] getIdProducto2(String producto) {
        int idproducto = 0, idgrupo = 0,unidades=0;
        try {
            String sql = "SELECT idproducto,grupo_idgrupo,producto_ultima_med FROM producto WHERE codigo = ?";
             ps = connection.prepareStatement(sql);
            ps.setString(1, producto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idproducto = rs.getInt("idproducto");
                idgrupo = rs.getInt("grupo_idgrupo");
                unidades = rs.getInt("producto_ultima_med");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        int[] result = {idproducto, idgrupo,unidades};
        return result;
    }
      public static void poneracero(){
          try {
               String sql = "UPDATE producto SET Producto_Costo=0 where idproducto<>0";

        ps = connection.prepareStatement(sql);
        
        int filasAfectadas = ps.executeUpdate();
        System.out.println("Filas afectadas: " + filasAfectadas);

        ps.close();
              
          } catch (Exception e) {
          }
      
      }
      
      public static void actualizarProductoprecio(String codext,  String descrip,float costo, int unid,int idproducto,int idgru) {
   
          
          
          
          
          try {
        
      
             String sql = "UPDATE producto SET Producto_Externo = ?, Descripcion = ?, Producto_Costo"
                + " = ?,producto_ultima_med=?,Producto_Update=now() WHERE idproducto = ?";

        ps = connection.prepareStatement(sql);
        ps.setString(1, codext);
        ps.setString(2, descrip);
        ps.setInt(4, unid);
        ps.setFloat(3, costo);
           ps.setInt(5, idproducto);
        
        
        
        
       

        int filasAfectadas = ps.executeUpdate();
        System.out.println("Filas afectadas: " + filasAfectadas);

        ps.close();
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
}

     
      public static int[] getIdProductobarra(String producto) {
        int idproducto = 0, idgrupo = 0,unidades=0;
        try {
            String sql = "SELECT p.idproducto,p.grupo_idgrupo,p.producto_ultima_med FROM producto as p "
                    + "inner join medida as m on m.idproducto=p.idproducto WHERE m.barra = ?";
             ps = connection.prepareStatement(sql);
            ps.setString(1, producto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idproducto = rs.getInt("idproducto");
                idgrupo = rs.getInt("grupo_idgrupo");
                unidades = rs.getInt("producto_ultima_med");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        int[] result = {idproducto, idgrupo,unidades};
        System.out.println(idproducto);
        return result;
        
          
    }


     public void ActualizarStockCompratraslado(String codigo,String empresa) {
        try {

            CallableStatement statement = connection.prepareCall("{call SP_U_Restablecerstocktraslado(?,?)}");
            statement.setString("pidcompra", codigo);
            statement.setString("pidempresa", empresa);

            statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
        //JOptionPane.showMessageDialog(null,"¡Producto Actualizado!","Mensaje del Sistema",1);
    }
    public ResultSet Comprobar_Codigo(String criterio) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ComprobarCodigo_Producto(?)}");
            statement.setString("pcorrelativo", criterio);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
    
    
    
    
     public ResultSet Ver_Existencia(String criterio) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_VerExist(?)}");
            statement.setString("pid", criterio);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
    
    
    
    
    

    public ResultSet verificarcorrelativo(String criterio) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ComprobarCodigoProducto?)}");
            statement.setString("pcodigo", criterio);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public void agregarProductolocal(ClsEntidadProducto Producto) throws SQLException {
        connection.setAutoCommit(true);
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Productolocal(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidproducto", Producto.getStrIdProducto());
            statement.setString("pcodigo", Producto.getStrCodigoProducto());
            statement.setString("pnombre", Producto.getStrNombreProducto());
            statement.setString("pdescripcion", Producto.getStrDescripcionProducto());
            statement.setString("pstockmin", Producto.getStrStockMinProducto());
            // statement.setString("ppreciocosto", Producto.getStrPrecioCostoProducto());
            // statement.setString("pprecioventa", Producto.getStrPrecioVentaProducto());
            // statement.setString("putilidad", Producto.getStrUtilidadProducto());
            statement.setString("pestado", Producto.getStrEstadoProducto());
            statement.setString("pidcategoria", Producto.getStrIdCategoria());
            statement.setString("pidproveedor", Producto.getStrIdProveedor());
            statement.setString("pgrupo", Producto.getStrIdGrupo());
            statement.setString("pproducto_ultima_med", Producto.getStrProducto_ultima_med());
             statement.setString("pupdate", Producto.getStrupdate());
              statement.setString("pimpuesto", Producto.getStrImpuesto());
               statement.setString("piva", Producto.getStrIva());
                statement.setString("pfovial", Producto.getStrFovial());
                 statement.setString("pcotrans", Producto.getStrCotrans());
            statement.execute();

        } catch (SQLException ex) {
            System.err.println("Error al insertar: " + ex + Producto.getStrIdProducto());

            DesktopNotify.showDesktopMessage("", "" + "ERROR" + "Error al insertar: " + ex + Producto.getStrIdProducto(), DesktopNotify.ERROR, 55000);
        }
    }

    public void modificarProducto(ClsEntidadProducto Producto) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Producto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidproducto", Producto.getStrIdProducto());
            System.out.println(Producto.getStrIdProducto());
            statement.setString("pcodigo", Producto.getStrCodigoProducto());
            statement.setString("pnombre", Producto.getStrNombreProducto());
            statement.setString("pdescripcion", Producto.getStrDescripcionProducto());
            // statement.setString("pstock", Producto.getStrStockProducto());
            //  statement.setString("pstockmin", Producto.getStrStockMinProducto());
            statement.setString("pestado", Producto.getStrEstadoProducto());
            statement.setString("pidcategoria", Producto.getStrIdCategoria());
            statement.setString("pidproveedor",(Producto.getStrIdProveedor()));
            
            System.out.println(Producto.getStrIdProveedor()+"PROVEEDOR");
            statement.setString("ppush", Producto.getStrpush());

            statement.setString("pcontrol", Producto.getStrProducto_ultima_med());
            statement.setString("pgrupo", Producto.getStrIdGrupo());
            statement.setBlob("pimage", Producto.getImagen());
             statement.setString("pimpuesto", Producto.getStrImpuesto());
            statement.setString("piva", Producto.getStrIva());
            statement.setString("pcotrans", Producto.getStrCotrans());
             statement.setString("pfovial", Producto.getStrFovial());
             statement.setString("pexterno", Producto.getStrExterno());
            statement.executeUpdate();
            //FrmProducto.cargarGrupos();
            DesktopNotify.showDesktopMessage("", "" + "PRODUCTO ACTUALIZADO", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
           // DesktopNotify.showDesktopMessage("", "" + "ERROR" + ex, DesktopNotify.ERROR, 5000);
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void ActualizarFechaVenta() {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_ActualizarFechaVenta()}");
            statement.executeUpdate();
            //FrmProducto.cargarGrupos();
            DesktopNotify.showDesktopMessage("", "" + "DATOS ACTUALIZADOS", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "¡ERROR" + ex, "Mensaje del Sistema", 1);
        }
    }

    public void Iniciar_Existencias() {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_IniciarExistencias()}");
            statement.executeUpdate();
            //FrmProducto.cargarGrupos();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
       DesktopNotify.showDesktopMessage("", "" + "Inventario Inicializado Correctamente", DesktopNotify.SUCCESS, 5000);
    }
    
    
     public void Finalizar_Existencias() {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_FinalizarExistencias()}");
            statement.executeUpdate();
            //FrmProducto.cargarGrupos();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
       DesktopNotify.showDesktopMessage("", "" + "Inventario Inicializado Correctamente", DesktopNotify.SUCCESS, 5000);
    }
    
    
    
     public void Actualizar_Existencias(int codigo, int idempresa) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_ActualizarExistencias(?,?)}");
           statement.setInt("pcodigo", codigo);
             statement.setInt("pidempresa", idempresa);
             System.out.println("codinv: "+codigo+" "+"empresa: "+idempresa);
            statement.executeUpdate();
            //FrmProducto.cargarGrupos();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
       DesktopNotify.showDesktopMessage("", "" + "Existencias Actualizadas Correctamente!", DesktopNotify.SUCCESS, 5000);
    }

    public void modificarProductolocal(ClsEntidadProducto Producto) throws SQLException {
        connection.setAutoCommit(true);
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Productolocal(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidproducto", Producto.getStrIdProducto());
            statement.setString("pcodigo", Producto.getStrCodigoProducto());
            statement.setString("pnombre", Producto.getStrNombreProducto());
            statement.setString("pdescripcion", Producto.getStrDescripcionProducto());
            statement.setString("pstockmin", Producto.getStrStockMinProducto());
            statement.setString("pestado", Producto.getStrEstadoProducto());
            statement.setString("pidcategoria", Producto.getStrIdCategoria());
            statement.setString("pidproveedor", Producto.getStrIdProveedor());
            statement.setString("pgrupo", Producto.getStrIdGrupo());
            statement.setString("pproducto_ultima_med", Producto.getStrProducto_ultima_med());
             statement.setString("pupdate", Producto.getStrupdate());
              statement.setString("pimpuesto", Producto.getStrImpuesto());
               statement.setString("piva", Producto.getStrIva());
                statement.setString("pfovial", Producto.getStrFovial());
                 statement.setString("pcotrans", Producto.getStrCotrans());
            statement.executeUpdate();
            System.out.println(Producto.getStrIdProducto() + "         " + Producto.getStrNombreProducto());
            //FrmProducto.cargarGrupos();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public void actualizarProductoStock(String codigo, ClsEntidadProducto Producto) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_ActualizarProductoStock(?,?)}");
            statement.setString("pidproducto", codigo);
            statement.setString("pstock", Producto.getStrStockProducto());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public void ActualizarStockCompra(String codigo) {
        try {

            CallableStatement statement = connection.prepareCall("{call SP_U_ActualizarStockCompra(?)}");
            statement.setString("pidcompra", codigo);

            statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
        //JOptionPane.showMessageDialog(null,"¡Producto Actualizado!","Mensaje del Sistema",1);
    }
    
    
      public void ActualizarStockCompraOrden(String codigo) {
        try {

            CallableStatement statement = connection.prepareCall("{call SP_U_ActualizarStockCompraOrden(?)}");
            statement.setString("pidcompra", codigo);
            

            statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
        //JOptionPane.showMessageDialog(null,"¡Producto Actualizado!","Mensaje del Sistema",1);
    }
    
    
     public void ActualizarCheck() {
        try {

            CallableStatement statement = connection.prepareCall("{call SP_U_ActualizarStockCheck()}");
           

            statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
        //JOptionPane.showMessageDialog(null,"¡Producto Actualizado!","Mensaje del Sistema",1);
    }
    public void ponercheck(int id) {
        try {

            CallableStatement statement = connection.prepareCall("{call SP_U_PonerCheck(?)}");
             statement.setInt("pidproducto", id);

            statement.executeUpdate();
             DesktopNotify.showDesktopMessage("", "" + " AGREGADO", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
        //JOptionPane.showMessageDialog(null,"¡Producto Actualizado!","Mensaje del Sistema",1);
    }
public void AgregarCodigoExterno(String id,String codigo) {
        try {

            CallableStatement statement = connection.prepareCall("{call SP_U_AgregarExterno(?,?)}");
             statement.setString("pidproducto", id);
              statement.setString("pcodigo", codigo);

            statement.executeUpdate();
             DesktopNotify.showDesktopMessage("", "" + " AGREGADO", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
        //JOptionPane.showMessageDialog(null,"¡Producto Actualizado!","Mensaje del Sistema",1);
    }
    public ArrayList<ClsEntidadProducto> listarProducto() {
        ArrayList<ClsEntidadProducto> productos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Producto}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadProducto producto = new ClsEntidadProducto();
                producto.setStrIdProducto(resultSet.getString("IdProducto"));
                producto.setStrCodigoProducto(resultSet.getString("Codigo"));
                producto.setStrNombreProducto(resultSet.getString("Nombre"));
                producto.setStrDescripcionProducto(resultSet.getString("Descripcion"));
                producto.setStrStockProducto(resultSet.getString("Stock"));
                producto.setStrStockMinProducto(resultSet.getString("StockMin"));
                producto.setStrPrecioCostoProducto(resultSet.getString("costo"));
                producto.setStrPrecioVentaProducto(resultSet.getString("PrecioVenta"));
                producto.setStrUtilidadProducto(resultSet.getString("Utilidad"));
                producto.setStrEstadoProducto(resultSet.getString("Estado"));
                producto.setStrDescripcionCategoria(resultSet.getString("categoria"));
                producto.setStrIdProveedor(resultSet.getString("idproveedor"));
                producto.setStrNombreProveedor(resultSet.getString("nombreproveedor"));
                producto.setStrIdCategoria(resultSet.getString("IdCategoria"));
                producto.setStrVencimientoConsulta(resultSet.getString("vencimiento"));
                producto.setStrIdGrupo(resultSet.getString("grupo"));
                producto.setStrNombreGrupo(resultSet.getString("nombreg"));
                producto.setStrcontrol(resultSet.getString("producto_ultima_med"));
                producto.setStrUltimaVenta(resultSet.getString("Producto_UltimaVenta"));
                producto.setStrpush(resultSet.getString("Producto_Push"));
                producto.setImagen(resultSet.getBinaryStream("Producto_Imagen"));
                productos.add(producto);
            }
            return productos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }
    
    
    
    
     public ArrayList<ClsEntidadProducto> listarProductoZeus() {
        ArrayList<ClsEntidadProducto> productos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ProductoZeus}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadProducto producto = new ClsEntidadProducto();
                producto.setStrIdProducto(resultSet.getString("IdProducto"));
                
                productos.add(producto);
            }
            return productos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }
    
    
    

    public ArrayList<ClsEntidadProducto> listarProductoActivo() {
        ArrayList<ClsEntidadProducto> productos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ProductoCompra}");
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
                producto.setStrPrecioVentaProducto(resultSet.getString("PrecioVenta"));
                producto.setStrUtilidadProducto(resultSet.getString("Utilidad"));
                producto.setStrEstadoProducto(resultSet.getString("Estado"));
                producto.setStrDescripcionCategoria(resultSet.getString("categoria"));
                producto.setStrCantidadVenta(resultSet.getString("venta"));
                producto.setStrDescuento(resultSet.getString("descuento"));
                producto.setStrIdProveedor(resultSet.getString("IdProveedor"));
                producto.setStrNombreProveedor(resultSet.getString("proveedor"));
                productos.add(producto);
            }
            return productos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadProducto> listarProductoActivoPorMayor() {
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

    public ArrayList<ClsEntidadProducto> listarProductoPorParametro(String criterio, String busqueda) {
        ArrayList<ClsEntidadProducto> productos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ProductoPorParametro(?,?)}");
            statement.setString("pcriterio", criterio);
            System.out.println(criterio+"este es el criterio");
            statement.setString("pbusqueda", busqueda);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadProducto producto = new ClsEntidadProducto();
                producto.setStrIdProducto(resultSet.getString("IdProducto"));
                producto.setStrCodigoProducto(resultSet.getString("Codigo"));
                producto.setStrNombreProducto(resultSet.getString("Nombre"));
                producto.setStrDescripcionProducto(resultSet.getString("Descripcion"));
                producto.setStrStockProducto(resultSet.getString("Stock"));
                producto.setStrStockMinProducto(resultSet.getString("StockMin"));
                producto.setStrPrecioCostoProducto(resultSet.getString("costo"));
                producto.setStrPrecioVentaProducto(resultSet.getString("PrecioVenta"));
                producto.setStrUtilidadProducto(resultSet.getString("Utilidad"));
                producto.setStrEstadoProducto(resultSet.getString("Estado"));
                producto.setStrDescripcionCategoria(resultSet.getString("categoria"));
                producto.setStrIdProveedor(resultSet.getString("idproveedor"));
                producto.setStrNombreProveedor(resultSet.getString("nombreproveedor"));
                producto.setStrIdCategoria(resultSet.getString("IdCategoria"));
                producto.setStrVencimientoConsulta(resultSet.getString("Vencimiento"));
                producto.setStrIdGrupo(resultSet.getString("grupo"));
                producto.setStrNombreGrupo(resultSet.getString("nombreg"));
                producto.setStrcontrol(resultSet.getString("producto_ultima_med"));
                producto.setStrUltimaVenta(resultSet.getString("Producto_UltimaVenta"));
                producto.setStrpush(resultSet.getString("Producto_Push"));
                producto.setStrimagen(resultSet.getBlob("Producto_Imagen"));
                productos.add(producto);
            }
            return productos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadProducto> listarProductoCantidadGrupo(String criterio, String busqueda) {
        ArrayList<ClsEntidadProducto> productos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ProductoActivoPorParametro(?,?)}");
            statement.setString("pcriterio", criterio);
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
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_GetStockProducto(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            System.out.println(busqueda);
            rs = statement.executeQuery();
            return rs;
            
            
           
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
    
      public ResultSet listarProductoActivoPorParametrobarra(String busqueda) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_GetStockProducto(?)}");
           
            statement.setString("pbusqueda", busqueda);
            System.out.println(busqueda);
            rs = statement.executeQuery();
            return rs;
            
            
           
        } catch (SQLException SQLex) {
            throw SQLex;
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

    public ResultSet listarDatosProductoCodigo(String busqueda) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ConsultaDatosProducto(?)}");
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listarDatosProductoBarra(String busqueda) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ConsultaDatosProductoBarra(?)}");
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listarProductotextbox(String criterio, String busqueda) throws Exception {
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
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_UltimoIdProducto()}");
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
    
    
     public ResultSet VerInvPorSala() throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_VerInvPorSala()}");
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public int ContarProducto(String cod) {
        ResultSet rs = null;
        try {
            int codigo = 0;
            CallableStatement statement = connection.prepareCall("{call SP_S_CountProducto(?)}");
            statement.setString("pcriterio", cod);
            rs = statement.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("ExisteProducto");
            }
            // connection.close();
            return codigo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }

    public int ContarStockMin() {
        sSQL = "CALL SP_S_CountStockMin";
        try {
            int existe = 0;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                existe = rs.getInt("ExisteStockMin");
            }
            return existe;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }

    public int ContarFechaVencimiento() {
        sSQL = "CALL SP_S_CounFechaVencimiento";
        try {
            int existe = 0;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                existe = rs.getInt("ExisteFechaVencimiento");
            }
            return existe;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }

    public int ContarProductoPresentacion(String cod) {
        
        System.out.println("a buscar presentacion");
        ResultSet rs = null;
        try {
            int codigo = 0;
            CallableStatement statement = connection.prepareCall("{call SP_S_CountProductoPresentacion(?)}");
            statement.setString("pcriterio", cod);
            rs = statement.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("ExisteProductoPresentacion");
            }
            return codigo;
           
            
           
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }
public int ContarProductoPresentacioncompra(String cod) {
        
        System.out.println("a buscar presentacion");
        ResultSet rs = null;
        try {
            int codigo = 0;
            CallableStatement statement = connection.prepareCall("{call SP_S_CountProductoPresentacioncompra(?)}");
            statement.setString("pid", cod);
            rs = statement.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("ExisteProductoPresentacion");
            }
            return codigo;
           
            
           
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }
public int ContarProductoPresentacioncomprabarra(String cod) {
        
        System.out.println("a buscar presentacion");
        ResultSet rs = null;
        try {
            int codigo = 0;
            CallableStatement statement = connection.prepareCall("{call SP_S_CountProductoPresentacioncomprabarra(?)}");
            statement.setString("pid", cod);
            rs = statement.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("ExisteProductoPresentacion");
            }
            return codigo;
           
            
           
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }
    public int ContarProductoConoferta(String cod) {
        ResultSet rs = null;
        try {
            int codigo = 0;
            CallableStatement statement = connection.prepareCall("{call SP_S_CountProductoconoferta(?)}");
            statement.setString("pcriterio", cod);
            rs = statement.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("ExisteProductoConOferta");
            }
            return codigo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }

    public int ContarProductoCodigo(String cod) {
        ResultSet rs = null;
        try {
            int codigo = 0;
            CallableStatement statement = connection.prepareCall("{call SP_S_CountProductoCodigo(?)}");
            statement.setString("pcriterio", cod);
            rs = statement.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("ExisteProducto");
            }
            return codigo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }

    //metodo para llenar jtable frmbuscarproducto_venta
    public ArrayList<ClsEntidadProducto> BuscarProductoVenta() {
        ArrayList<ClsEntidadProducto> productos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_GetProductoVenta}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadProducto producto = new ClsEntidadProducto();
                producto.setStrIdProducto(resultSet.getString("IdProducto"));
                producto.setStrCodigoProducto(resultSet.getString("Codigo"));
                producto.setStrNombreProducto(resultSet.getString("Nombre"));
                producto.setStrDescripcionProducto(resultSet.getString("Descripcion"));
                producto.setStrStockProducto(resultSet.getString("Stock"));
                producto.setStrPrecioVentaProducto(resultSet.getString("PrecioVenta"));
                producto.setStrIdGrupo(resultSet.getString("grupo_idgrupo"));
                producto.setStrcontrol(resultSet.getString("producto_ultima_med"));
                productos.add(producto);
            }
            return productos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }
    
    
    
    
    

    public ArrayList<ClsEntidadProducto> BuscarProductoOferta() {
        ArrayList<ClsEntidadProducto> productos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_GetProductoOferta}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadProducto producto = new ClsEntidadProducto();
                producto.setStrIdProducto(resultSet.getString("IdProducto"));
                producto.setStrCodigoProducto(resultSet.getString("Codigo"));
                producto.setStrNombreProducto(resultSet.getString("Nombre"));
                producto.setStrDescripcionProducto(resultSet.getString("Descripcion"));
                producto.setStrStockProducto(resultSet.getString("Stock"));
                producto.setStrPrecioVentaProducto(resultSet.getString("PrecioVenta"));
                producto.setStrIdGrupo(resultSet.getString("grupo_idgrupo"));
                productos.add(producto);
            }
            return productos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadProducto> BuscarProductoEgreso() {
        ArrayList<ClsEntidadProducto> productos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_GetProductoEgreso}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadProducto producto = new ClsEntidadProducto();
                producto.setStrIdProducto(resultSet.getString("IdProducto"));
                producto.setStrCodigoProducto(resultSet.getString("Codigo"));
                producto.setStrNombreProducto(resultSet.getString("Nombre"));
                producto.setStrDescripcionProducto(resultSet.getString("Descripcion"));
                producto.setStrStockProducto(resultSet.getString("Stock"));
                producto.setStrPrecioVentaProducto(resultSet.getString("PrecioVenta"));
                productos.add(producto);
            }
            return productos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    //metodo para filtrar jtable frmbuscarproducto_venta
    public ResultSet filtrarProductoVenta(String criterio, String busqueda) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_GetProductoCompraPorParametro(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
    
    
    public ResultSet BuscarInv() throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Inv()}");
           
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
    
     public ResultSet filtrarProductoVentaVendedor(String criterio, String busqueda,int idproveedor) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_GetProductoCompraPorParametroProveedor(?,?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
              statement.setInt("pidproveedor", idproveedor);
            
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet filtrarProductoOferta(String criterio, String busqueda) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_GetProductoCompraPorOferta(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ArrayList<ClsEntidadProducto> listarProductoStockMin() {
        ArrayList<ClsEntidadProducto> productos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_StockAlert}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadProducto producto = new ClsEntidadProducto();
                producto.setStrNombreProducto(resultSet.getString("Nombre"));
                producto.setStrCodigoProducto(resultSet.getString("Codigo"));
                producto.setStrDescripcionProducto(resultSet.getString("Descripcion"));
                producto.setStrStockProducto(resultSet.getString("Stock"));
                productos.add(producto);
            }
            return productos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadProducto> listarProductoVencidos() {
        ArrayList<ClsEntidadProducto> productos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ProductosVencidos}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadProducto producto = new ClsEntidadProducto();
                producto.setStrNombreProducto(resultSet.getString("Nombre"));
                producto.setStrCodigoProducto(resultSet.getString("Codigo"));
                producto.setStrDescripcionProducto(resultSet.getString("Descripcion"));
                producto.setStrStockProducto(resultSet.getString("vencimiento"));
                productos.add(producto);
            }
            return productos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }
}
