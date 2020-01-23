package net.home.oleksin.calculator.parser;

public class OperatorTokenReader implements TokenReader {
    @Override
    public Token proceed(ParserContext parserContext) {
        parserContext.incIndex();
        Token tempToken = new Token(parserContext.getFormula().substring(parserContext.getIndex()-1,parserContext.getIndex()).charAt(0), TokenType.OPERATION);
        return tempToken;
    }
}
