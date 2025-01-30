
package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablaGUI extends JFrame {
    
    
    private JTable tablaConDatos;
    private DefaultTableModel modeloDeLaTabla;
    private JPanel panelPrincipal;
    private JScrollPane panelConLaTabla;
    private Object[] nombres = {"Nombres","Telefonos"};
    private Object[][] datos = {}; 
    
    public TablaGUI(){
        super("Tabla con datos");
         
        panelPrincipal = new JPanel();
        panelPrincipal.setSize(400,400);
        
        modeloDeLaTabla = new DefaultTableModel(datos, nombres);
        tablaConDatos = new JTable(modeloDeLaTabla);
        
        panelConLaTabla = new  JScrollPane(tablaConDatos);
        
        panelPrincipal.add(panelConLaTabla);
        
        add(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        
        pack();
        setLocationRelativeTo(null);
        
    }
    
    public void setDatosEnLaTabla(Object[][] datosNuevos) {
        // Limpiar los datos anteriores
        modeloDeLaTabla.setRowCount(0);
        
        // Agregar los nuevos datos
        for (Object[] fila : datosNuevos) {
            modeloDeLaTabla.addRow(fila);
        }
    }
}
