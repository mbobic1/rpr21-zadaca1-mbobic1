package ba.unsa.etf.rpr;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Kviz {
    private String naziv;
    private SistemBodovanja sistemBodovanja;
    private final ArrayList<Pitanje> pitanja;

    public Kviz(String naziv1, SistemBodovanja bodovanje1){
        this.naziv=naziv1;
        this.sistemBodovanja=bodovanje1;
        pitanja=new ArrayList<>();
    }
    public String getNaziv(){
        return naziv;
    }
    public SistemBodovanja getSistemBodovanja(){
        return sistemBodovanja;
    }
    public ArrayList<Pitanje> getPitanja(){
        return pitanja;
    }
    public void setNaziv(String naziv1){
        this.naziv=naziv1;
    }
    public void setSistemBodovanja(SistemBodovanja sistemBodovanja1){
        this.sistemBodovanja=sistemBodovanja1;
    }
    public void dodajPitanje(Pitanje pitanje1){
        for(Pitanje p : pitanja) {
            if (p.getTekst().equalsIgnoreCase(pitanje1.getTekst())) {
                throw new IllegalArgumentException("Ne možete dodati pitanje sa tekstom koji već postoji");
            }
        }
            pitanja.add(pitanje1);
    }
    @Override
    public String toString(){
        StringBuilder ispis=new StringBuilder("Kviz "+naziv+" boduje se "+sistemBodovanja.getBodovanje()+". Pitanja:\n");
        int i=1;
        for(Pitanje p: pitanja){
            ispis.append(i);
            ispis.append(". ");
            ispis.append(p.getTekst());
            ispis.append("(").append(p.getBrojPoena()).append("b)");
            HashMap<String,Odgovor> odg=p.getOdgovori();
            for(String s : odg.keySet()){
                ispis.append("\n\t").append(s).append(": ").append(odg.get(s).getTekstOdgovora());
                if(odg.get(s).isTacno()) ispis.append("(T)");
            }
            i++;
            ispis.append("\n\n");
        }
        return  ispis.toString();
    }
    public RezultatKviza predajKviz(Map<Pitanje,ArrayList<String>> zaokruzeni){
        RezultatKviza rez=new RezultatKviza(this);
        HashMap<Pitanje, Double> mapa=new HashMap<>();
        double suma=0;
        for(Pitanje p : zaokruzeni.keySet()){
            double bodovi;
            ArrayList<String> odogovor=zaokruzeni.get(p);
            bodovi=p.izracunajPoene(odogovor,sistemBodovanja);
            suma=suma+bodovi;
            mapa.put(p,bodovi);
        }
        if(pitanja.size()!=mapa.size()){
            for(Pitanje p : pitanja){
                if(!(mapa.containsKey(p))){
                    mapa.put(p,(double) 0);
                }
            }
        }
        rez.setBodovi(mapa);
        rez.setTotal(suma);
        return rez;
    }



}
