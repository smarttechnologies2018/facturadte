package Negocio;

import Conexion.*;
import Entidad.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public final class ClsDetalleVenta extends ClsVenta {

    private final Connection connection = new ClsConexionLocal().getConection();

    public void agregarDetalleVenta(ClsEntidadDetalleVenta DetalleVenta) {
        try {
            // int fila=0;
            CallableStatement statement = connection.prepareCall("{call SP_I_DetalleVenta(?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidventa", DetalleVenta.getStrIdVenta());
            statement.setString("pidproducto", DetalleVenta.getStrIdProducto());
            statement.setString("pcantidad", DetalleVenta.getStrCantidadDet());
            statement.setString("pprecio", DetalleVenta.getStrPrecioDet());
            statement.setString("ptotal", DetalleVenta.getStrTotalDet());
            statement.setString("ptcant", DetalleVenta.getStrTcant());
            statement.setString("pcontenedor", DetalleVenta.getStrContenedor());
            statement.setString("pcosto", DetalleVenta.getStrCostoDet());
            statement.setString("putilidad", DetalleVenta.getStrUtilidad());
            statement.setString("pnombre", DetalleVenta.getStrNombre());
            statement.execute();

            //JOptionPane.showMessageDialog(null,"¡Venta Realizada con éxito!","Mensaje del Sistema",1);
        } catch (SQLException ex) {
            System.out.println("Error agregar detalle " + ex);

            JOptionPane.showMessageDialog(null, ex, "/n" + "error" + DetalleVenta.getStrNombre() + DetalleVenta.getStrContenedor(), 1);
        }
    }
    
    public void eliminarCuerpoPorCodigoGeneracion(String codigoGeneracion) {
    String query = "DELETE FROM dte_cuerpo WHERE codigoGeneracion = ?";

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, codigoGeneracion);

        int rowsDeleted = statement.executeUpdate();

        if (rowsDeleted > 0) {
            System.out.println("Datos de cuerpo eliminados correctamente");
        } else {
            System.out.println("No se encontraron datos de cuerpo para eliminar");
        }

    } catch (SQLException ex) {
        System.out.println("Error al eliminar datos de cuerpo: " + ex);
        JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
    }
}


    public void agregarCuerpo(ClsDteDocumento cuerpo, String codigoGeneracion) {
        String query = "INSERT ignore INTO dte_cuerpo (cantidad, codTributo, codigo, descripcion,"
                + " montoDescu, noGravado, numItem, numeroDocumento, precioUni, psv, tipoItem,"
                + " uniMedida, ventaExenta, ventaGravada, ventaNoSuj, tributos, codigoGeneracion)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cuerpo.getCantidad());
            statement.setString(2, cuerpo.getCodTributo());
            statement.setString(3, cuerpo.getCodigo());
            statement.setString(4, cuerpo.getDescripcion());
            statement.setDouble(5, cuerpo.getMontoDescu());
            statement.setDouble(6, cuerpo.getNoGravado());
            statement.setInt(7, cuerpo.getNumItem());
            statement.setString(8, cuerpo.getNumeroDocumento());
            statement.setDouble(9, cuerpo.getPrecioUni());
            statement.setDouble(10, cuerpo.getPsv());
            statement.setInt(11, cuerpo.getTipoItem());
            statement.setInt(12, cuerpo.getUniMedida());
            statement.setDouble(13, cuerpo.getVentaExenta());
            statement.setDouble(14, cuerpo.getVentaGravada());
            statement.setDouble(15, cuerpo.getVentaNoSuj());
            statement.setString(16, String.valueOf(cuerpo.getTributos()));
            statement.setString(17, codigoGeneracion);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Datos de cuerpo insertados correctamente");
            }

        } catch (SQLException ex) {
            System.out.println("Error al insertar datos de cuerpo: " + ex);
            JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
        }
    }

    public void agregarDetalleVentaZeus(ClsEntidadDetalleVenta DetalleVenta, int numero) {
        try {
            // int fila=0;
            CallableStatement statement = connection.prepareCall("{call SP_I_DetalleVentaZeus("
                    + "?,?,?,?,?"
                    + ",?,?,?,?,?"
                    + ",?,?,?,?,?,"
                    + "?,?,?,?,?"
                    + ",?,?,?,?,?)}");
            statement.setString("pidventa", DetalleVenta.getStrIdVenta());
            statement.setString("pidproducto", DetalleVenta.getStrIdProducto());
            statement.setString("pcantidad", DetalleVenta.getStrCantidadDet());
            statement.setString("pprecio", DetalleVenta.getStrPrecioDet());
            statement.setString("psubprecio", DetalleVenta.getStrSubPrecio());
            statement.setString("ptotal", DetalleVenta.getStrTotalDet());
            statement.setString("ptcant", DetalleVenta.getStrTcant());
            statement.setString("pcontenedor", DetalleVenta.getStrContenedor());
            statement.setString("pcosto", DetalleVenta.getStrCostoDet());
            statement.setString("putilidad", DetalleVenta.getStrUtilidad());
            statement.setString("pnombre", DetalleVenta.getStrNombre());
            statement.setString("pSubtotal", DetalleVenta.getStrSubTotalVenta());
            statement.setString("pExenta", DetalleVenta.getStrExenta());
            statement.setString("pNosujeta", DetalleVenta.getStrnosujeta());
            statement.setString("pNumeroVenta", DetalleVenta.getStrNumeroVenta());
            statement.setString("pContrans", DetalleVenta.getStrCotrans());
            statement.setString("pFovial", DetalleVenta.getStrFovial());
            statement.setString("pIgvVenta", DetalleVenta.getStrIgvVenta());
            statement.setString("pTipoImpuesto", DetalleVenta.getStrtTipoImpuesto());
            statement.setString("pcontrol", DetalleVenta.getStrControl());
            statement.setString("pidempresa", DetalleVenta.getStrIdEmpresa());
            statement.setString("piddoccumento", DetalleVenta.getStrIdTipoDocumento());
            statement.setInt("pnumero", numero);
            statement.setDate("pfecha", new java.sql.Date(DetalleVenta.getStrFechaVenta().getTime()));
            statement.setInt("pcodinv", DetalleVenta.getStrCodinv());

            statement.execute();

            //JOptionPane.showMessageDialog(null,"¡Venta Realizada con éxito!","Mensaje del Sistema",1);
        } catch (SQLException ex) {
            System.out.println("Error agregar detalle Zeus " + ex);

            JOptionPane.showMessageDialog(null, ex, "/n" + "error" + DetalleVenta.getStrNombre() + DetalleVenta.getStrContenedor(), 1);
        }
    }

    public void agregarDetalleBorrado(ClsEntidadDetalleVenta DetalleVenta) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Detalle_Borrado(?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidventa", (DetalleVenta.getStrIdVenta()));
            statement.setString("pidproducto", DetalleVenta.getStrIdProducto());
            statement.setString("pcantidad", DetalleVenta.getStrCantidadDet());
            statement.setString("pprecio", DetalleVenta.getStrPrecioDet());
            statement.setString("ptotal", DetalleVenta.getStrTotalDet());
            statement.setString("ptcant", DetalleVenta.getStrTcant());
            statement.setString("pcontenedor", DetalleVenta.getStrContenedor());
            statement.setString("pcosto", DetalleVenta.getStrCostoDet());
            statement.setString("putilidad", DetalleVenta.getStrUtilidad());
            statement.setString("pnombre", DetalleVenta.getStrNombre());

            statement.setString("pid", DetalleVenta.getIdempleado());
            statement.execute();
            //  connection.close();
            //JOptionPane.showMessageDialog(null,"¡Venta Realizada con éxito!","Mensaje del Sistema",1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void modificarDetalleVenta(String codigo, ClsEntidadDetalleVenta DetalleVenta) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_DetalleVenta(?,?,?,?,?,?,?)}");
            statement.setString("pidventa", codigo);
            statement.setString("pidproducto", DetalleVenta.getStrIdProducto());
            statement.setString("pcantidad", DetalleVenta.getStrCantidadDet());
            statement.setString("pcosto", DetalleVenta.getStrCostoDet());
            statement.setString("pprecio", DetalleVenta.getStrPrecioDet());
            statement.setString("ptotal", DetalleVenta.getStrTotalDet());
            statement.setString("ptcant", DetalleVenta.getStrTcant());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ResultSet listarDetalleVentaPorParametro(String criterio, String busqueda) throws Exception {

        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_DetalleVentaPorParametro(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            //statement.setString("paccion", accion);

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

}
