package Negocio;

import Conexion.*;
import Entidad.*;
import Presentacion.FrmPresentacion;
import Presentacion.FrmPrincipal;
import ds.desktop.notify.DesktopNotify;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class ClsEmpleado {

    private final Connection connection = new ClsConexionLocal().getConection();

    public void agregarEmpleado(ClsEntidadEmpleado empleado) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Empleado(?,?,?,?,?,"//5
                    + "?,?,?,?,?,"//10
                    + "?,?,?,?,?"//15
                    + ",?,?,?,?,?,"//20
                    + "?,?,?,?,?,"//25

                    + "?,?,?,?,?,?,?)}");//41

            statement.setString("pnombre", empleado.getStrNombreEmpleado());//
            statement.setString("papellido", empleado.getStrApellidoEmpleado());//
            statement.setString("psexo", empleado.getStrSexoEmpleado());//
            statement.setDate("pfechanac", new java.sql.Date(empleado.getStrFechaNacEmpleado().getTime()));//
            statement.setString("pdireccion", empleado.getStrDireccionEmpleado());//
            statement.setString("ptelefono", empleado.getStrTelefonoEmpleado());//6

            statement.setString("pcelular", empleado.getStrCelularEmpleado());//
            statement.setString("pemail", empleado.getStrEmailEmpleado());//
            statement.setString("pdni", empleado.getStrDniEmpleado());//
            statement.setString("pisss", empleado.getStrIsssEmpleado());//
            statement.setString("pnup", empleado.getStrNupEmpleado());//11

            statement.setDate("pfechaing", new java.sql.Date(empleado.getStrFechaIngEmpleado().getTime()));//
            statement.setString("psueldo", empleado.getStrSueldoEmpleado());//
            statement.setString("pestado", empleado.getStrEstadoEmpleado());//
            statement.setString("pusuario", empleado.getStrUsuarioEmpleado());//
            statement.setString("pcontrasenia", empleado.getStrContraseñaEmpleado());//
            statement.setString("pidtipousuario", empleado.getStrIdTipoUsuario());//17

            statement.setString("pPermisos", empleado.getStrIsActive());//
            statement.setString("pobservacion", empleado.getStrObservacion());//
            statement.setString("pnit", empleado.getStrNit());//
            statement.setString("pcargo", empleado.getStrCargo());//
            statement.setString("pcivil", empleado.getStrEstadoCivil());//

            statement.setString("pedad", empleado.getStrEdad());//23

            statement.setString("pestudios", empleado.getStrEstudios());
            statement.setString("pexperiencia", empleado.getStrExperiencia());
            statement.setString("pcomision", empleado.getStrComision());
            statement.setString("pporcentaje", empleado.getStrPorcentaje());
            statement.setString("phoras", empleado.getStrHoras());
            statement.setString("pidempresa", empleado.getStrIdEmpresa());//29

            statement.setString("pfija", empleado.getStrFija());
            statement.setString("pcodigo", empleado.getStrcodigo());
            statement.setString("puuid", empleado.getStrUUID());//32

            statement.execute();
            // connection.close();
            DesktopNotify.showDesktopMessage("", "" + "DATOS GUARDADOS ", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);

            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public ArrayList<ClsEntidadEmpleado> listarEmpleadoonline() {
        Connection ClsConexionLocal = new ClsConexionLocal().getConection();
        ArrayList<ClsEntidadEmpleado> empleados = new ArrayList<>();
        try {
            CallableStatement statement = ClsConexionLocal.prepareCall("{call SP_S_EmpleadoLocal}");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ClsEntidadEmpleado empleado = new ClsEntidadEmpleado();
                empleado.setStrIdEmpleado(resultSet.getString("IdEmpleado"));//1
                empleado.setStrNombreEmpleado(resultSet.getString("Nombre"));//2
                empleado.setStrApellidoEmpleado(resultSet.getString("Apellido"));//3
                empleado.setStrSexoEmpleado(resultSet.getString("Sexo"));//4
                empleado.setStrFechaNacEmpleado(resultSet.getDate("FechaNac"));//5
                empleado.setStrDireccionEmpleado(resultSet.getString("Direccion"));//6
                empleado.setStrTelefonoEmpleado(resultSet.getString("Telefono"));//7
                empleado.setStrCelularEmpleado(resultSet.getString("Celular"));//8
                empleado.setStrEmailEmpleado(resultSet.getString("Email"));//9
                empleado.setStrDniEmpleado(resultSet.getString("Dni"));//10
                empleado.setStrIsssEmpleado(resultSet.getString("Isss"));//11
                empleado.setStrNupEmpleado(resultSet.getString("Nup"));//12
                empleado.setStrFechaIngEmpleado(resultSet.getDate("FechaIng"));//13
                empleado.setStrSueldoEmpleado(resultSet.getString("Sueldo"));//14
                empleado.setStrEstadoEmpleado(resultSet.getString("Estado"));//15
                empleado.setStrUsuarioEmpleado(resultSet.getString("Usuario"));//16
                empleado.setStrContraseñaEmpleado(resultSet.getString("Contrasenia"));//17
                empleado.setStrIdTipoUsuario(resultSet.getString("IdTipoUsuario"));//18
                empleado.setStrIsActive(resultSet.getString("IsActive"));//19
                empleado.setStrObservacion(resultSet.getString("Empleado_Observacion"));//20
                empleado.setStrNit(resultSet.getString("Empleado_Nit"));//21
                empleado.setStrCargo(resultSet.getString("Empleado_Cargo"));//22
                empleado.setStrIdEmpresa(resultSet.getString("Empleado_IdEmpresa"));//23
                empleado.setStrcodigo(resultSet.getString("Empleado_Codigo"));//24
                empleado.setStrEdad(resultSet.getString("Empleado_Edad"));//25
                empleado.setStrEstadoCivil(resultSet.getString("Empleado_EstadoCivil"));//26
                empleado.setStrEstudios(resultSet.getString("Empleado_Estudios"));//27
                empleado.setStrExperiencia(resultSet.getString("Empleado_Experiencia"));//28
                empleado.setStrHoras(resultSet.getString("Empleado_HorasExtra"));//29
                empleado.setStrComision(resultSet.getString("Empleado_Comicion"));//30
                empleado.setStrPorcentaje(resultSet.getString("Empleado_PorcentajeCo"));//31
                empleado.setStrFija(resultSet.getString("Empleado_CoFija"));//32
                empleado.setStrUpdate(resultSet.getDate("Empleado_Update"));//33
                empleado.setStrentrada(resultSet.getString("Emp_Entrada"));//34
                empleado.setSetstrsalida(resultSet.getString("Emp_Salida"));//35
                empleado.setSetstrjornada(resultSet.getString("Emp_Jornada"));//36
                empleado.setStrUUID(resultSet.getString("Emp_ContraUUID"));//37
                empleado.setStrdescanso(resultSet.getString("Emp_DiaDescanso"));//38
                empleado.setStrAnticipo(resultSet.getString("Emp_Anticipo15"));//39
                empleado.setStrtipo(resultSet.getString("Emp_Tipo"));//40
                empleado.setStrauinaldo(resultSet.getString("Emp_Agui"));

                empleados.add(empleado);
            }
            return empleados;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public void agregarvendedor(ClsEntidadEmpleado empleado) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Vendedor(?,?,?,?)}");
            statement.setString("pnombre", empleado.getStrNombreEmpleado());

            statement.setString("ptelefono", empleado.getStrTelefonoEmpleado());
            statement.setString("pdni", empleado.getStrDniEmpleado());
            statement.setString("pnit", empleado.getStrNit());
            statement.execute();
            // connection.close();
            DesktopNotify.showDesktopMessage("", "" + "DATOS GUARDADOS ", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);

            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void agregarplanillaanticipo(ClsEntidadEmpleado empleado) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_PlanillaAnticipo(?,?,?,?)}");
            statement.setString("pidempleado", empleado.getStrIdEmpleado());

            statement.setString("pperiodo", empleado.getStrperiodo());
            statement.setString("panticipo", empleado.getStrAnticipo());
            statement.setString("pidsucursal", empleado.getStrIdEmpresa());

            statement.execute();
            // connection.close();

        } catch (SQLException ex) {
            System.out.println("Error : " + ex);

            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void eliminarplanilla(ClsEntidadEmpleado empleado) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_D_PlanillaAnticipo(?,?)}");

            statement.setString("pperiodo", empleado.getStrperiodo());

            statement.setString("pidsucursal", empleado.getStrIdEmpresa());

            statement.execute();
            // connection.close();

        } catch (SQLException ex) {
            System.out.println("Error : " + ex);

            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void agregarplanillamensual(ClsEntidadEmpleado empleado) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_PlanillaMensual(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidempleado", empleado.getStrIdEmpleado());
            statement.setString("psalario", empleado.getStrSueldoEmpleado());
            statement.setString("phora", empleado.getStrHoras());
            statement.setString("pcomision", empleado.getStrComision());
            statement.setString("pdevengado", empleado.getStrdevengado());
            statement.setString("pisss", empleado.getStrIsssEmpleado());
            statement.setString("pafp", empleado.getStrafpempleado());
            statement.setString("prenta", empleado.getStrrentaempleado());
            statement.setString("panticipo", empleado.getStrAnticipo());
            statement.setString("pliquido", empleado.getLiquido());
            statement.setString("pperiodo", empleado.getStrperiodo());
            statement.setString("pvacacion", empleado.getStrvacacion());
            statement.setString("pempresa", empleado.getStrIdEmpresa());
            statement.setString("pasueto", empleado.getStrasueto());
            statement.setString("ptotalhoras", empleado.getStrtotalhoras());
            statement.setString("pdiaslab", empleado.getStrdias());
            statement.setString("pver", empleado.getStrversion());
            statement.setDate("pfechaplanilla", new java.sql.Date(empleado.getStrfechaplanilla().getTime()));//
            statement.setString("pobs", empleado.getStrObservacion());

            statement.execute();
            // connection.close();

        } catch (SQLException ex) {
            System.out.println("Error : " + ex);

            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void agregarVendedor(ClsEntidadEmpleado empleado) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_VendedorPorProveedor(?,?)}");
            statement.setString("pidproveedor", empleado.getStrIdProveedor());
            statement.setString("pidvendedor", empleado.getStrIdEmpleado());

            statement.execute();
            // connection.close();
            DesktopNotify.showDesktopMessage("", "" + "DATOS GUARDADOS ", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);

            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void modificarEmpleadoLocal(ClsEntidadEmpleado empleado) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_EmpleadoLocal(?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pnombre", empleado.getStrNombreEmpleado());
            statement.setString("papellido", empleado.getStrApellidoEmpleado());
            statement.setString("psexo", empleado.getStrSexoEmpleado());
            if (empleado.getStrFechaNacEmpleado() == null) {
                statement.setNull("pfechanac", java.sql.Types.DATE);
            } else {
                statement.setDate("pfechanac", new java.sql.Date(empleado.getStrFechaNacEmpleado().getTime()));
            }
            statement.setString("pdireccion", empleado.getStrDireccionEmpleado());
            statement.setString("ptelefono", empleado.getStrTelefonoEmpleado());
            statement.setString("pcelular", empleado.getStrCelularEmpleado());
            statement.setString("pemail", empleado.getStrEmailEmpleado());
            statement.setString("pdni", empleado.getStrDniEmpleado());
            statement.setString("pisss", empleado.getStrIsssEmpleado());
            
            statement.setString("pnup", empleado.getStrNupEmpleado());
            if (empleado.getStrFechaIngEmpleado() == null) {
                statement.setNull("pfechaing", java.sql.Types.DATE);
            } else {
                statement.setDate("pfechaing", new java.sql.Date(empleado.getStrFechaIngEmpleado().getTime()));
            }
            statement.setString("psueldo", empleado.getStrSueldoEmpleado());
            statement.setString("pestado", empleado.getStrEstadoEmpleado());
            statement.setString("pusuario", empleado.getStrUsuarioEmpleado());
            statement.setString("pcontrasenia", empleado.getStrContraseñaEmpleado());
            statement.setString("pidtipousuario", empleado.getStrIdTipoUsuario());
            statement.setString("pPermisos", empleado.getStrIsActive());
            statement.setString("pidempleado", empleado.getStrIdEmpleado());
            //-----------------------------------------------------//
            statement.setString("pcodigo", empleado.getStrcodigo());
            
            
            statement.setString("pnit", empleado.getStrNit());
            statement.setString("pcivil", empleado.getStrEstadoCivil());
            statement.setString("pedad", empleado.getStrEdad());
            statement.setString("pcargo", empleado.getStrCargo());
            statement.setString("pestudio", empleado.getStrEstudios());
            statement.setString("pdescanso", empleado.getStrdescanso());
            statement.setString("pexperiencia", empleado.getStrExperiencia());
              statement.setDate("pupdate", (Date) empleado.getStrUpdate());
                statement.setString("pobs", empleado.getStrObservacion());
                 statement.setString("pidempresa", empleado.getStrIdEmpresa());

            statement.execute();
            //connection.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void modificarEmpleado(String codigo, ClsEntidadEmpleado empleado) {
        try {
            System.out.println("aqui entro");
            CallableStatement statement = connection.prepareCall("{call SP_U_Empleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pnombre", empleado.getStrNombreEmpleado());
            statement.setString("papellido", empleado.getStrApellidoEmpleado());
            statement.setString("psexo", empleado.getStrSexoEmpleado());
            statement.setDate("pfechanac", new java.sql.Date(empleado.getStrFechaNacEmpleado().getTime()));
            statement.setString("pdireccion", empleado.getStrDireccionEmpleado());
            statement.setString("ptelefono", empleado.getStrTelefonoEmpleado());
            statement.setString("pcelular", empleado.getStrCelularEmpleado());
            statement.setString("pemail", empleado.getStrEmailEmpleado());
            statement.setString("pdni", empleado.getStrDniEmpleado());
            statement.setString("pisss", empleado.getStrIsssEmpleado());
            statement.setString("pnup", empleado.getStrNupEmpleado());
            statement.setDate("pfechaing", new java.sql.Date(empleado.getStrFechaIngEmpleado().getTime()));
            statement.setString("psueldo", empleado.getStrSueldoEmpleado());
            statement.setString("pestado", empleado.getStrEstadoEmpleado());
            statement.setString("pusuario", empleado.getStrUsuarioEmpleado());
            statement.setString("pcontrasenia", empleado.getStrContraseñaEmpleado());
            statement.setString("pidtipousuario", empleado.getStrIdTipoUsuario());
            statement.setString("pPermisos", empleado.getStrIsActive());
            statement.setString("pidempleado", codigo);

            statement.setString("pcivil", empleado.getStrEstadoCivil());
            statement.setString("pnit", empleado.getStrNit());
            statement.setString("pedad", empleado.getStrEdad());
            statement.setString("pcargo", empleado.getStrCargo());

            statement.setString("pestudios", empleado.getStrEstudios());
            statement.setString("pexperiencia", empleado.getStrExperiencia());
            statement.setString("pcomision", empleado.getStrComision());
            statement.setString("pporcentaje", empleado.getStrPorcentaje());
            statement.setString("phoras", empleado.getStrHoras());
            statement.setString("pidempresa", empleado.getStrIdEmpresa());
            statement.setString("pobservacion", empleado.getStrObservacion());

            statement.setString("pfija", empleado.getStrFija());
            statement.setString("pcodigo", empleado.getStrcodigo());
            statement.setString("puuid", empleado.getStrUUID());
            statement.execute();
            // connection.close();
            DesktopNotify.showDesktopMessage("", "" + "DATOS ACTUALIZADOS ", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);

            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void modificarVendedor(ClsEntidadEmpleado empleado) {
        try {
            System.out.println("aqui entro");
            CallableStatement statement = connection.prepareCall("{call SP_U_EmpleadoVendedor(?,?,?,?,?)}");
            statement.setString("pnombre", empleado.getStrNombreEmpleado());

            statement.setString("ptelefono", empleado.getStrTelefonoEmpleado());
            statement.setString("pdni", empleado.getStrDniEmpleado());
            statement.setString("pidempleado", empleado.getStrIdEmpleado());
            statement.setString("pnit", empleado.getStrNit());

            statement.execute();
            // connection.close();
            DesktopNotify.showDesktopMessage("", "" + "DATOS ACTUALIZADOS ", DesktopNotify.SUCCESS, 5000);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);

            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void IsActive(String codigo, ClsEntidadEmpleado empleado) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_EmpleadoIsActive(?,?)}");
            statement.setString("pidempleado", codigo);
            statement.setString("pIsACtive", empleado.getStrIsActive());
            statement.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
//        JOptionPane.showMessageDialog(null,"¡Empleado Actualizado!","Mensaje del Sistema",1);
    }

    public ResultSet LoginEmpleados(String usu, String contra) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Login(?,?)}");
            statement.setString("pusuario", usu);
            statement.setString("pcontrasenia", contra);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ArrayList<ClsEntidadEmpleado> listarEmpleadoDescuento(String cod) {
        ArrayList<ClsEntidadEmpleado> empleados = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_EmpleadoDescuento(?)}");
            statement.setString("pusuario", cod);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadEmpleado empleado = new ClsEntidadEmpleado();
                empleado.setStrIdEmpleado(resultSet.getString("IdEmpleado"));
                empleado.setStrContraseñaEmpleado(resultSet.getString("Contrasenia"));
                empleado.setStrIsActive(resultSet.getString("IsActive"));
                empleados.add(empleado);
            }
            //  connection.close();
            return empleados;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public int ValidarUsuarioEnForm(String contra, String pass) {
        ResultSet rs = null;
        try {
            int Existe = 0, idempleado = 0;
            CallableStatement statement = connection.prepareCall("{call SP_S_ExisteEmpleado(?,?)}");
            statement.setString("pcontrasenia", contra);
            statement.setString("pcontrasenia2", pass);
            rs = statement.executeQuery();
            while (rs.next()) {
                Existe = rs.getInt("ExisteEmpleado");
            }
            return Existe;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }
    public float obtenerPlaLiquido(int pla_idempleado, String pla_periodo) {
    ResultSet rs = null;
    float pla_liquido = 0;

    try {
        String sql = "SELECT sum(pla_liquido+pla_isss) as pla FROM planilla WHERE pla_idempleado=? AND pla_periodo=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pla_idempleado);
        statement.setString(2, pla_periodo);
        rs = statement.executeQuery();

        if (rs.next()) {
            pla_liquido = rs.getFloat("pla");
        } else {
            pla_liquido = 0;
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
        System.out.println(pla_idempleado+" "+pla_periodo+" "+pla_liquido);
    return pla_liquido;
}


    public String ValidarAutoriza(String contra, String pass) {
        ResultSet rs = null;
        try {
            String Existe = "", idempleado = "";
            CallableStatement statement = connection.prepareCall("{call SP_S_EmpleadoAutoriza(?,?)}");
            statement.setString("pcontrasenia", contra);
            statement.setString("pcontrasenia2", pass);
            rs = statement.executeQuery();
            while (rs.next()) {
                Existe = rs.getString("empleado");
            }
            return Existe;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return "";
        }
    }

    public int ValidarUsuarioEnForm2(String contra, String pass) {
        ResultSet rs = null;
        try {
            ClsEntidadEmpleado emp = new ClsEntidadEmpleado();
            int Existe = 0;
            CallableStatement statement = connection.prepareCall("{call SP_S_ExisteEmpleado2(?,?)}");
            statement.setString("pcontrasenia", contra);
            statement.setString("pcontrasenia2", pass);
            rs = statement.executeQuery();
            while (rs.next()) {
                Existe = rs.getInt("ExisteEmpleado");
                emp.setStrNombreEmpleado(rs.getString("usuario"));
                FrmPrincipal.lbempleado.setText(emp.getStrNombreEmpleado());
                System.out.println(emp.getStrNombreEmpleado());
            }
            return Existe;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }

    public ArrayList<ClsEntidadEmpleado> listarEmpleado() {
        ArrayList<ClsEntidadEmpleado> empleados = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Empleado}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadEmpleado empleado = new ClsEntidadEmpleado();
                empleado.setStrIdEmpleado(resultSet.getString("IdEmpleado"));
                empleado.setStrNombreEmpleado(resultSet.getString("Nombre"));
                empleado.setStrApellidoEmpleado(resultSet.getString("Apellido"));
                empleado.setStrSexoEmpleado(resultSet.getString("Sexo"));
                empleado.setStrFechaNacEmpleado(resultSet.getDate("FechaNac"));
                empleado.setStrDireccionEmpleado(resultSet.getString("Direccion"));
                empleado.setStrTelefonoEmpleado(resultSet.getString("Telefono"));
                empleado.setStrCelularEmpleado(resultSet.getString("Celular"));
                empleado.setStrEmailEmpleado(resultSet.getString("Email"));
                empleado.setStrDniEmpleado(resultSet.getString("Dni"));
                empleado.setStrIsssEmpleado(resultSet.getString("Isss"));
                empleado.setStrNupEmpleado(resultSet.getString("Nup"));
                empleado.setStrFechaIngEmpleado(resultSet.getDate("FechaIng"));
                empleado.setStrSueldoEmpleado(resultSet.getString("Sueldo"));
                empleado.setStrEstadoEmpleado(resultSet.getString("Estado"));
                empleado.setStrUsuarioEmpleado(resultSet.getString("Usuario"));
                //empleado.setStrContraseñaEmpleado(resultSet.getString("Contrasenia"));
                empleado.setStrTipoUsuario(resultSet.getString("TipoUsuario"));
                empleado.setStrIsActive(resultSet.getString("IsActive"));
                empleados.add(empleado);
            }
            return empleados;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadEmpleado> listarEmpleadoPlanilla(int idempresa) {
        ArrayList<ClsEntidadEmpleado> empleados = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_EmpleadoPlanilla(?)}");
            statement.setInt("pidempresa", idempresa);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadEmpleado empleado = new ClsEntidadEmpleado();
                empleado.setStrIdEmpleado(resultSet.getString("IdEmpleado"));
                empleado.setStrNombreEmpleado(resultSet.getString("Nombre"));

                empleado.setStrAnticipo(resultSet.getString("Emp_Anticipo15"));
                empleados.add(empleado);
            }
            return empleados;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadEmpleado> listarPlanillaAnticipo() {
        ArrayList<ClsEntidadEmpleado> empleados = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_PlanillaAnticipo()}");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadEmpleado empleado = new ClsEntidadEmpleado();
                empleado.setStrIdEmpleado(resultSet.getString("Codigo"));
                empleado.setStrNombreEmpleado(resultSet.getString("IdEmpresa"));

                empleado.setStrAnticipo(resultSet.getString("Empresa"));
                empleados.add(empleado);
            }
            return empleados;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadEmpleado> listarPlanillaMensual() {
        ArrayList<ClsEntidadEmpleado> empleados = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Planillamensual()}");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadEmpleado empleado = new ClsEntidadEmpleado();
                empleado.setStrIdEmpleado(resultSet.getString("Codigo"));
                empleado.setStrNombreEmpleado(resultSet.getString("IdEmpresa"));

                empleado.setStrAnticipo(resultSet.getString("Empresa"));
                empleado.setStrversion(resultSet.getString("pla_ver"));
                empleados.add(empleado);
            }
            return empleados;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadEmpleado> listarEmpleadoPlanillamensual(int idempresa) {
        ArrayList<ClsEntidadEmpleado> empleados = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_EmpleadoPlanillaMensual(?)}");
            statement.setInt("pidempresa", idempresa);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadEmpleado empleado = new ClsEntidadEmpleado();
                empleado.setStrafp(resultSet.getString("@afp"));
                empleado.setStrIsss(resultSet.getString("@isss"));
                empleado.setStrIdEmpleado(resultSet.getString("IdEmpleado"));
                empleado.setStrIdEmpleado(resultSet.getString("IdEmpleado"));
                empleado.setStrApellidoEmpleado(resultSet.getString("Apellido"));
                empleado.setStrNombreEmpleado(resultSet.getString("Nombre"));
                empleado.setStrSueldoEmpleado(resultSet.getString("sueldo"));
                empleado.setStrHoras(resultSet.getString("horas"));
                empleado.setStrComision(resultSet.getString("comision"));
                empleado.setStrvacacion(resultSet.getString("vacacion"));

                empleado.setStrdevengado(resultSet.getString("devengado"));
                empleado.setStrIsssEmpleado(resultSet.getString("isss"));
                empleado.setStrafpempleado(resultSet.getString("afp"));
                empleado.setStrrentaempleado(resultSet.getString("renta"));

                empleado.setStrAnticipo(resultSet.getString("anticipo"));
                empleado.setLiquido(resultSet.getString("liquido"));
                empleados.add(empleado);
            }
            return empleados;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
   

    public ArrayList<ClsEntidadEmpleado> listarEmpleadoVendedor() {
        ArrayList<ClsEntidadEmpleado> empleados = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_EmpleadoVendedor}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadEmpleado empleado = new ClsEntidadEmpleado();
                empleado.setStrIdEmpleado(resultSet.getString("IdEmpleado"));
                empleado.setStrNombreEmpleado(resultSet.getString("Nombre"));
                empleados.add(empleado);
            }
            return empleados;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadEmpleado> listarVendedoresPorProveedor(String busqueda) {
        ArrayList<ClsEntidadEmpleado> empleados = new ArrayList<>();
        ClsEntidadEmpleado empleado = new ClsEntidadEmpleado();

        try {

            CallableStatement statement = connection.prepareCall("{call SP_S_VendedorPorProveedor(?)}");
            statement.setString("pnombre", busqueda);
            System.out.println(busqueda + "pedo");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                empleado.setStrIdEmpleado(resultSet.getString("Id"));
                empleado.setStrNombreEmpleado(resultSet.getString("Nombre"));
                empleado.setStrDniEmpleado(resultSet.getString("Dui"));
                empleado.setStrNit(resultSet.getString("Nit"));
                empleado.setStrTelefonoEmpleado(resultSet.getString("Telefono"));
                empleados.add(empleado);
            }
            //resultSet.close();
            return empleados;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadEmpleado> listarProductoprecio(String cod) {
        ArrayList<ClsEntidadEmpleado> productosVenta = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_VendedorPorProveedor(?)}");
            statement.setString("pnombre", cod);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadEmpleado producto = new ClsEntidadEmpleado();
                producto.setStrIdEmpleado(resultSet.getString("Id"));
                producto.setStrNombreEmpleado(resultSet.getString("nombre"));
                producto.setStrDniEmpleado(resultSet.getString("Dui"));
                producto.setStrNit(resultSet.getString("Nit"));
                producto.setStrTelefonoEmpleado(resultSet.getString("Telefono"));

                productosVenta.add(producto);

            }
            resultSet.close();
