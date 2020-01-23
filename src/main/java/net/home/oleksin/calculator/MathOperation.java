package net.home.oleksin.calculator;

import net.home.oleksin.calculator.parser.Token;

import java.math.BigDecimal;

public interface MathOperation {

    BigDecimal execute(BigDecimal left, BigDecimal right);
}
