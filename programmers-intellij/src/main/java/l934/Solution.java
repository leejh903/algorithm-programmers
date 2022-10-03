package l934;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int shortestBridge(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean out = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                // once do dfs
                dfs(grid, queue, i, j);
                out = true;
                break;
            }
            if (out) {
                break;
            }
        }

        while (!queue.isEmpty()) {
            int[] queued = queue.poll();
            int row = queued[0];
            int col = queued[1];
            int distance = queued[2];

            for (int i = 0; i < DIRECTIONS.length; i++) {
                int newRow = row + DIRECTIONS[i][0];
                int newCol = col + DIRECTIONS[i][1];

                if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid.length) {
                    continue;
                }
                if (grid[newRow][newCol] == 1) {
                    return distance;
                }
                if (grid[newRow][newCol] == 0) {
                    grid[newRow][newCol] = 2;
                    queue.add(new int[] { newRow, newCol, distance + 1 });
                }
            }
        }

        return -1;
    }

    void dfs(int[][] grid, Queue<int[]> queue, int row, int col) {
        grid[row][col] = 2;
        queue.add(new int[] { row, col, 0 });

        for (int i = 0; i < DIRECTIONS.length; i++) {
            int newRow = row + DIRECTIONS[i][0];
            int newCol = col + DIRECTIONS[i][1];

            if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid.length) {
                continue;
            }
            if (grid[newRow][newCol] == 0 || grid[newRow][newCol] == 2) {
                continue;
            }
            dfs(grid, queue, newRow, newCol);
        }
    }
}
