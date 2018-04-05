package Archivio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DomandaDAO {
    static Connection conn;
    static PreparedStatement pst;
    static ResultSet rs;
    static Statement st;
    public static void insertDomanda(Domanda d){
        
        try{    
            conn = PostgreSQLJDBC.getConn();
            pst = conn.prepareStatement("INSERT INTO domanda (testodomanda, id_questionario) VALUES (?, ?)",Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, d.getDomanda());
            pst.setInt(2, 2);
            pst.executeUpdate();
            
            //Prende ultimo id di domanda
            String query = "SELECT iddomanda FROM domanda ORDER BY iddomanda DESC LIMIT 1"; 
            st = conn.createStatement();
            rs = st.executeQuery(query);
            rs.next();
            int id = rs.getInt(1);
            
            for(String s: d.getRisposte()){
                pst = conn.prepareStatement("INSERT INTO risposta (testorisposta, id_domanda) VALUES (?, ?)",Statement.RETURN_GENERATED_KEYS);
                pst.setString(1, s.toString());
                pst.setInt(2, id);
                pst.executeUpdate();
            }
            conn.close();   
        }
        
        catch(Exception e){
            System.out.println(e);
        }
    }
}
