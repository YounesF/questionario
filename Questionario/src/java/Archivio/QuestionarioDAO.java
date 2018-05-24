
package Archivio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sala.stefano
 */
public class QuestionarioDAO {
    
    static Connection conn;
    static PreparedStatement pst;
    static ResultSet rs;
    static Statement st;
    static int id;
    public static int insertQuestionario(Questionario q){
        
        try{    
            conn = PostgreSQLJDBC.getConn();
            pst = conn.prepareStatement("INSERT INTO questionario(numerodomande,costo,nome,utente_email,frequenza_sicurezza) VALUES (?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, q.getNumeroDomande());
            pst.setDouble(2, q.getCosto());
            pst.setString(3, q.getNome());
            pst.setString(4, q.getEmail());
            pst.setInt(5, q.getFrequenzaSic());
            pst.executeUpdate();
            
            String query = "SELECT idquestionario FROM questionario ORDER BY idquestionario DESC LIMIT 1"; 
            st = conn.createStatement();
            rs = st.executeQuery(query);
            rs.next();
            id = rs.getInt(1);
            
            conn.close();      
        }
        
        catch(Exception e){
            System.out.println(e);
        }
        return id;
    }
}
