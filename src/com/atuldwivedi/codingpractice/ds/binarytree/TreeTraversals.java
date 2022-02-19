package com.atuldwivedi.codingpractice.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Atul Dwivedi
 * @date 07/07/21
 */
public class TreeTraversals {

    //Inorder Traversal: (Left, Root, Right)
    public void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.data + "\t");
        inOrderTraversal(root.right);
    }

    //Preorder Traversal: (Root, Left, Right)
    public void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + "\t");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //Postorder Traversal: (Left, Right, Root)
    private void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + "\t");
    }

    //Level Order Traversal using tree height
    public void levelOrderTraversalUsingTreeHeight(Node root) {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printCurrentLevel(root, i);
        }
    }

    private int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            /* compute  height of each subtree */
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            /* use the larger one */
            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }
    }

    private void printCurrentLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + "\t");
        } else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    //Level Order Traversal using queue
    public void levelOrderTraversalUsingQueue(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + "\t");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
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

        TreeTraversals treeTraversals = new TreeTraversals();

        System.out.print("Inorder Traversal: \t\t");
        treeTraversals.inOrderTraversal(node1);
        System.out.println();

        System.out.print("Preorder Traversal: \t");
        treeTraversals.preOrderTraversal(node1);
        System.out.println();

        System.out.print("Postorder Traversal: \t");
        treeTraversals.postOrderTraversal(node1);
        System.out.println();

        System.out.print("Level Order Traversal(with height): \t");
        treeTraversals.levelOrderTraversalUsingTreeHeight(node1);
        System.out.println();

        System.out.print("Level Order Traversal(with queue): \t\t");
        treeTraversals.levelOrderTraversalUsingQueue(node1);
        System.out.println();

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
