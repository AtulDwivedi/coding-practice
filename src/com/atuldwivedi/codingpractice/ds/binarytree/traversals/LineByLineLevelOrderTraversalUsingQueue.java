package com.atuldwivedi.codingpractice.ds.binarytree.traversals;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Atul Dwivedi
 * @date 09/07/21
 */
public class LineByLineLevelOrderTraversalUsingQueue {

    public void lineByLineLevelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                    System.out.println();
                }
            } else {
                System.out.print(node.data + "\t");
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
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

        LineByLineLevelOrderTraversalUsingQueue lineByLineLevelOrderTraversalUsingQueue = new LineByLineLevelOrderTraversalUsingQueue();
        lineByLineLevelOrderTraversalUsingQueue.lineByLineLevelOrderTraversal(node1);
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
