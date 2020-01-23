package net.home.oleksin.calculator;


import java.math.BigDecimal;
import java.math.MathContext;

public class AdditionOperation implements MathOperation{
    @Override
    public BigDecimal execute(BigDecimal left, BigDecimal right) {
        BigDecimal temp = right.add(left, MathContext.DECIMAL32);
        return temp;
    }
}
