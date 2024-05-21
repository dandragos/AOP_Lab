package Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculatorCompletableFuture {
    public static void main(String[] args) {
        int numCount = 10000;
        int processors = Runtime.getRuntime().availableProcessors();

        ExecutorService executorService = Executors.newWorkStealingPool();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= numCount; i++) {
            numbers.add(i);
        }

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < processors; i++) {
            int fromIndex = i * (numCount / processors);
            int toIndex = (i == processors - 1) ? numCount : fromIndex + (numCount / processors);

            List<Integer> subList = numbers.subList(fromIndex, toIndex);
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                for (Integer number : subList) {
                    System.out.println(number + "^2=" + (number * number));
                }
            }, executorService);
            futures.add(future);
        }

        futures.forEach(CompletableFuture::join);
        executorService.shutdown();
    }
}
