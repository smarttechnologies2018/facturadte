package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadDescuento;
import ds.desktop.notify.DesktopNotify;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ramos
 */
public class ClsDescuento {

    private final Connection connection = new ClsConexionLocal().getConection();

    public void agregarDescuento(ClsEntidadDescuento Descuento) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Descuento(?,?,?,?,?,?)}");
            statement.setString("pIdProducto", Descuento.getStrIdProducto());
            statement.setString("pCosto", Descuento.getStrCosto());
            statement.setString("pCantidadProducto", Descuento.getStrCantidadVenta());
            statement.setString("pUtilidad", Descuento.getStrDescuento());
            statement.setString("pCarga", Descuento.getStrCarga());
            statement.setString("pContenedor", Descuento.getStrContenedor());
            statement.execute();
            // DesktopNotify.showDesktopMessage("", " " + "PRECIO AGREGADO"  +Descuento.getStrIdProducto(), DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "¡Error ingrese el descuento en formato!" + ex, "Mensaje del Sistema", 1);
        }
    }

    public void agregarDescuentolocaldesdeserver(ClsEntidadDescuento Descuento) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_DescuentoDesdeServer(?,?,?,?,?,?,?,?,?,?,?)}");

            statement.setString("pidprecio", Descuento.getStrIdPrecio());
            statement.setString("pIdProducto", Descuento.getStrProductoIdProfucto());
            statement.setString("pCosto", Descuento.getStrCosto());
            statement.setString("pCantidadProducto", Descuento.getStrCantidadVenta());
            statement.setString("pUtilidad", Descuento.getStrDescuento());
            statement.setString("pCarga", Descuento.getStrCarga());
            statement.setString("pContenedor", Descuento.getStrContenedor());
            statement.setString("pprecioventa", Descuento.getStrPrecioVenta());
            statement.setString("ptotal", Descuento.getStrTotal());
            statement.setString("pcodigo", Descuento.getCodigo());
            statement.setString("pUUID", Descuento.getUUID());

            statement.execute();
            // DesktopNotify.showDesktopMessage("", " " + "PRECIO AGREGADO"  +Descuento.getStrIdProducto(), DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "¡Error ingrese el descuento en formato!" + ex, "Mensaje del Sistema", 1);
        }
    }

    public void agregarDescuentoSinMensajes(ClsEntidadDescuento Descuento) throws SQLException {
        connection.setAutoCommit(true);
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Descuento(?,?,?,?,?,?)}");
            statement.setString("pIdProducto", Descuento.getStrIdProducto());
            statement.setString("pCosto", Descuento.getStrCosto());
            statement.setString("pCarga", Descuento.getStrCarga());
            statement.setString("pCantidadProducto", Descuento.getStrCantidadVenta());
            statement.setString("pUtilidad", Descuento.getStrDescuento());
            statement.setString("pContenedor", Descuento.getStrContenedor());
            statement.execute();
            DesktopNotify.showDesktopMessage("", " " + "PRECIO AGREGADO", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }

    public void agregarDescuentolocal(ClsEntidadDescuento Descuento) throws SQLException {
        connection.setAutoCommit(true);
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Descuentolocal(?,?,?,?,?,?,?)}");
            statement.setString("pIdPrecio", Descuento.getStrIdPrecio());
            statement.setString("pIdProducto", Descuento.getStrProductoIdProfucto());
            statement.setString("pCosto", Descuento.getStrCosto());
            statement.setString("pCantidadProducto", Descuento.getStrCantidadVenta());
            statement.setString("pUtilidad", Descuento.getStrDescuento());
            statement.setDate("pFecha", new java.sql.Date(Descuento.getStrFecha().getDate()));
            statement.setString("pContenedor", Descuento.getStrContenedor());
            statement.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void modificarDescuento(ClsEntidadDescuento Descuento) throws SQLException {
        connection.setAutoCommit(true);
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Descuento(?,?,?,?,?,?)}");
            statement.setString("pidprecio", Descuento.getStrIdPrecio());
            statement.setString("pCosto", Descuento.getStrCosto());
            statement.setString("pCantidadProducto", Descuento.getStrCantidadVenta());
            statement.setString("pUtilidad", Descuento.getStrDescuento());
            statement.setString("pCarga", Descuento.getStrCarga());
            statement.setString("pContenedor", Descuento.getStrContenedor());
            statement.executeUpdate();
            DesktopNotify.showDesktopMessage("", " " + "PRECIO ACTUALIZADO", DesktopNotify.SUCCESS, 5000);
            Presentacion.FrmProducto.actualizarTablaDescuentos();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public void modificarDescuentolocal(ClsEntidadDescuento Descuento) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Descuentolocal(?,?,?,?,?,?,?,?)}");
            statement.setString("pidprecio", Descuento.getStrIdPrecio());
            statement.setString("pproducto_IdProducto", Descuento.getStrProductoIdProfucto());
            statement.setString("pCosto", Descuento.getStrCosto());
            statement.setString("pCantidadProducto", Descuento.getStrCantidadVenta());
            statement.setString("pUtilidad", Descuento.getStrDescuento());
            statement.setDate("pFecha", new java.sql.Date(Descuento.getStrFecha().getTime()));
            statement.setString("pContenedor", Descuento.getStrContenedor());
            statement.setString("pCarga", Descuento.getStrCarga());
            statement.executeUpdate();
            System.out.println(Descuento.getStrIdPrecio() + "   " + Descuento.getStrProductoIdProfucto() + "  " + Descuento.getStrCosto());
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public ArrayList<ClsEntidadDescuento> listarDescuentos() {
        ArrayList<ClsEntidadDescuento> descuentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Precio}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadDescuento descuento = new ClsEntidadDescuento();
                descuento.setStrIdPrecio(resultSet.getString("idprecio"));
                descuento.setStrProductoIdProfucto(resultSet.getString("producto_IdProducto"));
                descuento.setStrNombreProducto(resultSet.getString("Nombre"));
                descuento.setStrPrecioCosto(resultSet.getString("PrecioCosto"));
                descuento.setStrPrecioVenta(resultSet.getString("PrecioVenta"));
                descuento.setStrDesde(resultSet.getString("cantidadi"));
                descuento.setStrCantidadVenta(resultSet.getString("cantidad"));
                descuento.setStrDescuento(resultSet.getString("porcentaje"));
                descuento.setStrTotalDescuento(resultSet.getString("descuento"));
                descuento.setStrPrecio2(resultSet.getString("precio2"));
                descuento.setStrContenedor("Contenedor");
                descuentos.add(descuento);
            }
            return descuentos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadDescuento> listarDescuentosPorId(String Id) {
        ArrayList<ClsEntidadDescuento> descuentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_PrecioPorId(?)}");
            statement.setString("pIdProducto", Id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadDescuento descuento = new ClsEntidadDescuento();
                descuento.setStrIdPrecio(resultSet.getString("idprecio"));
                descuento.setStrProductoIdProfucto(resultSet.getString("producto_IdProducto"));
                descuento.setStrNombreProducto(resultSet.getString("Nombre"));
                descuento.setStrPrecioCosto(resultSet.getString("costo"));
                descuento.setStrPrecioVenta(resultSet.getString("PrecioVenta"));
                descuento.setStrCantidadVenta(resultSet.getString("cantidad"));
                descuento.setStrDescuento(resultSet.getString("porcentaje"));
                descuento.setStrContenedor(resultSet.getString("Contenedor"));
                descuento.setStrCarga(resultSet.getString("Carga"));
                descuento.setStrTotal(resultSet.getString("Total"));
                descuento.setStrTotalCosto(resultSet.getString("totalcosto"));
                descuento.setFecha2(resultSet.getString("fecha"));

                descuentos.add(descuento);
            }
            return descuentos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadDescuento> listarpreciosexcel() {
        ArrayList<ClsEntidadDescuento> descuentos = new ArrayList<>();
        String query = "SELECT pr.producto_IdProducto, p.codigo, p.Nombre, venta as cantidad,pr.contenedor, p.Producto_Costo, "
                + "round((p.Producto_Costo * pr.venta),2) as totalcosto, (p.Producto_Costo * pr.utilidad) as PrecioVenta, "
                + "(p.Producto_Costo * pr.utilidad * pr.venta) as total,pr.utilidad,"
                + " DATE_FORMAT(pr.fecha, '%d/%m/%Y') as fecha, p.grupo_idgrupo FROM precio as pr LEFT JOIN "
                + "producto as p on pr.producto_IdProducto = p.IdProducto "
                + "WHERE p.Producto_Costo <> 0 ORDER BY p.nombre, pr.venta ASC";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ClsEntidadDescuento descuento = new ClsEntidadDescuento();

                descuento.setStrProductoIdProfucto(resultSet.getString("producto_IdProducto"));
                descuento.setStrcodigo(resultSet.getString("codigo"));
                descuento.setStrNombreProducto(resultSet.getString("Nombre"));
                descuento.setStrCantidadVenta(resultSet.getString("cantidad"));
                descuento.setStrPrecioCosto(resultSet.getString("Producto_Costo"));
                descuento.setStrPrecioVenta(resultSet.getString("PrecioVenta"));
                descuento.setStrTotalCosto(resultSet.getString("totalcosto"));
                descuento.setStrTotal(resultSet.getString("total"));
                descuento.setStrDescuento(resultSet.getString("utilidad"));
                descuento.setFecha2(resultSet.getString("fecha"));
                  descuento.setStrGrupo(resultSet.getString("grupo_idgrupo"));
                    descuento.setStrContenedor(resultSet.getString("contenedor"));
                descuentos.add(descuento);
            }
            return descuentos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public void modificarCosto(ClsEntidadDescuento Costo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Costo(?,?,?)}");
            statement.setString("pIdProducto", Costo.getStrIdPrecio());
            statement.setString("pCosto", Costo.getStrCosto());
            statement.setString("pGrupo", Costo.getStrGrupo());
            statement.executeUpdate();
            DesktopNotify.showDesktopMessage("", " " + "COSTO AGREGADO", DesktopNotify.SUCCESS, 5000);
            Presentacion.FrmProducto.actualizarTablaDescuentos();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public void EliminarDescuento(String codigo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_D_Descuento(?)}");
            statement.setString("pidprecio", codigo);
            statement.executeUpdate();
            DesktopNotify.showDesktopMessage("", " " + "GUARDANDO" + codigo, DesktopNotify.INFORMATION, 5000);
            // Presentacion.FrmProducto.actualizarTablaDescuentos();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public void EliminarPrecios() {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_D_PRECIOS()}");

            statement.executeUpdate();
            DesktopNotify.showDesktopMessage("", " " + "ACTUALIZANDO", DesktopNotify.INFORMATION, 5000);
            // Presentacion.FrmProducto.actualizarTablaDescuentos();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }
    
    public void Eliminarpre(int productoId) {
    String query = "DELETE FROM precio WHERE producto_idproducto = ?";
    
    try {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, productoId);

       int filasAfectadas = statement.executeUpdate();
       DesktopNotify.showDesktopMessage("", " " + "Registros afectados: " + filasAfectadas, DesktopNotify.INFORMATION, 5000);
    } catch (SQLException ex) {
        System.err.println("Error : " + ex);
    }
}


    public void PrepararPrecios(ClsEntidadDescuento descuento) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_DescuentoDesdeServer(?,?,?,?,?,?,?,?,?,?,?,?)}");

            statement.setString("pidprecio", descuento.getStrIdPrecio());
            statement.setString("pIdProducto", descuento.getStrProductoIdProfucto());
            statement.setString("pCosto", descuento.getStrCosto());
            statement.setString("pCantidadProducto", descuento.getStrCantidadVenta());
            statement.setString("pUtilidad", descuento.getStrDescuento());
            statement.setString("pCarga", descuento.getStrCarga());
            statement.setString("pContenedor", descuento.getStrContenedor());
            statement.setString("pprecioventa", descuento.getStrPrecioVenta());
            statement.setString("ptotal", descuento.getStrTotal());
            statement.setString("pcodigo", descuento.getCodigo());
            statement.setString("pUUID", descuento.getUUID());
            statement.setDate("pfecha", (Date) descuento.getStrFecha());

            //System.out.println(descuento.getStrFecha().getDate()+"fecha");
            statement.executeUpdate();
            //  DesktopNotify.showDesktopMessage("", " " + "ACTUALIZANDO", DesktopNotify.INFORMATION, 500);
            // Presentacion.FrmProducto.actualizarTablaDescuentos();

            System.out.println(descuento.getStrProductoIdProfucto());
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public void PrepararPrecios2(ClsEntidadDescuento descuento) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_DescuentoDesdeServer2(?,?,?,?,?,?,?,?,?,?,?,?)}");

            statement.setString("pidprecio", descuento.getStrIdPrecio());
            statement.setString("pIdProducto", descuento.getStrProductoIdProfucto());
            statement.setString("pCosto", descuento.getStrCosto());
            statement.setString("pCantidadProducto", descuento.getStrCantidadVenta());
            statement.setString("pUtilidad", descuento.getStrDescuento());
            statement.setString("pCarga", descuento.getStrCarga());
            statement.setString("pContenedor", descuento.getStrContenedor());
            statement.setString("pprecioventa", descuento.getStrPrecioVenta());
            statement.setString("ptotal", descuento.getStrTotal());
            statement.setString("pcodigo", descuento.getCodigo());
            statement.setString("pUUID", descuento.getUUID());
            statement.setDate("pfecha", (Date) descuento.getStrFecha());

            //System.out.println(descuento.getStrFecha().getDate()+"fecha");
            statement.execute();
            //  DesktopNotify.showDesktopMessage("", " " + "ACTUALIZANDO", DesktopNotify.INFORMATION, 500);
            // Presentacion.FrmProducto.actualizarTablaDescuentos();

            System.out.println(descuento.getStrIdPrecio());
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public void EliminarDescuentogRUPO(String codigo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_D_DescuentoGrupo(?)}");
            statement.setString("pidprecio", codigo);
           int filasAfectadas = statement.executeUpdate();
            DesktopNotify.showDesktopMessage("", " " + "Registros afectados: " + filasAfectadas, DesktopNotify.INFORMATION, 5000);
            // Presentacion.FrmProducto.actualizarTablaDescuentos();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public void EliminarDescuentoSinEstado() {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_D_DescuentoSinEstado()}");

            statement.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public void AgregarLista(ClsEntidadDescuento descuento) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_AGREGARLISTA(?,?)}");

            statement.setString("pIdProducto", descuento.getStrProductoIdProfucto());

            statement.setString("pcantidad", descuento.getStrCantidadVenta());
            System.out.println(descuento.getStrProductoIdProfucto() + "  " + descuento.getStrCantidadVenta());

            statement.executeUpdate();
            DesktopNotify.showDesktopMessage("MENSAJE", " " + "ACTUALIZANDO", DesktopNotify.INFORMATION, 5000);

        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void QuitarLista(ClsEntidadDescuento descuento) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_QUITARLISTA(?,?)}");

            statement.setString("pIdProducto", descuento.getStrProductoIdProfucto());
            statement.setString("pcantidad", descuento.getStrCantidadVenta());

            statement.executeUpdate();
            DesktopNotify.showDesktopMessage("MENSAJE", " " + "ELIMINADO", DesktopNotify.INFORMATION, 5000);
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public int ExisteDescuento(int Id) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CountDescuento(?)}");
            statement.setInt("pId", Id);
            int codigo = 0;
            Statement st = connection.createStatement();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("ExisteDescuento");
            }
            return codigo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error sql " + e);
            return 0;
        }
    }

    public int BuscarContenedorRepetidoPorGrupo(String IdProducto, String IdGrupo, String Contenedor) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_NombreContenedorTablaPrecio(?,?,?)}");
            statement.setString("pIdProducto", IdProducto);
            statement.setString("pIdGrupo", IdGrupo);
            statement.setString("pContenedor", Contenedor);
            int codigo = 0;
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("ExisteContenedor");
            }
            return codigo;
        } catch (SQLException e) {

            return 0;
        }
    }
}
