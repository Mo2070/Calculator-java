package de.upb.se.profcalculator.operations;

import de.upb.se.profcalculator.interfaces.BinaryExpression;
import de.upb.se.profcalculator.interfaces.Expression;
import de.upb.se.profcalculator.main.Value;

public class Subtract extends BinaryExpression {

    public Subtract(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Value evaluate() {
        return new Value(leftOperand.evaluate().getValue() - rightOperand.evaluate().getValue());
    }

    @Override
    protected String getOperator() {
        return "-";
    }
}