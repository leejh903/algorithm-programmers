package p42896;

class Solution {
    public int solution(int[] left, int[] right) {
        int answer = 0;
        int length = left.length;

        int[][] dp = new int[2005][2005];
        int[] newLeft = new int[2005];
        int[] newRight = new int[2005];

        for (int i = 1; i <= length; i++) {
            newLeft[i] = left[i - 1];
            newRight[i] = right[i - 1];
        }
        
        for (int i = 1; i <= length + 1; i++) {
            dp[0][i] = -1;
        }

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i-1][j]);
                if(dp[i][j - 1] != -1 && newLeft[i] > newRight[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + newRight[j - 1]);
                }
            }
        }

        for (int i = 1; i <= length + 1; i++) {
            if(answer < dp[length][i]) answer = dp[length][i];
        }
        return answer;
    }
}
