package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadCaja;
import Entidad.ClsEntidadCorte;
import ds.desktop.notify.DesktopNotify;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JoseRamos
 */
public class ClsNegocioCorte {
    
    private final Connection connection=new ClsConexionLocal().getConection();
    
    public ArrayList<ClsEntidadCorte> listarCorte(int pIdCaja, int pCorte){
        ArrayList<ClsEntidadCorte> cortes=new ArrayList<>();
        try{
            CallableStatement statement=connection.prepareCall("{call SP_S_CorteX(?,?)}");
            statement.setInt("pIdCaja", pIdCaja);
            statement.setInt("pCorte", pCorte);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                ClsEntidadCorte corte=new ClsEntidadCorte();
                corte.setIntIdCategoria(resultSet.getInt("IdCategoria"));
                corte.setStrDescripcion(resultSet.getString("Descripcion"));
                corte.setIntunidades(resultSet.getInt("unidades"));
                corte.setDoubleTotal(resultSet.getDouble("Total"));
                cortes.add(corte);
            }
            return cortes;
         }catch(SQLException ex){
             System.err.println(ex);
            return null;
        }
    }  
    public ArrayList<ClsEntidadCorte> listarCorteZ(int pIdCaja, int pCorte){
        ArrayList<ClsEntidadCorte> cortes=new ArrayList<>();
        try{
            CallableStatement statement=connection.prepareCall("{call SP_S_CorteZ(?,?)}");
            statement.setInt("pIdCaja", pIdCaja);
            statement.setInt("pCorte", pCorte);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                ClsEntidadCorte corte=new ClsEntidadCorte();
                corte.setIntIdCategoria(resultSet.getInt("IdCategoria"));
                corte.setStrDescripcion(resultSet.getString("Descripcion"));
                corte.setIntunidades(resultSet.getInt("unidades"));
                corte.setDoubleTotal(resultSet.getDouble("Total"));
                cortes.add(corte);
            }
            return cortes;
         }catch(SQLException ex){
             System.err.println(ex);
            return null;
        }
    } 
    
    
    
    public void SumarCorte( ClsEntidadCaja caja ){
       
        try{
            CallableStatement statement=connection.prepareCall("{call SP_U_CorteX(?)}");
       
             statement.setString("pIdPc", caja.getStrIdPcCaja());
           
            statement.executeUpdate();
       } catch (SQLException ex) {
            System.err.println(ex);
        }
        DesktopNotify.showDesktopMessage("", "" + "CORTE X ACTUALIZADO", DesktopNotify.SUCCESS, 5555);
    }
    
    
      public void SumarCorteZ( ClsEntidadCaja caja ){
       
        try{
            CallableStatement statement=connection.prepareCall("{call SP_U_CorteZ(?)}");
       
             statement.setString("pIdPc", caja.getStrIdPcCaja());
           
            statement.executeUpdate();
       } catch (SQLException ex) {
            System.err.println(ex);
        }
        
    }
    
    
    

    
    
    
    
    
    
    
    public ArrayList<ClsEntidadCorte> listarDocumentos(int pIdCaja, int pCorte){
        ArrayList<ClsEntidadCorte> cortes=new ArrayList<>();
        try{
            CallableStatement statement=connection.prepareCall("{call SP_S_CountTypeDocuments(?,?)}");
            statement.setInt("pIdCaja", pIdCaja);
            statement.setInt("pCorte", pCorte);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                ClsEntidadCorte corte=new ClsEntidadCorte();
                corte.setStrDescripcionDocumento(resultSet.getString("Descripcion"));
                corte.setIntCantidadDocumento(resultSet.getInt("cantidad"));
                corte.setStrDesdeDocumento(resultSet.getString("desde"));
                corte.setStrHastaDocumento(resultSet.getString("Hasta"));
                corte.setStrTotalVentaDocumento(resultSet.getString("Total"));
                cortes.add(corte);
            }
            return cortes;
         }catch(SQLException ex){
             System.err.println(ex);
            return null;
        }
    }  
    
    
    
    
     public ArrayList<ClsEntidadCorte> listarDocumentosZ(int pIdCaja, int pCorte){
        ArrayList<ClsEntidadCorte> cortes=new ArrayList<>();
        try{
            CallableStatement statement=connection.prepareCall("{call SP_S_CountTypeDocumentsZ(?,?)}");
            statement.setInt("pIdCaja", pIdCaja);
            statement.setInt("pCorte", pCorte);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                ClsEntidadCorte corte=new ClsEntidadCorte();
                corte.setStrDescripcionDocumento(resultSet.getString("Descripcion"));
                corte.setIntCantidadDocumento(resultSet.getInt("cantidad"));
                corte.setStrDesdeDocumento(resultSet.getString("desde"));
                corte.setStrHastaDocumento(resultSet.getString("Hasta"));
                corte.setStrTotalVentaDocumento(resultSet.getString("Total"));
                cortes.add(corte);
            }
            return cortes;
         }catch(SQLException ex){
             System.err.println(ex);
            return null;
        }
    } 

    public void SumarCorte(String StrIdPcCaja, ClsEntidadCaja corte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
