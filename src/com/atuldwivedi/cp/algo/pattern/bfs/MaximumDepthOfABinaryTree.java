package com.atuldwivedi.cp.algo.pattern.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Atul Dwivedi
 */
public class MaximumDepthOfABinaryTree {

    /**
     * @param root
     * @return height of binary tree
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maximumTreeDepth = 0;

        while (!queue.isEmpty()) {
            maximumTreeDepth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return maximumTreeDepth;
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
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + findHeight(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + findHeight(root));
    }
}
