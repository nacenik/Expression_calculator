package net.home.oleksin.calculator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivisionOperationTest {
    private DivisionOperation divisionOperation = new DivisionOperation();

    @Test
    void division(){
        assertEquals(new BigDecimal("0.5"), divisionOperation.execute(new BigDecimal("4"), new BigDecimal("2")));
    }
}
