package de.upb.se.profcalculator;

public class Divide extends Expression {

    public Divide(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public int evaluate() {
        if (rightValue.getValue() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return leftValue.getValue() / rightValue.getValue();
    }

    @Override
    public String represent() {
        return leftValue.getValue() + " / " + rightValue.getValue();
    }
}
