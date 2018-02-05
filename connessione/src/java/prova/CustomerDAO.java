    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova;
import java.sql.*;
/**
 *
 * @author sala.stefano
 */
public class CustomerDAO {
    
    static Connection conn;
    static PreparedStatement pst;
    
    public static void insertCustomer(CustomerBean u){
        
        try{
            System.out.println(2);
            conn = PostgreSQLJDBC.getConn();
            pst = conn.prepareStatement("INSERT INTO utente VALUES (?, ?, 44, 'werwesdfr','11/11/2011','pasdfwss',121)");
            pst.setString(1, u.getNome());
            pst.setString(2, u.getCognome());
            pst.executeUpdate();
            conn.close();   
            System.out.println(3);
        }
        
        catch(Exception e){
            System.out.println(e);
        }
    }
}
