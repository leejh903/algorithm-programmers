package l91;

class Solution {
	public int numDecodings(String s) {
		if (s.isEmpty() || s.charAt(0) == '0') {
			return 0;
		}

		int n = s.length();
		// dp: 해당 글자까지 나올 수 있는 경우의 수
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			int first = Integer.parseInt(s.substring(i - 1, i));
			int second = Integer.parseInt(s.substring(i - 2, i));

			if (first >= 1 && first <= 9)
				dp[i] += dp[i - 1];
			if (second >= 10 && second <= 26)
				dp[i] += dp[i - 2];
		}
		return dp[n];
	}
}
