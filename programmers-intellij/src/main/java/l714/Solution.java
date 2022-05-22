package l714;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int answer = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] > min + fee) {
                answer += prices[i] - min - fee;
                min = prices[i] - fee;
            }
        }
        return answer;
    }
}
