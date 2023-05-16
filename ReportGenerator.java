/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import Conexion.ClsConexionLocal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ReportGenerator {
      private final Connection connection = new ClsConexionLocal().getConection();
      
       public List<DataRow> generateReportData(LocalDate fecha_ini, LocalDate fecha_fin, int idproveedor) {
        List<DataRow> dataRows = new ArrayList<>();

        String sql = "SELECT p.codigo, SUM(ROUND(dv.tcan, 2)) AS unidades, dv.nombreproducto, IFNULL(p.Producto_ultima_med, 1) AS fracc, ROUND(SUM(dv.total), 2), ROUND(SUM((dv.tcan)) / (IFNULL(p.Producto_ultima_med, 1)), 1) AS st, po.nombre, po.nombre AS proveedor " +
                "FROM detalleventa AS dv " +
                "INNER JOIN producto AS p ON p.idproducto = dv.idproducto " +
                "INNER JOIN venta AS v ON v.venta_idcaja = dv.idventa " +
                "INNER JOIN proveedor AS po ON p.idproveedor = po.idproveedor " +
                "WHERE (v.estado = 'EMITIDO') AND (p.idproveedor = ? AND v.fecha BETWEEN ? AND ?) " +
                "GROUP BY p.idproducto " +
                "ORDER BY dv.nombreproducto ASC";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idproveedor);
            ps.setDate(2, Date.valueOf(fecha_ini));
            ps.setDate(3, Date.valueOf(fecha_fin));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DataRow row = new DataRow(
                        rs.getString("codigo"),
                        rs.getDouble("unidades"),
                        rs.getString("nombreproducto"),
                        rs.getInt("fracc"),
                        rs.getDouble(5),
                        rs.getDouble("st"),
                        rs.getString("nombre"),
                        rs.getString("proveedor")
                );
                dataRows.add(row);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return dataRows;
    }

    // Clase DataRow para almacenar los datos de una fila de la consulta
    public static class DataRow {
        private String codigo;
        private double unidades;
        private String nombreProducto;
        private int fracc;
        private double total;
        private double st;
        private String nombre;
        private String proveedor;

        public DataRow(String codigo, double unidades, String nombreProducto, int fracc, double total, double st, String nombre, String proveedor) {
            this.codigo = codigo;
            this.unidades = unidades;
            this.nombreProducto = nombreProducto;
            this.fracc = fracc;
            this.total = total;
            this.st = st;
            this.nombre = nombre;
            this.proveedor = proveedor;
        }

        // Getters y setters para los campos
    }
    
}
