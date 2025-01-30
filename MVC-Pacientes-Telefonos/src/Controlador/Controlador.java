package Controlador;

import Modelo.*;
import Vista.*;
import Vista.VistaPrincipal;
import com.sun.jdi.connect.spi.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;




public class Controlador implements ActionListener {


    //************************************ */
    
    private Conexion conexion;
    private Querys querys;

    public Controlador() {
        this.conexion = new Conexion();
        ArrayList<String> credenciales = conexion.credenciales();
        Connection con = (Connection) conexion.conection(credenciales);
        this.querys = new Querys((java.sql.Connection) con);
    }

    public ResultSet obtenerDatos(String consulta) {
        return querys.hacerConsulta(consulta);
    }

    public Object[][] procesarDatos(ResultSet rs) {
        ArrayList<String[]> datos = new ArrayList<>();
        try {
            while (rs.next()) {
                String[] fila = new String[rs.getMetaData().getColumnCount()];
                for (int i = 0; i < fila.length; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                datos.add(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datos.toArray(new Object[0][]);
    }
    
    /*
    public List<Modelo> obtenerPacientes() throws SQLException {
        List<Modelo> pacientes = new ArrayList<>();
        //ResultSet resultSet asignar con funcion emiliano
        Querys qr = new Querys(cn); 
        ResultSet rs = qr.hacerConsulta("nombre, telefono");

        try {
            
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            String telefono = rs.getString("telefono");
            Modelo paciente = new Modelo (nombre, telefono);
            pacientes.add(paciente);
        }
        
        //Convertir lista de pacientes a arreglo de dos dimensiones (Nombre, telefono).
        return pacientes;
    }
    */
    
    
    //************************************ */

    private VistaPrincipal v_view;
    private Modelo m_modelo;

    public Controlador(VistaPrincipal view, Modelo modelo) {
        v_view = view;
        m_modelo = modelo;
        
        view.btnGuardar.addActionListener(this);
        view.btnLimpiar.addActionListener(this);
        view.getBtnTabla().addActionListener(this);
    }

    public void iniciar(){
        v_view.setTitle("Registro");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == v_view.btnGuardar) {
            String nombre = v_view.txtNombre.getText().trim();
            String telefono = v_view.txtTel.getText().trim();

            if (validarNombre(nombre) && validarTelefono(telefono)) {
                m_modelo.setNombre(nombre);
                m_modelo.setTelefono(telefono);
                JOptionPane.showMessageDialog(v_view,
                        "Datos guardados correctamente:\nNombre: " + m_modelo.getNombre() + "\nTeléfono: " + m_modelo.getTelefono()
                );
            } else {
                JOptionPane.showMessageDialog(v_view,
                        "Datos inválidos. Verifica que:\n- El nombre contenga solo letras.\n- El teléfono sea numérico y válido.",
                        "Error de validación", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == v_view.btnLimpiar) {
            limpiarCampos();
        }
        else {
            v_view.getVentanConTabla().setDatosEnLaTabla(new Object[][] {});
            v_view.getVentanConTabla().setVisible(true);
        }
    }

    private boolean validarNombre(String nombre) {
        return nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
    }

    private boolean validarTelefono(String telefono) {
        return telefono.matches("\\d{10}");
    }

    private void limpiarCampos() {
        v_view.txtNombre.setText("");
        v_view.txtTel.setText("");
    }
    
    //************************************** */

}
