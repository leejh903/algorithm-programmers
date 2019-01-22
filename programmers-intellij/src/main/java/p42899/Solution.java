package p42899;

class Solution {
    public int solution(int K, int[][] travel) {
        int answer = 0;

        int n = travel.length;
        int[][] dp = new int[n + 1][K + 1];
        boolean[][] visit = new boolean[n + 1][K + 1];

        visit[0][0] = true;
        for (int i = 0; i < n; i++) {
            int wt = travel[i][0];
            int wc = travel[i][1];
            int bt = travel[i][2];
            int bc = travel[i][3];

            for (int j = 0; j <= K; j++) {
                if(!visit[i][j]) continue;
                if(j + wt <= K) {
                    dp[i + 1][j + wt] = dp[i][j] + wc;
                    visit[i + 1][j + wt] = true;
                }
                if(j + bt <= K) {
                    dp[i + 1][j + bt] = Math.max(dp[i + 1][j + bt], dp[i][j] + bc);
                    visit[i + 1][j + bt] = true;
                }
            }
        }

        for (int i = 0; i <= K; i++) {
            answer = Math.max(answer, dp[n][i]);
        }

        return answer;
    }
}
