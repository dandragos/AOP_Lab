package test2.pr2;

public class Asigurare {

    public String tip;

    public String titular;

    public int valoare;

    public String localitate;

    public Asigurare(String tip, String titular, Integer valoare, String localitate){
        this.tip = tip;
        this.titular=titular;
        this.valoare=valoare;
        this.localitate=localitate;
    }

    public String getLocalitate() {
        return localitate;
    }

    public int getValoare() {
        return valoare;
    }

    public String getTip() {
        return tip;
    }

    public String getTitular() {
        return titular;
    }

    @Override
    public String toString() {
        return "Asigurare{" +
                "tip='" + tip + '\'' +
                ", titular='" + titular + '\'' +
                ", valoare=" + valoare +
                ", localitate='" + localitate + '\'' +
                '}';
    }
}
