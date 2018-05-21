package Archivio;

import java.util.ArrayList;

public class Domanda {
    
    private String domanda;
    private int idDomanda;
    private ArrayList<String> risposte;
    private boolean noRisposte;
    private int id_questionario;
    private boolean multipla;
    private boolean aperta;

    public boolean isNoRisposte() {
        return noRisposte;
    }

    public void setNoRisposte(boolean noRisposte) {
        this.noRisposte = noRisposte;
    }
    

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

    public int getIdDomanda() {
        return idDomanda;
    }

    public void setIdDomanda(int idDomanda) {
        this.idDomanda = idDomanda;
    }

    public boolean isAperta() {
        return aperta;
    }

    public void setAperta(boolean aperta) {
        this.aperta = aperta;
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
        return "Domanda{" + "domanda=" + domanda + ", idDomanda=" + idDomanda + ", risposte=" + risposte + ", noRisposte=" + noRisposte + ", id_questionario=" + id_questionario + ", multipla=" + multipla + ", aperta=" + aperta + '}';
    }

    


    
}
