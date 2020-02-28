package net.home.oleksin.calculator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionOperationTest {

    private AdditionOperation additionOperation = new AdditionOperation();

    @Test
    void shouldAddition() {

        assertEquals(new BigDecimal("2"), additionOperation.execute(new BigDecimal("1"), new BigDecimal("1")));
    }

}
