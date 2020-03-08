package net.home.oleksin.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MultiplicationOperationTest {

    private MultiplicationOperation multiplicationOperation = new MultiplicationOperation();

    @Test
    @DisplayName("should Multiply 1.2 And 5")
    public void shouldMultiply1Dot2And5(){
        BigDecimal firstNum = new BigDecimal("1.2");
        BigDecimal secondNum = new BigDecimal("5");
        BigDecimal rightResult = new BigDecimal("6.0");
        assertThat(rightResult, is(multiplicationOperation.execute(firstNum,secondNum)));
    }

    @Test
    @DisplayName("should Multiply 0 And 1000")
    public void shouldMultiply0And1000(){
        BigDecimal firstNum = new BigDecimal("0");
        BigDecimal secondNum = new BigDecimal("1000");
        BigDecimal rightResult = new BigDecimal("0");
        assertThat(rightResult, is(multiplicationOperation.execute(firstNum,secondNum)));
    }

    @Test
    @DisplayName("should Multiply 0.2 And 0.1")
    public void shouldMultiply0Dot2And0Dot1(){
        BigDecimal firstNum = new BigDecimal("0.2");
        BigDecimal secondNum = new BigDecimal("0.1");
        BigDecimal rightResult = new BigDecimal("0.02");
        assertThat(rightResult, is(multiplicationOperation.execute(firstNum,secondNum)));
    }

    @Test
    @DisplayName("should Multiply -5 And -10")
    public void shouldMultiplyMinus5AndMinus10(){
        BigDecimal firstNum = new BigDecimal("-5");
        BigDecimal secondNum = new BigDecimal("-10");
        BigDecimal rightResult = new BigDecimal("50");
        assertThat(rightResult, is(multiplicationOperation.execute(firstNum,secondNum)));
    }

    @Test
    @DisplayName("should Multiply -1000 And 0.1")
    public void shouldMultiplyMinus1000And0Dot1(){
        BigDecimal firstNum = new BigDecimal("-1000");
        BigDecimal secondNum = new BigDecimal("0.1");
        BigDecimal rightResult = new BigDecimal("-100.0");
        assertThat(rightResult, is(multiplicationOperation.execute(firstNum,secondNum)));
    }

}
