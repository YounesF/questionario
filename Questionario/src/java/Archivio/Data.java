/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivio;

/**
 *
 * @author Ste
 */
public class Data {
    private int giorno;
    private int mese;
    private int anno;

    public Data(int giorno, int mese, int anno) {
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
    }

    
    public int getGiorno() {
        return giorno;
    }

    public int getMese() {
        return mese;
    }

    public int getAnno() {
        return anno;
    }
    
    String conversione(){
        String s = new String();
        s="";
        s=s.concat(Integer.toString(giorno));
        s=s.concat("/");
        s=s.concat(Integer.toString(mese));
        s=s.concat("/");
        s=s.concat(Integer.toString(anno));
        return s;
    }
}
