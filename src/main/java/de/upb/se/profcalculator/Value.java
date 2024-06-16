package de.upb.se.profcalculator;

public class Value {
    Integer value;

    public Value() {
        this.value = 0;
    }

    public Value(int value) {
        this.value = value;
    }

    public static Value parseValue(String str) throws NumberFormatException {
        int intValue = Integer.parseInt(str);
        return new Value(intValue);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public int getValue() {
        return value;
    }
}
