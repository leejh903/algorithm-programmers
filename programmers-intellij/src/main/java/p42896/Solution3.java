package p42896;

public class Solution3 {
        public int solution(int[] left, int[] right) {
            int[][] dp = new int[left.length + 1][right.length + 1];

            for (int i = 1; i <= left.length; i++) {
                for (int j = 1; j <= right.length; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                    if(left[i - 1] > right[j - 1]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + right[j - 1]);
                    }
                }
            }

            int answer = 0;
            for (int i = 1; i <= right.length; i++) {
                answer = Math.max(answer, dp[left.length][i]);
            }
            return answer;
        }
}
