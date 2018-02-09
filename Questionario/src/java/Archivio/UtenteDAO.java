    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivio;
import java.sql.*;
/**
 *
 * @author sala.stefano
 */
public class UtenteDAO {
    
    static Connection conn;
    static PreparedStatement pst;
    
    public static void insertUtente(Utente u){
        
        try{
            conn = PostgreSQLJDBC.getConn();
            pst = conn.prepareStatement("INSERT INTO utente VALUES (?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, u.getNome());
            pst.setString(2, u.getCognome());
            pst.setString(3, Integer.toString(u.getCellulare()));
            pst.setString(4, u.getEmail());
            pst.setString(5, u.getData());
            pst.setString(6, u.getPassword());
            pst.executeUpdate();
            conn.close();   
        }
        
        catch(Exception e){
            System.out.println(e);
        }
    }
    
 
}


