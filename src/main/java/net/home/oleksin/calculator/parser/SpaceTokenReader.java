package net.home.oleksin.calculator.parser;

public class SpaceTokenReader implements TokenReader{

    @Override
    public Token proceed(ParserContext parserContext) {
        parserContext.incIndex();
        return new Token(TokenType.SPACE);
    }
}
