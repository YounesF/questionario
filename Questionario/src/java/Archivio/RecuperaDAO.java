/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivio;
import static Archivio.DomandaDAO.conn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ejb.EJB;

/**
 *
 * @author sala.stefano
 */


public class RecuperaDAO {
    
    
    public static String password;
    
    public static String recupera(Utente u) throws SQLException{
        try{
            conn = PostgreSQLJDBC.getConn();
            Statement st=conn.createStatement();
            String email=u.getEmail();
            String query = "SELECT password FROM utente where email='"+email+"'";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            
            password = rs.getString(1);
            
            
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        return password;
    }
    
}
