package com.levo.Parser;

import java.util.ArrayList;

/**
 * Created by lennart on 04.01.15.
 */
public class Node<T> {
    private T content;
    private Node<T> parent;
    private ArrayList<Node<T>> children;

    public Node(T content) {
        this.content = content;
        this.children = new ArrayList<Node<T>>();
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return children.size() == 0;
    }

    public int getLevel() {
        return this.isRoot() ? 0 : this.parent.getLevel() + 1;
    }

    public void addChild(T content) {
        Node<T> child = new Node<T>(content);
        child.parent = this;
        this.children.add(child);
    }
    public Node<T> removeChild(Node<T> child) {
        for (Node<T> node : children) {
            if (node == child) {
                children.remove(child);
                child.parent = null;
                return child;
            }
        }
        return null;
    }
}
