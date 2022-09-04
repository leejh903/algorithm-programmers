package l221;

class Solution {
    int[][] dp;
    public int maximalSquare(char[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];

        int answer = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if(r == 0 || c == 0 || matrix[r][c] == '0') {
                    dp[r][c] = matrix[r][c] - '0';
                } else {
                    dp[r][c] = Math.min(dp[r-1][c-1], Math.min(dp[r-1][c], dp[r][c-1])) + 1;
                }
                answer = Math.max(answer, dp[r][c] * dp[r][c]);
            }
        }
        return answer;
    }
}
