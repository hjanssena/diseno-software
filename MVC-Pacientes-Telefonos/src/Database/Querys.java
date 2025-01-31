package Database;

import Modelo.Paciente;
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
    
    public void insertarNuevoPaciente(String nombre, String telefono){
        Conexion con = new Conexion();
        try{
            Statement stmt = con.getStatement();
            stmt.executeQuery(String.format(
                    "INSERT INTO \"Pacientes\" (\"nombre\", \"telefono\") VALUES (\"%s\",\"%s\")", 
                    nombre, telefono));
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void eliminarPaciente(int id){
        
    }
    
    public void actualizarPaciente(int id, String nombre, String telefono){
        
    }
}
