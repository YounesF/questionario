package Archivio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Utente implements Serializable {
    
    private String nome;
    private String cognome;
    private int cellulare;
    private String email;
    private String password;
    private Date data;
    private boolean valid;
    

    public Utente(String nome, String cognome, int cellulare, String email, String password, Date data) {
        this.nome = nome;
        this.cognome = cognome;
        this.cellulare = cellulare;
        this.email = email;
        this.data = data;
        this.password = password;
    }

    public Utente(){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getCellulare() {
        return cellulare;
    }

    public void setCellulare(int cellulare) {
        this.cellulare = cellulare;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
       public boolean isValid() {
         return valid;
	}

      public void setValid(boolean newValid) {
         valid = newValid;
	}	
    
 

    @Override
    public String toString() {
        return "Utente{" + "nome=" + nome + ", cognome=" + cognome + ", cellulare=" + cellulare + ", email=" + email + ", password=" + password + ", data=" + data + '}';
    }

  

    

    
}
