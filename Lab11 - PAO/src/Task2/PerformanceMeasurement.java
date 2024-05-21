package Task2;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerformanceMeasurement {

    public static void main(String[] args) {
        int[] testSizes = {10, 1000, 10000, 10000000};
        int processors = Runtime.getRuntime().availableProcessors();

        for (int size : testSizes) {
            System.out.println("Test size: " + size);

            // Sequential
            List<Integer> numbers = generateNumbers(size);
            long start = System.nanoTime();
            sequentialSquare(numbers);
            long end = System.nanoTime();
            System.out.println("Sequential: " + (end - start) / 1e6 + " ms");

            // Thread Class
            start = System.nanoTime();
            threadSquare(numbers, processors);
            end = System.nanoTime();
            System.out.println("Thread: " + (end - start) / 1e6 + " ms");

            // ParallelStream
            start = System.nanoTime();
            parallelStreamSquare(numbers);
            end = System.nanoTime();
            System.out.println("Parallel Stream: " + (end - start) / 1e6 + " ms");

            // CompletableFuture
            start = System.nanoTime();
            completableFutureSquare(numbers, processors);
            end = System.nanoTime();
            System.out.println("CompletableFuture: " + (end - start) / 1e6 + " ms");

            System.out.println();
        }
    }

    private static List<Integer> generateNumbers(int size) {
        return IntStream.rangeClosed(1, size).boxed().collect(Collectors.toList());
    }

    private static void sequentialSquare(List<Integer> numbers) {
        for (Integer number : numbers) {
            int result = number * number;
        }
    }

    private static void threadSquare(List<Integer> numbers, int processors) {
        int chunkSize = (numbers.size() + processors - 1) / processors;
        List<SquareCalculatorThread> threads = new ArrayList<>();

        for (int i = 0; i < processors; i++) {
            int fromIndex = i * chunkSize;
            int toIndex = Math.min(fromIndex + chunkSize, numbers.size());
            List<Integer> subList = numbers.subList(fromIndex, toIndex);
            SquareCalculatorThread thread = new SquareCalculatorThread(subList);
            threads.add(thread);
            thread.start();
        }

        for (SquareCalculatorThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void parallelStreamSquare(List<Integer> numbers) {
        numbers.parallelStream().forEach(number -> {
            int result = number * number;
        });
    }

    private static void completableFutureSquare(List<Integer> numbers, int processors) {
        ExecutorService executorService = Executors.newWorkStealingPool();
        int chunkSize = (numbers.size() + processors - 1) / processors;
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < processors; i++) {
            int fromIndex = i * chunkSize;
            int toIndex = Math.min(fromIndex + chunkSize, numbers.size());
            List<Integer> subList = numbers.subList(fromIndex, toIndex);

            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                for (Integer number : subList) {
                    int result = number * number;
                }
            }, executorService);
            futures.add(future);
        }

        futures.forEach(CompletableFuture::join);
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class SquareCalculatorThread extends Thread {
        private List<Integer> numbers;

        public SquareCalculatorThread(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public void run() {
            for (Integer number : numbers) {
                int result = number * number;
            }
        }
    }
}
