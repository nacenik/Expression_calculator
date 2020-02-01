import net.home.oleksin.calculator.ExpressionCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        String execute;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        execute = bufferedReader.readLine();
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        System.out.println(expressionCalculator.execute(execute));
    }
}
