package net.home.oleksin.calculator;


import java.math.BigDecimal;

public class AdditionOperation implements MathOperation{
    @Override
    public BigDecimal execute(BigDecimal left, BigDecimal right) {
        BigDecimal temp = right.add(left);
        return temp;
    }
}
