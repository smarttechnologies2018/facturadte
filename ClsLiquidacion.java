/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadLiquidacion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class ClsLiquidacion {
     private Connection connection=new ClsConexionLocal().getConection();
     public ResultSet MostrarLiquidacion() throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement statement = connection.prepareCall("{call SP_S_VerLiquidacion()}");
            rs = statement.executeQuery();
            return rs;
        }catch(SQLException SQLex){
            throw SQLex;            
        }
          } 
     
     
      public ResultSet MostrarLiquidacionfecha(Date fecha1) throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement statement = connection.prepareCall("{call SP_S_VerLiquidacionfecha(?)}");
             statement.setDate("pfecha", new java.sql.Date(fecha1.getTime()));//3
            rs = statement.executeQuery();
            return rs;
        }catch(SQLException SQLex){
            throw SQLex;            
        }
          } 
      
      
       public ResultSet MostrarCortes(Date fecha1, int sucursal) throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement statement = connection.prepareCall("{call SP_S_VerLiquidacionfechadoc(?,?)}");
             statement.setDate("pfecha", new java.sql.Date(fecha1.getTime()));//3
            statement.setInt("psala", sucursal);
            rs = statement.executeQuery();
            return rs;
        }catch(SQLException SQLex){
            throw SQLex;            
        }
          } 
     
     
     
      public ResultSet VerDocPorCliente(int liquidacion,String cliente) throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement statement = connection.prepareCall("{call SP_S_VerDocPorCliente(?,?)}");
               statement.setInt("pidliquidacion", liquidacion);
                  statement.setString("Pidcliente", cliente);
            rs = statement.executeQuery();
            return rs;
        }catch(SQLException SQLex){
            throw SQLex;            
        }
          } 
     
     
     
     
     
     
     
     
     
     
     
     
     public ResultSet MostrarLiquidacionCerrada() throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement statement = connection.prepareCall("{call SP_S_VerLiquidacionCerrada()}");
            rs = statement.executeQuery();
            return rs;
        }catch(SQLException SQLex){
            throw SQLex;            
        }
          }  
     
     
     
     
     
      public void cerrarliquidacion(ClsEntidadLiquidacion Costo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_CerrarLiquidacion(?)}");
            statement.setString("pcriterio", Costo.getStrIdLiquidacion());
           
            statement.executeUpdate();
              JOptionPane.showMessageDialog(null, "¡Liquidacion Cerrada!", "Mensaje del Sistema", 1);
          
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }
        public void abrirliquidacion(ClsEntidadLiquidacion Costo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_AbrirLiquidacion(?)}");
            statement.setString("pcriterio", Costo.getStrIdLiquidacion());
           
            statement.executeUpdate();
              JOptionPane.showMessageDialog(null, "¡Liquidacion Abierta!", "Mensaje del Sistema", 1);
          
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }
     
     
     
}
