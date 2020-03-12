package net.home.oleksin.calculator.parser;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BracketTokenReaderTest extends Mockito {
    private BracketTokenReader bracketTokenReader = new BracketTokenReader();

    @Test
    @DisplayName("should Return Bracket Open")
    public void shouldReturnBracketOpen(){
        ParserContext parserContext = new ParserContext("(");
        assertThat(TokenType.BRACKET_OPEN, is(bracketTokenReader.proceed(parserContext).getTokenType()));
    }

    @Test
    @DisplayName("should Return Bracket Close")
    public void shouldReturnBracketClose(){
        ParserContext parserContext = new ParserContext(")");
        assertThat(TokenType.BRACKET_CLOSE, is(bracketTokenReader.proceed(parserContext).getTokenType()));
    }
}
