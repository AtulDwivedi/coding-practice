package com.atuldwivedi.cp.leetcode.p0463;

/**
 * @author Atul Dwivedi
 */
public class IslandPerimeter {

    /**
     * @param grid
     * @return perimeter
     * <p>
     * Time Complexity: O(n*m)
     * Space Complexity: O(1)
     * References:
     * https://www.geeksforgeeks.org/find-perimeter-shapes-formed-1s-binary-matrix/
     */
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += (4 - numberOfNeighbour(i, j, grid));
                }
            }
        }
        return perimeter;
    }

    private int numberOfNeighbour(int currRow, int currCol, int[][] grid) {
        int neighbourCount = 0;

        //UP
        if (currRow > 0 && grid[currRow - 1][currCol] == 1) {
            neighbourCount++;
        }

        //LEFT
        if (currCol > 0 && grid[currRow][currCol - 1] == 1) {
            neighbourCount++;
        }

        //DOWN
        if (currRow < grid.length - 1 && grid[currRow + 1][currCol] == 1) {
            neighbourCount++;
        }

        //RIGHT
        if (currCol < grid[currRow].length - 1 && grid[currRow][currCol + 1] == 1) {
            neighbourCount++;
        }

        return neighbourCount;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0}
        };

        System.out.println(new IslandPerimeter().islandPerimeter(grid));
    }
}
