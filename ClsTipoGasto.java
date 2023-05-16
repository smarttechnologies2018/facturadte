
package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadTipoGasto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ramos
 */
public class ClsTipoGasto {
    private final Connection connection=new ClsConexionLocal().getConection();
    
    public ArrayList<ClsEntidadTipoGasto> listarTipoGastos(){
        ArrayList<ClsEntidadTipoGasto> gastos=new ArrayList<>();
        try{
            CallableStatement statement=connection.prepareCall("{call SP_S_TipoGastos}");
            ResultSet resultSet=statement.executeQuery();
            
            while (resultSet.next()){
                ClsEntidadTipoGasto gasto=new ClsEntidadTipoGasto();
                gasto.setStrIdTiposGastos(resultSet.getString("idtiposgastos"));
                gasto.setStrTipo(resultSet.getString("tipo"));
                gastos.add(gasto);
            }
            return gastos;
         }catch(SQLException ex){
            System.out.println(ex);
            return null;
        }
    }
    
    public void modificarTipoGastosOnline(ClsEntidadTipoGasto Gastos) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_TipoGastosOnline(?,?)}");
            statement.setString("pidtiposgasto", Gastos.getStrIdTiposGastos());
            statement.setString("ptipo", Gastos.getStrTipo());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("alv " + ex);
        }
    }
}
