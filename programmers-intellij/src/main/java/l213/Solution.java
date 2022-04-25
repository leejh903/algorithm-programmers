package l213;

import java.util.Arrays;

class Solution {
	// dp: 해당 index로부터 끝까지 갔을 경우 최대값
	int[] dp = new int[105];
	int max = Integer.MIN_VALUE;

	public int rob(int[] nums) {
		for (int i = 0; i <= 2; i++) {
			int length = nums.length;
			// do not rob when first one robbed
			// length 1 is exceptional case
			if (length != 1 && i == 0) {
				length--;
			}

			Arrays.fill(dp, -1);
			dp[i] = dfs(nums, i, length);
			max = Math.max(Math.max(max, dp[0]), Math.max(dp[1], dp[2]));
		}
		return max;
	}

	public int dfs(int[] nums, int current, int length) {
		if (dp[current] != -1)
			return dp[current];
		if (current >= length) {
			return 0;
		}

		int two = dfs(nums, current + 2, length);
		int three = dfs(nums, current + 3, length);
		return dp[current] = nums[current] + Math.max(two, three);
	}
}

