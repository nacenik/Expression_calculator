package net.home.oleksin.calculator.parser;

public class BracketTokenReader implements TokenReader{

    @Override
    public Token proceed(ParserContext parserContext) {
        TokenType type = parserContext.getCurrentCharacter() == '(' ? TokenType.BRACKET_OPEN : TokenType.BRACKET_CLOSE;
        parserContext.incIndex();
        return new Token(type);
    }
}
