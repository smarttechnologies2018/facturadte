package Negocio;

import Conexion.*;
import Entidad.*;
import ds.desktop.notify.DesktopNotify;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClsProveedor {

    private final Connection connection = new ClsConexionLocal().getConection();

    public void agregarProveedor(ClsEntidadProveedor Proveedor) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Proveedor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pnombre", Proveedor.getStrNombreProveedor());
            statement.setString("pruc", Proveedor.getStrRucProveedor());
            statement.setString("pnit", Proveedor.getStrNitProveedor());
            statement.setString("pdireccion", Proveedor.getStrDireccionProveedor());
            statement.setString("ptelefono", Proveedor.getStrTelefonoProveedor());
            statement.setString("pcelular", Proveedor.getStrCelularProveedor());
            statement.setString("pemail", Proveedor.getStrEmailProveedor());
            statement.setString("pcuenta1", Proveedor.getStrCuenta1Proveedor());
            statement.setString("pcuenta2", Proveedor.getStrCuenta2Proveedor());
            statement.setString("pestado", Proveedor.getStrEstadoProveedor());
            statement.setString("pobsv", Proveedor.getStrObsvProveedor());
            statement.setString("pnbanco1", Proveedor.getStrBanco1Proveedor());
            statement.setString("pnbanco2", Proveedor.getStrBanco2Proveedor());
            statement.setString("pcategoria", Proveedor.getStrCategoriaProveedor());
            statement.setString("pgiro", Proveedor.getStrGiroProveedor());
            statement.setString("pdepartamento", Proveedor.getStrDepartamento());
            statement.setString("pmunicipio", Proveedor.getStrMunicipio());
            statement.setString("ppais", Proveedor.getStrPaisCliente());
            statement.setDouble("plimite", Proveedor.getStrLimite());
            statement.setString("pasignar", Proveedor.getStrAsignar());
            statement.execute();
            DesktopNotify.showDesktopMessage("", "" + "PROVEDOR AGREGADO", DesktopNotify.SUCCESS, 1111);
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public ResultSet listar_Proveedor_datos(long id) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Proveedor_datos(?)}");
            statement.setLong("pidproveedor", id);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public void modificarProveedor(String codigo, ClsEntidadProveedor Proveedor) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Proveedor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidproveedor", codigo);
            statement.setString("pnombre", Proveedor.getStrNombreProveedor());
            statement.setString("pruc", Proveedor.getStrRucProveedor());
            statement.setString("pnit", Proveedor.getStrNitProveedor());
            statement.setString("pdepartamento", Proveedor.getStrDepartamento());
            statement.setString("pmunicipio", Proveedor.getStrMunicipio());
            statement.setString("ppais", Proveedor.getStrPaisCliente());
            statement.setString("pdireccion", Proveedor.getStrDireccionProveedor());
            statement.setDouble("plimite", Proveedor.getStrLimite());
            statement.setString("ptelefono", Proveedor.getStrTelefonoProveedor());
            statement.setString("pcelular", Proveedor.getStrCelularProveedor());
            statement.setString("pemail", Proveedor.getStrEmailProveedor());
            statement.setString("pcuenta1", Proveedor.getStrCuenta1Proveedor());
            statement.setString("pcuenta2", Proveedor.getStrCuenta2Proveedor());
            statement.setString("pestado", Proveedor.getStrEstadoProveedor());
            statement.setString("pobsv", Proveedor.getStrObsvProveedor());
            statement.setString("pnbanco1", Proveedor.getStrBanco1Proveedor());
            statement.setString("pnbanco2", Proveedor.getStrBanco2Proveedor());
            statement.setString("pcategoria", Proveedor.getStrCategoriaProveedor());
            statement.setString("pgiro", Proveedor.getStrGiroProveedor());
            statement.setString("pasignar", Proveedor.getStrAsignar());
            statement.executeUpdate();
            DesktopNotify.showDesktopMessage("", "" + "PROVEDOR ACTUALIZADO20", DesktopNotify.SUCCESS, 1111);
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);

        }

    }

    public void modificarProveedorlocal(ClsEntidadProveedor Proveedor) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_ProveedorLocal(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidproveedor", Proveedor.getStrIdProveedor());
            statement.setString("pnombre", Proveedor.getStrNombreProveedor());
            statement.setString("pruc", Proveedor.getStrRucProveedor());

            statement.setString("pdireccion", Proveedor.getStrDireccionProveedor());
            statement.setString("ptelefono", Proveedor.getStrTelefonoProveedor());
            statement.setString("pcelular", Proveedor.getStrCelularProveedor());
            statement.setString("pemail", Proveedor.getStrEmailProveedor());
            statement.setString("pcuenta1", Proveedor.getStrCuenta1Proveedor());
            statement.setString("pcuenta2", Proveedor.getStrCuenta2Proveedor());
            statement.setString("pestado", Proveedor.getStrEstadoProveedor());
            statement.setString("pobsv", Proveedor.getStrObsvProveedor());
            statement.setString("pnbanco1", Proveedor.getStrBanco1Proveedor());
            statement.setString("pnbanco2", Proveedor.getStrBanco2Proveedor());
            statement.setString("pcategoria", Proveedor.getStrCategoriaProveedor());
            statement.setString("pnit", Proveedor.getStrNitProveedor());
            statement.setString("pgiro", Proveedor.getStrGiroProveedor());
            statement.execute();
            //DesktopNotify.showDesktopMessage("",""+"PROVEDOR ACTUALIZADO00000", DesktopNotify.SUCCESS, 1111);
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public ArrayList<ClsEntidadProveedor> listarProveedor() {
        ArrayList<ClsEntidadProveedor> proveedores = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Proveedor()}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadProveedor proveedor = new ClsEntidadProveedor();
                proveedor.setStrIdProveedor(resultSet.getString("IdProveedor"));
                proveedor.setStrNombreProveedor(resultSet.getString("nombre"));
                proveedor.setStrRucProveedor(resultSet.getString("ruc"));
                proveedor.setStrDniProveedor(resultSet.getString("dni"));
                proveedor.setStrDireccionProveedor(resultSet.getString("direccion"));
                proveedor.setStrTelefonoProveedor(resultSet.getString("telefono"));
                proveedor.setStrCelularProveedor(resultSet.getString("celular"));
                proveedor.setStrEmailProveedor(resultSet.getString("email"));
                proveedor.setStrCuenta1Proveedor(resultSet.getString("cuenta1"));
                proveedor.setStrCuenta2Proveedor(resultSet.getString("cuenta2"));
                proveedor.setStrEstadoProveedor(resultSet.getString("estado"));
                proveedor.setStrObsvProveedor(resultSet.getString("obsv"));
                proveedor.setStrBanco1Proveedor(resultSet.getString("nbanco1"));
                proveedor.setStrBanco2Proveedor(resultSet.getString("nbanco2"));
                proveedor.setStrCategoriaProveedor(resultSet.getString("categoria"));
                proveedor.setStrNitProveedor(resultSet.getString("nit"));
                proveedor.setStrGiroProveedor(resultSet.getString("giro"));
                proveedores.add(proveedor);
            }
            return proveedores;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ResultSet listar_proveedor_datos(int id) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Proveedor_datos(?)}");
            statement.setInt("pidproveedor", id);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

