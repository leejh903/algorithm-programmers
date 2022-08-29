package l1162;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static final int[][] DIRECTIONS = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int answer = -1;

    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    queue.add(new int[] { r, c });
                }
            }
        }

        int res = -1;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int row = p[0];
            int col = p[1];

            for (int i = 0; i < DIRECTIONS.length; i++) {
                int newRow = p[0] + DIRECTIONS[i][0];
                int newCol = p[1] + DIRECTIONS[i][1];

                // grid[newRow][newCol] != 0 means it is already visited by other close land
                if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length
                        || grid[newRow][newCol] != 0) {
                    continue;
                }

                grid[newRow][newCol] = grid[row][col] + 1;
                res = Math.max(res, grid[newRow][newCol]);
                queue.add(new int[] { newRow, newCol });
            }
        }

        // res -1 b/c it start from land(1)
        return res == -1 ? -1 : res - 1;
    }
}
