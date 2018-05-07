package Archivio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VisualizzaDAO {
    static Connection conn;
    static PreparedStatement pst;
    static ResultSet rs;
    static Statement st;
    
    public static void insertDomanda(Questionario currentQuest, ArrayList<Domanda> questionarioVisual){
        
        try{    
            conn = PostgreSQLJDBC.getConn();
            String query = "SELECT iddomanda,testodomanda,aperta,multipla,idrisposta,testorisposta FROM domanda JOIN risposta ON domanda.iddomanda=risposta.id_domanda WHERE id_questionario = 17 GROUP BY iddomanda,idrisposta ORDER BY iddomanda";
            //pst.setInt(1, currentQuest.getId());
            rs = pst.executeQuery(query);
            rs.next();
            int iddomanda;
            
            for(int i = 0; i < currentQuest.getNumeroDomande(); i++){
                try{
                    iddomanda = rs.getInt("iddomanda");
                    Domanda d = new Domanda();
                    d.setDomanda(rs.getString("testodomanda"));
                    while(iddomanda == rs.getInt("iddomanda")){
                        if(!rs.getBoolean("aperta")){ 
                            d.getRisposte().add((rs.getString("testorisposta")));
                            rs.next();
                        }
                    }
                    questionarioVisual.add(d);
                    System.out.println(d);
                }
                catch(NullPointerException e){
                }
                i++;
            }
            conn.close();   
        }
        
        catch(Exception e){
            System.out.println(e);
        }
    }

}
