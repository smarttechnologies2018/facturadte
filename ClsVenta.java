package Negocio;

import Conexion.*;
import Entidad.*;
import ds.desktop.notify.DesktopNotify;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import org.checkerframework.checker.units.qual.Time;

public class ClsVenta {

    private final Connection connection = new ClsConexionLocal().getConection();

    public void agregarVenta(ClsEntidadVenta Venta) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Venta(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidtipodocumento", Venta.getStrIdTipoDocumento());
            statement.setString("pidcliente", Venta.getStrIdCliente());
            statement.setString("pidempleado", Venta.getStrIdEmpleado());
            statement.setString("pidcaja", Venta.getStrIdCaja());
            statement.setString("pserie", Venta.getStrSerieVenta());
            statement.setString("pnumero", Venta.getStrNumeroVenta());
            statement.setDate("pfecha", new java.sql.Date(Venta.getStrFechaVenta().getTime()));
            statement.setString("ptotalventa", Venta.getStrTotalVenta());
            statement.setString("pdescuento", Venta.getStrDescuentoVenta());
            statement.setString("psubtotal", Venta.getStrSubTotalVenta());
            statement.setString("pigv", Venta.getStrIgvVenta());
            statement.setString("ptotalpagar", Venta.getStrTotalPagarVenta());
            statement.setString("pestado", Venta.getStrEstadoVenta());
            statement.setString("pimporte", Venta.getStrImporteVenta());
            statement.setString("pcambio", Venta.getStrCambioVenta());
            statement.setString("ptipotrans", Venta.getStrTipoTrans());
            statement.setString("pcortex", Venta.getStrCortex());
            statement.setString("pcortez", Venta.getStrCortez());
            statement.setString("pValorLetra", Venta.getStrValorEnLetras());
            statement.setString("pRetencion", Venta.getStrRetencion());
            statement.setString("pPersepcion", Venta.getStrPersepcion());
            statement.setString("pEstado_Cuenta", Venta.getStrEstado_Cuenta());
            statement.setString("pTipoVenta", Venta.getStrTipoVenta());
            statement.setString("pIdEmpresa", Venta.getStrIdEmpresa());
            statement.setString("pid_ventacaja", Venta.getStrVenta_idcaja());

            statement.setString("pidcuenta", Venta.getStrIdCuenta());

            statement.execute();

//            connection.close();
        } catch (SQLException ex) {
            System.out.println("error f culeros agregando venta" + ex);
            JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);

        }
    }
    
    public void agregarTributos(List<ClsDtttributo> tributos, String codigoGeneracion) {
    String query = "INSERT ignore  INTO dte_tributo  (codigoTributo, descripcion, valor, codigoGeneracion) VALUES (?, ?, ?, ?)";

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        for (ClsDtttributo tributo : tributos) {
            statement.setString(1, tributo.getCodigo());
            statement.setString(2, tributo.getDescripcion());
            statement.setDouble(3, tributo.getValor());
            statement.setString(4, codigoGeneracion);

            statement.addBatch();
        }

        int[] rowsInserted = statement.executeBatch();
        System.out.println("Filas insertadas en la tabla dte_tributos: " + rowsInserted.length);

    } catch (SQLException ex) {
        System.out.println("Error al insertar datos de tributos: " + ex);
        JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
    }
}
    
    public void eliminarTributos(String codigoGeneracion, String codtributo) {
    String query = "DELETE FROM dte_tributo WHERE codigoGeneracion = ? and codigoTributo=?";

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, codigoGeneracion);
         statement.setString(2, codtributo);

        int rowsDeleted = statement.executeUpdate();

        System.out.println("Filas eliminadas en la tabla dte_tributos: " + rowsDeleted);

    } catch (SQLException ex) {
        System.out.println("Error al eliminar datos de tributos: " + ex);
        JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
    }
}

    
    

    public void agregarResumen(ClsDteresumen resumen, String codigoGeneracion) {
    String query = "INSERT INTO dte_resumen (condicionOperacion, descuExenta, descuGravada, descuNoSuj, ivaPerci1, ivaRete1,"
            + " montoTotalOperacion, numPagoElectronico, porcentajeDescuento, reteRenta, saldoFavor, subTotal, subTotalVentas,"
            + " totalDescu, totalExenta, totalGravada, totalLetras, totalNoGravado, totalNoSuj, totalPagar,codigoGeneracion) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, resumen.getCondicionOperacion());
        statement.setDouble(2, resumen.getDescuExenta());
        statement.setDouble(3, resumen.getDescuGravada());
        statement.setDouble(4, resumen.getDescuNoSuj());
        statement.setDouble(5, resumen.getIvaPerci1());
        statement.setDouble(6, resumen.getIvaRete1());
        statement.setDouble(7, resumen.getMontoTotalOperacion());
        statement.setString(8, resumen.getNumPagoElectronico());
        statement.setDouble(9, resumen.getPorcentajeDescuento());
        statement.setDouble(10, resumen.getReteRenta());
        statement.setDouble(11, resumen.getSaldoFavor());
        statement.setDouble(12, resumen.getSubTotal());
        statement.setDouble(13, resumen.getSubTotalVentas());
        statement.setDouble(14, resumen.getTotalDescu());
        statement.setDouble(15, resumen.getTotalExenta());
        statement.setDouble(16, resumen.getTotalGravada());
        statement.setString(17, resumen.getTotalLetras());
        statement.setDouble(18, resumen.getTotalNoGravado());
        statement.setDouble(19, resumen.getTotalNoSuj());
        statement.setDouble(20, resumen.getTotalPagar());
        statement.setString(21, codigoGeneracion);

        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("Datos de resumen insertados correctamente");
        }

    } catch (SQLException ex) {
        System.out.println("Error al insertar datos de resumen: " + ex);
        JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
    }
}

    
    public void agregarPago(ClsDtepago pago, String codigoGeneracion) {
    String query = "INSERT ignore INTO dte_pagos (codigo, montoPago, periodo, plazo, referencia, codigoGeneracion) VALUES (?, ?, ?, ?, ?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, pago.getCodigo());
        statement.setFloat(2, (float) pago.getMontoPago());
        statement.setInt(3, pago.getPeriodo());
        statement.setString(4, pago.getPlazo());
        statement.setString(5, pago.getReferencia());
        statement.setString(6, codigoGeneracion);

        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("Datos de pago insertados correctamente");
        }

    } catch (SQLException ex) {
        System.out.println("Error al insertar datos de pago: " + ex);
        JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
    }
}
    
    public void eliminarpago(ClsDtepago pago, String codigoGeneracion) {
    String query = "delete from  dte_pagos where codigo=? and codigogeneracion=?";
    try {
        connection.setAutoCommit(false); // Inicia una transacción
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, pago.getCodigo());
        statement.setString(2, codigoGeneracion);
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Datos de pago eliminados correctamente");
        }
        connection.commit(); // Confirma la transacción
    } catch (SQLException ex) {
        try {
            connection.rollback(); // Anula la transacción si hay un error
        } catch (SQLException ex2) {
            System.out.println("Error al anular la transacción: " + ex2);
        }
        System.out.println("Error al eliminar datos de pago: " + ex);
        JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
    } finally {
        try {
            connection.setAutoCommit(true); // Restaura el modo de auto-commit
        } catch (SQLException ex) {
            System.out.println("Error al restaurar el modo de auto-commit: " + ex);
        }
    }
}


    public void agregarExtension(ClsDteExtension extension, String codigoGeneracion) {
    String query = "INSERT ignore INTO dte_extension (docuEntrega, docuRecibe, nombEntrega, nombRecibe, observaciones, placaVehiculo, codigoGeneracion) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, extension.getDocuEntrega());
        statement.setString(2, extension.getDocuRecibe());
        statement.setString(3, extension.getNombEntrega());
        statement.setString(4, extension.getNombRecibe());
        statement.setString(5, extension.getObservaciones());
        statement.setString(6, extension.getPlacaVehiculo());
        statement.setString(7, codigoGeneracion);

        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("Datos de extensión de documento insertados correctamente");
        }

    } catch (SQLException ex) {
        System.out.println("Error al insertar datos de extensión de documento: " + ex);
        JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
    }
}

    
    public void agregarDteIdentificacion(ClsDtefactura factura) {
        
         ClsDteitentificacion identificacion = factura.getIdentificacion();

    String query = "INSERT ignore INTO dte_Identificacion "
             + "(codigoGeneracion, ambiente, fecEmi, horEmi, motivoContin, numeroControl, tipoContingencia, tipoDte, tipoModelo, tipoMoneda, tipoOperacion, version) "
             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        
        statement.setString(1, identificacion.getCodigoGeneracion());
        statement.setString(2, identificacion.getAmbiente());
        
        statement.setString(3,identificacion.getFecEmi());
        statement.setString(4, (identificacion.getHorEmi()));
        statement.setString(5, identificacion.getMotivoContin());
        statement.setString(6, identificacion.getNumeroControl());
        statement.setString(7, identificacion.getTipoContingencia());
        statement.setString(8, identificacion.getTipoDte());
        statement.setInt(9, identificacion.getTipoModelo());
        statement.setString(10, identificacion.getTipoMoneda());
        statement.setInt(11, identificacion.getTipoOperacion());
        statement.setInt(12, identificacion.getVersion());

        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("Datos de DTE_Identificacion insertados correctamente");
        }

    } catch (SQLException ex) {
        System.out.println("error al insertar datos en DTE_Identificacion: " + ex);
        JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
    }
    }
    
    public void agregarEmisor(ClsDteEmisor emisor,String Id) {
    ClsDireccion direccion = emisor.getDireccion();
    String query = "INSERT ignore INTO dte_emisor (codActividad, codEstable, codEstableMH"
            + ", codPuntoVenta, codPuntoVentaMH, correo, descActividad, nit, nombre"
            + ", nombreComercial, nrc, telefono, tipoEstablecimiento, complemento"
            + ", departamento, municipio,codigoGeneracion) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, emisor.getCodActividad());
        statement.setString(2, emisor.getCodEstable());
        statement.setString(3, emisor.getCodEstableMH());
        statement.setString(4, emisor.getCodPuntoVenta());
        statement.setString(5, emisor.getCodPuntoVentaMH());
        statement.setString(6, emisor.getCorreo());
        statement.setString(7, emisor.getDescActividad());
        statement.setString(8, emisor.getNit());
        statement.setString(9, emisor.getNombre());
        statement.setString(10, emisor.getNombreComercial());
        statement.setString(11, emisor.getNrc());
        statement.setString(12, emisor.getTelefono());
        statement.setString(13, emisor.getTipoEstablecimiento());
        statement.setString(14, direccion.getComplemento());
        statement.setString(15, direccion.getDepartamento());
        statement.setString(16, direccion.getMunicipio());
        statement.setString(17, Id);

        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("Datos de emisor insertados correctamente");
        }

    } catch (SQLException ex) {
        System.out.println("Error al insertar datos de emisor: " + ex);
        JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
    }
}
    public void agregarReceptor(ClsDteReceptor receptor, String codigoGeneracion) {
    ClsDireccion direccion = receptor.getDireccion();
    String query = "INSERT ignore INTO dte_receptor (codActividad, correo, descActividad,"
            + " nit, nombre, nombreComercial, nrc, telefono, complemento,"
            + " departamento, municipio, codigoGeneracion)"
            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, receptor.getCodActividad());
        statement.setString(2, receptor.getCorreo());
        statement.setString(3, receptor.getDescActividad());
        statement.setString(4, receptor.getNit());
        statement.setString(5, receptor.getNombre());
        statement.setString(6, receptor.getNombreComercial());
        statement.setString(7, receptor.getNrc());
        statement.setString(8, receptor.getTelefono());
        statement.setString(9, direccion.getComplemento());
        statement.setString(10, direccion.getDepartamento());
        statement.setString(11, direccion.getMunicipio());
        statement.setString(12, codigoGeneracion);

        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("Datos de receptor insertados correctamente");
        }

    } catch (SQLException ex) {
        System.out.println("Error al insertar datos de receptor: " + ex);
        JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
    }
}



    public void agregarVentaZeus(ClsEntidadVenta Venta, String uuid) {
    try {
        CallableStatement statement = connection.prepareCall("{call SP_I_VentaZeus(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        statement.setString("pidtipodocumento", Venta.getStrIdTipoDocumento());
        statement.setString("pidcliente", Venta.getStrIdCliente());
        statement.setString("pidempleado", Venta.getStrIdEmpleado());
        statement.setString("pidcaja", Venta.getStrIdCaja());
        statement.setString("pserie", Venta.getStrSerieVenta());
        statement.setString("pnumero", Venta.getStrNumeroVenta());
        statement.setDate("pfecha", new java.sql.Date(Venta.getStrFechaVenta().getTime()));
        statement.setString("ptotalventa", Venta.getStrTotalPagarVenta());
        statement.setString("pdescuento", Venta.getStrDescuentoVenta());
        statement.setString("psubtotal", Venta.getStrSubTotalVenta());
        statement.setString("pobservacion", Venta.getStrObservacion());
        statement.setString("pigv", Venta.getStrIgvVenta());
        statement.setString("ptotalpagar", Venta.getStrTotalPagarVenta());
        statement.setString("pestado", Venta.getStrEstadoVenta());
        statement.setString("pimporte", Venta.getStrImporteVenta());
        statement.setString("pcambio", Venta.getStrCambioVenta());
        statement.setString("ptipotrans", Venta.getStrTipoTrans());
        statement.setString("pcortex", Venta.getStrCortex());
        statement.setString("pcortez", Venta.getStrCortez());
        statement.setString("pValorLetra", Venta.getStrValorEnLetras());
        statement.setString("pRetencion", Venta.getStrRetencion());
        statement.setString("pPersepcion", Venta.getStrPersepcion());
        statement.setString("pEstado_Cuenta", Venta.getStrEstado_Cuenta());
        statement.setString("pTipoVenta", Venta.getStrTipoVenta());
        statement.setString("pIdEmpresa", Venta.getStrIdEmpresa());
        statement.setString("pid_ventacaja", Venta.getStrVenta_idcaja());
        statement.setString("pidcuenta", Venta.getStrIdCuenta());
        statement.setString("pexenta", Venta.getStrExenta());
        statement.setString("pnosujeta", Venta.getStrnosujeta());
        statement.setString("pfovial", Venta.getStrFovial());
        statement.setString("pcotrans", Venta.getStrCotrans());
        statement.setString("pefectivo", Venta.getStrefectivo());
        statement.setString("ptarjeta", Venta.getStrtarjeta());
        statement.setString("pcheque", Venta.getStrCheque());
        statement.setString("puuid", uuid);
        statement.execute();
    } catch (SQLException ex) {
        System.out.println("error f culeros agregando venta Zeus" + ex);
        JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);
    }
}

    
      public void agregarVentaZeus2(ClsEntidadVenta Venta) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_VentaZeus2(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidtipodocumento", Venta.getStrIdTipoDocumento());
            statement.setString("pidcliente", Venta.getStrIdCliente());
            statement.setString("pidempleado", Venta.getStrIdEmpleado());
            statement.setString("pidcaja", Venta.getStrIdCaja());
            statement.setString("pserie", Venta.getStrSerieVenta());
            statement.setString("pnumero", Venta.getStrNumeroVenta());
            statement.setDate("pfecha", new java.sql.Date(Venta.getStrFechaVenta().getTime()));
             statement.setDate("pfechacredito", new java.sql.Date(Venta.getStrFechaCredito().getTime()));
            statement.setString("ptotalventa", Venta.getStrTotalPagarVenta());
            statement.setString("pdescuento", Venta.getStrDescuentoVenta());
            statement.setString("psubtotal", Venta.getStrSubTotalVenta());
             statement.setString("pobservacion", Venta.getStrObservacion());
            
            
            
            
            
            statement.setString("pigv", Venta.getStrIgvVenta());
            statement.setString("ptotalpagar", Venta.getStrTotalPagarVenta());
            statement.setString("pestado", Venta.getStrEstadoVenta());
            statement.setString("pimporte", Venta.getStrImporteVenta());
            statement.setString("pcambio", Venta.getStrCambioVenta());
            statement.setString("ptipotrans", Venta.getStrTipoTrans());
            statement.setString("pcortex", Venta.getStrCortex());
            statement.setString("pcortez", Venta.getStrCortez());
            statement.setString("pValorLetra", Venta.getStrValorEnLetras());
            statement.setString("pRetencion", Venta.getStrRetencion());
            
            
            
            
            
            
            statement.setString("pPersepcion", Venta.getStrPersepcion());
            statement.setString("pEstado_Cuenta", Venta.getStrEstado_Cuenta());
            statement.setString("pTipoVenta", Venta.getStrTipoVenta());
            statement.setString("pIdEmpresa", Venta.getStrIdEmpresa());
            statement.setString("pid_ventacaja", Venta.getStrVenta_idcaja());
            statement.setString("pidcuenta", Venta.getStrIdCuenta());
            statement.setString("pexenta", Venta.getStrExenta());
            statement.setString("pnosujeta", Venta.getStrnosujeta());
            statement.setString("pfovial", Venta.getStrFovial());
            statement.setString("pcotrans", Venta.getStrCotrans());
            statement.setString("pefectivo", Venta.getStrefectivo());
            statement.setString("ptarjeta", Venta.getStrtarjeta());
            statement.setString("pcheque", Venta.getStrCheque());

            statement.execute();

//            connection.close();
        } catch (SQLException ex) {
            System.out.println("error f culeros agregando venta Zeus" + ex);
            JOptionPane.showMessageDialog(null, "¡ERROR!" + ex, "Mensaje del Sistema", 1);

        }
    }

    public void agregarVentaIva(ClsEntidadVenta Venta) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_VentaIVA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            statement.setString("pIdEmpresa", Venta.getStrIdEmpresa());
            statement.setString("pidtipodocumento", Venta.getStrIdTipoDocumento());
            statement.setString("pnumero", Venta.getStrNumeroVenta());
            statement.setDate("pfecha", new java.sql.Date(Venta.getStrFechaVenta().getTime()));
            statement.setString("pidcliente", Venta.getStrIdCliente());
            statement.setString("pidempleado", Venta.getStrIdEmpleado());
            statement.setString("pidcaja", Venta.getStrIdCaja());
            statement.setString("pTipoVexternInter", Venta.getStrTipoVexternInter());
            statement.setString("psubtotal", Venta.getStrSubTotalVenta());
            statement.setString("pigv", Venta.getStrIgvVenta());
            statement.setString("ptotalventa", Venta.getStrTotalVenta());
            statement.setString("ppersepcion", Venta.getStrPersepcion());
            statement.setString("pexenta", Venta.getStrExenta());
            statement.setString("ptotalpagar", Venta.getStrTotalPagarVenta());
            statement.setString("pestado", Venta.getStrEstadoVenta());
            statement.setString("ptipotrans", Venta.getStrTipoTrans());
            statement.setString("pid_ventacaja", Venta.getStrVenta_idcaja());
            DesktopNotify.showDesktopMessage("", "" + "VENTA REALIZADA", DesktopNotify.SUCCESS, 5555);
            statement.execute();
        } catch (SQLException ex) {
            System.out.println("error agregando venta" + ex);
        }
    }

    public void agregarVentaFactura(ClsEntidadVenta Venta) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_VentaFacturaZeus(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidtipodocumento", Venta.getStrIdTipoDocumento());
            statement.setString("pidcliente", Venta.getStrIdCliente());
            statement.setString("pidempleado", Venta.getStrIdEmpleado());
            statement.setString("pidcaja", Venta.getStrIdCaja());
            statement.setString("pnumero", Venta.getStrNumeroVenta());
            statement.setDate("pfecha", new java.sql.Date(Venta.getStrFechaVenta().getTime()));
            statement.setString("ptotalventa", Venta.getStrTotalVenta());
            statement.setString("psubtotal", Venta.getStrSubTotalVenta());
            statement.setString("ptotalpagar", Venta.getStrTotalPagarVenta());
            statement.setString("pIdEmpresa", Venta.getStrIdEmpresa());
            statement.setString("pid_ventacaja", Venta.getStrVenta_idcaja());
            statement.setString("pTipoVexternInter", Venta.getStrTotalPagarVenta());
            statement.setString("pigv", Venta.getStrIgvVenta());
            statement.setString("pret", Venta.getStrRetencion());
            statement.setString("pper", Venta.getStrPersepcion());
            statement.setString("pexenta", Venta.getStrExenta());
            statement.setString("pnosujeta", Venta.getStrventanosujeta());
              statement.setString("pz", Venta.getStrCortez());
              statement.setString("psalfec", Venta.getStrSalfec());
           
            statement.execute();
            DesktopNotify.showDesktopMessage("", "" + "EXITO", DesktopNotify.SUCCESS, 5555);
        } catch (SQLException ex) {
            System.out.println("error f culeros agregando venta" + ex);
              JOptionPane.showMessageDialog(null,ex);
            
        }
    }

    public void eliminarventa(String codigo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_D_venta(?)}");
            statement.setString("pidventa", codigo);
            statement.executeUpdate();
            System.out.println("venta eliminada");
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public void ActualizarStockVenta(String codigo, String documento) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_ActualizarStockVenta(?,?)}");
            statement.setString("pidventa", codigo);
            statement.setString("pTipoDocumento", documento);
            statement.executeUpdate();
            DesktopNotify.showDesktopMessage("", "" + "ACTUALIZANDO STOCK", DesktopNotify.SUCCESS, 2500);
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }

    public void ActualizarImpresion(String codigo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_ActualizarImpresion(?)}");
            statement.setString("pidventa", codigo);

            statement.executeUpdate();
            //  DesktopNotify.showDesktopMessage("", "" + "ACTUALIZANDO STOCK", DesktopNotify.SUCCESS, 2500);
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }
    
    
    
     public void ActualizarPicking(String codigo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_ActualizarPicking(?)}");
            statement.setString("pidventa", codigo);

            statement.executeUpdate();
            //  DesktopNotify.showDesktopMessage("", "" + "ACTUALIZANDO STOCK", DesktopNotify.SUCCESS, 2500);
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }
    
     public void ActualizarPickingQuitar() {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_ActualizarPickingQuitar()}");
           

            statement.executeUpdate();
            //  DesktopNotify.showDesktopMessage("", "" + "ACTUALIZANDO STOCK", DesktopNotify.SUCCESS, 2500);
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
        }
    }
    

    public void ActualizarStockAnulacion(String codigo, String documento) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_ActualizarStockAnulacion(?,?)}");
            statement.setString("pidventa", codigo);
            statement.setString("pTipoDocumento", documento);
            statement.executeUpdate();
            DesktopNotify.showDesktopMessage("", "" + "INVENTARIO ACTUALIZADO", DesktopNotify.SUCCESS, 5555);
        } catch (SQLException ex) {
            System.err.println("Error : " + ex);
            DesktopNotify.showDesktopMessage("", "" + "" + ex, DesktopNotify.FAIL, 5555);
        }
    }

    public void generarcortex(ClsEntidadVenta Venta) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Cortex(?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidtipodocumento", Venta.getStrIdTipoDocumento());
            statement.setString("pidempleado", Venta.getStrIdEmpleado());
            statement.setString("pidcaja", Venta.getStrIdCaja());
            statement.setString("pnumero", Venta.getStrNumeroVenta());
            statement.setString("pestado", Venta.getStrEstadoVenta());
            statement.setString("pcortex", Venta.getStrCortex());
            statement.setString("pcortez", Venta.getStrCortez());
            statement.setString("pIdEmpresa", Venta.getStrIdEmpresa());
            statement.setString("pid_ventacaja", Venta.getStrVenta_idcaja());
            statement.setString("pImpresion", Venta.getStrImpresion());
            statement.execute();
            DesktopNotify.showDesktopMessage("", "" + "Corte  Generado", DesktopNotify.SUCCESS, 5555);
        } catch (SQLException ex) {
            System.out.println("error f culeros " + ex);
        }
    }

    public void generarcortez(ClsEntidadVenta Venta) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_I_Cortez(?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidtipodocumento", Venta.getStrIdTipoDocumento());
            statement.setString("pidempleado", Venta.getStrIdEmpleado());
            statement.setString("pidcaja", Venta.getStrIdCaja());
            statement.setString("pnumero", Venta.getStrNumeroVenta());
            statement.setString("pestado", Venta.getStrEstadoVenta());
            statement.setString("pcortex", Venta.getStrCortex());
            statement.setString("pcortez", Venta.getStrCortez());
            statement.setString("pIdEmpresa", Venta.getStrIdEmpresa());
            statement.setString("pid_ventacaja", Venta.getStrVenta_idcaja());
            statement.setString("pImpresion", Venta.getStrImpresion());
            statement.execute();
            DesktopNotify.showDesktopMessage("", "" + "Corte Z Generado", DesktopNotify.SUCCESS, 5555);
        } catch (SQLException ex) {
            System.out.println("error f culeros " + ex);
        }
    }

    public ResultSet listarVentaPorCliente(Date fecha_ini, Date fecha_fin, String Documento, String idCliente) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_VentaPorCliente(?,?,?,?)}");
            statement.setDate("pfecha_ini", new java.sql.Date(fecha_ini.getTime()));
            statement.setDate("pfecha_fin", new java.sql.Date(fecha_fin.getTime()));
            statement.setString("pDocumento", Documento);
            statement.setString("pIdCliente", idCliente);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet ComprobarDocumento(Date fecha_ini, String Documento) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Comprobar_Venta_Factura2(?,?)}");
            statement.setDate("pfecha", new java.sql.Date(fecha_ini.getTime()));

            statement.setString("pDocumento", Documento);

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet obtenerLineasFacturas(String criterio) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_LineasFactura(?)}");
            statement.setString("pconsulta", criterio);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
           // System.out.println(SQLex);
            throw SQLex;
        }
    }

    public void modificarVenta(String codigo, ClsEntidadVenta Venta) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Venta(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            statement.setString("pidventa", codigo);
            statement.setString("pidtipodocumento", Venta.getStrIdTipoDocumento());
            statement.setString("pidcliente", Venta.getStrIdCliente());
            statement.setString("pidempleado", Venta.getStrIdEmpleado());
            statement.setString("pserie", Venta.getStrSerieVenta());
            statement.setString("pnumero", Venta.getStrNumeroVenta());
            statement.setDate("pfecha", new java.sql.Date(Venta.getStrFechaVenta().getTime()));
            statement.setString("ptotalventa", Venta.getStrTotalVenta());
            statement.setString("pdescuento", Venta.getStrDescuentoVenta());
            statement.setString("psubtotal", Venta.getStrSubTotalVenta());
            statement.setString("pigv", Venta.getStrIgvVenta());
            statement.setString("ptotalpagar", Venta.getStrTotalPagarVenta());
            statement.setString("pestado", Venta.getStrEstadoVenta());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(null, "¡Venta Actualizada!", "Mensaje del Sistema", 1);
    }

    public void eliminarcotizacion(String codigo) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Cotizacion(?)}");
            statement.setString("pid", codigo);
            statement.executeUpdate();
           
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex, "Mensaje del Sistema", 1);
        }

    }

    public ArrayList<ClsEntidadVenta> listarVenta() {
        ArrayList<ClsEntidadVenta> ventas = new ArrayList<>();
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Venta}");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClsEntidadVenta venta = new ClsEntidadVenta();
                venta.setStrIdVenta(resultSet.getString("IdVenta"));
                venta.setStrTipoDocumento(resultSet.getString("TipoDocumento"));
                venta.setStrCliente(resultSet.getString("Cliente"));
                venta.setStrEmpleado(resultSet.getString("Empleado"));
                venta.setStrSerieVenta(resultSet.getString("Serie"));
                venta.setStrNumeroVenta(resultSet.getString("Numero"));
                venta.setStrFechaVenta(resultSet.getDate("Fecha"));
                venta.setStrTotalVenta(resultSet.getString("TotalVenta"));
                venta.setStrDescuentoVenta(resultSet.getString("Descuento"));
                venta.setStrSubTotalVenta(resultSet.getString("SubTotal"));
                venta.setStrIgvVenta(resultSet.getString("Igv"));
                venta.setStrTotalPagarVenta(resultSet.getString("TotalPagar"));
                venta.setStrEstadoVenta(resultSet.getString("Estado"));
                ventas.add(venta);
            }
            return ventas;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ResultSet listarVentaPorParametro(String criterio, String busqueda) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_VentaPorParametro(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet obtenerUltimoIdVenta(String criterio) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call ultimoidventajava(?)}");
            statement.setString("pidcaja", criterio);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet Comprobar_Venta_factura(String numero, String periodo, Date fecha, int idcaja) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Comprobar_Venta_Factura(?,?,?)}");
            statement.setInt("pidcaja", idcaja);
            statement.setDate("pfecha", new java.sql.Date(fecha.getTime()));

            statement.setString("pnumero", numero);

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet verificarcorrelativo(String criterio) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ComprobarRegVenta(?)}");
            statement.setString("pcorrelativo", criterio);
            //System.out.println("comprobando");
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listarVentaPorFecha(String criterio, Date fecha) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_VentaPorFecha(?,?)}");
            statement.setString("pCriterio", criterio);
            statement.setDate("pFecha", new java.sql.Date(fecha.getTime()));
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listarVentaPorAnular(Date fecha_ini, Date fecha_fin) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_VentaPorAnular(?,?)}");
            statement.setDate("pfecha_ini", new java.sql.Date(fecha_ini.getTime()));
            statement.setDate("pfecha_fin", new java.sql.Date(fecha_fin.getTime()));
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listarVentaPorAnularXCaja(String criterio, String busqueda, Date fecha_ini, Date fecha_fin, int ID,int idsala) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_VentaPorAnularxCaja(?,?,?,?,?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            statement.setDate("pfecha_ini", new java.sql.Date(fecha_ini.getTime()));
            statement.setDate("pfecha_fin", new java.sql.Date(fecha_fin.getTime()));
            statement.setInt("pIdCaja", ID);
             statement.setInt("pidsala", idsala);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public void Enumerar_Venta_factura(String codigo, ClsEntidadVenta venta, Date fecha_ini) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Venta_Iva_Factura(?,?,?)}");

            statement.setString("pperiodo", venta.getStrSalfec());
            statement.setString("pidventa", codigo);
            statement.setDate("pfecha_ini", new java.sql.Date(fecha_ini.getTime()));
            statement.executeUpdate();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex + "actualizar venta");
        }

