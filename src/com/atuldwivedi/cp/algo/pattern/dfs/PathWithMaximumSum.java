package com.atuldwivedi.cp.algo.pattern.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Atul Dwivedi
 */
public class PathWithMaximumSum {

    public static List<Integer> pathWithMaximumSum(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        int maxSum = 0;
        int currentSum = 0;
        pathWithMaximumSumRecursive(root, path, maxSum, currentSum);
        return path;
    }

    private static void pathWithMaximumSumRecursive(TreeNode root, List<Integer> path, int maxSum, int currentSum) {
        if (root == null) {
            return;
        }

        currentSum += root.val;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (currentSum > maxSum) {
                maxSum = currentSum;
            } else {
                path.remove(path.size() - 1);
            }
        }
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
