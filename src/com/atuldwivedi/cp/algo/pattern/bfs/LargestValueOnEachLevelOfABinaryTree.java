package com.atuldwivedi.cp.algo.pattern.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Atul Dwivedi
 */
public class LargestValueOnEachLevelOfABinaryTree {

    /**
     * @param root
     * @return level order traversal
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static List<Integer> findLargestValueAtEachLevels(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Integer largestValue = Integer.MIN_VALUE;

            for (int i = 0; i < levelSize; i++) {
                TreeNode treeNode = queue.poll();
                largestValue = Math.max(largestValue, treeNode.val);

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }

            result.add(largestValue);
        }

        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Integer> result = findLargestValueAtEachLevels(root);
        System.out.print("Level values at each level are: " + result);
    }
}
