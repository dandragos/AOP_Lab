package Adresa;

public class Adresa {

    public String strada;
    public String localitate;
    public String tara;

    public Integer numar;

    public Adresa (String strada, String localitate, String tara){
        this.strada=strada;
        this.localitate=localitate;
        this.tara = tara;
    }

    public String getStrada() {
        return strada;
    }

    public Integer getNumar() {
        return numar;
    }

    public String getLocalitate() {
        return localitate;
    }

    public String getTara() {
        return tara;
    }


}
