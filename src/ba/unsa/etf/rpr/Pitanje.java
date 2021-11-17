package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pitanje{
    private String tekst;
    private double brojPoena;
    private HashMap<String, Odgovor> odgovori;

    public Pitanje(String tekst1, double brojPoena1){
        this.tekst=tekst1;
        this.brojPoena=brojPoena1;
        this.odgovori=new HashMap<>();
    }
    public void setTekst(String tekst1){
        this.tekst=tekst1;
    }
    public void setBrojPoena(double brojPoena1){
        this.brojPoena=brojPoena1;
    }
    public void setOdgovori(HashMap<String, Odgovor> odg1){
        this.odgovori=odg1;
    }
    public HashMap<String, Odgovor> getOdgovori(){
        return odgovori;
    }
    public String getTekst(){
        return tekst;
    }
    public double getBrojPoena(){
        return brojPoena;
    }
    public void dodajOdgovor(String id, String tekst, boolean tacno){
        Odgovor odg1=new Odgovor(tekst, tacno);
        for(String i: odgovori.keySet()){
            if(i.equals(id)) throw new IllegalArgumentException("Id odgovora mora biti jedinstven");
        }
        odgovori.put(id,odg1);
    }
    public void obrisiOdgovor(String id){
        if(!odgovori.containsKey(id)) throw new IllegalArgumentException("Odgovor sa ovim id-em ne postoji");
        /*for(String i : odgovori.keySet()) {
            if (!i.equals(id)) throw new IllegalArgumentException("Odgovor sa ovim id-em ne postoji");
        }*/
        odgovori.remove(id);
    }
    public List<Odgovor> dajListuOdgovora(){
        return new ArrayList<>(odgovori.values());
    }
    public String toString(){
        StringBuilder ispis=new StringBuilder(tekst+"("+brojPoena+"b)");
        for(String i : odgovori.keySet()){
            ispis.append("\n").append(i).append(": ").append(odgovori.get(i).getTekstOdgovora());
        }
        return ispis.toString();
    }
    public double izracunajPoene(List<String> tacni, SistemBodovanja sistemBodovanja){
        boolean vrati=true;
        for(String s: tacni){
            if(!tacni.contains(s)){
                vrati=false;
                break;
            }
        }
        if(!vrati) throw new IllegalArgumentException("Odabran je nepostojeci odgovor");
        return 0;

    }

}
