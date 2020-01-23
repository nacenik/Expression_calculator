package net.home.oleksin.calculator;


import java.math.BigDecimal;

public class SubtractionOperation implements MathOperation{
    @Override
    public BigDecimal execute(BigDecimal left, BigDecimal right) {
        BigDecimal temp = right.subtract(left);
        return temp;
    }
}
