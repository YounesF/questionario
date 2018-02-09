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
    
    public static void insertUtente(Utente p){
        
        try{
            System.out.println(2);
            conn = PostgreSQLJDBC.getConn();
            pst = conn.prepareStatement("INSERT INTO utente VALUES (?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, p.getNome());
            pst.setString(2, p.getCognome());
            pst.setString(3, Integer.toString(p.getCellulare()));
            pst.setString(4, p.getEmail());
            pst.setString(5, ConvertDate.convertStringToDate(p.getDataNascita()));
            pst.setString(6, p.getPassword());
            pst.executeUpdate();
            conn.close();   
            System.out.println(3);
        }
        
        catch(Exception e){
            System.out.println(e);
        }
    }
    
 
}


