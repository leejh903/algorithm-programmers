package l33;

class Solution {
    public int search(int[] nums, int target) {
        int answer = -1;
        int left = 0;
        int right = nums.length - 1;

        int mid;
        while (left <= right) {
            mid = (left + right) / 2;

            if (nums[mid] == target) {
                answer = mid;
            }

            if (nums[left] > nums[right]) {
                if (target > nums[right] && target >= nums[0]) right--;
                else left++;
            } else {
                if (nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            }
        }
        return answer;
    }
}