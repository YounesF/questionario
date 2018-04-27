package Archivio;

import java.util.ArrayList;

public class Domanda {
    
    private String domanda;
    private ArrayList<String> risposte;
    private int id_questionario;
    private boolean multipla;

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

    public int getId_questionario() {
        return id_questionario;
    }

    public void setId_questionario(int id_questionario) {
        this.id_questionario = id_questionario;
    }

    public boolean isMultipla() {
        return multipla;
    }

   

    public void setMultipla(boolean multipla) {
        this.multipla = multipla;
    }

    @Override
    public String toString() {
        return "Domanda{" + "domanda=" + domanda + ", risposte=" + risposte + ", id_questionario=" + id_questionario + ", multipla=" + multipla + '}';
    }

   
    
}
