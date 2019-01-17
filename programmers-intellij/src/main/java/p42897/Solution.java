package p42897;

class Solution {
    public int solution(int[] money) {
        int length = money.length;

        if(length == 3) {
            return Math.max(money[0], Math.max(money[1], money[2]));
        }

        int[] dp = new int[length];  // 처음 포함
        dp[0] = money[0];
        dp[1] = money[0];
        int[] dp2 = new int[length];  // 처음 포함x
        dp2[0] = 0;
        dp2[1] = money[1];

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }

        return Math.max(dp[length - 2], dp2[length - 1]);
    }
}