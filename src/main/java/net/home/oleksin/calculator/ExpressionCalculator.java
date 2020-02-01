package net.home.oleksin.calculator;

import net.home.oleksin.calculator.parser.Operation;
import net.home.oleksin.calculator.parser.Parser;
import net.home.oleksin.calculator.parser.Token;
import net.home.oleksin.calculator.parser.TokenType;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EnumMap;
import java.util.Optional;

public class ExpressionCalculator {
    private EnumMap <Operation, MathOperation> operators;
    private Deque <Token> outputArray;
    private Deque <Token> operatorsStack;

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
            outputArray.add(operatorsStack.pollLast());
        }
    }


    private void setSwitch (Token tempToken){
        switch (tempToken.getTokenType()) {
            case NUMBER:
                outputArray.addLast(tempToken);
                break;
            case BRACKET_OPEN:
                operatorsStack.addLast(tempToken);
                break;
            case BRACKET_CLOSE:
                boolean bl = false;
                while (!operatorsStack.isEmpty()) {
                    if (operatorsStack.getLast().getTokenType() != TokenType.BRACKET_OPEN) {
                        outputArray.addLast(operatorsStack.pollLast());
                    } else {
                        bl = true;
                        operatorsStack.removeLast();
                        break;
                    }
                }
                if (!bl) {
                    throw new IllegalStateException();
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
                break;
        }
    }


    public BigDecimal execute (String expression){
        Parser parser = new Parser(expression);
        stackingToken(parser);
        Deque<BigDecimal> tempArray = new ArrayDeque<>();
        while (!outputArray.isEmpty()){
            if (outputArray.getFirst().getTokenType() == TokenType.NUMBER){
                tempArray.addLast(outputArray.pollFirst().getOperand());
            }
            else{
                BigDecimal left = tempArray.pollLast();
                BigDecimal right = tempArray.pollLast();
                tempArray.addLast(operators.get(outputArray.pollFirst().getOperation()).execute(left, right));
            }
        }
        return tempArray.poll();
    }
}
