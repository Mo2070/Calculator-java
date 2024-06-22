package de.upb.se.profcalculator.operations;

import de.upb.se.profcalculator.interfaces.Expression;
import de.upb.se.profcalculator.main.Value;

public class Multiply extends Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public Multiply(Expression leftOperand, Expression rightOperand) {
        this.leftExpression = leftOperand;
        this.rightExpression = rightOperand;
    }

    @Override
    public Value evaluate() {
        return new Value(leftExpression.evaluate().getValue() * rightExpression.evaluate().getValue());
    }

    @Override
    public String computeEquation() {
        return "(" + leftExpression.computeEquation() + " * " + rightExpression.computeEquation() + ")";
    }

    @Override
    public int getValue() {
        return evaluate().getValue();
    }
}
