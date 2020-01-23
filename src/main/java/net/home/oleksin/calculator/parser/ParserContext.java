package net.home.oleksin.calculator.parser;

public class ParserContext{

    private final String formula;

    private int index;

    public ParserContext (String formula){
        this.formula = formula;
        index = 0;
    }

    public String getFormula() {
        return formula;
    }

    public char getCurrentCharacter() {
        return formula.charAt(index);
    }

    public int getLength(){
        return formula.length();
    }

    public int getIndex() {
        return index;
    }

    public void incIndex(){
        index++;
    }
// (345345 + 345345)
}
