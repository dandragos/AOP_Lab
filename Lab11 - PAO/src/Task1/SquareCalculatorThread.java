package Task1;
import java.util.ArrayList;
import java.util.List;

public class SquareCalculatorThread extends Thread {
    private List<Integer> numbers;

    public SquareCalculatorThread(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        for (Integer number : numbers) {
            System.out.println(number + "^2=" + (number * number));
        }
    }

    public static void main(String[] args) {
        int numCount = 10000;
        int processors = Runtime.getRuntime().availableProcessors();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= numCount; i++) {
            numbers.add(i);
        }

        int chunkSize = (numCount + processors - 1) / processors;
        List<SquareCalculatorThread> threads = new ArrayList<>();

        for (int i = 0; i < processors; i++) {
            int fromIndex = i * chunkSize;
            int toIndex = Math.min(fromIndex + chunkSize, numCount);
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
}
