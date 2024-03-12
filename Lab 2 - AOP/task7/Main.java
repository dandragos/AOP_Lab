package lab2.task7;
import java.util.List;

public class Main {
    public static void foo(String[] args) throws Exceptie {
        List<CalculatorResult> calculationResults =  SmarterCalculator.calculate(args);
        for (CalculatorResult result : calculationResults) {
            CalculatorRequest request = result.getRequest();
            System.out.println("Operation " + request + " has result " + result.computeResult());
        }
    }

    public static void main(String[] args) throws Exceptie {

        foo(new String[]{"1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "1",
                "true", "|", "false",
                "true", "&", "true",
                "true", "&", "false"});
    }
}
