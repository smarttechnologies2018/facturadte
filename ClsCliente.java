package Negocio;

import Conexion.*;
import Entidad.*;
import ds.desktop.notify.DesktopNotify;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ClsCliente {

     static Connection connection = new ClsConexionLocal().getConection();
     static  PreparedStatement statement;

    public void agregarCliente(ClsEntidadCliente Cliente) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Cliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pIdCliente", Cliente.getStrCorrelativo());
            statement.setString("pnombre", Cliente.getStrNombreCliente());
            statement.setString("pruc", Cliente.getStrRucCliente());
            statement.setString("pdni", Cliente.getStrDniCliente());
            statement.setString("pdireccion", Cliente.getStrDireccionCliente());
            statement.setString("ptelefono", Cliente.getStrTelefonoCliente());
            statement.setString("pobsv", Cliente.getStrObsvCliente());
            statement.setString("pnit", Cliente.getStrNitCliente());
            statement.setString("pcat", Cliente.getStrCategoriaCliente());
            statement.setString("pcontribuyente", Cliente.getStrContribuyenteCliente());
            statement.setString("pdepartamento", Cliente.getStrDepartamento());
            statement.setString("pmunicipio", Cliente.getStrMunicipio());
            if (Cliente.getStrIdRuta() == 0) {
                statement.setNull("pIdRuta", Cliente.getStrIdRuta());
            } else {
                statement.setInt("pIdRuta", Cliente.getStrIdRuta());
            }
            statement.setInt("pIdCaja", Cliente.getIntIdCaja());
            statement.setString("pCorrelativo", Cliente.getStrCorrelativo());
            statement.setString("pgiro", Cliente.getStrgiro());
            statement.setString("pEstadoCliente", Cliente.getStrEstadoCliente());
            statement.setString("pTipoVentaCliente", Cliente.getStrTipoVenta());
            statement.setString("pSaldoLimite", Cliente.getStrSaldoLimite());
            statement.setString("ppais", Cliente.getStrPaisCliente());
            statement.setString("pdireccion2", Cliente.getStrDirecion2());
            statement.setInt("pidempresa", Cliente.getStrCliente_IdEmpresa());
            statement.setLong("ptitular", Cliente.getStrLbtitular());
              statement.setString("pemali", Cliente.getStrEmail1());
            statement.execute();
            //JOptionPane.showMessageDialog(null, "¡Cliente Agregado con éxito!", "Mensaje del Sistema", 1);
            DesktopNotify.showDesktopMessage("Mensaje del Sistema", "¡Cliente Agregado con éxito!", DesktopNotify.SUCCESS, 4000);
        } catch (SQLException ex) {
            DesktopNotify.showDesktopMessage("Mensaje del Sistema", "" + ex, DesktopNotify.ERROR, 14000);
            System.out.println(ex.getMessage());
        }
    }

    public void modificarCliente(String codigo, ClsEntidadCliente Cliente) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Cliente_Venta(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidcliente2", codigo);
            statement.setString("pnombre", Cliente.getStrNombreCliente());
            statement.setString("pruc", Cliente.getStrRucCliente());
            statement.setString("pdni", Cliente.getStrDniCliente());
            statement.setString("pdireccion", Cliente.getStrDireccionCliente());
            statement.setString("ptelefono", Cliente.getStrTelefonoCliente());
            statement.setString("pobsv", Cliente.getStrObsvCliente());
            statement.setString("pnit", Cliente.getStrNitCliente());
            statement.setString("pcat", Cliente.getStrCategoriaCliente());
            statement.setString("pdepartamento", Cliente.getStrDepartamento());
            statement.setString("pmunicipio", Cliente.getStrMunicipio());
            statement.setString("ppais", Cliente.getStrPaisCliente());
            statement.setString("pcontribuyente", Cliente.getStrContribuyenteCliente());
            statement.setInt("pIdRuta", Cliente.getStrIdRuta());
            statement.setString("pgiro", Cliente.getStrgiro());
            statement.setString("pEstadoCliente", Cliente.getStrEstadoCliente());
            statement.setString("pTipoVentaCliente", Cliente.getStrTipoVenta());
            statement.setString("pSaldoLimite", Cliente.getStrSaldoLimite());

            statement.setString("pdireccion2", Cliente.getStrDirecion2());
            statement.setLong("ptitular", Cliente.getStrLbtitular());
             statement.setString("pemali", Cliente.getStrEmail1());
            statement.executeUpdate();
            System.out.println("ACTUALIZADO" + codigo + Cliente.getStrEstadoCliente());

            DesktopNotify.showDesktopMessage("Mensaje del Sistema", "CLIENTE ACTUALIZADO", DesktopNotify.SUCCESS, 8000);

        } catch (SQLException ex) {
            DesktopNotify.showDesktopMessage("Mensaje del Sistema", "¡ERROR!" + ex, DesktopNotify.ERROR, 8000);
            System.out.println(ex);
            //DesktopNotify.showDesktopMessage("Mensaje del Sistema", ""+ex, DesktopNotify.ERROR, 14000);
        }
    }

    public void modificarClienteOnline(ClsEntidadCliente Cliente) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Cliente_VentaOnline(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pIdCliente", Cliente.getStrIdCliente());//1
            statement.setString("pnombre", Cliente.getStrNombreCliente());//2
            statement.setString("pruc", Cliente.getStrRucCliente());//3
            statement.setString("pdni", Cliente.getStrDniCliente());//4
            statement.setString("pdireccion", Cliente.getStrDireccionCliente());//5
            statement.setString("ptelefono", Cliente.getStrTelefonoCliente());//6
            statement.setString("pobsv", Cliente.getStrObsvCliente());//7
            statement.setString("pnit", Cliente.getStrNitCliente());//8
            statement.setString("pcat", Cliente.getStrCategoriaCliente());//9            
            statement.setString("pcontribuyente", Cliente.getStrContribuyenteCliente());//10
            statement.setInt("pIdRuta", Cliente.getStrIdRuta());//11
            statement.setString("pgiro", Cliente.getStrgiro());//12
            statement.setString("pidcorrelativo", Cliente.getStrCorrelativo());//13
            statement.setString("pEstadoCliente", Cliente.getStrEstadoCliente());//14
            statement.setDate("pFecha", new java.sql.Date(Cliente.getStrUpdate().getTime()));//15
         
            statement.setString("ppais", Cliente.getStrPaisCliente());//16
            statement.setString("pdireccion2", Cliente.getStrDirecion2());//17          
            statement.setString("pdepartamento", Cliente.getStrDepartamento());//18
            statement.setString("pmunicipio", Cliente.getStrMunicipio());//19
            statement.setString("ptelefono2", Cliente.getStrTelefono2());//20
            statement.setString("pemail1", Cliente.getStrEmail1());//21
            statement.setString("pemail2", Cliente.getTrEmail2());//22            
            statement.setLong("ptitular", Cliente.getStrLbtitular());//23
             statement.setInt("pidempresa", Cliente.getStrCliente_IdEmpresa());//24

            statement.execute();
            // System.out.println("ACTUALIZADO" + codigo + Cliente.getStrEstadoCliente());

            DesktopNotify.showDesktopMessage("Mensaje del Sistema", "CLIENTE ACTUALIZADO"+Cliente.getStrIdCliente(), DesktopNotify.SUCCESS, 8000);

        } catch (SQLException ex) {
            DesktopNotify.showDesktopMessage("Mensaje del Sistema", "¡ERROR INSERTANDO!" + ex, DesktopNotify.ERROR, 8000);
            System.out.println(ex);
            //DesktopNotify.showDesktopMessage("Mensaje del Sistema", ""+ex, DesktopNotify.ERROR, 14000);
        }
    }

    public void insertarclienteonline(ClsEntidadCliente Cliente) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_GuardarClienteOnline(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidcliente2", Cliente.getStrIdCliente());
            statement.setString("pnombre", Cliente.getStrNombreCliente());
            statement.setString("pruc", Cliente.getStrRucCliente());
            statement.setString("pdni", Cliente.getStrDniCliente());
            statement.setString("pdireccion", Cliente.getStrDireccionCliente());
            statement.setString("ptelefono", Cliente.getStrTelefonoCliente());
            statement.setString("pobsv", Cliente.getStrObsvCliente());
            statement.setString("pnit", Cliente.getStrNitCliente());
            statement.setString("pcat", Cliente.getStrCategoriaCliente());
            statement.setString("pdepartamento", Cliente.getStrDepartamento());
            statement.setString("pmunicipio", Cliente.getStrMunicipio());
            statement.setString("ppais", Cliente.getStrPaisCliente());
            statement.setString("pcontribuyente", Cliente.getStrContribuyenteCliente());
            statement.setInt("pIdRuta", Cliente.getStrIdRuta());
            statement.setString("pgiro", Cliente.getStrgiro());
            statement.setString("pEstadoCliente", Cliente.getStrEstadoCliente());
            statement.setString("pTipoVentaCliente", Cliente.getStrTipoVenta());
            statement.setString("pSaldoLimite", Cliente.getStrSaldoLimite());

            statement.setString("pdireccion2", Cliente.getStrDirecion2());

            statement.executeUpdate();

            DesktopNotify.showDesktopMessage("Mensaje del Sistema", "CLIENTE ACTUALIZADO", DesktopNotify.SUCCESS, 8000);

        } catch (SQLException ex) {
            DesktopNotify.showDesktopMessage("Mensaje del Sistema", "¡ERROR!" + ex, DesktopNotify.ERROR, 8000);
            System.out.println(ex);
            //DesktopNotify.showDesktopMessage("Mensaje del Sistema", ""+ex, DesktopNotify.ERROR, 14000);
        }
    }

    public void modificar_estado_cliente(String codigo, ClsEntidadCliente Cliente) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Cliente_Estado(?,?)}");
            statement.setString("pidcliente", codigo);

            statement.setString("pEstadoCliente", Cliente.getStrEstadoCliente());

            statement.executeUpdate();
            //DesktopNotify.showDesktopMessage("Mensaje del Sistema", "¡Cliente Actualizado con éxito!", DesktopNotify.SUCCESS, 4000);
        } catch (SQLException ex) {
            DesktopNotify.showDesktopMessage("Mensaje del Sistema", "¡ERROR!" + ex, DesktopNotify.ERROR, 8000);
            System.out.println(ex);
            //DesktopNotify.showDesktopMessage("Mensaje del Sistema", ""+ex, DesktopNotify.ERROR, 14000);
        }
    }

    public void modificarClienteVenta(String codigo, ClsEntidadCliente Cliente) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_ClienteVenta(?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidcliente", codigo);
            statement.setString("pnombre", Cliente.getStrNombreCliente());
            statement.setString("pruc", Cliente.getStrRucCliente());
            statement.setString("pdni", Cliente.getStrDniCliente());
            statement.setString("pdireccion", Cliente.getStrDireccionCliente());

            statement.setString("pnit", Cliente.getStrNitCliente());
            statement.setString("pcat", Cliente.getStrCategoriaCliente());
             statement.setString("pmuni", Cliente.getStrMunicipio());
              statement.setString("pdepa", Cliente.getStrDepartamento());
               statement.setString("pgiro", Cliente.getStrgiro());
               
                 statement.setString("pemail", Cliente.getStrEmail1());
                   statement.setString("ptelefono", Cliente.getStrTelefonoCliente());
               
             

            statement.executeUpdate();
            DesktopNotify.showDesktopMessage("Mensaje del Sistema", "¡Datos Agregados!", DesktopNotify.SUCCESS, 4000);
        } catch (SQLException ex) {
            DesktopNotify.showDesktopMessage("Mensaje del Sistema", "¡ERROR!" + ex, DesktopNotify.ERROR, 8000);
            System.out.println(ex);
            //DesktopNotify.showDesktopMessage("Mensaje del Sistema", ""+ex, DesktopNotify.ERROR, 14000);
        }
    }

    public void desactivar_cliente(String codigo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_INACTIVARCLIENTE(?)}");
            statement.setString("pid", codigo);

            statement.executeUpdate();
            DesktopNotify.showDesktopMessage("Mensaje del Sistema", "¡Cliente Desactivado!", DesktopNotify.SUCCESS, 4000);
        } catch (SQLException ex) {
            DesktopNotify.showDesktopMessage("Mensaje del Sistema", "¡ERROR!" + ex, DesktopNotify.ERROR, 8000);
            System.out.println(ex);
        }
    }

    public void reactivar_cliente(String codigo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_REACTIVARCLIENTE(?)}");
            statement.setString("pid", codigo);

            statement.executeUpdate();
            DesktopNotify.showDesktopMessage("Mensaje del Sistema", "¡Cliente Reactivado!", DesktopNotify.SUCCESS, 4000);
        } catch (SQLException ex) {
            DesktopNotify.showDesktopMessage("Mensaje del Sistema", "¡ERROR!" + ex, DesktopNotify.ERROR, 8000);
            System.out.println(ex);
        }
    }

    public void modificarCliente2(ClsEntidadCliente Cliente) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Cliente2(?,?)}");
            statement.setString("pidcliente", Cliente.getStrIdCliente());
            statement.setString("pdireccion", Cliente.getStrDireccionCliente());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }
        DesktopNotify.showDesktopMessage("Mensaje del Sistema", "¡Dirección Actualizada!", DesktopNotify.SUCCESS, 4000);
        try {
            Rutas.FrmClientesRutas.BuscarDetalle();
        } catch (Exception e) {
        }

    }

    public void modificarClienteMaestro(ClsEntidadCliente Cliente) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_ClienteMaestro(?,?,?,?)}");
            statement.setString("pidcliente", Cliente.getStrIdCliente());
            statement.setString("pdireccion", Cliente.getStrDireccionCliente());
            statement.setString("pestado", Cliente.getStrEstadoCliente());
            statement.setString("pnombre", Cliente.getStrNombreCliente());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }
        DesktopNotify.showDesktopMessage("Mensaje del Sistema", "¡Dirección Actualizada!", DesktopNotify.SUCCESS, 4000);
        try {
            Rutas.FrmClientesRutas.BuscarDetalle();
        } catch (Exception e) {
        }

    }

    public void Aumentar_Id_Cliente() {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Aumentar_Id_Cliente()}");

            statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
            DesktopNotify.showDesktopMessage("Mensaje del Sistema", "Error" + ex, DesktopNotify.ERROR, 4000);

        }

    }
     public void actualizarsaldo(Long idcliente,float saldo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ActualizarSaldoCliente(?,?)}");
              statement.setLong("pidcliente", (idcliente));
            statement.setFloat("psaldo", saldo);

            statement.executeUpdate();
            DesktopNotify.showDesktopMessage("Mensaje del Sistema", "Saldo Actualizado", DesktopNotify.SUCCESS, 4000);

        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
            DesktopNotify.showDesktopMessage("Mensaje del Sistema", "Error" + ex, DesktopNotify.ERROR, 4000);

        }

    }
    
    
    
    
    

    public ArrayList<ClsEntidadCliente> listarCliente() {
        ArrayList<ClsEntidadCliente> clienteusuarios = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ClienteEnvio}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadCliente cliente = new ClsEntidadCliente();
                cliente.setStrIdCliente(resultSet.getString("IdCliente"));
                cliente.setStrNombreCliente(resultSet.getString("nombre"));
                cliente.setStrRucCliente(resultSet.getString("ruc"));
                cliente.setStrDniCliente(resultSet.getString("dni"));
                cliente.setStrDireccionCliente(resultSet.getString("direccion"));
                cliente.setStrTelefonoCliente(resultSet.getString("telefono"));
                cliente.setStrObsvCliente(resultSet.getString("obsv"));
                cliente.setStrNitCliente(resultSet.getString("nit"));
                cliente.setStrCategoriaCliente(resultSet.getString("categoria"));
                cliente.setStrContribuyenteCliente(resultSet.getString("contribuyente"));
                cliente.setStrIdRuta(resultSet.getInt("ruta"));
                cliente.setStrNombreRuta(resultSet.getString("nombreruta"));
                cliente.setStrgiro(resultSet.getString("giro"));
                cliente.setStrSaldoLimite(resultSet.getString("cliente_limite"));
                cliente.setStrSaldoActual(resultSet.getString("Pendiente"));
                cliente.setStrTipoVenta(resultSet.getString("Cliente_Venta"));
                cliente.setStrEstadoCliente(resultSet.getString("Cliente_Estado"));
                clienteusuarios.add(cliente);
            }
            return clienteusuarios;
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
            return null;
        }
    }
    
     public ArrayList<ClsEntidadCliente> listarClientecc(String busqueda) {
        ArrayList<ClsEntidadCliente> clienteusuarios = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ClienteEnviocc(?)}");
               statement.setString("pbusqueda", (busqueda));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadCliente cliente = new ClsEntidadCliente();
                cliente.setStrIdCliente(resultSet.getString("Cliente_Uni"));
                cliente.setStrNombreCliente(resultSet.getString("nombre"));
                
                clienteusuarios.add(cliente);
            }
            return clienteusuarios;
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
            return null;
        }
    }
    
    
    
    
    
      public void EstimarSaldos(String Id,int idliquidacion) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_ListasSaldosClienteLiq(?,?)}");
            statement.setString("pidcliente", Id);
             statement.setInt("pidliquidacion", idliquidacion);

            statement.executeUpdate();
            //DesktopNotify.showDesktopMessage("Mensaje del Sistema", "¡Cliente Actualizado con éxito!", DesktopNotify.SUCCESS, 4000);
        } catch (SQLException ex) {
            DesktopNotify.showDesktopMessage("Mensaje del Sistema", "¡ERROR!" + ex, DesktopNotify.ERROR, 8000);
            System.out.println(ex);
            //DesktopNotify.showDesktopMessage("Mensaje del Sistema", ""+ex, DesktopNotify.ERROR, 14000);
        }
    }
      
      
      public void EstimiarSaldoIni( int idliquidacion) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_ListasSaldosClienteLiq2(?)}");
            
             statement.setInt("pidliquidacion", idliquidacion);

            statement.executeUpdate();
             DesktopNotify.showDesktopMessage("Mensaje del Sistema", "Actualizando", DesktopNotify.SUCCESS, 4000);
        } catch (SQLException ex) {
            DesktopNotify.showDesktopMessage("Mensaje del Sistema", "¡ERROR!" + ex, DesktopNotify.ERROR, 8000);
            System.out.println(ex);
            //DesktopNotify.showDesktopMessage("Mensaje del Sistema", ""+ex, DesktopNotify.ERROR, 14000);
        }
    }
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public ArrayList<ClsEntidadCliente> listarClienteContribuyente() {
        ArrayList<ClsEntidadCliente> clienteusuarios = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ClienteContribuyete}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadCliente cliente = new ClsEntidadCliente();
                cliente.setStrIdCliente(resultSet.getString("IdCliente"));
                cliente.setStrNombreCliente(resultSet.getString("nombre"));
                cliente.setStrRucCliente(resultSet.getString("ruc"));
                cliente.setStrDniCliente(resultSet.getString("dni"));
                cliente.setStrDireccionCliente(resultSet.getString("direccion"));
                cliente.setStrTelefonoCliente(resultSet.getString("telefono"));
                cliente.setStrObsvCliente(resultSet.getString("obsv"));
                cliente.setStrNitCliente(resultSet.getString("nit"));
                cliente.setStrCategoriaCliente(resultSet.getString("categoria"));
                cliente.setStrContribuyenteCliente(resultSet.getString("contribuyente"));
                cliente.setStrIdRuta(resultSet.getInt("ruta"));
                cliente.setStrNombreRuta(resultSet.getString("nombreruta"));
                cliente.setStrgiro(resultSet.getString("giro"));
                clienteusuarios.add(cliente);
            }
            return clienteusuarios;
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
            return null;
        }
    }

    public ResultSet Listas_Cliente_Result(String idcliente) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Cliente_ResultSet(?)}");
            statement.setString("pidcliente", idcliente);

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listarClientePorParametro(String criterio, String busqueda) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ClientePorParametro(?,?)}");
            System.out.println(criterio + "criterio");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listarClientevario(String idcliente) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ClienteVario(?)}");
             statement.setString("pidcliente", idcliente);

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listarClientePorParametroContribuyente(String criterio, String busqueda) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ClientePorParametroContribuyente(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ArrayList<ClsEntidadCliente> listarClientesEnRuta(int Id) {
        ArrayList<ClsEntidadCliente> descuentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ClienteEnRuta(?)}");
            statement.setInt("pidRuta", Id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadCliente cliente = new ClsEntidadCliente();
                cliente.setStrNombreCliente(resultSet.getString("Nombre"));
                cliente.setStrDireccionCliente(resultSet.getString("Direccion"));
                descuentos.add(cliente);
            }
            return descuentos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ResultSet verificarcliente(String criterio) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Comprobaridcliente(?)}");
            statement.setString("pcorrelativo", criterio);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listar_cliente_datos(long id) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Cliente_datos(?)}");
            statement.setLong("pidcliente", id);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listar_empleados_datos(long id) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Empleado_datos(?)}");
            statement.setLong("pidempleado", id);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ArrayList<ClsEntidadCliente> listarmunicipio(String departamento) {
        ArrayList<ClsEntidadCliente> descuentos = new ArrayList<>();
        try {
           String query = "SELECT cod_dep, nombre_dep  FROM municipio where departamento=?";
            statement = connection.prepareStatement(query);
             
        ResultSet resultSet = statement.executeQuery();
           
            while (resultSet.next()) {
                ClsEntidadCliente cliente = new ClsEntidadCliente();
                cliente.setCoddep("codigo");
                cliente.setStrMunicipio(resultSet.getString("valores"));
                //cliente.setStrDireccionCliente(resultSet.getString("Direccion"));
                descuentos.add(cliente);
            }
            return descuentos;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }
    
    public static ArrayList<ClsEntidadCliente> listadepartamento() {
    ArrayList<ClsEntidadCliente> descuentos = new ArrayList<>();
    try {
        String query = "SELECT cod_dep, nombre_dep  FROM departamentos";
         statement = connection.prepareStatement(query);
        
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            ClsEntidadCliente cliente = new ClsEntidadCliente();
            cliente.setCoddep(resultSet.getString("cod_dep"));
            cliente.setStrDepartamento(resultSet.getString("nombre_dep"));
           
            descuentos.add(cliente);
        }
        return descuentos;
    } catch (SQLException ex) {
        System.err.println("Error : " + ex);
        return null;
    }
}

    public ResultSet obtenerCorrelativoCliente() throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call CorrelativoIdCliente()}");

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
}
