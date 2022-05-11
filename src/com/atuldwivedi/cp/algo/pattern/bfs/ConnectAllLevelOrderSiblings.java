package com.atuldwivedi.cp.algo.pattern.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Atul Dwivedi
 */
public class ConnectAllLevelOrderSiblings {

    /**
     * @param root <p>
     *             Time Complexity: O(n)
     *             Space Complexity: O(n)
     */
    public static void connect(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode prevNode = null, currNode = null;

        while (!queue.isEmpty()) {
            currNode = queue.poll();
            if (prevNode != null) {
                prevNode.next = currNode;
            }
            prevNode = currNode;

            if (currNode.left != null) {
                queue.offer(currNode.left);
            }

            if (currNode.right != null) {
                queue.offer(currNode.right);
            }
        }
    }

    static class TreeNode {
        int val;
        TreeNode left, right, next;

        public TreeNode(int val) {
            this.val = val;
        }

        public void printTree() {
            TreeNode current = this;
            System.out.print("Traversal using 'next' pointer: ");
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        connect(root);
        root.printTree();
    }
}
