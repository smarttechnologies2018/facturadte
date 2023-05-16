package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadGrupo;
import Entidad.ClsEntidadOferta;
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
public class ClsOferta {
    private final Connection connection=new ClsConexionLocal().getConection();
   
    public ArrayList<ClsEntidadOferta> listarOferta(){
        ArrayList<ClsEntidadOferta> ofertas=new ArrayList<>();
        try{
            CallableStatement statement=connection.prepareCall("{call SP_S_Oferta}");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                ClsEntidadOferta oferta=new ClsEntidadOferta();
               
                oferta.setStrIdOferta(resultSet.getInt("Oferta_IdOferta"));
                  oferta.setStrIdProducto(resultSet.getInt("Oferta_IdProducto"));
                  oferta.setStrNombreProducto(resultSet.getString("Nombre"));
                  oferta.setStrIdunidades(resultSet.getInt("Oferta_Venta"));
                  oferta.setStrHasta(resultSet.getInt("Oferta_Hasta"));
                  oferta.setStrIdProductooferta(resultSet.getString("Oferta_IdProdOferta"));
                  oferta.setStrNombreOferta(resultSet.getString("NombreOf"));
                  oferta.setStrUnidadOferta(resultSet.getInt("Oferta_Unidades"));//
                   oferta.setStrIdgrupo(resultSet.getString("Ofs.Oferta_idgrupo"));
                ofertas.add(oferta);
            }
            return ofertas;
         }catch(SQLException ex){
            System.err.println("Error : " + ex);
            return null;
        }
    }
    
    public void agregarOferta(ClsEntidadOferta Oferta) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Oferta(?,?,?,?,?,?)}");
           statement.setInt("pOferta_IdProducto", Oferta.getStrIdProducto());
            statement.setInt("pOferta_Venta", Oferta.getStrIdunidades());
             statement.setInt("pOferta_Hasta", Oferta.getStrHasta());
            statement.setString("pOferta_IdProdOferta", Oferta.getStrIdProductooferta());
            statement.setInt("pOferta_Unidades", Oferta.getStrUnidadOferta());
             statement.setString("pOferta_idgrupo", Oferta.getStrIdgrupo());
            statement.execute();
         DesktopNotify.showDesktopMessage("", "" + "Oferta Realizada", DesktopNotify.SUCCESS, 5555);
           
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            JOptionPane.showMessageDialog(null, "¡Algo salio mal!", "Mensaje del Sistema", 1);
        }
    }
    
    
    
    
    
    
    
    
    
      public void ModificarOferta(ClsEntidadOferta Oferta) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Oferta(?,?,?,?,?,?)}");
             statement.setInt("pOferta_IdOferta",Oferta.getStrIdOferta());
            statement.setInt("pOferta_IdProducto", Oferta.getStrIdProducto());
                statement.setInt("pOferta_Hasta", Oferta.getStrHasta());
            statement.setInt("pOferta_Venta", Oferta.getStrIdunidades());
            statement.setString("pOferta_IdProdOferta", Oferta.getStrIdProductooferta());
            statement.setInt("pOferta_Unidades", Oferta.getStrUnidadOferta());
           
            statement.execute();
         DesktopNotify.showDesktopMessage("", "" + "Oferta Realizada", DesktopNotify.SUCCESS, 5555);
           
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
}