//    public void agregarProveedorlocal(ClsEntidadProveedor Proveedor) {
//        try {
//            CallableStatement statement = connection.prepareCall("{call SP_I_Proveedorlocal(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
//            statement.setString("pIdproveedor", Proveedor.getStrIdProveedor());
//            statement.setString("pnombre", Proveedor.getStrNombreProveedor());
//            statement.setString("pruc", Proveedor.getStrRucProveedor());
//            
//            statement.setString("pdireccion", Proveedor.getStrDireccionProveedor());
//            statement.setString("ptelefono", Proveedor.getStrTelefonoProveedor());
//            statement.setString("pcelular", Proveedor.getStrCelularProveedor());
//            statement.setString("pemail", Proveedor.getStrEmailProveedor());
//            statement.setString("pcuenta1", Proveedor.getStrCuenta1Proveedor());
//            statement.setString("pcuenta2", Proveedor.getStrCuenta2Proveedor());
//            statement.setString("pestado", Proveedor.getStrEstadoProveedor());
//            statement.setString("pobsv", Proveedor.getStrObsvProveedor());
//            statement.setString("pnbanco1", Proveedor.getStrBanco1Proveedor());
//            statement.setString("pnbanco2", Proveedor.getStrBanco2Proveedor());
//            statement.setString("pcategoria", Proveedor.getStrCategoriaProveedor());
//            statement.setString("pnit", Proveedor.getStrNitProveedor());
//            statement.setString("pgiro", Proveedor.getStrGiroProveedor());
//            statement.execute();
//         
//
//        } catch (SQLException ex) {
//            System.err.println("Error : " + ex);
//        }
//    }
    public ResultSet listarProveedorPorParametro(String criterio, String busqueda) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ProveedorPorParametro(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
}
