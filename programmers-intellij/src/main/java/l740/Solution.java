package l740;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	int[] dp = new int[20000 + 5];

	public int deleteAndEarn(int[] nums) {
		Map<Integer, Integer> numCounts = new HashMap<>();
		for (int num : nums) {
			if (numCounts.containsKey(num)) {
				numCounts.put(num, numCounts.get(num) + 1);
				continue;
			}
			numCounts.put(num, 1);
		}

		// newNums is sum of (each number * each count)
		int[] newNums = new int[10001];
		for (int key : numCounts.keySet()) {
			newNums[key] = key * numCounts.get(key);
		}

		Arrays.fill(dp, -1);
		dfs(newNums, 0);
		dfs(newNums, 1);
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
