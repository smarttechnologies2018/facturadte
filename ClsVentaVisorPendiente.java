package Negocio;

import Conexion.ClsConexionLocal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author William
 */
public final class ClsVentaVisorPendiente {

    private final Connection connection = new ClsConexionLocal().getConection();

    public ResultSet MostrarVisor(String criterio, Date fechaini, Date fechafin, String doc) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CompraVentaVisorDocumentoPendiente2(?,?,?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setDate("pfechaini", new java.sql.Date(fechaini.getTime()));
            statement.setDate("pfechafin", new java.sql.Date(fechafin.getTime()));
            statement.setString("pruta", doc);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet MostrarVisorSinCB(String criterio, Date fechaini, Date fechafin) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_VisorSinCBPendiente(?,?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setDate("pfechaini", new java.sql.Date(fechaini.getTime()));
            statement.setDate("pfechafin", new java.sql.Date(fechafin.getTime()));
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
}