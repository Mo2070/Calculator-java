package de.upb.se.profcalculator;

public class Multiply {
    public Value leftValue, rightValue;
    
    public Multiply(Value leftOperand, Value rightOperand) {
        this.leftValue = leftOperand;
        this.rightValue = rightOperand;
    }

    public String represent() {
        return leftValue.toString() + " * " + rightValue.toString();
    }

    public int evaluate() {
        return leftValue.getValue() * rightValue.getValue();
    }
    
    public String computeEquation() {
        return represent() + " = " + evaluate();
    }
}
