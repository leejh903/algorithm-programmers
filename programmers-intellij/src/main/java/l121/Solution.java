package l121;

class Solution {
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int buyPrice = prices[0];
		for (int i = 0; i < prices.length; i++) {
			int currentPrice = prices[i];
			if(prices[i] < buyPrice) {
				buyPrice = currentPrice;
				continue;
			}
			maxProfit = Math.max(maxProfit, currentPrice - buyPrice);
		}	
	return maxProfit;
    }
}

			
