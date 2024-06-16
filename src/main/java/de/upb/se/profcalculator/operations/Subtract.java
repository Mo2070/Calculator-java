package de.upb.se.profcalculator.operations;

import de.upb.se.profcalculator.main.Value;
import de.upb.se.profcalculator.main.Expression;

public class Subtract extends Expression {

    public Subtract(Value leftOperand, Value rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public int evaluate() {
        return leftValue.getValue() - rightValue.getValue();
    }

    @Override
    public String computeEquation() {
        return represent("-") + " = " + evaluate();
    }
}
