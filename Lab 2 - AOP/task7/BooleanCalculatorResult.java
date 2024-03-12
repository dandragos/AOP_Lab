package lab2.task7;

import java.util.Objects;

public class BooleanCalculatorResult extends CalculatorResult{
    protected BooleanCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Boolean computeResult() throws Exceptie {
        CalculatorRequest cr = getRequest();
        Object l = cr.getLeftOperand(),r=cr.getRightOperand();
        String op = cr.getOperation();
        if(op.equals("&"))
            return (Boolean) l && (Boolean) r;
        else if(op.equals("|"))
            return (Boolean) l || (Boolean) r;
        else{
            System.out.println(op);
            throw new Exceptie("Op. incorect");
        }

    }
}
