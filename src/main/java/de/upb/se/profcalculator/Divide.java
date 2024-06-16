package de.upb.se.profcalculator;

public class Divide implements Operation {
    private Value leftValue, rightValue;

    public Divide(Value leftOperand, Value rightOperand) {
        this.leftValue = leftOperand;
        this.rightValue = rightOperand;
    }

    @Override
    public String represent() {
        return leftValue.toString() + " / " + rightValue.toString();
    }

    @Override
    public int evaluate() {
        if (rightValue.getValue() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return leftValue.getValue() / rightValue.getValue();
    }

    @Override
    public String computeEquation() {
        try {
            return represent() + " = " + evaluate();
        } catch (ArithmeticException e) {
            return represent() + " = Error: " + e.getMessage();
        }
    }
}
