package Modelo;

import java.sql.*;


/**
 *
 * @author Emiliano Contreras Gamboa
 */
public class Querys {

    private Connection conexion;

    public Querys(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para ejecutar una consulta SELECT y devolver un ResultSet
    public ResultSet hacerConsulta(String query) {
        ResultSet rs = null;
        try {
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(query); // Ejecutar la consulta
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}
