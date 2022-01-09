package l81;

class Solution {
	public boolean search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		int mid;
		while (left <= right) {
			mid = (left + right) / 2;

			if (nums[mid] == target) {
				return true;
			}

			// adjust index to start binary search properly
			if (nums[left] >= nums[right]) {
				if (target > nums[right] && target >= nums[0])
					right--;
				else
					left++;
			} else {
				if (nums[mid] > target)
					right = mid - 1;
				else
					left = mid + 1;
			}
		}
		return false;
	}
}
