package test2.pr3;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Tip asig: ");

        String tipAsig = scanner.nextLine();

        AtomicInteger counter = new AtomicInteger(0);

        Thread t1 = new Thread (new Counter("src/test2/pr3/asig1.txt", tipAsig, counter));
        Thread t2 = new Thread (new Counter("src/test2/pr3/asig2.txt", tipAsig, counter));

        t1.start();
        t2.start();



        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Contor: " + counter);

    }
}
