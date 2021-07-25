package l27;

import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int num : nums) {
            if(num != val) {
                nums[idx] = num;
                idx++;
            }
        }
        nums = Arrays.copyOfRange(nums, 0, idx);
        return nums.length;
    }
}
