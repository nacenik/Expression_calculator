package net.home.oleksin.calculator;

import net.home.oleksin.calculator.parser.Operation;
import net.home.oleksin.calculator.parser.Parser;
import net.home.oleksin.calculator.parser.Token;
import net.home.oleksin.calculator.parser.TokenType;

import java.math.BigDecimal;
import java.util.*;

public class ExpressionCalculator {
    private EnumMap <Operation, MathOperation> operators;

    private Deque <Token> outputArray;
    private Deque <Token> operatorsStack;

    private boolean numOrOperation = false;

    public ExpressionCalculator(){
        outputArray = new ArrayDeque<>();
        operatorsStack = new ArrayDeque<>();
        operators = new EnumMap<>(Operation.class);

        operators.put(Operation.PLUS, new AdditionOperation());
        operators.put(Operation.MINUS, new SubtractionOperation());
        operators.put(Operation.MULTIPLY, new MultiplicationOperation());
        operators.put(Operation.DIVIDE, new DivisionOperation());
    }


    private void stackingToken(Parser parser)  {
        for (Optional<Token> tempToken : parser){
            tempToken.ifPresent(tempToken1 -> {
                setSwitch(tempToken1);
            });
        }


        while (!operatorsStack.isEmpty()) {
            if (testForOpenBracket(operatorsStack.getLast().getTokenType())){
                throw new IllegalStateException("You haven't open bracket");
            }
            outputArray.add(operatorsStack.pollLast());
        }
    }


    private void setSwitch (Token tempToken){
        switch (tempToken.getTokenType()) {
            case NUMBER:
                outputArray.addLast(tempToken);
                if (!numOrOperation) {
                    numOrOperation = true;
                }
                else {
                    throw new IllegalStateException("You have 2 numbers in a row");
                }
                break;

            case BRACKET_OPEN:
                operatorsStack.addLast(tempToken);
                break;

            case BRACKET_CLOSE:
                boolean bl = false;
                while (!operatorsStack.isEmpty()) {
                    if (!testForOpenBracket(operatorsStack.getLast().getTokenType())) {
                        outputArray.addLast(operatorsStack.pollLast());
                    } else {
                        bl = true;
                        operatorsStack.removeLast();
                        break;
                    }
                }
                if (!bl) {
                    throw new IllegalStateException("You haven't close bracket");
                }
                break;

            case OPERATION:
                if (operatorsStack.isEmpty() || operatorsStack.getLast().getTokenType() == TokenType.BRACKET_OPEN) {
                    operatorsStack.addLast(tempToken);
                } else if (operatorsStack.getLast().getOperation().getPriority() < tempToken.getOperation().getPriority()) {
                    operatorsStack.addLast(tempToken);
                } else {
                    outputArray.addLast(operatorsStack.pollLast());
                    operatorsStack.addLast(tempToken);
                }
                if (numOrOperation) {
                    numOrOperation = false;
                }
                else {
                    throw new IllegalStateException("You have 2 operations in a row");
                }
                break;
        }
    }

    private boolean testForOpenBracket(TokenType token){
        if (token == TokenType.BRACKET_OPEN)
            return true;
        return false;
    }


    public BigDecimal execute (String expression){
        Parser parser = new Parser(expression);
        Deque<BigDecimal> numbersArray = new ArrayDeque<>();

        stackingToken(parser);

        while (!outputArray.isEmpty()){
            if (outputArray.getFirst().getTokenType() == TokenType.NUMBER){
                numbersArray.addLast(outputArray.pollFirst().getOperand());
            }

            else{
                BigDecimal left = numbersArray.pollLast();
                BigDecimal right = numbersArray.pollLast();
                numbersArray.addLast(operators.get(outputArray.pollFirst().getOperation()).execute(left, right));
            }
        }


        return numbersArray.poll();
    }
}
