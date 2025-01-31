package Database;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author janss
 */
public class Credenciales {
    
    private String usr;
    private String pass;
    private String url;
    
    
    public Credenciales(){
        ArrayList con = new ArrayList();
        String dir = System.getProperty("user.dir");
        try {
            Scanner scanner = new Scanner(new File(dir + "\\src\\Database\\Credenciales.txt"));  
            while (scanner.hasNextLine()) {        
                String linea = scanner.nextLine();
                String[] partes = linea.split(","); 
                if (partes.length > 1) {
                    con.add(partes[1].trim());
                }
            }
            scanner.close(); 
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado.");
        }
        url = (String) con.get(0);
        usr = (String) con.get(1);
        pass = (String) con.get(2);
    }
        
    public String getUsr() {
        return usr;
    }

    public String getPass() {
        return pass;
    }

    public String getUrl() {
        return url;
    }
}
