package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadGrupo;
import ds.desktop.notify.DesktopNotify;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ramos
 */
public class ClsGrupo {
    private final Connection connection=new ClsConexionLocal().getConection();
   
    public ArrayList<ClsEntidadGrupo> listarGrupo(){
        ArrayList<ClsEntidadGrupo> grupos=new ArrayList<>();
        try{
            CallableStatement statement=connection.prepareCall("{call SP_S_GrupoPorParametro}");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                ClsEntidadGrupo grupo=new ClsEntidadGrupo();
                grupo.setStrIdGrupo(resultSet.getString("idgrupo"));
                grupo.setStrNombre(resultSet.getString("nombreg"));
                  grupo.setStrCantidad(resultSet.getString("producto_ultima_med"));
                grupos.add(grupo);
            }
            return grupos;
         }catch(SQLException ex){
            System.err.println("Error : " + ex);
            return null;
        }
    }
    
    public void agregarDescuento(ClsEntidadGrupo Grupo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Grupo(?)}");
            statement.setString("pNombreGrupo", Grupo.getStrNombre());
            statement.execute();
            JOptionPane.showMessageDialog(null, "¡Grupo Creado con éxito!", "Mensaje del Sistema", 1);
            Presentacion.FrmProducto.actualizarTablaDescuentos();
             DesktopNotify.showDesktopMessage("", "" + "GRUPO AGREGADO ", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            JOptionPane.showMessageDialog(null, "¡Algo salio mal!", "Mensaje del Sistema", 1);
        }
    }
    
    
//    public void agregargrupolocal(ClsEntidadGrupo Grupo) {
//        try {
//            CallableStatement statement = connection.prepareCall("{call SP_I_GrupoLocal(?,?)}");
//           statement.setString("pidgrupo", Grupo.getStrIdGrupo());
//            statement.setString("pNombreGrupo", Grupo.getStrNombre());
//            statement.execute();
//          
//           
//        } catch (SQLException ex) {
//            System.err.println("Error : " + ex);
//           
//        }
//    }
    public void updategrupolocal(ClsEntidadGrupo Grupo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_GrupoLocal(?,?)}");
            statement.setString("pidgrupo", Grupo.getStrIdGrupo());
            statement.setString("pNombreGrupo", Grupo.getStrNombre());
            statement.execute();
       
           
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
           
        }
    }
     public void updategrupos(ClsEntidadGrupo Grupo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Grupos(?,?)}");
            statement.setString("pIdGrupo", Grupo.getStrIdGrupo());
            statement.setString("pNombreGrupo", Grupo.getStrNombre());
            statement.execute();
        DesktopNotify.showDesktopMessage("", "" + "GRUPO ACTUALIZADO ", DesktopNotify.SUCCESS, 5000);
           
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
           
        }
    }
    
    
    
    public ArrayList<ClsEntidadGrupo> listarGrupos() {
        ArrayList<ClsEntidadGrupo> grupos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Grupos}");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ClsEntidadGrupo grupo = new ClsEntidadGrupo();
                grupo.setStrIdGrupo(resultSet.getString("IdGrupo"));
                grupo.setStrNombre(resultSet.getString("NombreGrupo"));
                grupo.setStrCantidad(resultSet.getString("prodCount"));

                grupos.add(grupo);
            }
            return grupos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }
    
    public ArrayList<ClsEntidadGrupo> listarGrupoPorParametro(String busqueda) {
        ArrayList<ClsEntidadGrupo> categorias = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_listarGrupoPorParametro(?)}");
            statement.setString("pbusqueda", busqueda);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadGrupo grupo = new ClsEntidadGrupo();
                grupo.setStrIdGrupo(resultSet.getString("idgrupo"));
                grupo.setStrNombre(resultSet.getString("nombreg"));
                 grupo.setStrCantidad(resultSet.getString("producto_ultima_med"));
                categorias.add(grupo);
            }
            return categorias;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }
    
    public int ContarProductosEnUnGrupo(String IdGrupo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ContarProductosEnUnGrupo(?)}");
            statement.setString("pIdGrupo", IdGrupo);
            int codigo = 0;
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("Productos");
            }
            return codigo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error sql " + e);
            return 0;
        }
    }  
    
    
    public void borrargrupo(int idgrupo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_D_Grupo(?)}");
           
            statement.setInt("pgrupo",idgrupo);
            statement.executeUpdate();
              DesktopNotify.showDesktopMessage("", "" + "GRUPO ELIMINADO ", DesktopNotify.SUCCESS, 5000);
            //  connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null,ex);
        }
        
    }
}
