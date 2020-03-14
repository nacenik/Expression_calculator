package net.home.oleksin.calculator.parser;

public class OperatorTokenReader implements TokenReader {
    @Override
    public Token proceed(ParserContext parserContext) {
        char chr = parserContext.getCurrentCharacter();
        parserContext.incIndex();
        return new Token(chr, TokenType.OPERATION);
    }
}
