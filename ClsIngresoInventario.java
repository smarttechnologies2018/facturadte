/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadCompra;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author william
 */

public class ClsIngresoInventario {
    private Connection connection=new ClsConexionLocal().getConection();
    
    public void agregarCompra(ClsEntidadCompra Compra){
        try{
            CallableStatement statement=connection.prepareCall("{call SP_I_Compra(?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidtipodocumento",Compra.getStrIdTipoDocumento());
            statement.setInt("pidproveedor",Compra.getStrIdProveedor());
            statement.setString("pidempleado",Compra.getStrIdEmpleado());
            statement.setString("pnumero",Compra.getStrNumeroCompra());
            statement.setDate ("pfecha", new java.sql.Date(Compra.getStrFechaCompra().getTime()));
            statement.setString("psubtotal",Compra.getStrSubTotalCompra());
            statement.setString("pigv",Compra.getStrIgvCompra());
            statement.setString("ptotal",Compra.getStrTotalCompra());
            statement.setString("pestado",Compra.getStrEstadoCompra());
            statement.execute();

            JOptionPane.showMessageDialog(null,"¡Compra Realizada con éxito!","Mensaje del Sistema",1);

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
    
    
     public void abririnventario(){
        try{
            CallableStatement statement=connection.prepareCall("{call SP_U_ABRIRINVNETARIO()}");
            
            statement.execute();

            JOptionPane.showMessageDialog(null,"¡Compra Realizada con éxito!","Mensaje del Sistema",1);

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
    
     public void cerrarinventario(){
        try{
            CallableStatement statement=connection.prepareCall("{call SP_U_CERRARINVNETARIO()}");
            
            statement.execute();

            JOptionPane.showMessageDialog(null,"¡Compra Realizada con éxito!","Mensaje del Sistema",1);

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
    
    
    
    public ResultSet comprobarinvebtario() throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement statement = connection.prepareCall("{call SP_S_EstadoInventario()}");
            rs = statement.executeQuery();
            return rs;
        }catch(SQLException SQLex){
            throw SQLex;            
        }        
    } 
    
    
    
    
    
    
    
    
    
    
     public ResultSet obtenerUltimoIdCompra() throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement statement = connection.prepareCall("{call SP_S_UltimoIdCompra()}");
            rs = statement.executeQuery();
            return rs;
        }catch(SQLException SQLex){
            throw SQLex;            
        }        
    }   
    
}
