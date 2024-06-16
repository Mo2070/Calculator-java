package de.upb.se.profcalculator.main;

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

    public int getValue() {
        return value.intValue();
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Value value1 = (Value) obj;
        return value.equals(value1.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
