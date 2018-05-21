package Archivio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RisposteUtenteDAO {
    static Connection conn;
    static PreparedStatement pst;
    static ResultSet rs;
    static Statement st;
    public static void insertDomanda(ArrayList<Domanda> risposte,int idQuestionario, String email){
        
        try{    
            conn = PostgreSQLJDBC.getConn();
            for(Domanda r: risposte){
                    for(String s: r.getRisposte()){
                        pst = conn.prepareStatement("INSERT INTO rispostedate (testorisposta, id_questionario, id_domanda, id_utente) VALUES (?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
                        pst.setString(1, s.toString());
                        pst.setInt(2, idQuestionario);
                        pst.setInt(3, r.getIdDomanda());
                        pst.setString(4, email);
                        pst.executeUpdate();
                    }
                
            }
            conn.close();
     
        }
        catch(Exception e){
            System.out.println(e);
        }   
    }
}
