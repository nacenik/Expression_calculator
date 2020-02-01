package net.home.oleksin.calculator;


import java.math.BigDecimal;
import java.math.MathContext;

public class MultiplicationOperation implements MathOperation{
    @Override
    public BigDecimal execute(BigDecimal left, BigDecimal right) {
        return right.multiply(left, MathContext.DECIMAL32);
    }
}
