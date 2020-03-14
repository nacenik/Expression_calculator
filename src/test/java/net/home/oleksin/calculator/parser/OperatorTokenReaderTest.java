package net.home.oleksin.calculator.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OperatorTokenReaderTest {
    private OperatorTokenReader operatorTokenReader = new OperatorTokenReader();
    private ParserContext parserContext = Mockito.mock(ParserContext.class);

    @Test
    @DisplayName("should Return Plus Operation")
    public void shouldReturnPlusOperation() {
        Mockito.when(parserContext.getCurrentCharacter()).thenReturn('+');
        assertThat(Operation.PLUS, is(operatorTokenReader.proceed(parserContext).getOperation()));

        Mockito.verify(parserContext).incIndex();
    }

    @Test
    @DisplayName("should Return Minus Operation")
    public void shouldReturnMinusOperation() {
        Mockito.when(parserContext.getCurrentCharacter()).thenReturn('-');
        assertThat(Operation.MINUS, is(operatorTokenReader.proceed(parserContext).getOperation()));

        Mockito.verify(parserContext).incIndex();
    }

    @Test
    @DisplayName("should Return Multiply Operation")
    public void shouldReturnMultiplyOperation() {
        Mockito.when(parserContext.getCurrentCharacter()).thenReturn('*');
        assertThat(Operation.MULTIPLY, is(operatorTokenReader.proceed(parserContext).getOperation()));

        Mockito.verify(parserContext).incIndex();
    }

    @Test
    @DisplayName("should Return Divide Operation")
    public void shouldReturnDivideOperation() {
        Mockito.when(parserContext.getCurrentCharacter()).thenReturn('/');
        assertThat(Operation.DIVIDE, is(operatorTokenReader.proceed(parserContext).getOperation()));

        Mockito.verify(parserContext).incIndex();
    }
}
