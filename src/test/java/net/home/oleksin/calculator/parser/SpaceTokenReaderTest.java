package net.home.oleksin.calculator.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SpaceTokenReaderTest {
    private SpaceTokenReader spaceTokenReader = new SpaceTokenReader();
    private ParserContext parserContext = Mockito.mock(ParserContext.class);

    @Test
    @DisplayName("should Return Space")
    public void shouldReturnSpace(){
        assertThat(TokenType.SPACE, is(spaceTokenReader.proceed(parserContext).getTokenType()));
        Mockito.verify(parserContext).incIndex();
    }
}
