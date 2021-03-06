package net.home.oleksin.calculator;


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class DivisionOperation implements MathOperation{
    @Override
    public BigDecimal execute(BigDecimal left, BigDecimal right) {
        return right.divide(left, MathContext.DECIMAL32);
    }
}
