/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivio;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
            pst = conn.prepareStatement("INSERT INTO domanda (testodomanda) VALUES (?)");
            pst.setString(1, q.getDomanda());
            pst.executeUpdate();
            conn.close();   
        }
        
        catch(Exception e){
            System.out.println(e);
        }
    }
}
