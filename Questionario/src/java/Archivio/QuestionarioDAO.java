
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
    public static void insertQuestionario(Questionario q){
        
        try{    
            conn = PostgreSQLJDBC.getConn();
            pst = conn.prepareStatement("INSERT INTO questionario(numerodomande,numeroquestionari,costo) VALUES (?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, q.getNumeroDomande());
            pst.setInt(2, q.getNumeroQuest());
            pst.setDouble(3, q.getCosto());
            pst.executeUpdate();
            conn.close();
        }
        
        catch(Exception e){
            System.out.println(e);
        }
    }
}
