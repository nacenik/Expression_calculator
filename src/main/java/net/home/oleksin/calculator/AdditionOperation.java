package net.home.oleksin.calculator;


import java.math.BigDecimal;
import java.math.MathContext;

public class AdditionOperation implements MathOperation{
    @Override
    public BigDecimal execute(BigDecimal left, BigDecimal right) {
         return right.add(left, MathContext.DECIMAL32);
    }
}
