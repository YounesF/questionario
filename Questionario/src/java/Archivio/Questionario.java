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

    @Override
    public String toString() {
        return "Questionario{" + "domanda=" + domanda + ", risposte=" + risposte.toString() + '}';
    }
    
    
    
}
