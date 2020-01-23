package net.home.oleksin.calculator;


import java.math.BigDecimal;

public class MultiplicationOperation implements MathOperation{
    @Override
    public BigDecimal execute(BigDecimal left, BigDecimal right) {
        BigDecimal temp = right.multiply(left);
        return temp;
    }
}
