package com.levo.Parser;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by lennart on 04.01.15.
 */
public class Symbol {
    public enum SymbolType {
        NUMBER, VARIABLE, UNARY_OP, BINARY_OP
    }

    public SymbolType type;
    public Number number;
    public BiFunction<Number, Number, Number> binaryOperator;
    public Function<Number, Number> unaryOperator;
    public Character varName;

    public Symbol(Number number) {
        this.type = SymbolType.NUMBER;
        this.number = number;
    }

    public Symbol(BiFunction<Number, Number, Number> binaryOperator) {
        this.type = SymbolType.BINARY_OP;
        this.binaryOperator = binaryOperator;
    }

    public Symbol(Function<Number, Number> unaryOperator) {
        this.type = SymbolType.UNARY_OP;
        this.unaryOperator = unaryOperator;
    }

    public Symbol(Character name) {
        this.type = SymbolType.VARIABLE;
    }

    public SymbolType getType() {
        return type;
    }

    public Number getNumber() {
        return number;
    }

    public BiFunction<Number, Number, Number> getBinaryOperator() {
        return binaryOperator;
    }

    public Function<Number, Number> getUnaryOperator() {
        return unaryOperator;
    }

    public Character getVarName() {
        return varName;
    }
}
