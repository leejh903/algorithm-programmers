package p12971;

class Solution {
    private int[] sticker;
    private int[][] dp;

    public int solution(int sticker[]) {
        this.dp = new int[2][sticker.length];
        this.sticker = sticker;

        int val1 = dfs(1, 2, sticker[0]);
        int val2 = dfs(0, 1, 0);

        return Math.max(val1, val2);
    }

    public int dfs(int firstSelected, int index, int sum) {
        if (index >= sticker.length || (firstSelected == 1 && index == sticker.length - 1)) {
            return sum;
        }
        if (dp[firstSelected][index] > 0) {
            return sum + dp[firstSelected][index];
        }

        // choose
        int val1 = dfs(firstSelected, index + 2, sum + sticker[index]);
        // not choose
        int val2 = dfs(firstSelected, index + 1, sum);

        int val = Math.max(val1, val2);
        dp[firstSelected][index] = val - sum;
        return val;
    }
}