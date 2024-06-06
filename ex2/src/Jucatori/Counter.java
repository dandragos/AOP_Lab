package Jucatori;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter implements Runnable {

    public String numefisier;

    public String nationalitate;

    public AtomicInteger counter;

    public Counter(String numefisier, String nationalitate, AtomicInteger counter) {
        this.numefisier = numefisier;
        this.nationalitate = nationalitate;
        this.counter = counter;
    }


    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(numefisier))){
            String linie;
            while ((linie = br.readLine()) != null){
                String parti[] = linie.split(",");

                if (parti.length==5){
                    Jucator jucator = new Jucator(parti[0], parti[1], Integer.parseInt(parti[2]), Integer.parseInt(parti[3]), Integer.parseInt(parti[4]));
                    if (jucator.getNationalitate().equalsIgnoreCase(nationalitate)){counter.incrementAndGet();}
                }
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}

