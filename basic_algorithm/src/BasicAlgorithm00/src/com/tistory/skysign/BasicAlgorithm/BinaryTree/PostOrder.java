package com.tistory.skysign.BasicAlgorithm.BinaryTree;

import java.util.Stack;

public class PostOrder extends BinaryTreeBase{
    static void postorder(BinaryTreeNode n) {
        if (null != n.childLeft) {
            postorder(n.childLeft);
        }

        if (null != n.childRight) {
            postorder(n.childRight);
        }

        visit(n);
    }

    static void postorder_stack(BinaryTreeNode n) {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();

        stack.push(n);

        while (false == stack.empty()) {
            n = stack.pop();

            if ((null == n.childLeft) && (null == n.childRight)) {
                visit(n);
                continue;
            }
            else {
                stack.push(n);

                if (null != n.childRight) {
                    stack.push(n.childRight);
                    n.childRight = null;
                }

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

        System.out.println("post-order!");
        postorder(A);
        System.out.println("");

        System.out.println("post-order stack!");
        postorder_stack(A);
        System.out.println("");
    }
}
