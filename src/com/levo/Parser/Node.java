package com.levo.Parser;

/**
 * Created by lennart on 04.01.15.
 */
public class Node<T> {
    public T content;
    public Node<T> parent;
    public Node<T> leftChild;
    public Node<T> rightChild;

    public Node(T content) {
        this.content = content;
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    public int getLevel() {
        return this.isRoot() ? 0 : this.parent.getLevel() + 1;
    }

    public void addChild(T content) {
        Node<T> child = new Node<T>(content);
        child.parent = this;
        if (leftChild == null) {
            this.leftChild = child;
        } else if (leftChild == null) {
            this.rightChild = child;
        }
    }

    public void removeChild(Node<T> child) {
        if (this.leftChild == child) {
            this.leftChild = null;
        } else if (this.rightChild == child) {
            this.rightChild = null;
        }
    }
}
