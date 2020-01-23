package net.home.oleksin.calculator.parser;

import com.sun.jdi.InvalidTypeException;

import java.math.BigDecimal;

public class NumberTokenReader implements TokenReader {

    @Override
    public Token proceed(ParserContext parserContext) {
        int dotCounter = 0;
        int startIndex = parserContext.getIndex();
        while (parserContext.getIndex() < parserContext.getLength() &&
                (parserContext.getCurrentCharacter() == '.' || Character.isDigit(parserContext.getCurrentCharacter()))) {
            if (parserContext.getCurrentCharacter() == '.' && ++dotCounter > 1) {
                throw new IllegalStateException("Invalid dot number");
            }
            parserContext.incIndex();
        }
        Token tempToken = new Token(new BigDecimal(parserContext.getFormula().substring(startIndex, parserContext.getIndex())).setScale(5), TokenType.NUMBER);
        return tempToken;
    }
}
