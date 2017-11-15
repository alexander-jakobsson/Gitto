import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RPNCalculator {
    private Boolean continueLoop = true;
    private List<String> calculatorStack = new ArrayList<>();
    private Scanner lineReader = new Scanner( System.in );
    private String currentLine;

    public void REPL() {

        while (continueLoop) {

            currentLine = lineReader.next();
            System.out.println("Current line is: " + currentLine);

        }

    }

}

