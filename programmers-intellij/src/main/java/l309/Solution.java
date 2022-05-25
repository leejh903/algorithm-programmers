package l309;

class Solution {
    private int max = 0;

    public int maxProfit(int[] prices) {
        dfs(prices, 0, prices[0], 0);
        return max;
    }

    void dfs(int[] prices, int current, int buyPrice, int sum) {
        if (current >= prices.length) {
            max = Math.max(max, sum);
            return;
        }
        if (prices[current] < buyPrice) {
            dfs(prices, current + 1, prices[current], sum);
            return;
        }

        // do not sell
        dfs(prices, current + 1, buyPrice, sum);

        // sell
        int profit = prices[current] - buyPrice;
        dfs(prices, current + 2, prices[current], sum + profit);
    }
}
