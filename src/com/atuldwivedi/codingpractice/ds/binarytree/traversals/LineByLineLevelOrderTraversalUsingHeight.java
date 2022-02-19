package com.atuldwivedi.codingpractice.ds.binarytree.traversals;

/**
 * @author Atul Dwivedi
 * @date 09/07/21
 */
public class LineByLineLevelOrderTraversalUsingHeight {

    public void lineByLineLevelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        int height = height(root);

        for (int i = 1; i <= height; i++) {
            System.out.println();
            printCurrentLevel(root, i);
        }
    }

    private void printCurrentLevel(Node root, int level) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            System.out.print(root.data + "\t");
        } else {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    private int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight > rightHeight) {
            return ++leftHeight;
        } else {
            return ++rightHeight;
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

        LineByLineLevelOrderTraversalUsingHeight lineByLineLevelOrderTraversalUsingQueue = new LineByLineLevelOrderTraversalUsingHeight();
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
