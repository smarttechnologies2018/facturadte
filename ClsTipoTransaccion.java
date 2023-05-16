/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadTIpoTransaccion;
import Entidad.ClsEntidadTipoDocumento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author william
 */
public class ClsTipoTransaccion {
    private final Connection connection = new ClsConexionLocal().getConection();
    
   public ArrayList<ClsEntidadTIpoTransaccion> listarTipotransaccionPositivo() {
        ArrayList<ClsEntidadTIpoTransaccion> tipodocumentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_TipoTransaccionpositivo}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadTIpoTransaccion categoria = new ClsEntidadTIpoTransaccion();
                categoria.setStrIdTipoTransa(resultSet.getString("Idtransaccion"));
                categoria.setStrDescripcionstrIdTipoTransa(resultSet.getString("Transaccion"));
                tipodocumentos.add(categoria);
            }
            return tipodocumentos;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
      public ArrayList<ClsEntidadTIpoTransaccion> listarTipotransaccionNegativo() {
        ArrayList<ClsEntidadTIpoTransaccion> tipodocumentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_TipoTransaccionnegativo}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadTIpoTransaccion categoria = new ClsEntidadTIpoTransaccion();
                categoria.setStrIdTipoTransa(resultSet.getString("Idtransaccion"));
                categoria.setStrDescripcionstrIdTipoTransa(resultSet.getString("Transaccion"));
                tipodocumentos.add(categoria);
            }
            return tipodocumentos;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
}
