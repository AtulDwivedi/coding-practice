package com.atuldwivedi.cp.ds.binarytree.traversals;

import java.util.Stack;

/**
 * @author Atul Dwivedi
 * @date 08/07/21
 */
public class SpiralLevelOrderTraversalUsingTwoStacks {

    public void spiralLevelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.add(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Node node = s1.pop();
                System.out.print(node.data + "\t");
                if (node.right != null) {
                    s2.add(node.right);
                }
                if (node.left != null) {
                    s2.add(node.left);
                }
            }

            while (!s2.isEmpty()) {
                Node node = s2.pop();
                System.out.print(node.data + "\t");
                if (node.left != null) {
                    s1.add(node.left);
                }
                if (node.right != null) {
                    s1.add(node.right);
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

        SpiralLevelOrderTraversalUsingTwoStacks spiralLevelOrderTraversal = new SpiralLevelOrderTraversalUsingTwoStacks();
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
