package net.home.oleksin.calculator.parser;

public class OperatorTokenReader implements TokenReader {
    @Override
    public Token proceed(ParserContext parserContext) {
        parserContext.incIndex();
        char chr = parserContext.getFormula().substring(parserContext.getIndex()-1,parserContext.getIndex()).charAt(0);
        return new Token(chr, TokenType.OPERATION);
    }
}
