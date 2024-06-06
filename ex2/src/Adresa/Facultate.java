package Adresa;

import java.util.List;

public class Facultate {

    private final String denumire;

    private final int numarstudenti;

    private final List<String> specializari;

    private final Adresa adresa;

    public Facultate(String denumire, int numarstudenti, List<String> specializari, Adresa adresa){
        this.denumire = denumire;
        this.numarstudenti=numarstudenti;
        this.specializari=specializari;
        this.adresa=adresa;

    }
}
