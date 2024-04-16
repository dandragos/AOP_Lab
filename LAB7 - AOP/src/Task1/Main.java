package Task1;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String filename = "src/Task1/input.txt";

        // Cu skip:

//        try {
//            FileInputStream fis = new FileInputStream(filename);
//
//            int bytesRead = fis.read(); // Citirea primului byte
//            while (bytesRead != -1 && (char) bytesRead != '\n') {
//                bytesRead = fis.read();
//            }
//
//            int data;
//            while ((data = fis.read()) != -1) {
//                System.out.print((char) data);
//            }
//
//            fis.close();

        // Cu available:

        try {
            FileInputStream fis = new FileInputStream(filename);

            while (fis.available() > 0 && fis.read() != '\n') {}


            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }




            fis.close();
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
}
