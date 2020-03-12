package net.home.oleksin.calculator.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NumberTokenReaderTest {
    private NumberTokenReader numberTokenReader = new NumberTokenReader();

    @Test
    @DisplayName("should Return Number 22.30000")
    public void shouldReturnNumber22Dot3() {
        ParserContext parserContext = new ParserContext("22.3");
        BigDecimal rightResult = new BigDecimal("22.30000");
        assertThat(rightResult, is(numberTokenReader.proceed(parserContext).getOperand()));
    }

    @Test
    @DisplayName("should Return NumberFormatException")
    public void shouldReturnNumberFormatException() {
        ParserContext parserContext = new ParserContext("-1");
        Assertions.assertThrows(NumberFormatException.class,() -> numberTokenReader.proceed(parserContext));
    }

    @Test
    @DisplayName("should Return IllegalStateException")
    public void shouldReturnIllegalStateException(){
        ParserContext parserContext = new ParserContext("2.2.2");
        Assertions.assertThrows(IllegalStateException.class,() -> numberTokenReader.proceed(parserContext));
    }

}
