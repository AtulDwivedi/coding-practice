package com.atuldwivedi.cp.algo.pattern.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Atul Dwivedi
 */
public class AllPathsForASum {

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findAllPathRecursive(root, sum, allPaths, currentPath);
        return allPaths;
    }

    private static void findAllPathRecursive(TreeNode root, int sum, List<List<Integer>> allPaths, List<Integer> currentPath) {
        if (root == null) {
            return;
        }

        currentPath.add(root.val);

        if (root.val == sum && root.left == null && root.right == null) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            findAllPathRecursive(root.left, sum - root.val, allPaths, currentPath);
            findAllPathRecursive(root.right, sum - root.val, allPaths, currentPath);
        }

        currentPath.remove(currentPath.size() - 1);
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
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