//        Jtconsola.append("¡Compra Actualizada!");
    }

    public void Anular_Venta_factura(String codigo, ClsEntidadVenta venta) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Anular_Venta_Factura(?)}");

            statement.setString("pidventa", codigo);
            statement.executeUpdate();
            DesktopNotify.showDesktopMessage("", "   VENTA ACTUALIZADA", DesktopNotify.SUCCESS, 5551);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex + "actualizar venta");
        }

//        Jtconsola.append("¡Compra Actualizada!");
    }

    public ResultSet listarVentafactura(String criterio, String busqueda, Date fecha_ini, Date fecha_fin, String documento) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Venta_Iva_Factura(?,?,?,?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            statement.setDate("pfecha_ini", new java.sql.Date(fecha_ini.getTime()));
            statement.setDate("pfecha_fin", new java.sql.Date(fecha_fin.getTime()));
            statement.setString("pdocumento", documento);

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listarVentaPorFechas(Date fecha_ini, Date fecha_fin) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_VentaPorFechas(?,?)}");
            statement.setDate("pfecha_ini", new java.sql.Date(fecha_ini.getTime()));
            statement.setDate("pfecha_fin", new java.sql.Date(fecha_fin.getTime()));
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listardocpendiente(String criterio, String busqueda, int sucursal) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_VerDocumentosP(?,?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            statement.setInt("psucursal", sucursal);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listarVentaPorCaja(String criterio, Date fecha, String idcaja) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_VentaPorFechaCaja(?,?,?)}");
            statement.setString("pCriterio", criterio);
            statement.setDate("pFecha", new java.sql.Date(fecha.getTime()));
            statement.setString("pIdCaja", idcaja);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public void generaranulacion(String codigo, String idventanuevo, String x, String z, String empleado) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_ActualizarVentaEstado(?,?,?,?,?)}");
            statement.setString("pidventa", codigo);
            statement.setString("pidventanuevo", idventanuevo);
            statement.setString("px", x);
            statement.setString("pz", z);
            statement.setString("pidempleado", empleado);

            statement.execute();
            DesktopNotify.showDesktopMessage("", "" + "ANULACION REALIZADA", DesktopNotify.SUCCESS, 5555);
        } catch (SQLException ex) {
            System.out.println("error f culeros " + ex);
            JOptionPane.showMessageDialog(null, ex, "Mensaje del Sistema", 1);
        }
    }

    public void actualizarDevolucion(String idcaja, String corte) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_Devolucion(?,?)}");
            statement.setString("pidcaja", idcaja);
            statement.setString("pcorte", corte);
            statement.executeUpdate();
            DesktopNotify.showDesktopMessage("", "" + "Cargando Datos", DesktopNotify.SUCCESS, 5555);
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(null, "¡error en actualizar devolucion!", "Mensaje del Sistema", 1);
        }

    }

    public void ActualizarDetalleVenta(String codigo, ClsEntidadVenta Venta) {
        try {
            CallableStatement statement = connection.prepareCall("{call SP_U_DetalleAnulacion(?)}");
            statement.setString("pidventa", codigo);

            statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        JOptionPane.showMessageDialog(null, "¡Venta Anulada!", "Mensaje del Sistema", 1);
    }

    public ResultSet listarVentaPorDetalle(String criterio, Date fechaini, Date fechafin) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_VentaPorDetalle(?,?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setDate("pfechaini", new java.sql.Date(fechaini.getTime()));
            statement.setDate("pfechafin", new java.sql.Date(fechafin.getTime()));
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet listarVentaMensual(String criterio, String fecha_ini, String fecha_fin) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_VentaMensual(?,?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pfecha_ini", fecha_ini);
            statement.setString("pfecha_fin", fecha_fin);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
    
    
    
    
    
     public ResultSet ListarVentaServicio() throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_ListarVentaServicio()}");
           
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
    
    
    
    
    
    
    
    

    public ResultSet obtenerLineasFacturas(String idpro, String cantidad) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_LineasFactura(?,?)}");
            statement.setString("pid", idpro);
            statement.setString("pcan", cantidad);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet obtenerPrecio(String idpro, String can) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Precios(?,?)}");
            statement.setString("Id", idpro);
            statement.setString("can", can);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet obtenerPreciosingrupo(String idpro, String can) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Precioscondescuento(?,?)}");
            statement.setString("Id", idpro);
            statement.setString("can", can);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }
    
      public ResultSet obtenerPreciosingrupo2(String idpro, String can) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Precioscondescuento2(?,?)}");
            statement.setString("Id", idpro);
            statement.setString("can", can);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet obtenerimpuestos(String idpro) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Impuesto_Producto(?)}");
            statement.setString("pidproducto", idpro);

            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet obtenerOferta(String idpro, String can) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_Ofertas(?,?)}");
            statement.setString("Id", idpro);
            statement.setString("can", can);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet BorrarOferta(String idofer, int idcant) throws Exception {
        ResultSet rs = null;
        try {
            CallableStatement statement = connection.prepareCall("{call SP_S_BorrarOferta(?,?)}");
            statement.setString("pcriterio", idofer);
            statement.setInt("pcriterio2", idcant);
            rs = statement.executeQuery();

            return rs;
        } catch (SQLException SQLex) {
            throw SQLex;
        }
    }

    public ResultSet ListarVentaDetalle(Date ini, Date fin) throws Exception {
        ResultSet rs = null;
        try {
            System.out.println(ini);
            System.out.println(fin);
            CallableStatement statement = connection.prepareCall("{call SP_S_VentaPorFechasEnvio(?,?)}");
            statement.setDate("pfecha_ini", new java.sql.Date(ini.getTime()));
            statement.setDate("pfecha_fin", new java.sql.Date(fin.getTime()));
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
               JOptionPane.showMessageDialog(null, SQLex);
            throw SQLex;
        }
    }

    public ResultSet ListarDetalleVentaDetalle(Date ini, Date fin) throws Exception {
        ResultSet rs = null;
        try {
            System.out.println(ini);
            System.out.println(fin);
            CallableStatement statement = connection.prepareCall("{call SP_S_DetalleVentaPorFechasEnvio(?,?)}");
            statement.setDate("pini", new java.sql.Date(ini.getTime()));
            statement.setDate("pfin", new java.sql.Date(fin.getTime()));
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException SQLex) {
               JOptionPane.showMessageDialog(null, SQLex);
            throw SQLex;
        }
    }
}
