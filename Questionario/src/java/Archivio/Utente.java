package Archivio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Utente implements Serializable {
    
    private String nome;
    private String cognome;
    private int cellulare;
    private String email;
    private Date dataNascita;
    private String password;

    public Utente(String nome, String cognome, int cellulare, String password, String email, Date dataNascita ) {
        this.nome = nome;
        this.cognome = cognome;
        this.cellulare = cellulare;
        this.password = password;
        this.email = email;
        this.dataNascita = dataNascita;
        
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

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Utente{" + "nome=" + nome + ", cognome=" + cognome + ", cellulare=" + cellulare + ", email=" + email + ", dataNascita=" + dataNascita + ", password=" + password + '}';
    }

    
}
