package com.tistory.skysign.BasicAlgorithm.BinaryTree;

import java.util.Stack;

public class PreOrder extends BinaryTreeBase {
    static void preorder(BinaryTreeNode binaryTreeNode) {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();

        stack.push(binaryTreeNode);

        while (false == stack.empty())
        {
            BinaryTreeNode n = stack.pop();
            visit(n);

            if (null != n.childRight) {
                stack.push(n.childRight);
            }

            if (null != n.childLeft) {
                stack.push(n.childLeft);
            }
        }
    }

    static public void run() {
        BinaryTreeNode A = new BinaryTreeNode('A');
        BinaryTreeNode B = new BinaryTreeNode('B');
        BinaryTreeNode C = new BinaryTreeNode('C');
        BinaryTreeNode D = new BinaryTreeNode('D');
        BinaryTreeNode E = new BinaryTreeNode('E');
        BinaryTreeNode F = new BinaryTreeNode('F');
        BinaryTreeNode G = new BinaryTreeNode('G');

        A.childLeft = B;
        A.childRight= C;

        B.childLeft = D;
        B.childRight= E;

        C.childLeft = F;
        C.childRight= G;

        System.out.println("pre-order!");
        preorder(A);
        System.out.println("");
    }
}
