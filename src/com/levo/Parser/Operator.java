package com.levo.Parser;

/**
 * Created by lennart on 05.01.15.
 */
public class Operator {
    public char operator;
    public int precedence;
    public boolean isRightPrecedence;

    public Operator(char operator, int precedence, boolean isRightPrecedence) {
        this.operator = operator;
        this.precedence = precedence;
        this.isRightPrecedence = isRightPrecedence;
    }
}
