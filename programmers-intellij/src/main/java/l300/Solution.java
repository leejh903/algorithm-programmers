package l300;

class Solution {
    public int lengthOfLIS(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;

        int answer = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] == 0) {
                dp[i] = 1;
            }
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}
