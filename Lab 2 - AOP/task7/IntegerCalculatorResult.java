package lab2.task7;

public class IntegerCalculatorResult extends CalculatorResult{
    public IntegerCalculatorResult(CalculatorRequest calculatorRequest){
        super(calculatorRequest);
    }
    @Override
    public Integer computeResult() throws Exceptie {
        CalculatorRequest cr = getRequest();
        Object l = cr.getLeftOperand(),r=cr.getRightOperand();
        String op = cr.getOperation();
        switch(op){
            case "+":
                return (Integer) l + (Integer) r;
            case "-":
                return (Integer) l - (Integer) r;
            case "*":
                return (Integer) l * (Integer) r;
            case "/":
                if((Integer) r==0)
                    throw new Exceptie("Impartire la 0");
                return (Integer) l / (Integer) r;
            default:
                throw new Exceptie("Op. incorect");
        }
    }
}
