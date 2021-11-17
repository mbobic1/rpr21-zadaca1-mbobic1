package ba.unsa.etf.rpr;


import java.util.ArrayList;

public class Kviz {
    private String naziv;
    private SistemBodovanja sistemBodovanja;
    private ArrayList<Pitanje> pitanja;

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
    public void setPitanja(ArrayList<Pitanje> pitanja1){
        this.pitanja=pitanja1;
    }
    public void dodajPitanje(Pitanje pitanje1){
        for(Pitanje p : pitanja){
            if(p.getTekst().equalsIgnoreCase(pitanje1.getTekst()))
                throw new IllegalArgumentException("Ne možete dodati pitanje sa tekstom koji već postoji");

            pitanja.add(pitanje1);
        }
    }
    @Override
    public String toString(){
        StringBuilder ispis=new StringBuilder("Kviz "+naziv+" boduje se "+sistemBodovanja.getBodovanje()+".\n Pitanja:\n");
        int i=1;
        for(Pitanje p: pitanja){
            ispis.append(i);
            ispis.append(p.getTekst());

        }
        return  ispis.toString();
    }



}
