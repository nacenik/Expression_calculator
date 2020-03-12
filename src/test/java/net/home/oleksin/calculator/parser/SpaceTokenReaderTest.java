package net.home.oleksin.calculator.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpaceTokenReaderTest {
    private SpaceTokenReader spaceTokenReader = new SpaceTokenReader();

    @Test
    @DisplayName("should Return Space")
    public void shouldReturnSpace(){
        ParserContext parserContext = new ParserContext(" ");
        assertThat(TokenType.SPACE, is(spaceTokenReader.proceed(parserContext).getTokenType()));
    }
}
