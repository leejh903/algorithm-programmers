package l198;

import java.util.Arrays;

class Solution {
	// dp: 해당 index로부터 끝까지 갔을 경우 최대값
	int[] dp = new int[105];
	int max = Integer.MIN_VALUE;

	public int rob(int[] nums) {
		Arrays.fill(dp, -1);
		dfs(nums, 0);
		dfs(nums, 1);
		return Math.max(dp[0], dp[1]);
	}

	public int dfs(int[] nums, int current) {
		if (dp[current] != -1)
			return dp[current];
		if (current >= nums.length) {
			return 0;
		}

		int one = dfs(nums, current + 2);
		int two = dfs(nums, current + 3);
		return dp[current] = nums[current] + Math.max(one, two);
	}
}
