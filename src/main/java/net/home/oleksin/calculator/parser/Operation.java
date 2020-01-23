package net.home.oleksin.calculator.parser;

public enum Operation {
    PLUS( 1),
    MINUS( 1),
    MULTIPLY( 2),
    DIVIDE(2);

    private int priority;

    Operation(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
