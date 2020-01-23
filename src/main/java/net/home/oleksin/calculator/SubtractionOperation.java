package net.home.oleksin.calculator;


import java.math.BigDecimal;
import java.math.MathContext;

public class SubtractionOperation implements MathOperation{
    @Override
    public BigDecimal execute(BigDecimal left, BigDecimal right) {
        BigDecimal temp = right.subtract(left, MathContext.DECIMAL32);
        return temp;
    }
}
