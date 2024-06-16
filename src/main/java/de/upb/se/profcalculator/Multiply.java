package de.upb.se.profcalculator;

public class Multiply extends Expression {

    public Multiply(Value leftValue, Value rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public int evaluate() {
        return leftValue.getValue() * rightValue.getValue();
    }

    @Override
    public String represent() {
        return leftValue.getValue() + " * " + rightValue.getValue();
    }
}
