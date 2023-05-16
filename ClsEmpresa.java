package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadEmpresa;
import ds.desktop.notify.DesktopNotify;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ramos
 */
public class ClsEmpresa {
    static PreparedStatement st=null;

    private static final Connection connection = new ClsConexionLocal().getConection();
    private String sSQL = "";

    public void agregarEmpresa(ClsEntidadEmpresa empresa) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Empresa(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pnombre", empresa.getStrNombreEmpresa());
            statement.setString("pdireccion", empresa.getStrDireccionEmpresa());
            statement.setString("ptelefono", empresa.getStrTelefonoEmpresa());
            statement.setString("pemail", empresa.getStrEmailEmpresa());
            statement.setString("pnit", empresa.getStrNitEmpresa());
            statement.setString("pncr", empresa.getStrNcrEmpresa());
            statement.setString("pgiro", empresa.getStrGiroEmpresa());
            statement.setString("piva", empresa.getStrIvaEmpresa());
            statement.setString("pcategoria", empresa.getStrCategoriaEmpresa());
            statement.setString("ppercepcion", empresa.getStrPercepcionEmpresa());
            statement.setString("pretencion", empresa.getStrRetencionEmpresa());
            statement.setString("pControlStock", empresa.getStrControlStock());
            statement.setString("psalfec", empresa.getStrSalFec());
            statement.setString("pdescarga", empresa.getStrDescarga());
            statement.setString("plocal", empresa.getStrLocal());
            statement.setString("pcarga", empresa.getStrCarga());
            statement.setString("prango", String.valueOf(empresa.getStrRango()));
            statement.setString("pbackup", empresa.getStrBackup());
            statement.setBytes("pfoto", empresa.getFoto());
            statement.execute();
            DesktopNotify.showDesktopMessage("", "" + "DATOS ACTUALIZADOS ", DesktopNotify.INPUT_REQUEST, 5000);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Mensaje del Sistema", 1);
        }
    }
    
    
    
    public static ClsEntidadEmpresa obtenerEmpresaPorId(String idempresa) {
    ClsEntidadEmpresa empresa = new ClsEntidadEmpresa();

    String query = "SELECT * FROM empresa WHERE idempresa = ?";

    try  {
        st = connection.prepareStatement(query);
        st.setString(1, idempresa);

        ResultSet resultSet = st.executeQuery();

        if (resultSet.next()) {
            empresa.setStrIdEmpresa(resultSet.getString("idempresa"));
            empresa.setStrcodestable(resultSet.getString("Empresa_CodEstable"));
            empresa.setStrNcrEmpresa(resultSet.getString("Ncr"));
            empresa.setStrNitEmpresa(resultSet.getString("Nit"));
            empresa.setStrNombreEmpresa(resultSet.getString("Nombre"));
            empresa.setStrnombrecomercial(resultSet.getString("Empresa_NombreComercial"));
            empresa.setStrnombresucursal(resultSet.getString("Empresa_NombreSucursal"));
            empresa.setStrDireccionEmpresa(resultSet.getString("Direccion"));
            empresa.setStrdepa(resultSet.getString("Empresa_depa"));
            empresa.setStrmuni(resultSet.getString("Empresa_muni"));
            empresa.setStrGiroEmpresa(resultSet.getString("Giro"));
            empresa.setStrTelefonoEmpresa(resultSet.getString("Telefono"));
            empresa.setStrEmailEmpresa(resultSet.getString("Email"));
            empresa.setStrCategoriaEmpresa(resultSet.getString("Categoria"));
            empresa.setStrcodmh(resultSet.getString("empresa_codMH"));
        }

    } catch (SQLException ex) {
        System.out.println("Error al obtener datos de empresa por id: " + ex);
        JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
    }

    return empresa;
}
    
    public ArrayList<ClsEntidadEmpresa> listarEmpresas() {
    ArrayList<ClsEntidadEmpresa> empresas = new ArrayList<>();
    try {
        PreparedStatement statement = connection.prepareStatement("SELECT idempresa, nombre, Empresa_NombreComercial, Empresa_NombreSucursal FROM empresa");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            ClsEntidadEmpresa empresa = new ClsEntidadEmpresa();
            empresa.setStrIdEmpresa(resultSet.getString("idempresa"));
            empresa.setStrNombreEmpresa(resultSet.getString("nombre"));
            empresa.setStrnombrecomercial(resultSet.getString("Empresa_NombreComercial"));
            empresa.setStrnombresucursal(resultSet.getString("Empresa_NombreSucursal"));
            empresas.add(empresa);
        }
        return empresas;
    } catch (SQLException ex) {
        System.out.println(ex);
        return null;
    }
}


    
     public int agregarempresa(ClsEntidadEmpresa resumen) {
    String query = "INSERT INTO empresa (empresa_codMH, Empresa_CodEstable, Ncr, Nit, Nombre, Empresa_NombreComercial,"
            + " Empresa_NombreSucursal, Direccion, Empresa_depa, Empresa_muni, Giro, Telefono,"
            + " Email, Categoria) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    int idFilaInsertada = -1; // Inicializa el ID de la fila insertada en -1 (no se encontró)

    try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
        statement.setString(1, resumen.getStrcodmh());
        statement.setString(2, resumen.getStrcodestable());
        statement.setString(3, resumen.getStrNcrEmpresa());
        statement.setString(4, resumen.getStrNitEmpresa());
        statement.setString(5, resumen.getStrNombreEmpresa());
        statement.setString(6, resumen.getStrnombrecomercial());
        statement.setString(7, resumen.getStrnombresucursal());
        statement.setString(8, resumen.getStrDireccionEmpresa());
        statement.setString(9, resumen.getStrdepa());
        statement.setString(10, resumen.getStrmuni());
        statement.setString(11, resumen.getStrGiroEmpresa());
        statement.setString(12, resumen.getStrTelefonoEmpresa());
        statement.setString(13, resumen.getStrEmailEmpresa());
        statement.setString(14, resumen.getStrCategoriaEmpresa());

        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0) {
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                idFilaInsertada = rs.getInt(1); // Obtiene el ID de la fila insertada
            }
        }

    } catch (SQLException ex) {
        System.out.println("Error al insertar datos de resumen: " + ex);
        JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
    }

    return idFilaInsertada;
}

     
     public void actualizarEmpresa(ClsEntidadEmpresa resumen) {
    String query = "UPDATE empresa SET " +
                   "Empresa_CodEstable = ?," +
                   "Ncr = ?," +
                   "Nit = ?," +
                   "Nombre = ?," +
                   "Empresa_NombreComercial = ?," +
                   "Empresa_NombreSucursal = ?," +
                   "Direccion = ?," +
                   "Empresa_depa = ?," +
                   "Empresa_muni = ?," +
                   "Giro = ?," +
                   "Telefono = ?," +
                   "Email = ?," +
                   "Categoria = ?, " +
            "empresa_codMH = ? " +
                   "WHERE idempresa = ?";

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, resumen.getStrcodestable());
        statement.setString(2, resumen.getStrNcrEmpresa());
        statement.setString(3, resumen.getStrNitEmpresa());
        statement.setString(4, resumen.getStrNombreEmpresa());
        statement.setString(5, resumen.getStrnombrecomercial());
        statement.setString(6, resumen.getStrnombresucursal());
        statement.setString(7, resumen.getStrDireccionEmpresa());
        statement.setString(8, resumen.getStrdepa());
        statement.setString(9, resumen.getStrmuni());
        statement.setString(10, resumen.getStrGiroEmpresa());
        statement.setString(11, resumen.getStrTelefonoEmpresa());
        statement.setString(12, resumen.getStrEmailEmpresa());
        statement.setString(13, resumen.getStrCategoriaEmpresa());
        statement.setString(14, resumen.getStrcodmh());
          statement.setString(15, resumen.getStrIdEmpresa());

        int rowsUpdated = statement.executeUpdate();

        if (rowsUpdated > 0) {
           DesktopNotify.showDesktopMessage("", "" + "Datos Actualizados Correctamente ", DesktopNotify.SUCCESS, 5000);
        }

    } catch (SQLException ex) {
        System.out.println("Error al actualizar datos de empresa: " + ex);
        JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
    }
}
     
     public boolean existeEmpresa(String codigoEmpresa) {
    boolean existe = false;

    String query = "SELECT COUNT(*) FROM empresa WHERE idempresa = ?";

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, codigoEmpresa);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next() && resultSet.getInt(1) > 0) {
            existe = true;
        }
    } catch (SQLException ex) {
        System.out.println("Error al comprobar si la empresa existe: " + ex);
    }

    return existe;
}



    public void modificarEmpresa(String codigo, ClsEntidadEmpresa empresa) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Empresa(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pnombre", empresa.getStrNombreEmpresa());
            statement.setString("pdireccion", empresa.getStrDireccionEmpresa());
            statement.setString("ptelefono", empresa.getStrTelefonoEmpresa());
            statement.setString("pemail", empresa.getStrEmailEmpresa());
            statement.setString("pnit", empresa.getStrNitEmpresa());
            statement.setString("pncr", empresa.getStrNcrEmpresa());
            statement.setString("pgiro", empresa.getStrGiroEmpresa());
            statement.setString("piva", empresa.getStrIvaEmpresa());
            statement.setString("pcategoria", empresa.getStrCategoriaEmpresa());
            statement.setString("pidempresa", codigo);
            statement.setString("ppercepcion", empresa.getStrPercepcionEmpresa());
            statement.setString("pretencion", empresa.getStrRetencionEmpresa());
            statement.setString("psalfec", empresa.getStrSalFec());
            statement.setString("pdescarga", empresa.getStrDescarga());
            statement.setString("plocal", empresa.getStrLocal());
            statement.setString("pcarga", empresa.getStrCarga());
            statement.setString("prango", String.valueOf(empresa.getStrRango()));
            statement.setString("pbackup", empresa.getStrBackup());
            statement.setBytes("pfoto", empresa.getFoto());
            statement.execute();
            DesktopNotify.showDesktopMessage("", "" + "DATOS ACTUALIZADOS ", DesktopNotify.INPUT_REQUEST, 5000);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Mensaje del Sistema", 1);
            System.err.println(ex);
        }

    }

    public void Actualizar_Limites(Date fecha1, Date fecha2) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_AcualizarLimites(?,?)}");

            statement.setDate("pfechaini", new java.sql.Date(fecha1.getTime()));
            statement.setDate("pfechafin", new java.sql.Date(fecha2.getTime()));

            statement.execute();
            DesktopNotify.showDesktopMessage("", "" + "LIMITES ACTUALIZADOS ", DesktopNotify.INPUT_REQUEST, 5000);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Mensaje del Sistema", 1);
            System.err.println(ex);
        }

    }

    public void modificarEmpresaSelected(ClsEntidadEmpresa empresa) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_EmpresaSelected(?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pnombre", empresa.getStrNombreEmpresa());
            statement.setString("pdireccion", empresa.getStrDireccionEmpresa());
            statement.setString("ptelefono", empresa.getStrTelefonoEmpresa());
            statement.setString("pemail", empresa.getStrEmailEmpresa());
            statement.setString("pnit", empresa.getStrNitEmpresa());
            statement.setString("pncr", empresa.getStrNcrEmpresa());
            statement.setString("pgiro", empresa.getStrGiroEmpresa());
            statement.setString("piva", empresa.getStrIvaEmpresa());
            statement.setString("pcategoria", empresa.getStrCategoriaEmpresa());
            statement.setString("pidempresa", empresa.getStrIdEmpresa());
            statement.setString("ppercepcion", empresa.getStrPercepcionEmpresa());
            statement.setString("pretencion", empresa.getStrRetencionEmpresa());

            statement.execute();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public int ContarDatos() {
        sSQL = "CALL SP_S_CountEmpresa";
        try {
            int codigo = 0;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                codigo = rs.getInt("ExisteEmpresa");
            }
//            connection.close();
            return codigo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }
    }

    public ArrayList<ClsEntidadEmpresa> listarEmpresa() {
        ArrayList<ClsEntidadEmpresa> datosEmpresa = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Empresa}");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ClsEntidadEmpresa empresa = new ClsEntidadEmpresa();
                empresa.setStrIdEmpresa(resultSet.getString("IdEmpresa"));
                empresa.setStrNombreEmpresa(resultSet.getString("Nombre"));
                empresa.setStrDireccionEmpresa(resultSet.getString("Direccion"));
                empresa.setStrTelefonoEmpresa(resultSet.getString("Telefono"));
                empresa.setStrEmailEmpresa(resultSet.getString("Email"));
                empresa.setStrNitEmpresa(resultSet.getString("Nit"));
                empresa.setStrNcrEmpresa(resultSet.getString("Ncr"));
                empresa.setStrGiroEmpresa(resultSet.getString("Giro"));
                empresa.setStrIvaEmpresa(resultSet.getString("iva"));
                empresa.setStrCategoriaEmpresa(resultSet.getString("Categoria"));
                empresa.setStrPercepcionEmpresa(resultSet.getString("Strpercepcion"));
                empresa.setStrRetencionEmpresa(resultSet.getString("Strretencion"));
                datosEmpresa.add(empresa);
            }
