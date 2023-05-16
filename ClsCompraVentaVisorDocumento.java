/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.ClsConexionLocal;
import Entidad.ClsEntidadLiquidacion;
import Entidad.ClsEntidadProducto;
import Entidad.ClsEntidadTipoDocumento;
import Entidad.ClsEntidadvisor;
import Entidad.ClsVisorruta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author william
 */
public class ClsCompraVentaVisorDocumento {

    private Connection connection = new ClsConexionLocal().getConection();

    public ResultSet listarDetalleVentaPorParametro(String criterio, String busqueda) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_DetalleCompraVentaVisorPorParametro(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ArrayList<ClsEntidadLiquidacion> listarDocumentosLiquidacion(Integer Id) {
        ArrayList<ClsEntidadLiquidacion> Liquidaciones = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_DocumentosAsignadosLiquidacion(?)}");
            statement.setInt("pcriterio", Id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadLiquidacion Liquidacion = new ClsEntidadLiquidacion();
                Liquidacion.setStrIdCliente(resultSet.getString("Cliente_Uni"));
                Liquidacion.setStrNOmbre(resultSet.getString("Nombre"));                
                Liquidacion.setStrDireccion(resultSet.getString("direccion"));
                Liquidacion.setStrSaldoInicial(resultSet.getString("inicial"));
                Liquidacion.setStrAbono(resultSet.getString("abono"));
                Liquidacion.setStrTotalPagar(resultSet.getString("TotalPagar"));
                Liquidacion.setStrSaldo(resultSet.getString("TotalPagar"));
                  Liquidacion.setStrLlimite(resultSet.getString("credito"));
                    Liquidacion.setStrSaldoActual(resultSet.getString("final"));
                    
                   

               // Liquidacion.setStrSaldo(resultSet.getString("saldo"));
              

                Liquidaciones.add(Liquidacion);
            }
            return Liquidaciones;
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            return null;
        }
    }

    public ResultSet MostrarVisor(String criterio, Date fechaini, Date fechafin, int id) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CompraVentaVisorDocumentoZeus(?,?,?,?)}");
            statement.setString("pcriterio", criterio);
            
             statement.setInt("pid", id);
            statement.setDate("pfechaini", new java.sql.Date(fechaini.getTime()));
            statement.setDate("pfechafin", new java.sql.Date(fechafin.getTime()));
           
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet MostrarVisorSinCB(String criterio, Date fechaini, Date fechafin) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_SVisorSinCHBEmitido(?,?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setDate("pfechaini", new java.sql.Date(fechaini.getTime()));
            statement.setDate("pfechafin", new java.sql.Date(fechafin.getTime()));

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ArrayList<ClsVisorruta> listarTipoDocumento() {
        ArrayList<ClsVisorruta> tipodocumentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_IdRuta}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsVisorruta categoria = new ClsVisorruta();
                categoria.setStrIdTipoDocumento(resultSet.getString("idruta"));
                categoria.setStrDescripcionTipoDocumento(resultSet.getString("nombreRuta"));
                tipodocumentos.add(categoria);
            }
            return tipodocumentos;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ResultSet MostrarVisorLiquidaciones(String criterio, Date fechaini, Date fechafin, String doc) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_CompraVentaVisorDocumentoLquidaciones(?,?,?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setDate("pfechaini", new java.sql.Date(fechaini.getTime()));
            statement.setDate("pfechafin", new java.sql.Date(fechafin.getTime()));
            statement.setString("pliquidacion", doc);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public void agregarLiquidacion(String criterio,int idruta) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Liquidaciones(?,?)}");

            statement.setString("pobservacion", criterio);
             statement.setInt("pidruta", idruta);

            statement.execute();

            JOptionPane.showMessageDialog(null, "¡Liquidacion agregada con exito!", "Mensaje del Sistema", 1);
        } catch (SQLException ex) {
            System.err.println("Error al insertar: " + ex);
        }
    }

    public ArrayList<ClsVisorruta> listarTipoDocumentoliquidaciones() {
        ArrayList<ClsVisorruta> tipodocumentos = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_tipodocumentosintiket}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsVisorruta categoria = new ClsVisorruta();
                categoria.setStrIdTipoDocumento(resultSet.getString("IdTipoDocumento"));
                categoria.setStrDescripcionTipoDocumento(resultSet.getString("Descripcion"));
                tipodocumentos.add(categoria);
            }
            return tipodocumentos;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

}
