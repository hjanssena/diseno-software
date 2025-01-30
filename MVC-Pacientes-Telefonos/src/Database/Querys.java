package Database;

import java.sql.*;


/**
 *
 * @author Emiliano Contreras Gamboa
 */
public class Querys {

    // Método para ejecutar una consulta SELECT y devolver un ResultSet
    public ResultSet consultarListaPacientes() {
        Conexion con = new Conexion();
        ResultSet rs = null;
        try {
            Statement stmt = con.getStatement();
            rs = stmt.executeQuery("SELECT * FROM Pacientes"); // Ejecutar la consulta
        } catch (SQLException e) {
            e.printStackTrace();
        }
        con.close();
        return rs;
    }
}
