package Negocio;

import Conexion.ClsConexionLocal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author JoseRamos
 */
public class ClsNegocioKardexProducto {

    private final Connection connection = new ClsConexionLocal().getConection();

    public ResultSet listarKardexProducto(int id,Date fecha_ini, Date fecha_fin) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call kardexProducto(?,?,?)}");
            statement.setInt("pIdProducto", id);
             statement.setDate("pfecha_ini", new java.sql.Date(fecha_ini.getTime()));
            statement.setDate("pfecha_fin", new java.sql.Date(fecha_fin.getTime()));
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
              System.out.println(SQLex);
            throw SQLex;
        }
    }
    
    
    public ResultSet listarKardexProductodo(int id,Date fecha_ini, Date fecha_fin, int idempresa) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call kardexProducto(?,?,?,?)}");
            statement.setInt("pIdProducto", id);
             statement.setInt("pidempresa", idempresa);
             statement.setDate("pfecha_ini", new java.sql.Date(fecha_ini.getTime()));
            statement.setDate("pfecha_fin", new java.sql.Date(fecha_fin.getTime()));
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            
            System.out.println(SQLex);
            throw SQLex;
        }
    }
    public ResultSet listarKardexProductoProveedor(int id, Date fecha_ini, Date fecha_fin) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call kardexProdutoProveedor(?,?,?)}");
            statement.setInt("pIdProveedor", id);
            statement.setDate("pfecha_ini", new java.sql.Date(fecha_ini.getTime()));
            statement.setDate("pfecha_fin", new java.sql.Date(fecha_fin.getTime()));
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
}
