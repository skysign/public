package com.tistory.skysign.BasicAlgorithm;

import java.util.Stack;

public class Main {
    static void preorder(Node node) {
        Stack<Node> stack = new Stack<Node>();

        stack.push(node);

        while (false == stack.empty())
        {
            Node n = stack.pop();
            visit(n);

            if (null != n.childRight) {
                stack.push(n.childRight);
            }

            if (null != n.childLeft) {
                stack.push(n.childLeft);
            }
        }
    }

    static void inorder(Node n) {
        if (null != n.childLeft) {
            inorder(n.childLeft);
        }

        visit(n);

        if (null != n.childRight) {
            inorder(n.childRight);
        }
    }

    static void inorder_stack(Node n) {
        Stack<Node> stack = new Stack<Node>();

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

    static void postorder(Node n) {
        if (null != n.childLeft) {
            postorder(n.childLeft);
        }

        if (null != n.childRight) {
            postorder(n.childRight);
        }

        visit(n);
    }

    static void postorder_stack(Node n) {
        Stack<Node> stack = new Stack<Node>();

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

    static void run() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');

        A.childLeft = B;
        A.childRight= C;

        B.childLeft = D;
        B.childRight= E;

        C.childLeft = F;
        C.childRight= G;

        System.out.println("pre-order!");
        preorder(A);
        System.out.println("");

        System.out.println("in-order!");
        inorder(A);
        System.out.println("");

        System.out.println("in-order stack!");
        inorder_stack(A);
        System.out.println("");

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

    static void visit(Node node) {
        System.out.print(node.v);
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        //run();

        System.out.println("SelectionSort");
        SelectionSort.run();
        System.out.println("InsertionSort");
        InsertionSort.run();
        System.out.println("BubbleSort");
        BubbleSort.run();
    }
}