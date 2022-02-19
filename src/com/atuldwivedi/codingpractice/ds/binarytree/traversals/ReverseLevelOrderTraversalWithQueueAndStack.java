package com.atuldwivedi.codingpractice.ds.binarytree.traversals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Atul Dwivedi
 * @date 07/07/21
 */
public class ReverseLevelOrderTraversalWithQueueAndStack {

    public void reverseLevelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            stack.add(node);

            if (node.right != null) {
                queue.add(node.right);
            }

            if (node.left != null) {
                queue.add(node.left);
            }
        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.data + "\t");
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

        ReverseLevelOrderTraversalWithQueueAndStack reverseLevelOrderTraversal = new ReverseLevelOrderTraversalWithQueueAndStack();
        reverseLevelOrderTraversal.reverseLevelOrderTraversal(node1);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

}

