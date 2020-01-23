package net.home.oleksin.calculator.parser;

import java.math.BigDecimal;

public final class Token {
    private TokenType tokenType;
    private Operation operation;
    private BigDecimal operand;

    public Token(Character operator, TokenType tokenType){
        switch (operator){
            case '+':
                this.operation = Operation.PLUS;
                break;
            case '-':
                this.operation = Operation.MINUS;
                break;
            case '*':
                this.operation = Operation.MULTIPLY;
                break;
            case '/':
                this.operation = Operation.DIVIDE;
                break;
        }

        this.tokenType = tokenType;
    }

    public Token(TokenType tokenType){
        this.tokenType = tokenType;
    }

    public Token(BigDecimal operand, TokenType tokenType){
        this.operand = operand;
        this.tokenType = tokenType;
    }

    public Operation getOperation() {

        return operation;
    }


    public BigDecimal getOperand(){

        return operand;
    }

    public TokenType getTokenType(){

        return tokenType;
    }

}
