
package Archivio;

/**
 *
 * @author sala.stefano
 */
public class Questionario {

    private int numeroQuest;
    private int numeroDomande;
    private double costo;

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
        return "Questionario{" + "numeroQuest=" + numeroQuest + ", numeroDomande=" + numeroDomande + ", costo=" + costo + '}';
    }
   
}
