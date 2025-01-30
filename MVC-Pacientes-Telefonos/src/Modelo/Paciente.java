

package Modelo;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Emiliano Contreras Gamboa
 */
public class Paciente {
    
    protected String nombre;
    protected String telefono;
    
    public Paciente(String nombre, String telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
