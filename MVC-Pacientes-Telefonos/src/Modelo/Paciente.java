package Modelo;

/**
 *
 * @author Emiliano Contreras Gamboa
 */
public class Paciente {
    
    private int id;
    private String nombre;
    private String telefono;
    
    public Paciente(String nombre, String telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    public Paciente(int id, String nombre, String telefono){
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public int getId(){
        return id;
    }
}
