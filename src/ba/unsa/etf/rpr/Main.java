package ba.unsa.etf.rpr;

import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void igrajKviz(Kviz kviz){
        ArrayList<Pitanje> pitanja=kviz.getPitanja();
        System.out.println(kviz.toString());
        Map<Pitanje, ArrayList<String>> zaokruzeniOdgovori = new HashMap<>();
        zaokruzeniOdgovori.put(pitanja.get(0), new ArrayList<>(List.of("a", "c", "b"))); //3
        zaokruzeniOdgovori.put(pitanja.get(1), new ArrayList<>(List.of("c"))); //0
        zaokruzeniOdgovori.put(pitanja.get(2), new ArrayList<>(List.of("b")));

        RezultatKviza rez= kviz.predajKviz(zaokruzeniOdgovori);
        System.out.println(rez);
    }

    public static void main(String[] args) {
        Kviz kviz;
        List<Pitanje> pitanja;
        Pitanje pitanje1=new Pitanje("Koliko je poena trica?", 2);
        pitanje1.dodajOdgovor("a","dva", false);
        pitanje1.dodajOdgovor("b", "jedan", false);
        pitanje1.dodajOdgovor("c", "tri", true);

        Pitanje pitanje2=new Pitanje("Kad je neradni dan?", 2);
        pitanje2.dodajOdgovor("a", "25.11", true);
        pitanje2.dodajOdgovor("b", "24.11", false);
        pitanje2.dodajOdgovor("c", "26.11", true);

        Pitanje pitanje3=new Pitanje("Ko zeli biti milioner?", 2);
        pitanje3.dodajOdgovor("a", "ti", true);
        pitanje3.dodajOdgovor("b", "mi", true);

        pitanja=new ArrayList<>();
        pitanja.add(pitanje1);
        pitanja.add(pitanje2);
        pitanja.add(pitanje3);

        kviz=new Kviz("Provjera znanja", SistemBodovanja.PARCIJALNO);
        pitanja.forEach(kviz::dodajPitanje);
        pitanja.get(0).setBrojPoena(2);
        pitanja.get(1).setBrojPoena(2);
        pitanja.get(2).setBrojPoena(2);

        igrajKviz(kviz);
    }
}
