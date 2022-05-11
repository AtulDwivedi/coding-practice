package com.atuldwivedi.cp.algo.pattern.bfs;

import java.util.*;

/**
 * @author Atul Dwivedi
 */
public class LeftViewOfABinaryTree {

    /**
     * @param root
     * @return leftView
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static List<TreeNode> traverse(TreeNode root) {
        if (root == null) {
            Collections.emptyList();
        }

        List<TreeNode> leftView = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (i == 0) {
                    leftView.add(node);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return leftView;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = traverse(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }
}
