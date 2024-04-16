package Task5;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdu numarul total de numere:");
        int totalNumbers = scanner.nextInt();
        List<Double> numbers = new ArrayList<>();

        System.out.println("Introdu cele " + totalNumbers + " numere:");

        while (numbers.size() < totalNumbers) {
            if (scanner.hasNextDouble()) {
                numbers.add(scanner.nextDouble());
            } else {
                System.out.println("Intrare invalida! ignored.");
                scanner.next(); // consum intrarea invalida din buffer
            }
        }

        List<Function<Double, String>> operations = Arrays.asList(
                num -> {
                    double result = num * 2;
                    return num + " * 2 = " + result;
                },               // inmultirea cu un scalar
                num -> {
                    double result = num + 1;
                    return num + " + 1 = " + result;
                },               // creșterea cu o unitate
                num -> {
                    double result = 1 / num;
                    return "1 / " + num + " = " + result;
                },               // inversarea numărului
                num -> {
                    double result = num * num;
                    return num + "^2 = " + result;
                },             // ridicarea la pătrat
                num -> {
                    double result = Math.sin(num);
                    return "sin(" + num + ") = " + result;
                }              // calcularea sinusului

        );

        Random random = new Random();
        System.out.println("Rezultatele operațiilor:");

        numbers.stream()
                .forEach(num -> {
                    Function<Double, String> operation = operations.get(random.nextInt(operations.size()));
                    String result = operation.apply(num);
                    System.out.println(result);
                });
    }
}
