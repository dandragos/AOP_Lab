package Jucatori;

public class Jucator {
    private String nume;
    private String nationalitate;
    private int pozitieATP;
    private int puncteATP;
    private int rTurneeATP;

    public Jucator(String nume, String nationalitate, int pozitieATP, int puncteATP, int rTurneeATP) {
        this.nume = nume;
        this.nationalitate = nationalitate;
        this.pozitieATP = pozitieATP;
        this.puncteATP = puncteATP;
        this.rTurneeATP = rTurneeATP;
    }

    public String getNationalitate() {
        return nationalitate;
    }

    public Integer getPuncte(){
        return puncteATP;
    }
    public Integer getrTurneeATP(){
        return rTurneeATP;
    }

    public String getNume(){
        return nume;
    }
}
