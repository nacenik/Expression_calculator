import net.home.oleksin.calculator.ExpressionCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        String formula;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        formula = bufferedReader.readLine();
        ExpressionCalculator expressionCalculator = new ExpressionCalculator(formula);
        System.out.println(expressionCalculator.getDecision());
        //expressionCalculator.getOutput();
    }
}
