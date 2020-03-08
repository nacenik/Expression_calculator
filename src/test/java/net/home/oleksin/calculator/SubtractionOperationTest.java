package net.home.oleksin.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.math.BigDecimal;

public class SubtractionOperationTest {

    SubtractionOperation subtractionOperation = new SubtractionOperation();

    @Test
    @DisplayName("should Subtract 3 from 5")
    public void shouldSubtract3From5(){
        BigDecimal firstNum = new BigDecimal("3");
        BigDecimal secondNum = new BigDecimal("5");
        BigDecimal rightResult = new BigDecimal("2");
        assertThat(rightResult, is(subtractionOperation.execute(firstNum,secondNum)));
    }

    @Test
    @DisplayName("should Subtract 20.5 from 10.5")
    public void shouldSubtract20Dot5From10Dot5(){
        BigDecimal firstNum = new BigDecimal("20.5");
        BigDecimal secondNum = new BigDecimal("10.5");
        BigDecimal rightResult = new BigDecimal("-10.0");
        assertThat(rightResult, is(subtractionOperation.execute(firstNum,secondNum)));
    }
}
