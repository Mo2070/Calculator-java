package de.upb.se.profcalculator;

public abstract class Expression {
    protected Value leftValue, rightValue;

    public Expression(Value leftValue, Value rightValue) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    public abstract int evaluate();

    public abstract String represent();

    public String computeEquation() {
        return represent() + " = " + evaluate();
    }
}
