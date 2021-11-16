package ba.unsa.etf.rpr;

import java.util.Objects;

public class Odgovor {
        private String tekstOdgovora;
        private boolean tacno;
        public Odgovor(String odgovor, boolean tacno){
            this.tekstOdgovora=odgovor;
            this.tacno=tacno;
        }
        public boolean isTacno(){
            return tacno;
        }
        public String getTekstOdgovora(){
            return tekstOdgovora;
        }

}
