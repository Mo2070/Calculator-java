package de.upb.se.profcalculator.interfaces;

import de.upb.se.profcalculator.main.Value;

public abstract class Expression {
    public abstract Value evaluate();
    public abstract String computeEquation();
    public abstract int getValue();  // Declare the getValue method
}
