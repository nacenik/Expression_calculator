package net.home.oleksin.calculator.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OperatorTokenReaderTest {
    OperatorTokenReader operatorTokenReader = new OperatorTokenReader();

    @Test
    @DisplayName("should Return Plus Operation")
    public void shouldReturnPlusOperation() {
        ParserContext parserContext = new ParserContext("+");
        assertThat(Operation.PLUS, is(operatorTokenReader.proceed(parserContext).getOperation()));
    }

    @Test
    @DisplayName("should Return Minus Operation")
    public void shouldReturnMinusOperation() {
        ParserContext parserContext = new ParserContext("-");
        assertThat(Operation.MINUS, is(operatorTokenReader.proceed(parserContext).getOperation()));
    }

    @Test
    @DisplayName("should Return Multiply Operation")
    public void shouldReturnMultiplyOperation() {
        ParserContext parserContext = new ParserContext("*");
        assertThat(Operation.MULTIPLY, is(operatorTokenReader.proceed(parserContext).getOperation()));
    }

    @Test
    @DisplayName("should Return Divide Operation")
    public void shouldReturnDivideOperation() {
        ParserContext parserContext = new ParserContext("/");
        assertThat(Operation.DIVIDE, is(operatorTokenReader.proceed(parserContext).getOperation()));
    }
}