//            connection.close();
            return datosEmpresa;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadEmpresa> listarEmpresalimite() {
        ArrayList<ClsEntidadEmpresa> datosEmpresa = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Limites}");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ClsEntidadEmpresa empresa = new ClsEntidadEmpresa();
                empresa.setStrIdEmpresa(resultSet.getString("idempresa"));
                empresa.setStrNombreEmpresa(resultSet.getString("nombre"));
                empresa.setStrLlimite(resultSet.getString("empresa_limite"));
                
                datosEmpresa.add(empresa);
            }
//            connection.close();
            return datosEmpresa;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ResultSet obtenerdatosempresa(int idcaja) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Datos_Empresa(?)}");
            statement.setString("pidcaja", String.valueOf(idcaja));
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listardiretorios(String criterio) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Directorio(?)}");
            statement.setString("pidempresa", criterio);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ArrayList<ClsEntidadEmpresa> listarSucursal() {
        ArrayList<ClsEntidadEmpresa> datosEmpresa = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Empresa}");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ClsEntidadEmpresa empresa = new ClsEntidadEmpresa();
                empresa.setStrIdEmpresa(resultSet.getString("IdEmpresa"));
                empresa.setStrNombreEmpresa(resultSet.getString("Nombre"));

                datosEmpresa.add(empresa);
            }
            // connection.close();
            return datosEmpresa;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ArrayList<ClsEntidadEmpresa> listarEmpresaFiltro(String id) {
        ArrayList<ClsEntidadEmpresa> datosEmpresa = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_EmpresaFiltro(?)}");
            statement.setString("pId", id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadEmpresa empresa = new ClsEntidadEmpresa();
                empresa.setStrIdEmpresa(resultSet.getString("IdEmpresa"));
                empresa.setStrNombreEmpresa(resultSet.getString("Nombre"));
                empresa.setStrDireccionEmpresa(resultSet.getString("Direccion"));
                empresa.setStrTelefonoEmpresa(resultSet.getString("Telefono"));
                empresa.setStrEmailEmpresa(resultSet.getString("Email"));
                empresa.setStrNitEmpresa(resultSet.getString("Nit"));
                empresa.setStrNcrEmpresa(resultSet.getString("Ncr"));
                empresa.setStrGiroEmpresa(resultSet.getString("Giro"));
                empresa.setStrIvaEmpresa(resultSet.getString("iva"));
                empresa.setStrCategoriaEmpresa(resultSet.getString("Categoria"));
                empresa.setStrPercepcionEmpresa(resultSet.getString("Strpercepcion"));
                empresa.setStrRetencionEmpresa(resultSet.getString("Strretencion"));
                empresa.setStrControlStock(resultSet.getString("Cotrolar_Stock"));
                empresa.setStrEmpresaEnvio(resultSet.getString("Empresa_Envio"));
                empresa.setStrSalFec(resultSet.getString("Empresa_Salfec"));
                empresa.setStrDescarga(resultSet.getString("Dir_Descarga"));
                empresa.setStrLocal(resultSet.getString("Dir_Local"));
                empresa.setStrCarga(resultSet.getString("Dir_Carga"));
                empresa.setStrRango(resultSet.getInt("Empresa_Rango"));
                empresa.setStrBackup(resultSet.getString("Empresa_Dir_Backup"));

                //imagen
                byte[] bytes = resultSet.getBytes("Empresa_Imagen_Logo");
                empresa.setFoto(bytes);
                datosEmpresa.add(empresa);
            }
//            connection.close();
            return datosEmpresa;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
}
