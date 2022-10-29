package l1143;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int answer = 0;
        if (text1.length() == 0 || text2.length() == 0) {
            return answer;
        }

        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (i == 0) {
                    if (text2.substring(0, j + 1).chars().anyMatch(num -> num == text1.charAt(0))) {
                        dp[i][j] = 1;
                    }
                    continue;
                }
                if (j == 0) {
                    if (text1.substring(0, i + 1).chars().anyMatch(num -> num == text2.charAt(0))) {
                        dp[i][j] = 1;
                    }
                    continue;
                }

                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }
}
