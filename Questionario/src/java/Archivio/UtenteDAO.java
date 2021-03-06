    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivio;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author sala.stefano
 */
public class UtenteDAO {
    
    static Connection conn;
    static PreparedStatement pst;
    
    //Inserisce l'utente nel database
    public static void insertUtente(Utente u){
        
        try{
            conn = PostgreSQLJDBC.getConn();
            pst = conn.prepareStatement("INSERT INTO utente VALUES (?, ?, ?, ?, ?, ?)");
            pst.setString(1, u.getNome());
            pst.setString(2, u.getCognome());
            pst.setInt(3, u.getCellulare());
            pst.setString(4, u.getEmail());
            pst.setDate(5, ConvertDate.convertJavaDateToSqlDate(u.getData()));
            pst.setString(6, u.getPassword());
            pst.executeUpdate();
            conn.close();   
        }
        
        catch(Exception e){
            System.out.println(e);
        }
    }
    
 
}


