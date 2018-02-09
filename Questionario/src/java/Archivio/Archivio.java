/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivio;

import java.util.ArrayList;

/**
 *
 * @author youne
 */
public class Archivio {
    
    /* public ArrayList<Persona> persone;

    public Archivio(ArrayList<Persona> persone) {
        this.persone = persone;
    }
     
      public Archivio(){
        persone = new ArrayList();
        persone.add(new Persona("A1","A1","A1","A1","A1@A1.it"));
        persone.add(new Persona("B1","B1","B1","B1","B1@B1.it"));
      }
    
      public boolean isPersona(Persona p){ 
        for(Persona pe: persone){ 
            if(pe.equals(p))
                return true; 
        } 
        return false; 
    }
      
    public void aggiungi (Persona p){
        persone.add(p);
    }
    
    public String lista(){
        String s = new String();
        s="";
        for (Persona pe: persone){
            s=s.concat(pe.toString());
            s=s.concat("\n <br>");
        }
        return s;
    }
    
    public boolean isUserIDTaken(String userID){
        for (Persona pe: persone){
            if(pe.getUserid().equals(userID)){
                return true;
            }
        }
        return false;
    }
    
    public boolean isEmailTaken(String email){
        for (Persona pe: persone){
            if(pe.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
  */    
}
