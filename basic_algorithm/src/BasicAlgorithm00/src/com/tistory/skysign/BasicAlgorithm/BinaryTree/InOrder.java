package com.tistory.skysign.BasicAlgorithm.BinaryTree;

import java.util.Stack;

public class InOrder extends BinaryTreeBase{
    static void inorder(BinaryTreeNode n) {
        if (null != n.childLeft) {
            inorder(n.childLeft);
        }

        visit(n);

        if (null != n.childRight) {
            inorder(n.childRight);
        }
    }

    static void inorder_stack(BinaryTreeNode n) {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();

        stack.push(n);

        while (false == stack.empty()) {
            n = stack.pop();

            if ((null == n.childLeft) && (null == n.childRight)) {
                visit(n);
                continue;
            }
            else {
                if (null != n.childRight) {
                    stack.push(n.childRight);
                    n.childRight = null;
                }

                stack.push(n);

                if (null != n.childLeft) {
                    stack.push(n.childLeft);
                    n.childLeft = null;
                }
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

        System.out.println("in-order!");
        inorder(A);
        System.out.println("");

        System.out.println("in-order stack!");
        inorder_stack(A);
        System.out.println("");
    }
}
