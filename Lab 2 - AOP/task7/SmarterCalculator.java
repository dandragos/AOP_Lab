package lab2.task7;
import java.util.ArrayList;
import java.util.List;

public class SmarterCalculator {
    public static List<CalculatorResult> calculate(String[] args){
        InputConverter inputConverter = new InputConverter();
        List<CalculatorResult> rez = new ArrayList<>();

        for(int i = 0; i <args.length; i+=3){
            List<CalculatorRequest> l = (inputConverter.mapRequests(new String[]{args[i], args[i + 1], args[i + 2]}));

            for(CalculatorRequest a : l){
                switch (a.getRequestType()) {
                    case "Integer":
                        rez.add(new IntegerCalculatorResult(a));
                        break;
                    case "Double":
                        rez.add(new DoubleCalculatorResult(a));
                        break;
                    case "Boolean":
                        rez.add(new BooleanCalculatorResult(a));
                        break;
                }
            }
        }
        return rez;
    }
}
