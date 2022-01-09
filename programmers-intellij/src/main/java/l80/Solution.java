package l80;

class Solution {
	private final int DUPLICATE_LIMIT = 2;

	public int removeDuplicates(int[] nums) {
		int index = -1;
		// to be replaced
		int curVal = nums[0] - 1;
		int curCount = 0;
		for (int i = 0; i < nums.length; i++) {
			// update current value
			if (nums[i] > curVal) {
				curVal = nums[i];
				curCount = 0;
			}

			curCount++;
			if (curCount <= DUPLICATE_LIMIT) {
				index++;
			}

			// swap point
			if (nums[index] != nums[i] && index != i) {
				swap(nums, index, i);
			}
		}
		// +1 to tell count, not index
		return index + 1;
	}

	void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}
}
