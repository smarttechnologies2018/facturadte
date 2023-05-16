package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadBanco;
import Entidad.ClsEntidadCuentas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan H.Castro
 */
public final class ClsAgregarBanco {

    private final Connection connection = new ClsConexionLocal().getConection();

    public void agregarBancos(ClsEntidadBanco Banco) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Banco(?,?,?,?)}");
            statement.setString("pnombrebanco", Banco.getStrNombreBanco());
            statement.setString("pdireccion", Banco.getStrDireccion());
            statement.setString("ptelefono", Banco.getStrTelefono());
            statement.setString("pemail", Banco.getStrEmail());
            statement.execute();
            JOptionPane.showMessageDialog(null, "¡Banco Agregado con éxito!", "Mensaje del Sistema", 1);
           // connection.close();
        } catch (SQLException ex) {
            System.err.println("Error al insertar: " + ex);
        }
    }

    public ArrayList<ClsEntidadBanco> BuscarBanco() {
        ArrayList<ClsEntidadBanco> bancos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Bancos}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadBanco Banco = new ClsEntidadBanco();
                Banco.setStrIdBanco(resultSet.getString("IdBanco"));
                Banco.setStrNombreBanco(resultSet.getString("NombreBanco"));
                Banco.setStrDireccion(resultSet.getString("Direccion"));
                Banco.setStrTelefono(resultSet.getString("Telefono"));
                Banco.setStrEmail(resultSet.getString("Email"));
                bancos.add(Banco);
            }
            return bancos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }
    
    
    
    
    
     public ArrayList<ClsEntidadCuentas> ListarCuentaPorbanco(int idbanco) {
        ArrayList<ClsEntidadCuentas> bancos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Cuentasbancos(?)}");
            statement.setInt("pid", idbanco);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadCuentas Banco = new ClsEntidadCuentas();
                 Banco.setStrIdCuenta(resultSet.getInt("idCuentaBanco"));
                   Banco.setStrDescripcion(resultSet.getString("Cuenta_titular"));
                Banco.setStrNumeroCuenta(resultSet.getString("NumeroCuenta"));
                Banco.setDoubleSaldo(resultSet.getDouble("Saldo"));
                
               
                bancos.add(Banco);
            }
            return bancos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }
    
    
    
    
    
    
    
    
    

    public void modificaBanco(ClsEntidadBanco Banco) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Banco(?,?,?,?,?)}");
            statement.setString("pidBanco", Banco.getStrIdBanco());
            statement.setString("pnombrebanco", Banco.getStrNombreBanco());
            statement.setString("pdireccion", Banco.getStrDireccion());
            statement.setString("ptelefono", Banco.getStrTelefono());
            statement.setString("pemail", Banco.getStrEmail());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
        JOptionPane.showMessageDialog(null, "¡Producto Actualizado!", "Mensaje del Sistema", 1);
    }

    public ArrayList<ClsEntidadBanco> listarBancos() {
        ArrayList<ClsEntidadBanco> tipodocumentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call sp_s_banco_combobox}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadBanco categoria = new ClsEntidadBanco();
                categoria.setStrIdBanco(resultSet.getString("IdBanco"));
                categoria.setStrNombreBanco(resultSet.getString("NombreBanco"));
                tipodocumentos.add(categoria);
            }
            return tipodocumentos;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
}
