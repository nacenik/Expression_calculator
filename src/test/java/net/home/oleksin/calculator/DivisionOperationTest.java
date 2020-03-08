package net.home.oleksin.calculator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DivisionOperationTest {
    private DivisionOperation divisionOperation = new DivisionOperation();

    @Test
    @DisplayName("should Divide 2 By 4")
    public void shouldDivide2By4(){
        BigDecimal firstNum = new BigDecimal("4");
        BigDecimal secondNum = new BigDecimal("2");
        BigDecimal rightResult = new BigDecimal("0.5");
        assertThat(rightResult, is(divisionOperation.execute(firstNum,secondNum)));
    }

    @Test
    @DisplayName("should Divide 4 By 2")
    public void shouldDivide4By2(){
        BigDecimal firstNum = new BigDecimal("2");
        BigDecimal secondNum = new BigDecimal("4");
        BigDecimal rightResult = new BigDecimal("2");
        assertThat(rightResult, is(divisionOperation.execute(firstNum,secondNum)));
    }

    @Test
    @DisplayName("should Return Arithmetic Exception")
    public void shouldReturnArithmeticException(){
        BigDecimal firstNum = new BigDecimal("0");
        BigDecimal secondNum = new BigDecimal("2");
        Assertions.assertThrows(ArithmeticException.class,() -> divisionOperation.execute(firstNum,secondNum));
    }
}
