/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadChequera;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author servidor
 */
public class ClsChequera {

    private final Connection connection = new ClsConexionLocal().getConection();

    public ResultSet Chequera(String id) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Chequera(?)}");
            statement.setString("id", id);
            rs = statement.executeQuery();
            return rs;

        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public void agregarChequera(ClsEntidadChequera Chequera) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Chequera(?,?)}");
            statement.setString("pnombreCheque", Chequera.getStrNumerochquera());
            statement.setString("idcuenta", Chequera.getStrIDcuentaChequera());
            statement.execute();
            JOptionPane.showMessageDialog(null, "¡Cheque Agregado con éxito!", "Mensaje del Sistema", 1);
            connection.close();
        } catch (SQLException ex) {
            System.err.println("Error al insertar: " + ex);
        }
    }

    public void modificaBanco(ClsEntidadChequera Chequera) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Chequera(?,?)}");
            statement.setInt("pidChequera", Chequera.getStrIdChequera());
            statement.setString("pNumeroChequera", Chequera.getStrNumerochquera());
            statement.executeUpdate();
            //FrmProducto.cargarGrupos();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
        JOptionPane.showMessageDialog(null, "¡Chequera Actualizado!", "Mensaje del Sistema", 1);
    }
    
    public ArrayList<ClsEntidadChequera> listarCuentaPorChequera(){
        ArrayList<ClsEntidadChequera> cheques=new ArrayList<>();
        try{
            CallableStatement statement=connection.prepareCall("{call SP_S_Cuenta_Por_Chequera}");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                ClsEntidadChequera cheque=new ClsEntidadChequera();
                cheque.setStrIDcuentaChequera(resultSet.getString("idChequera"));
                cheque.setStrNombreBanco(resultSet.getString("NombreBanco"));
                cheque.setStrNumeroCuenta(resultSet.getString("NumeroCuenta"));
                cheques.add(cheque);
            }
            return cheques;
         }catch(SQLException ex){
            System.err.println("Error : " + ex);
            return null;
        }
    }
}
