package Negocio;

import Conexion.*;
import Entidad.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClsTipoDocumento {

    private final Connection connection = new ClsConexionLocal().getConection();

    public void agregarTipoDocumento(ClsEntidadTipoDocumento TipoDocumento) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_TipoDocumento(?)}");
            statement.setString("pdescripcion", TipoDocumento.getStrDescripcionTipoDocumento());
            statement.execute();
            JOptionPane.showMessageDialog(null, "¡Tipo de Documento Agregado con éxito!", "Mensaje del Sistema", 1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void modificarTipoDocumento(String codigo, ClsEntidadTipoDocumento TipoDocumento) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_TipoDocumento(?,?,?)}");
            statement.setString("pidtipodocumento", codigo);
            statement.setString("pdescripcion", TipoDocumento.getStrDescripcionTipoDocumento());
             statement.setString("pcodigo", TipoDocumento.getStrNumeroDeLineasDocumento());
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(null, "¡Tipo de Documento Actualizado!", "Mensaje del Sistema", 1);
    }

    public ArrayList<ClsEntidadTipoDocumento> listarTipoDocumento() {
        ArrayList<ClsEntidadTipoDocumento> tipodocumentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ListardocumentosVenta}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadTipoDocumento categoria = new ClsEntidadTipoDocumento();
                categoria.setStrIdTipoDocumento(resultSet.getString("IdTipoDocumento"));
                categoria.setStrDescripcionTipoDocumento(resultSet.getString("Descripcion"));
                categoria.setStrNumeroDeLineasDocumento(resultSet.getString("lineas"));
                tipodocumentos.add(categoria);
            }
//            connection.close();
            return tipodocumentos;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    public ArrayList<ClsEntidadTipoDocumento> listarTipoDocumentomant() {
        ArrayList<ClsEntidadTipoDocumento> tipodocumentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ListardocumentosVentamant}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadTipoDocumento categoria = new ClsEntidadTipoDocumento();
                categoria.setStrIdTipoDocumento(resultSet.getString("IdTipoDocumento"));
                categoria.setStrDescripcionTipoDocumento(resultSet.getString("Descripcion"));
                categoria.setStrNumeroDeLineasDocumento(resultSet.getString("ultimocodigo"));
                tipodocumentos.add(categoria);
            }
//            connection.close();
            return tipodocumentos;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    
    
     public ArrayList<ClsEntidadTipoDocumento> listarTipoDocumentoPedido() {
        ArrayList<ClsEntidadTipoDocumento> tipodocumentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ListardocumentosPedido}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadTipoDocumento categoria = new ClsEntidadTipoDocumento();
                categoria.setStrIdTipoDocumento(resultSet.getString("IdTipoDocumento"));
                categoria.setStrDescripcionTipoDocumento(resultSet.getString("Descripcion"));
                 categoria.setStrNumeroDeLineasDocumento(resultSet.getString("lineas"));
                
                tipodocumentos.add(categoria);
            }
