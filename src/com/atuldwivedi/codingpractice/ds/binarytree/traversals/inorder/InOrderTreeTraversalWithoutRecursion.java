package com.atuldwivedi.codingpractice.ds.binarytree.traversals.inorder;

import java.util.Stack;

/**
 * @author Atul Dwivedi
 * @date 09/07/21
 */
public class InOrderTreeTraversalWithoutRecursion {

    public void inorder(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            Node node = stack.pop();
            System.out.print(node.data + "\t");

            curr = node.right;
        }

    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        InOrderTreeTraversalWithoutRecursion inOrderTreeTraversalWithoutRecursion = new InOrderTreeTraversalWithoutRecursion();
        inOrderTreeTraversalWithoutRecursion.inorder(node1);
    }
}
