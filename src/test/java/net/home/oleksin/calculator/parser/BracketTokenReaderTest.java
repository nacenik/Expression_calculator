package net.home.oleksin.calculator.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class BracketTokenReaderTest {
    private BracketTokenReader bracketTokenReader = new BracketTokenReader();
    private ParserContext parserContext = Mockito.mock(ParserContext.class);

    @Test
    @DisplayName("should Return Bracket Open")
    public void shouldReturnBracketOpen(){
        Mockito.when(parserContext.getCurrentCharacter()).thenReturn('(');
        assertThat(TokenType.BRACKET_OPEN, is(bracketTokenReader.proceed(parserContext).getTokenType()));

        Mockito.verify(parserContext).incIndex();
    }

    @Test
    @DisplayName("should Return Bracket Close")
    public void shouldReturnBracketClose(){
        Mockito.when(parserContext.getCurrentCharacter()).thenReturn(')');
        assertThat(TokenType.BRACKET_CLOSE, is(bracketTokenReader.proceed(parserContext).getTokenType()));

        Mockito.verify(parserContext).incIndex();
    }
}
