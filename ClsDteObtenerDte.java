/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import Conexion.*;
import Entidad.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Usuario
 */
public class ClsDteObtenerDte {
    Connection connection = new ClsConexionLocal().getConection();
    public ClsDteitentificacion obtenerIdentificacion(String codigoGeneracion) {
   ClsDteitentificacion identificacion = null;

try {
    String query = "SELECT * FROM dte_identificacion WHERE codigoGeneracion = ?";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.setString(1, codigoGeneracion);
    ResultSet result = statement.executeQuery();

    if (result.next()) {
        identificacion = new ClsDteitentificacion(
            result.getString("ambiente"),
            result.getString("codigoGeneracion"),
            result.getString("fecEmi"),
            result.getString("horEmi"),
            result.getString("motivoContin"),
            result.getString("numeroControl"),
            result.getString("tipoContingencia"),
            result.getString("tipoDte"),
            result.getInt("tipoModelo"),
            result.getString("tipoMoneda"),
            result.getInt("tipoOperacion"),
            result.getInt("version")
        );
    }
} catch (SQLException ex) {
    System.out.println("Error al obtener datos de identificación: " + ex);
    JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
}

return identificacion;
}
    
    public ClsDteEmisor obtenerEmisor(String codigoGeneracion) {
   ClsDteEmisor emisor = null;

   try {
      String query = "SELECT * FROM dte_emisor WHERE codigoGeneracion = ?";
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setString(1, codigoGeneracion);
      ResultSet result = statement.executeQuery();

      if (result.next()) {
         ClsDireccion direccion = new ClsDireccion(
            result.getString("complemento"),
            result.getString("departamento"),
            result.getString("municipio")
         );

         emisor = new ClsDteEmisor(
            result.getString("codActividad"),
            result.getString("codEstable"),
            result.getString("codEstableMH"),
            result.getString("codPuntoVenta"),
            result.getString("codPuntoVentaMH"),
            result.getString("correo"),
            result.getString("descActividad"),
            result.getString("nit"),
            result.getString("nombre"),
            result.getString("nombreComercial"),
            result.getString("nrc"),
            result.getString("telefono"),
            result.getString("tipoEstablecimiento"),
            direccion
         );
      }
   } catch (SQLException ex) {
      System.out.println("Error al obtener datos del emisor: " + ex);
      JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
   }

   return emisor;
}
    
   public ClsDteReceptor obtenerReceptor(String codigoGeneracion) {
    ClsDteReceptor receptor = null;

    try {
        String query = "SELECT * FROM dte_receptor WHERE codigoGeneracion = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, codigoGeneracion);
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            ClsDireccion direccion = new ClsDireccion(
                result.getString("complemento"),
                result.getString("departamento"),
                result.getString("municipio")
            );

            receptor = new ClsDteReceptor(
                result.getString("codActividad"),
                result.getString("correo"),
                result.getString("descActividad"),
                result.getString("nit"),
                result.getString("nombre"),
                result.getString("nombreComercial"),
                result.getString("nrc"),
                result.getString("telefono"),
                direccion
            );
        }
    } catch (SQLException ex) {
        System.out.println("Error al obtener datos del receptor: " + ex);
        JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
    }

