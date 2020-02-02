import net.home.oleksin.calculator.ExpressionCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.NoSuchFileException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException {

        String execute;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("Enter the expression to get decision, if you want to exit enter \"exit\": ");

                execute = bufferedReader.readLine();

                if (execute.compareToIgnoreCase("exit") == 0) {
                    System.out.println("Good bye!");
                    Thread.sleep(1000);
                    break;
                }

                ExpressionCalculator expressionCalculator = new ExpressionCalculator();
                System.out.println(expressionCalculator.execute(execute));

            }
            catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            catch (IllegalStateException ex) {
                System.out.println(ex.getMessage());
            }
            catch (NoSuchElementException ex) {
                System.out.println(ex.getMessage());
            }
            catch (NullPointerException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
