package l45;

class Solution {
	// dp is lowest distance from current index to last index
	private int[] dp;

	public int jump(int[] nums) {
		if (nums.length == 1)
			return 0;
		dp = new int[nums.length];
		return dfs(nums, 0);
	}

	public int dfs(int[] nums, int index) {
		if (index == nums.length - 1) {
			return 0;
		}
		if (dp[index] != 0) {
			return dp[index];
		}

		int lowest = Integer.MAX_VALUE;
		for (int i = 1; i <= nums[index]; i++) {
			int next = index + i;
			if (next >= nums.length || (next != nums.length - 1 && nums[next] == 0))
				continue;

			int val = dfs(nums, next);
			if (val != Integer.MAX_VALUE) {
				lowest = Math.min(lowest, val + 1);
			}
		}
		dp[index] = lowest;

		return dp[index];
	}
}
