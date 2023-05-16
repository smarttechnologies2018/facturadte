package Negocio;

import Conexion.ClsConexionLocal;
import Consultas.FrmBuscarCajasCorte;

import Entidad.ClsEntidadCaja;
import Entidad.ClsEntidadError;
import ds.desktop.notify.DesktopNotify;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ramos
 */
public class ClsError {

    private final Connection connection = new ClsConexionLocal().getConection();
    private String sSQL = "";

    public ArrayList<ClsEntidadCaja> listarCaja(int idempresa) {
        ArrayList<ClsEntidadCaja> cajas = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Caja(?)}");
             statement.setInt("pbusqueda", idempresa);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadCaja caja = new ClsEntidadCaja();
                caja.setStrIdPcCaja(resultSet.getString("IdPc"));
                caja.setStrMacPcCaja(resultSet.getString("MacPc"));
                caja.setStrNombrePcCaja(resultSet.getString("nombrePc"));
                caja.setStrCortex(resultSet.getString("cortex"));
                caja.setStrCortexz(resultSet.getString("cortez"));
                cajas.add(caja);
            }
            return cajas;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
 public ArrayList<ClsEntidadCaja> listarCOrtez(String nombre,Date fechaini) {
        ArrayList<ClsEntidadCaja> cajas = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CortePorCajaZ(?,?)}");
            
              statement.setString("pcaja", nombre);
              statement.setDate("pfechaini", new java.sql.Date(fechaini.getTime()));
             
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadCaja caja = new ClsEntidadCaja();
                caja.setStrCortexz(resultSet.getString("z"));
                
                cajas.add(caja);
            }
            return cajas;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    
    
      public ArrayList<ClsEntidadCaja> listarCajaCorte(Date busqueda) {
        String corte="";
        if(FrmBuscarCajasCorte.chkz.isSelected()){
        corte="cortez";
        
        }
        
         if(FrmBuscarCajasCorte.chkx.isSelected()){
        corte="cortex";
        
        }
          ArrayList<ClsEntidadCaja> cajas = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CajaPorParametroCorteZ(?,?)}");
             statement.setDate("pbusqueda", new java.sql.Date(busqueda.getTime()));
             statement.setString("pcorte", corte);
         
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadCaja caja = new ClsEntidadCaja();
                caja.setStrIdPcCaja(resultSet.getString("IdPc"));
                caja.setStrNombrePcCaja(resultSet.getString("nombrepc"));
                caja.setFecha((resultSet.getString("fecha")));
                caja.setStrCortez(resultSet.getString("z"));
                  caja.setStrTotalPagarVenta(resultSet.getString("venta"));
               
              
                cajas.add(caja);
            }
            return cajas;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public ArrayList<ClsEntidadCaja> listarCajaparametro(String busqueda) {
        ArrayList<ClsEntidadCaja> cajas = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CajaPorParametro(?)}");
            statement.setString("pbusqueda", busqueda);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadCaja caja = new ClsEntidadCaja();
                caja.setStrIdPcCaja(resultSet.getString("IdPc"));
                caja.setStrMacPcCaja(resultSet.getString("MacPc"));
                caja.setStrNombrePcCaja(resultSet.getString("nombrePc"));
                caja.setStrCortex(resultSet.getString("cortex"));
                caja.setStrCortexz(resultSet.getString("cortez"));
                cajas.add(caja);
            }
            return cajas;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadCaja> listarCajaXSucursal(int IdSucursal) {
        ArrayList<ClsEntidadCaja> cajas = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CajaxSucursal(?)}");
            statement.setInt("pidSucursal", IdSucursal);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadCaja caja = new ClsEntidadCaja();
                caja.setStrIdPcCaja(resultSet.getString("IdPc"));
                caja.setStrMacPcCaja(resultSet.getString("MacPc"));
                caja.setStrNombrePcCaja(resultSet.getString("nombrePc"));
                caja.setStrCortex(resultSet.getString("cortex"));
                caja.setStrCortexz(resultSet.getString("cortez"));
                cajas.add(caja);
            }
            return cajas;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    

    public int ContarDatos() {
        sSQL = "CALL SP_S_CountCaja";
        try {
            int codigo = 0;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                codigo = rs.getInt("ExisteCaja");
            }
            return codigo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        } finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                System.err.println("Error cerrando..." + e);
