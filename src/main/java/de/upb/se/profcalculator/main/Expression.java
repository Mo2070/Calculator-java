package de.upb.se.profcalculator.main;

public abstract class Expression {
    protected Value leftValue, rightValue;

    public Expression(Value leftValue, Value rightValue) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    public abstract int evaluate();
    public abstract String computeEquation();  

    public String represent(String operator) {
        return leftValue.toString() + " " + operator + " " + rightValue.toString();
    }
}
