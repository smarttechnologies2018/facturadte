package Negocio;

import Conexion.*;
import Entidad.*;
import ds.desktop.notify.DesktopNotify;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClsDetalleCompra {

    
    public void agregarDetalleCompra(ClsEntidadDetalleCompra DetalleCompra, int numero) {
         Connection connection = new ClsConexionLocal().getConection();

        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_DetalleCompra(?,?,?,?,?,?,?,?,?,?,?"
                    + ",?,?,?,?,?,?,?,?,?,?"
                    + ",?,?,?)}");
            statement.setString("pidcompra", DetalleCompra.getStrIdCompra());
            statement.setString("pidproducto", DetalleCompra.getStrIdProducto());
            statement.setString("pcantidad", DetalleCompra.getStrCantidadDet());
            statement.setString("pprecio", DetalleCompra.getStrPrecioDet());
            statement.setString("ptotal", DetalleCompra.getStrTotalDet());
            statement.setString("pcontenedor", DetalleCompra.getStrContenedor());
            statement.setString("ptunidad", DetalleCompra.getStrTunidad());
            statement.setString("pnombre", DetalleCompra.getStrNombreProducto());
            statement.setString("pidempresa", DetalleCompra.getStrIdEmpresa());
            statement.setDouble("pfracc", DetalleCompra.getStrFracc());
            
            statement.setDouble("pcostosin", DetalleCompra.getStrCostoSin());
            statement.setDouble("ptotalsin", DetalleCompra.getTotalSin());
            statement.setString("pimpuesto", DetalleCompra.getStrTipoImpuesto());
           
            statement.setString("pigv", DetalleCompra.getStrIgvCompra());
            statement.setDouble("pcotrans", DetalleCompra.getStrCotrans());
            statement.setDouble("pfovial", DetalleCompra.getStrfovial());
            statement.setString("piddocumento", DetalleCompra.getStrIdTipoDocumento());
            statement.setString("pcoment", DetalleCompra.getStrObervacion());
            statement.setDouble("pdescuento", DetalleCompra.getStrDescuento());
            statement.setDouble("ptotal2", DetalleCompra.getStrTotal2());
            
            statement.setDouble("pconteo", numero);
              statement.setString("pcodinv", DetalleCompra.getStrCodInv());
               statement.setDate("pfecha", new java.sql.Date(DetalleCompra.getStrFechaCompra().getTime()));
                 statement.setString("pcodigo", DetalleCompra.getStrCodigo());
            statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public ResultSet listarDetalleCompraPorParametrolinea(String criterio, String busqueda) throws Exception {
         Connection connection = new ClsConexionup().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_DetalleCompraPorParametrozeus(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }

        
        
        
    }

    public void agregarDetalleOrden(ClsEntidadDetalleCompra DetalleCompra, int numero) {
         Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_DetalleCompraOrden(?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidcompra", DetalleCompra.getStrIdCompra());
            statement.setString("pidproducto", DetalleCompra.getStrIdProducto());
            statement.setString("pcodigo", DetalleCompra.getStrCodigo());
            statement.setString("pnombre", DetalleCompra.getStrNombreProducto());
            statement.setString("pcontenedor", DetalleCompra.getStrContenedor());
            statement.setDouble("pfardos", DetalleCompra.getStrFardos());
            statement.setDouble("punidades", DetalleCompra.getStrUnidades());
            statement.setString("pcantidad", DetalleCompra.getStrCantidadDet());
            statement.setDouble("pcostosin", DetalleCompra.getStrPreciosinImpuesto());
            statement.setDouble("pivaunitario", DetalleCompra.getStrIvaUnit());
            statement.setString("ptotal", DetalleCompra.getStrTotalCompra());
            statement.setString("ptunidades", DetalleCompra.getStrTunidad());
            statement.setDouble("pfracc", DetalleCompra.getStrFracc());
            statement.setString("pprecio", DetalleCompra.getStrPrecioDet());
            statement.setDouble("ptotalsin", DetalleCompra.getStrCostoSin());
            statement.setString("pimpuesto", DetalleCompra.getStrTipoImpuesto());
            statement.setString("pigv", DetalleCompra.getStrIgvCompra());
            statement.setDouble("pexist", DetalleCompra.getStrExist());
            statement.setString("pnumero", DetalleCompra.getStrNumeroCompra());
            statement.setString("pidempresa", DetalleCompra.getStrIdEmpresa());
            statement.setString("piddocumento", DetalleCompra.getStrIdTipoDocumento());
            statement.setDouble("pconteo", numero);
            statement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void modificarDetalleCompra(String codigo, ClsEntidadDetalleCompra DetalleCompra) {
         Connection connection = new ClsConexionLocal().getConection();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_DetalleCompra(?,?,?,?,?)}");
            statement.setString("pidcompra", codigo);
            statement.setString("pidproducto", DetalleCompra.getStrIdProducto());
            statement.setString("pcantidad", DetalleCompra.getStrCantidadDet());
            statement.setString("pprecio", DetalleCompra.getStrPrecioDet());
            statement.setString("ptotal", DetalleCompra.getStrTotalDet());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public ResultSet listarDetalleProductoVendido(String criterio, String busqueda) throws Exception {
         Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_DetalleCompraPorParametro(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }

    }

    public ResultSet listarDetalleCompraPorParametro(String criterio, String busqueda) throws Exception {
         Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_DetalleCompraPorParametrozeus(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }

        
        
        
    }
    
    public ResultSet listarDetalleCompraPorParametro_Orden( String busqueda) throws Exception {
         Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_DetalleCompraPorParametrozeus_Orden(?)}");
           
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }

    }
    
 public ResultSet listarDetalleCompraPorParametroOrden(String criterio, String busqueda) throws Exception {
      Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_DetalleCompraPorParametrozeusOrden(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }

    }
    public ResultSet ListarORden( Integer rango, Integer idempresa) throws Exception {
         Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_OrdenDeCompraZeus(?,?)}");
           
            statement.setInt("prango", rango);
              statement.setInt("pidempresa", idempresa);
            
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }

    }

    public ResultSet listarDetalleCompraPorParametrototal(String criterio, String busqueda) throws Exception {
         Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_DetalleCompraPorParametrozeustotal(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }

    }
    
      public ResultSet listarlimites(int idempresa) throws Exception {
           Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ListasLimites(?)}");
            statement.setInt("pempresa", idempresa);
            
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }

    }
    

    public ResultSet listarAutoPedido(float frecuencia) throws Exception {
         Connection connection = new ClsConexionLocal().getConection();
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Autopedido(?)}");
            statement.setFloat("pfrecuencia", frecuencia);

            System.out.println(frecuencia);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }

    }

}
