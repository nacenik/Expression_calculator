package net.home.oleksin.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ExpressionCalculatorTest extends Mockito {
    private  ExpressionCalculator expressionCalculator =  new ExpressionCalculator();


    @Test
    @DisplayName("should Return IllegalStateException Two Numbers In Row")
    public void shouldReturnIllegalStateExceptionTwoNumbersInRow() {
        Assertions.assertThrows(IllegalStateException.class, () -> expressionCalculator.execute("2 2"));
    }

    @Test
    @DisplayName("should Return IllegalStateException Two Operations In Row")
    public void shouldReturnIllegalStateExceptionTwoOperationsInRow() {
        Assertions.assertThrows(IllegalStateException.class, () -> expressionCalculator.execute("2++2"));
    }

    @Test
    @DisplayName("should Return IllegalStateException Open Bracket")
    public void shouldReturnIllegalStateExceptionOpenBracket() {
        Assertions.assertThrows(IllegalStateException.class, () -> expressionCalculator.execute("2+2)"));
    }

    @Test
    @DisplayName("should Return IllegalStateException Close Bracket")
    public void shouldReturnIllegalStateExceptionCloseBracket() {
        Assertions.assertThrows(IllegalStateException.class, () -> expressionCalculator.execute("(2+2"));
    }

    @Test
    @DisplayName("should Return IllegalStateException Last Operation")
    public void shouldReturnIllegalStateExceptionLastOperation() {
        Assertions.assertThrows(IllegalStateException.class, () -> expressionCalculator.execute("2+2+"));
    }

    @Test
    @DisplayName("should Return 8.000000")
    public void shouldReturn8Dot000000() {
        BigDecimal rightResult = new BigDecimal("8.000000");
        assertThat(rightResult, is(expressionCalculator.execute("2/2*2+2*2+2")));
    }

    @Test
    @DisplayName("should Return 99.33334")
    public void shouldReturn99Dot33334() {
        BigDecimal rightResult = new BigDecimal("99.33334");
        assertThat(rightResult, is(expressionCalculator.execute("2+2*6+(4/6)*128")));
    }
}
