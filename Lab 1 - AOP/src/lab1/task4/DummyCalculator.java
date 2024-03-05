package lab1.task4;


    public class DummyCalculator {
        public void calculate(String[] args) {
            if (args.length < 3) {
                System.out.println("Input invalid.");
                return;
            }

            double operand1 = Double.parseDouble(args[0]);
            String operator = args[1];
            double operand2 = Double.parseDouble(args[2]);


            double result = 0.0;

            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    result = operand1 / operand2;
                    break;
                default:
                    System.out.println("Invalid operator.");
                    return;
            }

            System.out.println("Result: " + result);
        }


    }


