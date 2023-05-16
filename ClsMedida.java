package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadMedida;
import ds.desktop.notify.DesktopNotify;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ramos
 */
public class ClsMedida {

    private final Connection connection = new ClsConexionLocal().getConection();
    private final String sSQL = "";

    public void agregarMedida(ClsEntidadMedida Medida) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Medida(?,?,?,?,?)}");
            statement.setString("pidproducto", Medida.getStrIdproducto());
            statement.setString("pnombre", Medida.getStrNombre());
            statement.setString("pcontenedor", Medida.getStrContenedor());
            statement.setString("punidades", Medida.getStrUnidades());
            statement.setString("pbarra", Medida.getStrBarra());
            statement.execute();
             DesktopNotify.showDesktopMessage("", " " + "PRESENTACION AGREGADA", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "¡error" + ex, "Mensaje del Sistema", 1);
        }
    }

//    public void agregarMedidalocal(ClsEntidadMedida Medida) {
//        try {
//            CallableStatement statement = connection.prepareCall("{call SP_I_Medidalocal(?,?,?,?,?,?)}");
//            statement.setString("pidmedida", Medida.getStrIdmedida());
//            statement.setString("pidproducto", Medida.getStrIdproducto());
//            statement.setString("pnombre", Medida.getStrNombre());
//            statement.setString("pcontenedor", Medida.getStrContenedor());
//            statement.setString("punidades", Medida.getStrUnidades());
//            statement.setString("pbarra", Medida.getStrBarra());
//            statement.execute();
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "¡error" + ex, "Mensaje del Sistema", 1);
//        }
//    }
    public void modificarMedidalocal(ClsEntidadMedida Medida) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Medidalocal(?,?,?,?,?,?,?)}");
            statement.setString("pidmedida", Medida.getStrIdmedida());
            statement.setString("pidproducto", Medida.getStrIdproducto());
            statement.setString("pnombre", Medida.getStrNombre());
            statement.setString("pcontenedor", Medida.getStrContenedor());
            statement.setString("punidades", Medida.getStrUnidades());
            statement.setString("pbarra", Medida.getStrBarra());
            statement.setString("pEstado", "UPDATE");
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }
    }

    public void modificarMedida(ClsEntidadMedida Medida) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Medida(?,?,?,?,?)}");
            statement.setString("pidmedida", Medida.getStrIdmedida());
            statement.setString("pcontenedor", Medida.getStrContenedor());
            statement.setString("punidades", Medida.getStrUnidades());
            statement.setString("pbarra", Medida.getStrBarra());
              statement.setString("pnombre", Medida.getStrNombre());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }
         DesktopNotify.showDesktopMessage("", " " + "PRESENTACION ACTUALIZADA", DesktopNotify.SUCCESS, 5000);;
    }

    public void modificarEstadoMedida() {
            System.out.println("modificarEstadoMedida");
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_EstadoMedida()}");
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }
    }

    public void EliminarMedida(ClsEntidadMedida Medida) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_D_Medida(?)}");
            statement.setString("pidMedida", Medida.getStrIdmedida());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Presentación Eliminada con éxito!", "Mensaje del Sistema", 1);
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public void EliminarMedidasinEstado() {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_D_MedidaSinEstado()}");
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public void EliminarMedidaSinEstatdo(ClsEntidadMedida Medida) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_D_MedidaLocal()}");

            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Presentación Eliminada con éxito!", "Mensaje del Sistema", 1);
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public int ExisteBarra(String caso, String Id) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CountBarra(?,?)}");
            statement.setString("pcriterio", caso);
            statement.setString("pbusqueda", Id);
            int codigo = 0;
            Statement st = connection.createStatement();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("Existe");
            }
            return codigo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error sql " + e);
            return 0;
        }
    }
}