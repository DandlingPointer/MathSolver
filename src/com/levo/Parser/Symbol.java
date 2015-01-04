package com.levo.Parser;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by lennart on 04.01.15.
 */
public class Symbol {
    public enum SymbolType {
        NUMBER, VARIABLE, FUNCTION, BIFUNCTION
    }

    public SymbolType type;
    public Number number;
    public BiFunction<Number, Number, Number> bifunction;
    public Function<Number, Number> function;
    public Character varName;

    public Symbol(Number number) {
        this.type = SymbolType.NUMBER;
        this.number = number;
    }

    public Symbol(BiFunction<Number, Number, Number> bifunction) {
        this.type = SymbolType.BIFUNCTION;
        this.bifunction = bifunction;
    }

    public Symbol(Function<Number, Number> function) {
        this.type = SymbolType.FUNCTION;
        this.function = function;
    }

    public Symbol(Character name) {
        this.type = SymbolType.VARIABLE;
    }
}
