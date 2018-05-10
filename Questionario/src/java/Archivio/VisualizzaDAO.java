package Archivio;

import static Archivio.DomandaDAO.st;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VisualizzaDAO {
    static Connection conn;
    static PreparedStatement pst;
    static ResultSet rs;
    static ResultSet rs2;
    static Statement st;
    
    public static void insertDomanda(int idQuestionario, ArrayList<Domanda> questionarioVisual){
        
        try{    
            conn = PostgreSQLJDBC.getConn();
            String query = "SELECT iddomanda,testodomanda,aperta,multipla,idrisposta,testorisposta,numerodomande,idquestionario FROM domanda left JOIN risposta ON domanda.iddomanda=risposta.id_domanda Join questionario on questionario.idquestionario = domanda.id_questionario  WHERE id_questionario ="+idQuestionario+" GROUP BY iddomanda,idrisposta,idquestionario ORDER BY iddomanda";
            //pst.setInt(1, currentQuest.getId());
            st = conn.createStatement();
            rs = st.executeQuery(query);
            rs.next();
            int iddomanda;
            int iddomandaNew=0;
            int numerodomande = rs.getInt("numerodomande");
            
            
            for(int i = 0; i <= numerodomande; i++){
                try{
                    System.out.println("prova3"); 
                    iddomanda = rs.getInt("iddomanda");
                    iddomanda=iddomandaNew;
                    Domanda d = new Domanda();
                    d.setDomanda(rs.getString("testodomanda"));
                    d.setAperta(rs.getBoolean("aperta"));
                    d.setMultipla(rs.getBoolean("aperta"));
                    d.setIdDomanda(rs.getInt("iddomanda"));
                    d.setId_questionario(rs.getInt("idquestionario"));
                                   
                    while(iddomanda == iddomandaNew ){
                        if(!rs.getBoolean("aperta")){ 
                            d.getRisposte().add((rs.getString("testorisposta")));
                            System.out.println("prova");
                        }
                        if(rs.next())
                         iddomandaNew= rs.getInt("iddomanda");
                        else
                            iddomandaNew=0;
                    }
                    questionarioVisual.add(d);
                    System.out.println(d);
                }
                catch(NullPointerException e){
                    System.out.println("exception");
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
