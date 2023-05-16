package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadRuta;
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
public class ClsNegocioRuta {

    private final Connection connection = new ClsConexionLocal().getConection();

    public void agregarRuta(ClsEntidadRuta Ruta) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Ruta(?,?)}");
            statement.setString("pnombre", Ruta.getStrNombreRuta());
            statement.setInt("pidempleado", Ruta.getStrIdVendedor());
            statement.execute();
            JOptionPane.showMessageDialog(null, "¡Ruta Agregado con éxito!", "Mensaje del Sistema", 1);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }
    }
    
    public void modificarRuta(ClsEntidadRuta Ruta){
        try{
            CallableStatement statement=connection.prepareCall("{call SP_U_Ruta(?,?,?)}");
            statement.setInt("pIdRuta",Ruta.getStrIdRuta()); 
            statement.setString("pNombre",Ruta.getStrNombreRuta());  
            statement.setInt("pIdv",Ruta.getStrIdVendedor());             
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null,"¡Ruta Actualizada!","Mensaje del Sistema",1);
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public ArrayList<ClsEntidadRuta> listarRutas(String busqueda){
        ArrayList<ClsEntidadRuta> rutas=new ArrayList<>();
        try{
            CallableStatement statement=connection.prepareCall("{call SP_S_Ruta(?)}");
             statement.setString("pbusqueda", busqueda);
            ResultSet resultSet=statement.executeQuery();
            
            while (resultSet.next()){
                ClsEntidadRuta ruta=new ClsEntidadRuta();
                ruta.setStrIdRuta(resultSet.getInt("idruta"));
                ruta.setStrNombreRuta(resultSet.getString("nombreRuta"));
                ruta.setStrIdVendedor(resultSet.getInt("idempleado"));
                ruta.setStrNombreVendedor(resultSet.getString("nombreVendedor"));
                  ruta.setStrNombreRepartidor(resultSet.getString("repartidor"));
                rutas.add(ruta);
            }
            return rutas;
         }catch(SQLException ex){
            System.out.println(ex);
            return null;
        }
    }
    
    public ArrayList<ClsEntidadRuta> listarRutaPorCriterio(String criterio, String busqueda) {
        ArrayList<ClsEntidadRuta> rutas = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_RutaPorParametro(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadRuta ruta = new ClsEntidadRuta();
                ruta.setStrIdRuta(resultSet.getInt("idruta"));
                ruta.setStrNombreRuta(resultSet.getString("nombreRuta"));
                ruta.setStrIdVendedor(resultSet.getInt("idempleado"));
                ruta.setStrNombreVendedor(resultSet.getString("nombreVendedor"));
                rutas.add(ruta);
            }
            return rutas;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }
    
    public void EliminarRuta(String codigo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_D_Ruta(?)}");
            statement.setString("pidRuta", codigo);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡ruta Eliminada!", "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
            Presentacion.FrmRutas.ListarRutas();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "¡Hay clientes asignados a esta ruta!", "Mensaje del Sistema", JOptionPane.WARNING_MESSAGE);
        }
    }
}
