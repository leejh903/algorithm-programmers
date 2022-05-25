package l309;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<String, Integer> dp;

    public int maxProfit(int[] prices) {
        dp = new HashMap<>();
        dfs(prices, 0, true);
        return dp.get(String.format("%d-%b", 0, true));
    }

    int dfs(int[] prices, int current, boolean canBuy) {
        if (current >= prices.length) {
            return 0;
        }

        String key = String.format("%d-%b", current, canBuy);
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (canBuy) {
            int bought = dfs(prices, current + 1, false) - prices[current];
            int cooldown = dfs(prices, current + 1, true);
            dp.put(key, Math.max(bought, cooldown));
        }
        // sell
        if (!canBuy) {
            int sold = dfs(prices, current + 2, true) + prices[current];
            int cooldown = dfs(prices, current + 1, false);
            dp.put(key, Math.max(sold, cooldown));
        }
        return dp.get(key);
    }
}
