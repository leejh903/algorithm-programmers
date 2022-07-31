package l931;

import java.util.Arrays;

class Solution {
    static private final int INITIAL = 10001;
    private int[][] dp;

    public int minFallingPathSum(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(dp[i], INITIAL);
        }

        int answer = INITIAL;
        for (int i = 0; i < matrix[0].length; i++) {
            answer = Math.min(answer, dfs(matrix, 0, i));
        }
        return answer;
    }

    public int dfs(int[][] matrix, int row, int col) {
        if (dp[row][col] != INITIAL) {
            return dp[row][col];
        }

        if (row + 1 == matrix.length) {
            return dp[row][col] = matrix[row][col];
        }

        // below
        int min = dfs(matrix, row + 1, col);
        // diagonally left
        if (col - 1 >= 0) {
            min = Math.min(min, dfs(matrix, row + 1, col - 1));
        }
        // diagonally right
        if (col + 1 < matrix[row].length) {
            min = Math.min(min, dfs(matrix, row + 1, col + 1));
        }

        return dp[row][col] = matrix[row][col] + min;
    }
}
