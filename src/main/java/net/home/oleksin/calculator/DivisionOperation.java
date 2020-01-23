package net.home.oleksin.calculator;


import java.math.BigDecimal;

public class DivisionOperation implements MathOperation{
    @Override
    public BigDecimal execute(BigDecimal left, BigDecimal right) {
        BigDecimal temp = right.divide(left);
        return temp;
    }
}
