package de.upb.se.profcalculator;

public class Divide {
    public Value leftValue, rightValue;
    
    public Divide(Value leftOperand, Value rightOperand) {
        this.leftValue = leftOperand;
        this.rightValue = rightOperand;
    }

    public String represent() {
        return leftValue.toString() + " / " + rightValue.toString();
    }

    public int evaluate() {
        if (rightValue.getValue() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return leftValue.getValue() / rightValue.getValue();
    }
    
    public String computeEquation() {
        try {
            return represent() + " = " + evaluate();
        } catch (ArithmeticException e) {
            return represent() + " = Error: " + e.getMessage();
        }
    }
}