//            }
        }
    }

    public void agregarerrror(ClsEntidadError Error) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Bitacora(?,?,?,?,?,?,?,?)}");
            statement.setString("pBit_Empresa", Error.getStrEmpresa());
            statement.setString("pBit_Caja", Error.getStrCaja());
            statement.setString("pBit_Usuario", Error.getStrUsuario());
            statement.setString("pBit_Evento", Error.getStrEvento());
            statement.setString("pBit_Modulo", Error.getStrModulo());
            statement.setInt("pBit_IdEmpresa", Error.getStrIdempresa());
            statement.setInt("pBit_IdCaja", Error.getStridCaja());
            statement.setInt("pBit_Idusuario", Error.getStrIdusuario());
             
            

            statement.execute();
           DesktopNotify.showDesktopMessage("", "" + "ERROR AGREGADO A BITACORA", DesktopNotify.SUCCESS, 4444);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Mensaje del Sistema", 1);
        }
    }

    public void modificarCaja(String codigo, ClsEntidadCaja Caja) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Caja(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("p_IdPcMac", codigo);
            statement.setString("p_MacPc", Caja.getStrMacPcCaja());
            statement.setString("p_NombrePc", Caja.getStrNombrePcCaja());
            statement.setString("p_IdempresaPc", Caja.getStrIdEmpresa());
            statement.setString("p_Cortex", Caja.getStrCortex());
            statement.setString("p_Cortez", Caja.getStrCortexz());
            statement.setString("p_UltimoTicket", Caja.getStrUltimoTicket());
            statement.setString("p_Impresora1", Caja.getStrNombreImpresoras1());
            statement.setString("p_Impresora2", Caja.getStrNombreImpresoras2());
            statement.setString("p_Impresora3", Caja.getStrNombreImpresoras3());
            statement.setString("p_Impresora4", Caja.getStrNombreImpresoras4());
            statement.setString("p_Obs1", Caja.getStrCaja_Obs1());
            statement.setString("p_Obs2", Caja.getStrCaja_Obs2());
            statement.setString("p_Obs3", Caja.getStrCaja_Obs3());
            statement.setString("p_Obs4", Caja.getStrCaja_Obs4());
            statement.setString("p_Estado", Caja.getStrCaja_Estado());
            statement.setString("p_Printer", Caja.getStrCaja_Printer());
            statement.setString("p_Pass", Caja.getStrCaja_Pass());
            statement.setString("p_Desc", Caja.getStrCaja_Desc());
            statement.setString("p_U_Costo", Caja.getStrCaja_U_Costo());
            statement.setString("p_TipoTicket", Caja.getStrTipoTicket());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Caja Actualizada!", "Mensaje del Sistema", 1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void modificarCajaOnline(ClsEntidadCaja Caja) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_CajaOnline(?,?)}");
            statement.setString("p_IdPcMac", Caja.getStrIdPcCaja());
            statement.setString("p_MacPc", Caja.getStrMacPcCaja());
            //   statement.setString("p_NombrePc", Caja.getStrNombrePcCaja());
//            statement.setString("p_NombreImpresoras",Caja.getStrNombreImpresoras());
//            statement.setString("p_NombreImpresoras2",Caja.getStrNombreImpresoras2());
            statement.executeUpdate();
            //JOptionPane.showMessageDialog(null, "¡Caja Actualizada!", "Mensaje del Sistema", 1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void modificarestadocaja(ClsEntidadCaja Caja) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_EstadoCaja(?)}");
            statement.setString("p_IdPc", Caja.getStrIdPcCaja());
            statement.executeUpdate();
            //JOptionPane.showMessageDialog(null, "¡Caja Actualizada!", "Mensaje del Sistema", 1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
     public void aumentar_Caja_IdVeta(int Caja) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_AumentarIdVenta(?)}");
            statement.setInt("pidcaja", Caja);
            statement.executeUpdate();
            //JOptionPane.showMessageDialog(null, "¡Caja Actualizada!", "Mensaje del Sistema", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "¡ERROR!"+ex, "Mensaje del Sistema", 1);
            System.out.println(ex);
        }
    }
     
     
     
      public void aumentar_Caja_IdCompra(int Caja) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_AumentarIdCompra(?)}");
            statement.setInt("pidcaja", Caja);
            statement.executeUpdate();
            //JOptionPane.showMessageDialog(null, "¡Caja Actualizada!", "Mensaje del Sistema", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "¡ERROR!"+ex, "Mensaje del Sistema", 1);
            System.out.println(ex);
        }
    }

    public ResultSet obtenerUltimoIdVentaCaja() throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_UltimoIdventaCaja()}");
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
}
