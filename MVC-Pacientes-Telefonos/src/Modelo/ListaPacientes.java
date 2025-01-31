/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Database.Querys;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author janss
 */
public class ListaPacientes {
    
    public ArrayList<Paciente> obtenerPacientes() {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        Querys qr = new Querys(); 
        ResultSet rs = qr.consultarListaPacientes();
        
        try {
            while (rs.next()) {
                int id = rs.getInt("idPaciente");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                Paciente paciente = new Paciente (id, nombre, telefono);
                pacientes.add(paciente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListaPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pacientes;
    }
    
    public void insertarNuevoPaciente(Paciente paciente){
        Querys querys = new Querys();
        querys.insertarNuevoPaciente(paciente.getNombre(), paciente.getTelefono());
    }
    
    public void eliminarPaciente(Paciente paciente){
        Querys querys = new Querys();
        querys.eliminarPaciente(paciente.getId());
    }
    
    public void actualizarPaciente(Paciente paciente){
        Querys querys = new Querys();
       querys.actualizarPaciente(paciente.getId(), paciente.getNombre(), paciente.getTelefono());
    }
}