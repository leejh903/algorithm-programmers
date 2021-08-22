package l34;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int mid;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;

            if (target <= nums[mid]) right = mid - 1;
            else left = mid + 1;
        }
        int mid1 = -1;
        if (isValid(nums, left) && nums[left] == target) mid1 = left;

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;

            if (target >= nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        int mid2 = -1;
        if (isValid(nums, right) && nums[right] == target) mid2 = right;

        return new int[]{mid1, mid2};
    }

    public boolean isValid(int[] nums, int index) {
        return nums.length != 0 && index >= 0 && index <= nums.length - 1;
    }
}