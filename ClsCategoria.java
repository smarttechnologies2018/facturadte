package Negocio;

import Conexion.*;

import Entidad.*;
import ds.desktop.notify.DesktopNotify;
import java.awt.TrayIcon;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.contentobjects.jnotify.JNotify;


public class ClsCategoria {

    private final Connection connection = new ClsConexionLocal().getConection();

    public void agregarCategoria(ClsEntidadCategoria Categoria) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Categoria(?)}");
            statement.setString("pdescripcion", Categoria.getStrDescripcionCategoria());
            statement.execute();
            JOptionPane.showMessageDialog(null, "¡Categoría Agregada con éxito!", "Mensaje del Sistema", 1);
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    
    
    
    
    
    
//    public void agregarCategorialocal(ClsEntidadCategoria Categoria) {
//        try {
//            CallableStatement statement = connection.prepareCall("{call SP_I_Categorialocal(?,?,?)}");
//           statement.setString("pidcategoria", Categoria.getStrIdCategoria());
//            statement.setString("pdescripcion", Categoria.getStrDescripcionCategoria());
//            statement.setString("pultimo", Categoria.getStrUltimoIdCategoria());
//            statement.execute();
//             
//           
//            
//        } catch (SQLException ex) {
//            System.err.println(ex);
//        }
//         
//    }
    
    
    
    
    
    
    
    public void modificarCategoria(String codigo, ClsEntidadCategoria Categoria) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Categoria(?,?)}");
            statement.setString("pidcategoria", codigo);
            statement.setString("pdescripcion", Categoria.getStrDescripcionCategoria());
            statement.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        JOptionPane.showMessageDialog(null, "¡Categoría Actualizada!", "Mensaje del Sistema", 1);
    }
    
    
    
    
    public void modificarCategorialocal(ClsEntidadCategoria Categoria) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Categorialocal(?,?,?)}");
            statement.setString("pidcategoria", Categoria.getStrIdCategoria());
            statement.setString("pdescripcion", Categoria.getStrDescripcionCategoria());
            statement.setString("pultimo", Categoria.getStrUltimoIdCategoria());
            statement.execute();
         
        
        
        

        } catch (SQLException ex) {
            System.err.println(ex);
        }
       
    }

    public ArrayList<ClsEntidadCategoria> listarCategoria() {
        ArrayList<ClsEntidadCategoria> categorias = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Categoria}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadCategoria categoria = new ClsEntidadCategoria();
                categoria.setStrIdCategoria(resultSet.getString("IdCategoria"));
                categoria.setStrDescripcionCategoria(resultSet.getString("Descripcion"));
                categorias.add(categoria);
            }
            return categorias;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadCategoria> listarCategoriasPorParametro(String criterio, String busqueda) {
        ArrayList<ClsEntidadCategoria> categorias = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CategoriaPorParametro(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadCategoria categoria = new ClsEntidadCategoria();
                categoria.setStrIdCategoria(resultSet.getString("IdCategoria"));
                categoria.setStrDescripcionCategoria(resultSet.getString("Descripcion"));
                categoria.setStrUltimoIdCategoria( resultSet.getString("UltimaIdCategoria"));
               
           
                
                categorias.add(categoria);
            }
            return categorias;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }

    public ResultSet listarCategoriaPorParametro(String criterio, String busqueda) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CategoriaPorParametro(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
    
     public ResultSet ListarProductoPorGrupo(String criterio  ) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ProductosAsociados(?)}");
            statement.setString("pcriterio", criterio);
            
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ArrayList<ClsEntidadCategoria> listarCategorias() {
        ArrayList<ClsEntidadCategoria> categorias = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Categoria}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadCategoria categoria = new ClsEntidadCategoria();
                categoria.setStrIdCategoria(resultSet.getString("IdCategoria"));
                categoria.setStrDescripcionCategoria(resultSet.getString("Descripcion"));
                categoria.setStrUltimoIdCategoria( resultSet.getString("IdCategoria")  + resultSet.getString("UltimaIdCategoria"));
                ///////
                String s = resultSet.getString("UltimaIdCategoria");
                int ss = Integer.parseInt(s);
                final int i = ss + 1;
                final DecimalFormat decimalFormat = new DecimalFormat("0000");
                //////
                categoria.setStrSiguienteCodigo( resultSet.getString("IdCategoria")  + decimalFormat.format(i));
                ///////
                String s1 = resultSet.getString("UltimaIdCategoria");
                int ss1 = Integer.parseInt(s1);
                final int ii = ss + 1;
                final DecimalFormat decimalFormat1 = new DecimalFormat("0000");
                //////
                categoria.setStrSoloCodigo(decimalFormat1.format(i));
                categorias.add(categoria);
            }
            return categorias;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }

    public void modificarUltimoCodigo(ClsEntidadCategoria Categoria) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_UltimoCodCategoria(?)}");
            statement.setString("pidcategoria", Categoria.getStrIdCategoria());
            
            statement.executeUpdate();
            DesktopNotify.showDesktopMessage("", "" + "CODIGOS ACTUALIZADOS", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Mensaje del Sistema", 1);
        }
    }
}
