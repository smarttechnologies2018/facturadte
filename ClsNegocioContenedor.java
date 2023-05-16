package Negocio;

import Conexion.ClsConexionLocal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JoseRamos
 */
public class ClsNegocioContenedor {
    
    private final Connection connection = new ClsConexionLocal().getConection();
    
    public ResultSet ListarContenedoresPorGruo(String pIdGrupo) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_listarContenedoresPorGrupo(?)}");
            statement.setString("pIdGrupo", pIdGrupo);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
}
