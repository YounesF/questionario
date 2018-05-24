package Archivio;

public class Questionario {

    private String nome;
    private int numeroDomande;
    private double costo;
    private String email;
    private int id;
    private int frequenzaSic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Questionario() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void DomandaInserita(){
        this.numeroDomande = this.numeroDomande - 1;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getFrequenzaSic() {
        return frequenzaSic;
    }

    public void setFrequenzaSic(int frequenzaSic) {
        this.frequenzaSic = frequenzaSic;
    }

    @Override
    public String toString() {
        return "Questionario{" + "nome=" + nome + ", numeroDomande=" + numeroDomande + ", costo=" + costo + ", email=" + email + ", id=" + id + ", frequenzaSic=" + frequenzaSic + '}';
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

}
