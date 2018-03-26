package Archivio;

import java.util.ArrayList;

public class Domanda {
    
    private String domanda;
    private ArrayList<String> risposte;

    public Domanda() {
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

    @Override
    public String toString() {
        return "Domanda{" + "domanda=" + domanda + ", risposte=" + risposte + '}';
    }


    
}
