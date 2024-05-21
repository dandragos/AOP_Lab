package Task1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SquareCalculatorParallelStream {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(1, 10000).boxed().collect(Collectors.toList());

        numbers.parallelStream().forEach(number -> {
            System.out.println(number + "^2=" + (number * number));
        });
    }
}
