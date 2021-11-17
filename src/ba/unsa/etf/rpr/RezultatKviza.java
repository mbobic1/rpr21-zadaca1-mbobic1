package ba.unsa.etf.rpr;

import java.util.Map;

public class RezultatKviza {
    private final Kviz kviz;
    private double total;
    private Map<Pitanje, Double> bodovi;


    public RezultatKviza(Kviz kviz1) {
        this.kviz=kviz1;
        this.total=0;
    }
    public double getTotal() {
        return total;
    }
    public Kviz getKviz() {
        return kviz;
    }
    public Map<Pitanje, Double> getBodovi(){
        return bodovi;
    }
    public void setTotal(double total1){
        this.total=total1;
    }
    public void setBodovi(Map<Pitanje, Double>bodovi1){
        this.bodovi=bodovi1;
    }
    @Override
    public String toString(){
        StringBuilder ispis=new StringBuilder("Na kvizu \""+kviz.getNaziv()+"\" ostvarili ste ukupno "+total+" poena. Raspored po pitanjima:\n");
        for(Pitanje p : bodovi.keySet()){
            ispis.append(p.getTekst()).append(" - ").append(bodovi.get(p)).append("b\n");
        }
        return ispis.toString();
    }
}
