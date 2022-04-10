package l746;

import java.util.Arrays;

class Solution {
	// dp: 해당 index로부터 끝까지 갔을 경우 최소 cost
	int[] dp = new int[1002];
	int minCost = Integer.MAX_VALUE;

	public int minCostClimbingStairs(int[] cost) {
		Arrays.fill(dp, -1);
		dfs(cost, 0);
		return Math.min(dp[0], dp[1]);
	}

	public int dfs(int[] cost, int current) {
		if (dp[current] != -1)
			return dp[current];
		if (current >= cost.length) {
			return 0;
		}

		// climb one
		int one = dfs(cost, current + 1);
		// climb two
		int two = dfs(cost, current + 2);

		return dp[current] = cost[current] + Math.min(one, two);
	}
}