    return receptor;
}
   
  public List<ClsDteDocumento> obtenerCuerpo(String codigoGeneracion) {
    List<ClsDteDocumento> listaCuerpo = new ArrayList<>();

    try {
        String query = "SELECT * FROM dte_cuerpo WHERE codigoGeneracion = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, codigoGeneracion);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            ClsDteDocumento cuerpo = new ClsDteDocumento(
                result.getInt("cantidad"),
                result.getString("codTributo"),
                result.getString("codigo"),
                result.getString("descripcion"),
                result.getDouble("montoDescu"),
                result.getDouble("noGravado"),
                result.getInt("numItem"),
                result.getString("numeroDocumento"),
                result.getDouble("precioUni"),
                result.getDouble("psv"),
                result.getInt("tipoItem"),
                result.getInt("uniMedida"),
                result.getDouble("ventaExenta"),
                result.getDouble("ventaGravada"),
                result.getDouble("ventaNoSuj"),
                Arrays.asList(result.getString("tributos").split(","))
            );
            listaCuerpo.add(cuerpo);
        }
    } catch (SQLException ex) {
        System.out.println("Error al obtener datos del cuerpo del documento: " + ex);
        JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
    }

    return listaCuerpo;
}
  public List<ClsDtttributo> obtenerTributos(String codigoGeneracion) {
    List<ClsDtttributo> listaTributos = new ArrayList<>();

    try {
        String query = "SELECT * FROM dte_tributo WHERE codigoGeneracion = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, codigoGeneracion);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            ClsDtttributo tributo = new ClsDtttributo(
                result.getString("codigoTributo"),
               result.getString("descripcion"),
                    result.getDouble("valor")
            );
            listaTributos.add(tributo);
        }
    } catch (SQLException ex) {
        System.out.println("Error al obtener datos de los tributos: " + ex);
        JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
    }

    return listaTributos;
}
  
  public List<ClsDtepago> obtenerPagos(String codigoGeneracion) {
    List<ClsDtepago> listaPagos = new ArrayList<>();

    try {
        String query = "SELECT * FROM dte_pagos WHERE codigoGeneracion = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, codigoGeneracion);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            ClsDtepago pago = new ClsDtepago(
                result.getString("codigo"),
                result.getDouble("montoPago"),
                result.getInt("periodo"),
                result.getString("plazo"),
                result.getString("referencia")
            );
            listaPagos.add(pago);
        }
    } catch (SQLException ex) {
        System.out.println("Error al obtener datos de los pagos: " + ex);
        JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
    }

    return listaPagos;
}
  
public List<ClsDteExtension> obtenerExtensiones(String codigoGeneracion) {
    List<ClsDteExtension> listaExtensiones = new ArrayList<>();

    try {
        String query = "SELECT * FROM dte_extension WHERE codigoGeneracion = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, codigoGeneracion);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            String docuEntrega = result.getString("docuEntrega");
            String docuRecibe = result.getString("docuRecibe");
            String nombEntrega = result.getString("nombEntrega");
            String nombRecibe = result.getString("nombRecibe");
            String observaciones = result.getString("observaciones");
            String placaVehiculo = result.getString("placaVehiculo");
            ClsDteExtension extension = new ClsDteExtension(docuEntrega, docuRecibe, nombEntrega, nombRecibe, observaciones, placaVehiculo);
            listaExtensiones.add(extension);
        }
    } catch (SQLException ex) {
        System.out.println("Error al obtener datos de las extensiones: " + ex);
        JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
    }

    return listaExtensiones;
}




  
  
  public ClsDteresumen obtenerResumen(String codigoGeneracion) {
    ClsDteresumen resumen = null;
    String query = "SELECT * FROM dte_resumen WHERE codigoGeneracion = ?";

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, codigoGeneracion);
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            resumen = new ClsDteresumen(
                result.getInt("condicionOperacion"),
                result.getDouble("descuExenta"),
                result.getDouble("descuGravada"),
                result.getDouble("descuNoSuj"),
                result.getDouble("ivaPerci1"),
                result.getDouble("ivaRete1"),
                result.getDouble("montoTotalOperacion"),
                result.getString("numPagoElectronico"),
                result.getDouble("porcentajeDescuento"),
                result.getDouble("reteRenta"),
                result.getDouble("saldoFavor"),
                result.getDouble("subTotal"),
                result.getDouble("subTotalVentas"),
                result.getDouble("totalDescu"),
                result.getDouble("totalExenta"),
                result.getDouble("totalGravada"),
                result.getString("totalLetras"),
                result.getDouble("totalNoGravado"),
                result.getDouble("totalNoSuj"),
                result.getDouble("totalPagar"),
                null, // Tributos
                null  // Pagos
            );
        }

    } catch (SQLException ex) {
        System.out.println("Error al obtener datos de resumen: " + ex);
        JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
    }

    return resumen;
}








    
}
