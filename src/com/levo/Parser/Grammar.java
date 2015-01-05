package com.levo.Parser;

import java.util.Set;

/**
 * Created by lennart on 05.01.15.
 */
public class Grammar {
    public Set<String> functions;
    public Set<Character> argumentDelimiter;
    public Set<Operator> operators;

    public Grammar(Set<String> functions, Set<Character> argumentDelimiter, Set<Operator> operators) {
        this.functions = functions;
        this.argumentDelimiter = argumentDelimiter;
        this.operators = operators;
    }

    public boolean operatorsContain(char val) {
        for (Operator op : operators) {
            if (op.operator == val) return true;
        }
        return false;
    }

    public Operator getOperator(char val) {
        for (Operator op : operators) {
            if (op.operator == val) return op;
        }
        return null;
    }
}
