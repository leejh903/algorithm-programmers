package l714;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 0; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee); // sell
            hold = Math.max(hold, cash - prices[i]); // buy
        }
        return cash;
    }
}
