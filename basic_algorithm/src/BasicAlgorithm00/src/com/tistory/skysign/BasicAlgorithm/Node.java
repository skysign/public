package com.tistory.skysign.BasicAlgorithm;

public class Node {
    char v;
    Node childLeft;
    Node childRight;

    public Node(char c) {
        this.v = c;
        this.childLeft = null;
        this.childRight = null;
    }
}