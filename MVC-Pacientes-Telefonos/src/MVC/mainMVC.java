package MVC;

import Controlador.Controlador;
import Modelo.ListaPacientes;
import Vista.VistaPrincipal;

/**
 *
 * @author Emiliano Contreras Gamboa
 */
public class mainMVC {

    public static void main(String[] args) {
        ListaPacientes listaPacientes = new ListaPacientes();
        VistaPrincipal vista = new VistaPrincipal();
        Controlador controlador = new Controlador();
        controlador.iniciar();
        vista.setVisible(true);
    }
}
