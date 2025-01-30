package MVC;

import Controlador.Controlador;
import Modelo.Modelo;
import Vista.VistaPrincipal;


/**
 *
 * @author Emiliano Contreras Gamboa
 */
public class mainMVC {

    public static void main(String[] args){
        Modelo modelo = new Modelo();
        VistaPrincipal vista = new VistaPrincipal();
        Controlador controlador = new Controlador(vista, modelo);
          
        controlador.iniciar();
        vista.setVisible(true);
    }
}
