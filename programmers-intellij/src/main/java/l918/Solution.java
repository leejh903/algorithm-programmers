package l918;

// Get maxSum and minSum using Kadane's Algorithm
// (total - minSum) is possible circular max sum array compared with maxSum
// Idea is that minSum can be useful using Kadane's Algorithm
class Solution {
	public int maxSubarraySumCircular(int[] nums) {
		int total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
		for (int n : nums) {
			curMax = Math.max(curMax + n, n);
			maxSum = Math.max(maxSum, curMax);
			curMin = Math.min(curMin + n, n);
			minSum = Math.min(minSum, curMin);
			total += n;
		}
		return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
	}
}
