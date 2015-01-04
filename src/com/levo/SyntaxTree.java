package com.levo;
/**
 * Created by lennart on 04.01.15.
 */
public class SyntaxTree {
    public static class Symbol {
        public static enum SymbolType {
            NUMBER, VARIABLE, FUNCTION, INFIX_OPERATOR, PREFIX_OPERATOR
        }
    }
    private Node<Symbol> tree;
}
