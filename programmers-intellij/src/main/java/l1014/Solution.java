package l1014;

class Solution {
	public int maxScoreSightseeingPair(int[] values) {
		int max = values[0];
		int maxIndex = 0;

		int ans = Integer.MIN_VALUE;
		for (int j = 1; j < values.length; j++) {
			ans = Math.max(ans, max + values[j] + maxIndex - j);
			if (values[j] + j > max + maxIndex) {
				max = values[j];
				maxIndex = j;
			}
		}
		return ans;
	}
}
