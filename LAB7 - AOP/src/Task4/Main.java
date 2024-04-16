package Task4;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int N = 12;

        IntStream.rangeClosed(1, N)
                .filter(num -> num % 2 == 0)
                .forEach(num -> System.out.println("Numar: " + num + ", Patrat: " + num * num));
    }
}
