package com.atuldwivedi.codingpractice.ds.binarytree.traversals;

/**
 * @author Atul Dwivedi
 * @date 08/07/21
 */
public class SpiralLevelOrderTraversalUsingHeight {

    public void spiralLevelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        int height = height(root);
        boolean order = false;
        for (int i = 1; i <= height; i++) {
            printCurrentLevel(root, i, order);
            order = !order;
        }
    }

    private void printCurrentLevel(Node root, int level, boolean order) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            System.out.print(root.data + "\t");
        }

        if (order) {
            printCurrentLevel(root.left, level - 1, order);
            printCurrentLevel(root.right, level - 1, order);
        } else {
            printCurrentLevel(root.right, level - 1, order);
            printCurrentLevel(root.left, level - 1, order);
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

        SpiralLevelOrderTraversalUsingHeight spiralLevelOrderTraversal = new SpiralLevelOrderTraversalUsingHeight();
        spiralLevelOrderTraversal.spiralLevelOrderTraversal(node1);
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
