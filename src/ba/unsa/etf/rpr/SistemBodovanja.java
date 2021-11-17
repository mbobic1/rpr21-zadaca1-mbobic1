package ba.unsa.etf.rpr;

public enum SistemBodovanja {
    BINARNO("binarno"),PARCIJALNO("parcijalno"),PARCIJALNO_SA_NEGATIVNIM("parcijalno sa negativnim bodovima");
    public final String bodovanje;
    SistemBodovanja(String bodovanje){
        this.bodovanje=bodovanje;
    }
    public String getBodovanje(){
        return bodovanje;
    }


}
