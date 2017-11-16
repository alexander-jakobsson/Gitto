import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RPNCalculator {
    private Boolean continueLoop = true;
    private List<Integer> calculatorStack = new ArrayList<>();
    private Scanner lineReader = new Scanner( System.in );
    private String currentLine;
    private Integer currentOperand;
    private String currentOperator;

    public void REPL() {

        while (continueLoop) {


            System.out.print("> ");
            currentLine = lineReader.next();
            if (currentLine.equals("exit")){
                continueLoop = false;
            }

            try {
                currentOperand = Integer.parseInt(currentLine);
                System.out.println("-> " + currentOperand);
                calculatorStack.add(currentOperand);
                System.out.println(calculatorStack);
            } catch (NumberFormatException e) {
                currentOperator = currentLine;
                System.out.println("-> " + currentOperator);
                int result = applyOperator(currentOperator);
                System.out.println(result);
                System.out.println(calculatorStack);
            }


        }

    }

    public int applyOperator(String currentOperator) {
        switch (currentOperator) {
            case "+":
                return RPNAdd();
            case "-":
                return RPNSubtract();
            case "*":
                return RPNMultiply();
            case "/":
                return RPNDivide();
        }
        return 0;
    }

    private int RPNSubtract() {
        int difference = 0;
        if (calculatorStack.size() >= 2) {
            difference = calculatorStack.get(calculatorStack.size() - 1) - calculatorStack.get(calculatorStack.size() - 2);
            calculatorStack.remove(calculatorStack.size() - 2);
            calculatorStack.remove(calculatorStack.size() - 1);
            calculatorStack.add(difference);
        }
        return difference;
    }

    private int RPNAdd() {
        int sum = 0;
        if (calculatorStack.size() >= 2) {
            sum = calculatorStack.get(calculatorStack.size() - 1) + calculatorStack.get(calculatorStack.size() - 2);
            calculatorStack.remove(calculatorStack.size() - 2);
            calculatorStack.remove(calculatorStack.size() - 1);
            calculatorStack.add(sum);
        }

        return sum;
    }

    private int RPNMultiply() {
        int product = 0;
        if (calculatorStack.size() >= 2) {
            product = calculatorStack.get(calculatorStack.size() - 1) * calculatorStack.get(calculatorStack.size() - 2);
            calculatorStack.remove(calculatorStack.size() - 2);
            calculatorStack.remove(calculatorStack.size() - 1);
            calculatorStack.add(product);
        }

        return product;
    }

    private int RPNDivide() {
        int quotient = 0;
        if (calculatorStack.size() >= 2) {
            quotient = calculatorStack.get(calculatorStack.size() - 1) / calculatorStack.get(calculatorStack.size() - 2);
            calculatorStack.remove(calculatorStack.size() - 2);
            calculatorStack.remove(calculatorStack.size() - 1);
            calculatorStack.add(quotient);
        }

        return quotient;
    }

}

/*

Inside REPL:

    Print a "> "
    Use Scanner to get a Line of Input.
    Inside a Try-Catch Construct, try to parse an Int from the Input
        If successful, add the int to the stack.
        If failed, the input is an operator. Apply the operator.



 */