package de.upb.se.profcalculator;

public interface Operation {
    String represent();
    int evaluate();
    String computeEquation();
    Value leftValue = new Value(0);
    Value rightValue = new Value(0);
}
