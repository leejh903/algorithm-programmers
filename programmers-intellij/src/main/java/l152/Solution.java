package l152;

// temp can bigger execpt for num is 0
// product from last is needed when [3, -1, 4] provided
class Solution {
	public int maxProduct(int[] nums) {
		int max = nums[0];
		int temp = 1;
		for (int i = 0; i < nums.length; i++) {
			temp *= nums[i];
			max = Math.max(max, temp);
			if (temp == 0)
				temp = 1;
		}
		temp = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			temp *= nums[i];
			max = Math.max(max, temp);
			if (temp == 0)
				temp = 1;
		}
		return max;
	}
}
