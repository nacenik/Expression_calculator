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
    EnumMap <Operation, MathOperation> operators;
    Deque <Token> outputArray;
    Deque <Token> operatorsStack;
    Parser parser;

    public ExpressionCalculator(String formula){
        outputArray = new ArrayDeque<>();
        operatorsStack = new ArrayDeque<>();
        operators = new EnumMap<>(Operation.class);

        operators.put(Operation.PLUS, new AdditionOperation());
        operators.put(Operation.MINUS, new SubtractionOperation());
        operators.put(Operation.MULTIPLY, new MultiplicationOperation());
        operators.put(Operation.DIVIDE, new DivisionOperation());

        parser = new Parser(formula);
    }


    private void stackingToken()  {
        for (Optional<Token> tempToken : parser){
            if (tempToken.isPresent()) {
                switch (tempToken.get().getTokenType()) {
                    case NUMBER:
                        outputArray.addLast(tempToken.get());
                        break;
                    case BRACKET_OPEN:
                        operatorsStack.addLast(tempToken.get());
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
                            operatorsStack.addLast(tempToken.get());
                        } else if (operatorsStack.getLast().getOperation().getPriority() < tempToken.get().getOperation().getPriority()) {
                            operatorsStack.addLast(tempToken.get());
                        } else {
                            outputArray.addLast(operatorsStack.pollLast());
                            operatorsStack.addLast(tempToken.get());
                        }
                        break;
                }
            }
            else{
                continue;
            }
        }
        while (!operatorsStack.isEmpty()) {
            outputArray.add(operatorsStack.pollLast());
        }

    }

    public void getOutput(){
        stackingToken();
        while (!outputArray.isEmpty()){
            if (outputArray.getFirst().getTokenType() == TokenType.NUMBER){
                System.out.println(outputArray.pollFirst().getOperand());
            }
            else{
                System.out.println(outputArray.pollFirst().getOperation());
            }
        }
    }


    public BigDecimal getDecision (){
        stackingToken();
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