//            connection.close();
            return productosVenta;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadEmpleado> listarvendedor(String cod) {
        ArrayList<ClsEntidadEmpleado> productosVenta = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_VPTABLA(?)}");
            statement.setString("pidproveedor", cod);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadEmpleado producto = new ClsEntidadEmpleado();
                producto.setStrIdEmpleado(resultSet.getString("VP_IdVend"));
                producto.setStrNombreEmpleado(resultSet.getString("nombre"));
                producto.setStrDniEmpleado(resultSet.getString("Vend_Dui"));
                producto.setStrNit(resultSet.getString("Vend_NIt"));
                producto.setStrTelefonoEmpleado(resultSet.getString("Vend_Telefono"));

                productosVenta.add(producto);

            }
            resultSet.close();
//            connection.close();
            return productosVenta;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ResultSet listarEmpleadoPorParametrozeus(String criterio, String busqueda, int idempresa) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_EmpleadoPorParametroZeus(?,?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
             statement.setInt("pidempresa", idempresa);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
    
      
      
      public ResultSet sueldoanterior(int idempleado,int periodo) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_SueldoAnterioro(?,?)}");
            statement.setInt("pieempleado", idempleado);
             statement.setInt("pperiodo", periodo);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
    
      public ResultSet listarEmpleadoPorParametroEmp(String criterio, String busqueda, int idempresa) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_EmpleadoPorParametroEmp(?,?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
             statement.setInt("pidempresa", idempresa);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
public ResultSet listarEmpleadoPorParametro(String criterio, String busqueda) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_EmpleadoPorParametroZeus(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
    public ResultSet listarempresaporparametro(String criterio) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_BuscarEmpresa(?)}");
            statement.setString("pcriterio", criterio);

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listarServidores(String criterio) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_BuscarServidor(?)}");
            statement.setString("pcriterio", criterio);

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listarEmpleadoVendedor(String criterio, String busqueda) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_EmpleadoPorVendedor(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public void cambiarContraseña(String codigo, ClsEntidadEmpleado Empleado) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_CambiarPass(?,?)}");
            statement.setString("pidempleado", codigo);
            statement.setString("pcontrasenia", Empleado.getStrContraseñaEmpleado());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(null, "¡Se cambio contraseña satisfactoriamente!", "Mensaje del Sistema", 1);
    }

    public void borrarplanillamensual(String salfec, int idempresa, int ver) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_D_Planillamensual(?,?,?)}");
            statement.setString("psalfec", salfec);
            statement.setInt("pidempresa", idempresa);
            statement.setInt("pver", ver);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);

        }

    }
}
