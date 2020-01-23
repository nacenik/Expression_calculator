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
    Deque <Token> operatorsArray;
    Parser parser;

    public ExpressionCalculator(String formula){
        outputArray = new ArrayDeque<>();
        operatorsArray = new ArrayDeque<>();
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
                        outputArray.add(tempToken.get());
                        break;
                    case BRACKET_OPEN:
                        operatorsArray.add(tempToken.get());
                        break;
                    case BRACKET_CLOSE:
                        boolean bl = false;
                        while (!operatorsArray.isEmpty()) {
                            if (operatorsArray.getLast().getTokenType() != TokenType.BRACKET_OPEN) {
                                outputArray.add(operatorsArray.pollLast());
                            } else {
                                bl = true;
                                operatorsArray.pollLast();
                                break;
                            }
                        }
                        if (!bl) {
                            throw new IllegalStateException();
                        }
                        break;
                    case OPERATION:
                        if (operatorsArray.isEmpty() || operatorsArray.getLast().getTokenType() == TokenType.BRACKET_OPEN)
                            operatorsArray.add(tempToken.get());
                        else {
                            if (operatorsArray.getLast().getOperation().getPriority() < tempToken.get().getOperation().getPriority()) {
                                operatorsArray.add(tempToken.get());
                            } else {
                                outputArray.add(operatorsArray.pollLast());
                                operatorsArray.add(tempToken.get());
                            }
                        }
                        break;
                }
            }
            else{
                continue;
            }
        }
        while (!operatorsArray.isEmpty()) {
            outputArray.add(operatorsArray.pollFirst());
        }

    }


    public BigDecimal getDecision (){
        stackingToken();
        Deque<BigDecimal> tempArray = new ArrayDeque<>();
        while (!outputArray.isEmpty()){
            if (outputArray.getFirst().getTokenType() == TokenType.NUMBER){
                tempArray.add(outputArray.pollFirst().getOperand());
            }
            else{
                tempArray.addLast(operators.get(outputArray.pollFirst().getOperation()).execute(tempArray.pollLast(),tempArray.pollLast()));
            }
        }
        return tempArray.poll();
    }
}
