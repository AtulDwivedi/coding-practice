package com.atuldwivedi.cp.algo.pattern.bfs;

import java.util.*;

/**
 * @author Atul Dwivedi
 */
public class RightViewOfABinaryTree {

    /**
     * @param root
     * @return rightView
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static List<TreeNode> traverse(TreeNode root) {
        if (root == null) {
            Collections.emptyList();
        }

        List<TreeNode> rightView = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (i == levelSize - 1) {
                    rightView.add(node);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return rightView;
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
