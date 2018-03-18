/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ceriani.gabriele
 */
public class QuestionarioDAO {
    static Connection conn;
    static PreparedStatement pst;
    public static void insertQuestionario(Questionario q){
        
        try{    
            conn = PostgreSQLJDBC.getConn();
            pst = conn.prepareStatement("INSERT INTO questionario(numerodomande,numeroquestionari,costo) VALUES (?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, q.getNumeroDomande());
            pst.setInt(2, q.getNumeroQuest());
            pst.setDouble(3, q.getCosto());
            pst.executeUpdate();
            ResultSet tableKeys = pst.getGeneratedKeys();
            tableKeys.next();
            int autoGeneratedID1 = tableKeys.getInt(1);
            
            /*pst = conn.prepareStatement("INSERT INTO domanda (testodomanda, id_questionario) VALUES (?, ?)",Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, q.getDomanda());
            pst.setInt(2, Statement.RETURN_GENERATED_KEYS);
            pst.executeUpdate();
            
            ResultSet rs = pst.getGeneratedKeys();
            rs.next();
            int autoGeneratedID2 = rs.getInt(1);
            if (rs.next()){
                rs.getInt(1);
            }*/
            conn.close();   
        }
        
        catch(Exception e){
            System.out.println(e);
        }
    }
}
