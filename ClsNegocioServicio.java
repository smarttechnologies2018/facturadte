/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadServicio;
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
public class ClsNegocioServicio {

    private final Connection connection = new ClsConexionLocal().getConection();

    public void Agregar_Servicio(ClsEntidadServicio servicio) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Servicio(?,?,?)}");
            statement.setString("pNombreServicio", servicio.getStrNombreServicio());
            statement.setDouble("pPrecioServicio", servicio.getDoublePrecioServicio());
            statement.setString("pDescripcionServicio", servicio.getStrDescripcionServicio());
            statement.execute();
            JOptionPane.showMessageDialog(null, "¡presentación !", "Mensaje del Sistema", 1);
        } catch (SQLException ex) {
            System.err.println("Error al insertar: " + ex);
        }
    }

    public ArrayList<ClsEntidadServicio> ListarServicios() {
        ArrayList<ClsEntidadServicio> servicios = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call sp_s_servicios}");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ClsEntidadServicio servicio = new ClsEntidadServicio();
                servicio.setIntIdServicio(resultSet.getInt("idservicio"));
                servicio.setStrNombreServicio(resultSet.getString("NombreServicio"));
                servicio.setDoublePrecioServicio(resultSet.getDouble("PrecioServicio"));
                servicio.setStrDescripcionServicio(resultSet.getString("DescripcionServicio"));
                servicios.add(servicio);
            }
            return servicios;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
}
