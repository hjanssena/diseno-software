package MVC;

import Controlador.Controlador;
import Modelo.Paciente;
import Vista.VistaPrincipal;

/**
 *
 * @author Emiliano Contreras Gamboa
 */
public class mainMVC {

    public static void main(String[] args) {
        Paciente modelo = new Paciente();
        VistaPrincipal vista = new VistaPrincipal();
        Controlador controlador = new Controlador(vista, modelo);
        controlador.iniciar();
        vista.setVisible(true);
    }
}
