package l1567;

class Solution {
	public int getMaxLen(int[] nums) {
		int n = nums.length;
		// 해당 index까지 양수 곱셈값을 가진 가진 가장 긴 값
		int[] positive = new int[n];
		// 해당 index까지 음수 곱셈값을 가진 가진 가장 긴 값
		int[] negative = new int[n];
		if (nums[0] > 0)
			positive[0] = 1;
		if (nums[0] < 0)
			negative[0] = 1;
		int ans = positive[0];
		for (int i = 1; i < n; i++) {
			if (nums[i] > 0) {
				positive[i] = 1 + positive[i - 1];
				negative[i] = negative[i - 1] > 0 ? 1 + negative[i - 1] : 0;
			}
			if (nums[i] < 0) {
				positive[i] = negative[i - 1] > 0 ? 1 + negative[i - 1] : 0;
				negative[i] = 1 + positive[i - 1];
			}
			ans = Math.max(ans, positive[i]);
		}
		return ans;
	}
}
