package l96;

class Solution {
	private int[] dp = new int[20];

	// dp[n] = sum(dp[i - 1] * dp[n - i]) (1 <= i <= n)
	public int numTrees(int n) {
		if (n <= 1)
			return 1;

		if (dp[n] != 0) {
			return dp[n];
		}

		int result = 0;
		for (int i = 1; i <= n; i++) {
			int left = numTrees(i - 1);
			int right = numTrees(n - i);
			result += left * right;
		}
		dp[n] = result;

		return dp[n];
	}
}
