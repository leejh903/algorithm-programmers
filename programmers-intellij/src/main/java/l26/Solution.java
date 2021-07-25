package l26;

import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        int num = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (num < nums[i]) {
                index++;
                num = nums[i];
                nums[index] = nums[i];
            }
        }
        nums = Arrays.copyOfRange(nums, 0, index + 1);
        return nums.length;
    }
}