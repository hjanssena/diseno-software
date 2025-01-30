/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author edwin
 */
public class Conexion {
    
    public ArrayList<String> credenciales(){
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
        return con;
    }
    
    public Connection conection(ArrayList con) {
        Connection conection = null;     
        String link = (String) con.get(0);
        String user = (String) con.get(1);
        String psw = (String) con.get(2);
        try{
            conection = DriverManager.getConnection(link,user,psw);
        }catch(SQLException e){
            System.out.println("Se cayo el sistema");
        }
        return conection;
    }
    
    public void close(Connection conection){
        try {
            conection.close();
        } catch (SQLException ex) {
            System.out.println("Se cerro");
        }
    }
}
