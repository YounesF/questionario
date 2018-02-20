/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivio;

/**
 *
 * @author youne
 */
import java.text.*;
   import java.util.*;
   import java.sql.*;

   public class LoginDAO 	
   {
      static Connection currentCon = null;
      static ResultSet rs = null;  
	
	
	
      public static Utente login(Utente bean) {
	
         //preparing some objects for connection 
         Statement stmt = null;    
	
         String email = bean.getEmail();    
         String password = bean.getPassword();   
	    
         String searchQuery =
               "select * from utente where email='" + email + "' AND password='"  + password  + "'";
	    
      // "System.out.println" prints in the console; Normally used to trace the process
      System.out.println("Your user name is " + email);          
      System.out.println("Your password is " + password);
      System.out.println("Query: "+searchQuery);
	    
      try 
      {
         //connect to DB 
         currentCon = PostgreSQLJDBC.getConn();
         stmt=currentCon.createStatement();
         rs = stmt.executeQuery(searchQuery);	        
         boolean more = rs.next();
	       
         // if user does not exist set the isValid variable to false
         if (!more) 
         {
            System.out.println("Sorry, you are not a registered user! Please sign up first");
            bean.setValid(false);
         } 
	        
         //if user exists set the isValid variable to true
         else if (more) 
         {
            String firstName = rs.getString("nome");
            String lastName = rs.getString("cognome");
	     	
            System.out.println("Welcome " + firstName);
            bean.setNome(firstName);
            bean.setCognome(lastName);
            bean.setValid(true);
         }
      } 

      catch (Exception ex) 
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
      } 
	    
      //some exception handling
      finally 
      {
         if (rs != null)	{
            try {
               rs.close();
            } catch (Exception e) {}
               rs = null;
            }
	
         if (stmt != null) {
            try {
               stmt.close();
            } catch (Exception e) {}
               stmt = null;
            }
	
         if (currentCon != null) {
            try {
               currentCon.close();
            } catch (Exception e) {
            }

            currentCon = null;
         }
      }

return bean;
	
      }	
   }
