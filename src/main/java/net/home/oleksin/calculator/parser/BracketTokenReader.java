package net.home.oleksin.calculator.parser;

public class BracketTokenReader implements TokenReader{

    @Override
    public Token proceed(ParserContext parserContext) {
        TokenType type;
        if (parserContext.getCurrentCharacter()=='(') {
            type = TokenType.BRACKET_OPEN;
        } else {
            type = TokenType.BRACKET_CLOSE;
        }
        parserContext.incIndex();
        Token tempToken = new Token(type);
        return tempToken;
    }
}
