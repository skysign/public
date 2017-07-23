package com.tistory.skysign.BasicAlgorithm.BinaryTree;

public class BinaryTreeNode {
    char v;
    BinaryTreeNode childLeft;
    BinaryTreeNode childRight;

    public BinaryTreeNode(char c) {
        this.v = c;
        this.childLeft = null;
        this.childRight = null;
    }
}