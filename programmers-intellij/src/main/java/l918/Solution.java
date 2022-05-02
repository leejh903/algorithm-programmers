package l918;

class Solution {
	public int maxSubarraySumCircular(int[] nums) {
		int[] newNums = new int[nums.length * 2 - 1];
		for (int i = 0; i < nums.length * 2 - 1; i++) {
			newNums[i] = nums[i % nums.length];
		}

		int max = newNums[0];
		for (int i = 0; i < nums.length; i++) {
			// copy newNums
			int[] temp = new int[newNums.length];
			for (int n = 0; n < newNums.length; n++) {
				temp[n] = newNums[n];
			}

			for (int j = i + 1; j < i + nums.length; j++) {
				temp[j] = Math.max(temp[j], temp[j] + temp[j - 1]);
				max = Math.max(max, temp[j]);
			}
		}
		return max;
	}
}
