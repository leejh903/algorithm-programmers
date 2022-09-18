package l1091;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, 1 }, { 1, 1 }, { 1, -1 },
            { -1, -1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) {
            return -1;
        }
        return bfs(grid, 0, 0);
    }

    int bfs(int[][] grid, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { row, col, 1 }); // row, col, length
        grid[row][col] = 1;

        while (!queue.isEmpty()) {
            int[] val = queue.poll();
            if (val[0] == grid.length - 1 && val[1] == grid[0].length - 1) {
                return val[2];
            }

            for (int i = 0; i < directions.length; i++) {
                int newRow = val[0] + directions[i][0];
                int newCol = val[1] + directions[i][1];

                if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) {
                    continue;
                }
                if (grid[newRow][newCol] != 0) {
                    continue;
                }
                grid[newRow][newCol] = 1;
                queue.add(new int[] { newRow, newCol, val[2] + 1 });
            }

        }
        return -1;
    }
}
