package net.home.oleksin.calculator.parser;

import java.util.*;

public class Parser implements Iterable<Optional<Token>> {
    private final ParserContext parserContext;
    private final Map<Character, TokenReader> mapForToken;

    private Token token;
    private Optional<Token> optionalToken;


    public Parser(String formula) {
        parserContext = new ParserContext(formula);
        mapForToken = new HashMap<>();
        for (int n = '0'; n <= '9'; n++) {
            mapForToken.put((char) n, new NumberTokenReader());
        }
        mapForToken.put(' ', new BracketTokenReader());
        mapForToken.put('+', new OperatorTokenReader());
        mapForToken.put('-', new OperatorTokenReader());
        mapForToken.put('*', new OperatorTokenReader());
        mapForToken.put('/', new OperatorTokenReader());
        mapForToken.put('(', new BracketTokenReader());
        mapForToken.put(')', new BracketTokenReader());
    }


    @Override
    public Iterator<Optional<Token>> iterator() {
        return new TokenIterator();
    }

    private class TokenIterator implements Iterator <Optional<Token>> {

        @Override
        public boolean hasNext() {
            return parserContext.getIndex() < parserContext.getLength() && mapForToken.containsKey(parserContext.getCurrentCharacter()) ? true : false;
        }

        @Override
        public Optional<Token> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                token = mapForToken.get(parserContext.getCurrentCharacter()).proceed(parserContext);
                if (parserContext.getLength() > parserContext.getIndex() && !mapForToken.containsKey(parserContext.getCurrentCharacter())) {
                    throw new IllegalStateException("Invalid character index " + (parserContext.getIndex() + 1));
                }
                if (token.getTokenType() == TokenType.SPACE) {
                    optionalToken = Optional.empty();
                }
                else {
                    optionalToken = Optional.of(token);
                }
            return optionalToken;
        }
    }
}
