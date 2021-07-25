package p12904;

class Solution {
    public int solution(String s) {
        int answer = 1;
        int len = s.length();
        char[] words = s.toCharArray();
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i < len - 1; i++) {
            if (words[i] == words[i + 1]) {
                dp[i][i + 1] = 1;
                answer = 2;
            }
        }

        for (int l = 3; l <= len; l++) {
            for (int i = 0; i <= len - l; i++) {
                int j = i + l - 1;
                if (words[i] == words[j] && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    answer = Math.max(answer, l);
                }
            }
        }

        return answer;
    }
}