package Jucatori;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nationalitate:");
//        String nationalitate = scanner.nextLine();
//
//        AtomicInteger counter = new AtomicInteger(0);
//
//        Thread t1 = new Thread(new Counter ("src/Jucatori/jucatori1.txt", nationalitate, counter));
//        Thread t2 = new Thread(new Counter ("src/Jucatori/jucatori2.txt", nationalitate, counter));
//
//        t1.start();
//        t2.start();
//
//        try{
//            t1.join();
//            t2.join();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//
//        System.out.println("Numarul total de jucatori cu nationalitatea " + nationalitate + " este: " + counter.get());
//

        System.out.println("Juc cu minim 10 turnee ");

        List<Jucator> Jucatori = new ArrayList<>();

        Jucatori.add(new Jucator("Stan Wawrinka","Elvetia",5,9000,15));
        Jucatori.add(new Jucator("Yorick","Germania",1,2000,9));
        Jucatori.add(new Jucator("Aolbon Wawrinka","Romania",2,9000,15));

        System.out.println();

        Jucatori.stream()
                .filter(t -> t.getrTurneeATP() > 10)
                .map(Jucator :: getNume)
                .sorted()
                .forEach(System.out :: println);

        List <String> nationalitati = new ArrayList<>();


        Jucatori.stream()
                .map(Jucator :: getNationalitate)
                .distinct()
                .forEach(nationalitati :: add);



        System.out.println("\n" + "Nationalitati distincte: " + nationalitati);


        Collection <String> Min4000 = Jucatori.stream()
                .filter(p -> p.getPuncte() <= 4000 & p.getPuncte() >= 1000)
                .map (Jucator :: getNume)
                .collect(Collectors.toList());
        System.out.println("1000-4000pct : " + Min4000 );

        Map <String, Long> JucatoriNationalitate = Jucatori.stream()
                .collect(Collectors.groupingBy(Jucator ::getNationalitate, Collectors.counting()));

        JucatoriNationalitate.forEach((nationalitate ,numarJucatori) -> System.out.println(nationalitate + ": " + numarJucatori));





    }


}
