package test2.pr3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter implements Runnable {

    public String numefisier;

    public String tipAsigurare;

    public AtomicInteger counter;


    public Counter(String numefisier, String tipAsigurare, AtomicInteger counter) {
        this.numefisier = numefisier;
        this.tipAsigurare = tipAsigurare;
        this.counter = counter;
    }

    public AtomicInteger getCounter() {
        return counter;
    }

    public String getNumefisier() {
        return numefisier;
    }

    public String getTipAsigurare() {
        return tipAsigurare;
    }


    @Override
    public void run() {

        try (BufferedReader br = new BufferedReader(new FileReader(numefisier))) {

            String linie;

            while ((linie = br.readLine()) != null) {
                String parti[] = linie.split(",");

                if (parti.length == 4) {
                    Asigurare asigurare = new Asigurare(parti[0], parti[1], Integer.parseInt(parti[2]), parti[3]);
                    if (asigurare.getTip().equalsIgnoreCase(tipAsigurare)) {
                        counter.addAndGet(asigurare.getValoare());
                    }
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
