package Controlador;

import Modelo.Modelo;
import Vista.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Emiliano Contreras Gamboa
 */
public class Controlador implements ActionListener {

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
        } else {
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
}
