package com.atuldwivedi.cp.algo.pattern.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Atul Dwivedi
 */
public class BFSOnTwoDimensionalArray {
    //up,left,down,right - anti clock wise start from up
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};

    private static void breadthFirstSearch(int row, int col, int[][] grid, boolean[][] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            row = pair.first;
            col = pair.second;

            System.out.print(grid[row][col] + " ");

            for (int i = 0; i < 4; i++) {
                int adjRow = row + dRow[i];
                int adjCol = col + dCol[i];

                if (isValid(adjRow, adjCol, visited)) {
                    queue.add(new Pair(adjRow, adjCol));
                    visited[adjRow][adjCol] = true;
                }
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

        int ROW = 4;
        int COL = 4;

        // Given input matrix
        int[][] grid = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        // Declare the visited array
        boolean[][] visited = new boolean[ROW][COL];

        breadthFirstSearch(0, 0, grid, visited);
    }
}
