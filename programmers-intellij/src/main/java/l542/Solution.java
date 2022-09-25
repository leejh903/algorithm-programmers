package l542;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private int[][] DIRECTIONS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int[][] updateMatrix(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                if (mat[r][c] == 0) {
                    queue.add(new int[] { r, c });
                    visited[r][c] = true;
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

                if (newRow < 0 || newRow >= mat.length || newCol < 0 || newCol >= mat[0].length
                        || visited[newRow][newCol]) {
                    continue;
                }

                mat[newRow][newCol] = mat[row][col] + 1;
                visited[newRow][newCol] = true;
                queue.add(new int[] { newRow, newCol });
            }
        }
        return mat;
    }
}
