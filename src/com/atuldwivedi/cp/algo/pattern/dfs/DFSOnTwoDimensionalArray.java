package com.atuldwivedi.cp.algo.pattern.dfs;

import java.util.Stack;

/**
 * @author Atul Dwivedi
 */
public class DFSOnTwoDimensionalArray {
    //left,down,right,up - anti clock wise start from left
    static int[] dRow = {0, 1, 0, -1};
    static int[] dCol = {-1, 0, 1, 0};

    /**
     * @param row
     * @param col
     * @param grid
     * @param visited all visited cells
     *                <p>
     *                Time Complexity: O(n*m)
     *                Space Complexity: O(n*m)
     *                Reference:
     *                https://www.geeksforgeeks.org/depth-first-traversal-dfs-on-a-2d-array/
     */
    private static void depthFirstSearch(int row, int col, int[][] grid, boolean[][] visited) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(row, col));

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            row = pair.first;
            col = pair.second;

            //continue to while loop id not valid
            if (!isValid(row, col, visited)) {
                continue;
            }

            //mark the current cell as visited
            visited[row][col] = true;
            System.out.print(grid[row][col] + " ");

            //push all the adjacent cells
            for (int i = 0; i < 4; i++) {
                stack.push(new Pair(dRow[i] + row, dCol[i] + col));
            }
        }
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static boolean isValid(int row, int col, boolean[][] visited) {
        if (row < 0 || row >= visited.length || col < 0 || col >= visited[0].length) {
            return false;
        }

        return !visited[row][col];
    }

    public static void main(String[] args) {
        int ROW = 3;
        int COL = 3;
        int[][] grid = {
                {-1, 2, 3},
                {0, 9, 8},
                {1, 0, 1}
        };

        boolean[][] visited = new boolean[ROW][COL];

        depthFirstSearch(0, 0, grid, visited);
    }
}
