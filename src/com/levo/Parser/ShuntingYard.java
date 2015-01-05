package com.levo.Parser;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by lennart on 05.01.15.
 */
public class ShuntingYard {
    private String[] postfixExpression;
    private String[] tokenizedExpression;
    private Grammar grammar;

    public ShuntingYard(String expression, Grammar grammar) {
        this.grammar = grammar;
        tokenizedExpression = tokenize(expression);
    }

    private String[] tokenize(String expression) {
        ArrayList<String> result = new ArrayList<String>();
        String token = "";
        for (int i = 0; i < expression.length(); i++) {
            char currChar = expression.charAt(i);
            char lastChar = i == 0 ? ' ' : expression.charAt(i - 1);
            if (Character.isDigit(currChar) || currChar == '.') { //Char is part of Number
                if (Character.isDigit(lastChar) || lastChar == '.') {
                    token += currChar;
                } else {
                    result.add(token);
                    token = "";
                    if (Character.isAlphabetic(lastChar)) {
                        result.add("*");
                    }
                }
            } else if (Character.isAlphabetic(currChar)) { //Char is part of variable or function
                if (Character.isAlphabetic(lastChar)) {
                    token += currChar;
                } else {
                    if (grammar.functions.contains(token)) {
                        result.add(token);
                    } else {
                        result.add(Character.toString(token.charAt(0)));
                        for (int j = 1; i < token.length(); i++) {
                            result.add("*");
                            result.add(Character.toString(token.charAt(j)));
                        }
                    }
                    if (Character.isDigit(lastChar) || lastChar == '.') {
                        result.add("*");
                    }
                    token = "";
                }
            } else if (currChar == ' ' && lastChar != ' ') { //char is whitespace
                result.add(token);
                token = "";
            } else if (grammar.operatorsContain(currChar)
                    || grammar.argumentDelimiter.contains(currChar)) {

                result.add(Character.toString(currChar));
            } else {
                throw new UnsupportedOperationException("This Operator is not known");
            }
        }
        return (String[]) result.toArray();
    }

    public void generatePostfixExpression() {
        Stack<String> operatorStack = new Stack<String>();
        ArrayList<String> result = new ArrayList<String>();
        for (String token : tokenizedExpression) {
        }
    }

    public String[] getPostfixExpression() {
        return postfixExpression;
    }

    public void setExpression(String expression) {
        this.tokenizedExpression = tokenize(expression);
    }

    public Grammar getGrammar() {
        return grammar;
    }

    public void setGrammar(Grammar grammar) {
        this.grammar = grammar;
    }
}
