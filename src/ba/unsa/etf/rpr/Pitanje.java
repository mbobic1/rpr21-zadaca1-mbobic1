package ba.unsa.etf.rpr;

import java.util.*;

public class Pitanje{
    private String tekst;
    private double brojPoena;
    private final HashMap<String, Odgovor> odgovori;

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
        if(!odgovori.containsKey(id)) throw new IllegalArgumentException("Odgovor s ovim id-em ne postoji");
        odgovori.remove(id);
    }
    public List<Odgovor> dajListuOdgovora(){
        return new ArrayList<Odgovor>(odgovori.values());
    }

    public String toString(){
        StringBuilder ispis=new StringBuilder(tekst+"("+brojPoena+"b)");
        for(String i : odgovori.keySet()){
            ispis.append("\n\t").append(i).append(": ").append(odgovori.get(i).getTekstOdgovora());
        }
        return ispis.toString();
    }
    public double izracunajPoene(List<String> tacni, SistemBodovanja sistemBodovanja1){
        boolean vrati=true;
        for(String s: tacni){
            if(!odgovori.containsKey(s)){
                vrati=false;
                break;
            }
        }
        if(!vrati) throw new IllegalArgumentException("Odabran je nepostojeći odgovor");
        Set<String> duplikati=new HashSet<>(tacni);
        if(duplikati.size()!= tacni.size()) throw new IllegalArgumentException("Postoje duplikati među odabranim odgovorima");
        int brojTacnih=0, brojOdgovora=0,zaokruzeni=0;
        boolean netacni=false;
        for(String s : tacni){
            if(!odgovori.get(s).isTacno()) netacni=true;
            if(odgovori.get(s).isTacno()) zaokruzeni=zaokruzeni+1;
        }
        for(Odgovor s : odgovori.values()){
            if(s.isTacno())
                brojTacnih=brojTacnih+1;
            brojOdgovora=brojOdgovora+1;
        }
        if(sistemBodovanja1.name().equals("BINARNO")){
            if(brojTacnih==zaokruzeni) return brojPoena;
            if(netacni) return 0;
        }
        if(sistemBodovanja1.name().equals("PARCIJALNO")){
            if(brojTacnih==zaokruzeni) return brojPoena;
            if(netacni) return 0;
            return (brojTacnih/brojOdgovora)*zaokruzeni;


        }
        if(sistemBodovanja1.name().equals("PARCIJALNO_SA_NEGATIVNIM")){
            if(brojTacnih==zaokruzeni) return brojPoena;
            else if(netacni){
                double vrati1=((-1.)*brojPoena)/2;
                return vrati1;
            }
            else return (brojTacnih/brojOdgovora)*zaokruzeni;
        }

        return 0;


    }

}
