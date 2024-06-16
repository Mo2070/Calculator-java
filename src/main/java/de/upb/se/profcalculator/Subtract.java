package de.upb.se.profcalculator;

public class Subtract implements Operation {
    private Value leftValue, rightValue;

    public Subtract(Value leftOperand, Value rightOperand) {
        this.leftValue = leftOperand;
        this.rightValue = rightOperand;
    }

    @Override
    public String represent() {
        return leftValue.toString() + " - " + rightValue.toString();
    }

    @Override
    public int evaluate() {
        return leftValue.getValue() - rightValue.getValue();
    }

    @Override
    public String computeEquation() {
        return represent() + " = " + evaluate();
    }
}
