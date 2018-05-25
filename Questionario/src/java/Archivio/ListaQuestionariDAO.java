/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivio;

import static Archivio.DomandaDAO.st;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ListaQuestionariDAO {
    static Connection conn;
    static PreparedStatement pst;
    static ResultSet rs;
    static ResultSet rs2;
    static Statement st;
    static ArrayList<Questionario> lista = new ArrayList<Questionario>(); 

    
    public static ArrayList<Questionario> lista(){
        
        try{    
            conn = PostgreSQLJDBC.getConn();
            String query = "SELECT * FROM questionario q";
            //pst.setInt(1, currentQuest.getId());
            st = conn.createStatement();
            rs = st.executeQuery(query);
            rs.next();
            
            while(rs.next()){
                Questionario quest = new Questionario();
                quest.setId(rs.getInt(1));
                quest.setNumeroDomande(rs.getInt(2));
                quest.setNome(rs.getString(4));
                
                System.out.println(quest.toString());
                
                lista.add(quest); 
            }
            
            conn.close();   
        }
        
        catch(Exception e){
            System.out.println(e);
        }
        return lista;
    }
    
}

