package Modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
            FileReader archivo = new FileReader( dir + "\\Credenciales.txt"); 
            System.out.println(archivo);
            BufferedReader scanner = new BufferedReader(archivo);
            String linea;  
            while ((linea = scanner.readLine())!= null) {          
                String[] partes = linea.split(","); 
                if (partes.length > 1) {
                con.add(partes[1].trim());
                }
            }
            scanner.close(); 
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado.");
        } catch (IOException ex) {
            
        }
        url = (String) con.get(0);
        usr = (String) con.get(1);
        pass = (String) con.get(2);
    }
        
    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
