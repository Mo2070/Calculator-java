package de.upb.se.profcalculator.interfaces;

import de.upb.se.profcalculator.main.Value;

public abstract class BinaryExpression extends Expression {
    protected final Expression leftOperand;
    protected final Expression rightOperand;

    public BinaryExpression(Expression leftOperand, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public abstract Value evaluate();

    public String computeEquation() {
        return leftOperand.computeEquation() + " " + getOperator() + " " + rightOperand.computeEquation();
    }

    protected abstract String getOperator();
}
