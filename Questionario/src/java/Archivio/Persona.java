package Archivio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Objects;

public class Persona {
    
    private String nome;
    private String cognome;
    private String userid;
    private String password;
    private String email;

    public Persona(String nome, String cognome, String userid, String password, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.userid = userid;
        this.password = password;
        this.email = email;
    }
    
    public Persona(){
        
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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Socio{" + "nome=" + nome + ", cognome=" + cognome + ", userid=" + userid + ", password=" + password + ", email=" + email +'}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.userid, other.userid)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    public void set(String nome, String cognome, String password, String email){
            this.setNome(nome);
            this.setCognome(cognome);
            this.setPassword(password);
            this.setEmail(email);
    }
    
    
    
}
