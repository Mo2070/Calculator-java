package de.upb.se.profcalculator;

public class Subtract {
    public Value leftValue, rightValue;
    
    public Subtract(Value leftOperand, Value rightOperand) {
        this.leftValue = leftOperand;
        this.rightValue = rightOperand;
    }

    public String represent() {
        return leftValue.toString() + " - " + rightValue.toString();
    }

    public int evaluate() {
        return leftValue.getValue() - rightValue.getValue();
    }
    
    public String computeEquation() {
        return represent() + " = " + evaluate();
    }
}
