/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivio;

import java.util.ArrayList;

/**
 *
 * @author ceriani.gabriele
 */
public class Questionario {
    
    private String domanda;
    private ArrayList<String> risposte;
    private int numeroQuest;
    private int numeroDomande;
    private double costo;

    public Questionario() {
        risposte = new ArrayList<String>();
    }

    public String getDomanda() {
        return domanda;
    }

    public void setDomanda(String domanda) {
        this.domanda = domanda;
    }

    public ArrayList<String> getRisposte() {
        return risposte;
    }

    public void setRisposte(ArrayList<String> risposte) {
        this.risposte = risposte;
    }

    public int getNumeroQuest() {
        return numeroQuest;
    }

    public void setNumeroQuest(int numeroQuest) {
        this.numeroQuest = numeroQuest;
    }
    
    public int getNumeroDomande() {
        return numeroDomande;
    }
    
    public void setNumeroDomande(int numeroDomande) {
        this.numeroDomande = numeroDomande;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    public void calcolaCosto(int numDomande){
        double costo = 0.0;
        if(numDomande <= 10)
            costo = 0.10 * numDomande;
        if(numDomande > 10 && numDomande <= 20)
            costo = 0.20 * numDomande;
        else
            costo = 0.30 * numDomande;   
        
        setCosto(costo);
    }
    
    @Override
    public String toString() {
        return "Questionario{" + "domanda=" + domanda + ", risposte=" + risposte + ", numeroQuest=" + numeroQuest + ", numeroDomande=" + numeroDomande + ", costo=" + costo + '}';
    }
    
}
