package Jucatori2;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nationalitate:");
        String nationalitate = scanner.nextLine();

        AtomicInteger counter = new AtomicInteger(0);

        Thread t1 = new Thread (new Counter("/src/Jucatori/jucatori1.txt", nationalitate, counter));
        Thread t2 = new Thread (new Counter("/src/Jucatori/jucatori2.txt", nationalitate, counter));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Jucatorii care au nationalitatea" + nationalitate + "Sunt in numar de " + counter);

    }
}