//            connection.close();
            return tipodocumentos;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    public ArrayList<ClsEntidadTipoDocumento> listarTipoDocumentoCompra() {
        ArrayList<ClsEntidadTipoDocumento> tipodocumentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ListardocumentosCompra}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadTipoDocumento categoria = new ClsEntidadTipoDocumento();
                categoria.setStrIdTipoDocumento(resultSet.getString("IdTipoDocumento"));
                categoria.setStrDescripcionTipoDocumento(resultSet.getString("Descripcion"));
                tipodocumentos.add(categoria);
            }
            return tipodocumentos;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    
    
    
    
     public ArrayList<ClsEntidadTipoDocumento> listarTipoDocumentotraslado() {
        ArrayList<ClsEntidadTipoDocumento> tipodocumentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Listardocumentostraslado}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadTipoDocumento categoria = new ClsEntidadTipoDocumento();
                categoria.setStrIdTipoDocumento(resultSet.getString("IdTipoDocumento"));
                categoria.setStrDescripcionTipoDocumento(resultSet.getString("Descripcion"));
                tipodocumentos.add(categoria);
            }
            return tipodocumentos;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    public ArrayList<ClsEntidadTipoDocumento> listarTipoDocumentoCompraIVA() {
        ArrayList<ClsEntidadTipoDocumento> tipodocumentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ListardocumentosIva}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadTipoDocumento categoria = new ClsEntidadTipoDocumento();
                categoria.setStrIdTipoDocumento(resultSet.getString("IdTipoDocumento"));
                categoria.setStrDescripcionTipoDocumento(resultSet.getString("Descripcion"));
                tipodocumentos.add(categoria);
            }
            return tipodocumentos;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    public ArrayList<ClsEntidadTipoDocumento> listarTipoDocumentoFactura() {
        ArrayList<ClsEntidadTipoDocumento> tipodocumentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ListardocumentosFactura}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadTipoDocumento categoria = new ClsEntidadTipoDocumento();
                categoria.setStrIdTipoDocumento(resultSet.getString("IdTipoDocumento"));
                categoria.setStrDescripcionTipoDocumento(resultSet.getString("Descripcion"));
                tipodocumentos.add(categoria);
            }
            return tipodocumentos;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadTipoDocumento> listarTipoDocuentoFinaciero() {
        ArrayList<ClsEntidadTipoDocumento> tipodocumentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ListarDocumentoFinanciero}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadTipoDocumento categoria = new ClsEntidadTipoDocumento();
                categoria.setStrIdTipoDocumento(resultSet.getString("IdTipoDocumento"));
                categoria.setStrDescripcionTipoDocumento(resultSet.getString("Descripcion"));
                tipodocumentos.add(categoria);
            }
            return tipodocumentos;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadTipoDocumento> listarTipoDocumentoTicketDevolucion() {
        ArrayList<ClsEntidadTipoDocumento> tipodocumentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ListardocumentosDecolucion}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadTipoDocumento categoria = new ClsEntidadTipoDocumento();
                categoria.setStrIdTipoDocumento(resultSet.getString("IdTipoDocumento"));
                categoria.setStrDescripcionTipoDocumento(resultSet.getString("Descripcion"));
                tipodocumentos.add(categoria);
            }
            return tipodocumentos;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadTipoDocumento> listarTipoDocumentoBoleta() {
        ArrayList<ClsEntidadTipoDocumento> tipodocumentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ListarDocumento}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadTipoDocumento categoria = new ClsEntidadTipoDocumento();
                categoria.setStrIdTipoDocumento(resultSet.getString("IdTipoDocumento"));
                categoria.setStrDescripcionTipoDocumento(resultSet.getString("Descripcion"));
                tipodocumentos.add(categoria);
            }
            return tipodocumentos;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ResultSet listarTipoDocumentoPorParametro(String criterio, String busqueda) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_TipoDocumentoPorParametro(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet obtenerUltimoCodigodeFactura(String busqueda) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_UltimoCodigoFactura(?)}");
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
    
     public ResultSet obtenerUltimoCodigodeFacturaR(String busqueda) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_UltimoCodigoFacturaR(?)}");
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet obtenerUltimoCodigodeTicket(int pId) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_UltimoCodigoTicket(?)}");
            statement.setInt("pId", pId);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public void aumentarUltimaFactura(String pNombreFactura,int pNumeroFactura) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_AumentarFacturas(?,?)}");
            statement.setString("pNombreFactura", pNombreFactura);
             statement.setInt("pNumeroFactura", pNumeroFactura);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //JOptionPane.showMessageDialog(null, "¡Tipo de Documento Actualizado!", "Mensaje del Sistema", 1);
    }

    public void aumentarUltimaTicketPorIdPc(int pIdPc) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_AumentarTicketPorIdPc(?)}");
            statement.setInt("pIdPc", pIdPc);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //JOptionPane.showMessageDialog(null, "¡Tipo de Documento Actualizado!", "Mensaje del Sistema", 1);
    }

    public ArrayList<ClsEntidadTipoDocumento> listarTipoDocumentosintikect() {
        ArrayList<ClsEntidadTipoDocumento> tipodocumentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_tipodocumentosintiket}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadTipoDocumento categoria = new ClsEntidadTipoDocumento();
                categoria.setStrIdTipoDocumento(resultSet.getString("IdTipoDocumento"));
                categoria.setStrDescripcionTipoDocumento(resultSet.getString("Descripcion"));
                tipodocumentos.add(categoria);
            }
            return tipodocumentos;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadTipoDocumento> listarTipoDocumentosintikectsinNota() {
        ArrayList<ClsEntidadTipoDocumento> tipodocumentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_tipodocumentosintiketsinNOTA}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadTipoDocumento categoria = new ClsEntidadTipoDocumento();
                categoria.setStrIdTipoDocumento(resultSet.getString("IdTipoDocumento"));
                categoria.setStrDescripcionTipoDocumento(resultSet.getString("Descripcion"));
                tipodocumentos.add(categoria);
            }
            return tipodocumentos;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
}
