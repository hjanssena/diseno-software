/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edwin
 */
public class Conexion {
    
    private Connection con;
    
    public Conexion() {     
        Credenciales credenciales = new Credenciales();
        
        try{
            con = DriverManager.getConnection(credenciales.getUrl(),credenciales.getUsr(),credenciales.getPass());
        }catch(SQLException e){
            System.out.println("Se cayo el sistema");
        }
    }
    
    public void close(){
        try {
            this.con.close();
        } catch (SQLException ex) {
            System.out.println("Se cerro");
        }
    }
    
    public Statement getStatement(){
        Statement stmnt = null;
        try {
            stmnt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stmnt;
    }
}
