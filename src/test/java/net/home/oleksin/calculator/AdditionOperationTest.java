package net.home.oleksin.calculator;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AdditionOperationTest {

    private AdditionOperation additionOperation = new AdditionOperation();


    @Test
    @DisplayName("should add 15 and 30")
    public void shouldAdd15And30() {
        BigDecimal firstNum = new BigDecimal("15");
        BigDecimal secondNum = new BigDecimal("30");
        BigDecimal rightResult = new BigDecimal("45");
        assertThat(rightResult, equalTo(additionOperation.execute(firstNum,secondNum)));
    }

    @Test
    @DisplayName("should add 77 and 33")
    public void shouldAdd77And33() {
        BigDecimal firstNum = new BigDecimal("77");
        BigDecimal secondNum = new BigDecimal("33");
        BigDecimal rightResult = new BigDecimal("110");
        assertThat(rightResult, equalTo(additionOperation.execute(firstNum,secondNum)));
    }

    @Test
    @DisplayName("should add 1.3 and 3.5")
    public void shouldAdd1Dot3And3Dot5() {
        BigDecimal firstNum = new BigDecimal("1.3");
        BigDecimal secondNum = new BigDecimal("3.5");
        BigDecimal rightResult = new BigDecimal("4.8");
        assertThat(rightResult, equalTo(additionOperation.execute(firstNum,secondNum)));
    }

    @Test
    @DisplayName("should add -2.5 and -1000")
    public void shouldAddMinus2Dot5AndMinus1000() {
        BigDecimal firstNum = new BigDecimal("-2.5");
        BigDecimal secondNum = new BigDecimal("-1000");
        BigDecimal rightResult = new BigDecimal("-1002.5");
        assertThat(rightResult, equalTo(additionOperation.execute(firstNum,secondNum)));
    }


    @Test
    @DisplayName("should add -2.5 and 1000")
    public void shouldAddMinus2Dot5And1000() {
        BigDecimal firstNum = new BigDecimal("-2.5");
        BigDecimal secondNum = new BigDecimal("1000");
        BigDecimal rightResult = new BigDecimal("997.5");
        assertThat(rightResult, equalTo(additionOperation.execute(firstNum,secondNum)));
    }

}
