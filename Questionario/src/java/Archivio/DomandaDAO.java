package Archivio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DomandaDAO {
    static Connection conn;
    static PreparedStatement pst;
    public static void insertDomanda(Domanda d){
        
        try{    
            conn = PostgreSQLJDBC.getConn();
            /*pst = conn.prepareStatement("INSERT INTO questionario(numerodomande,numeroquestionari,costo) VALUES (?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, q.getNumeroDomande());
            pst.setInt(2, q.getNumeroQuest());
            pst.setDouble(3, q.getCosto());
            pst.executeUpdate();
            ResultSet tableKeys = pst.getGeneratedKeys();
            tableKeys.next();
            int autoGeneratedID1 = tableKeys.getInt(1);
            */
            pst = conn.prepareStatement("INSERT INTO domanda (testodomanda, id_questionario) VALUES (?, ?)",Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, d.getDomanda());
            pst.setInt(2, 2);
            pst.executeUpdate();
            
            /*ResultSet rs = pst.getGeneratedKeys();
            rs.next();
            int autoGeneratedID2 = rs.getInt(3);
            if (rs.next()){
                rs.getInt(3);
            }*/
            
            for(String s: d.getRisposte()){
                pst = conn.prepareStatement("INSERT INTO risposta (testorisposta, id_domanda) VALUES (?, ?)",Statement.RETURN_GENERATED_KEYS);
                pst.setString(1, s.toString());
                pst.setInt(2,  Statement.RETURN_GENERATED_KEYS);
                pst.executeUpdate();
            }
            ResultSet rs = pst.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()){
                generatedKey = rs.getInt("id_domanda");
            }
            
            conn.close();   
        }
        
        catch(Exception e){
            System.out.println(e);
        }
    }
}