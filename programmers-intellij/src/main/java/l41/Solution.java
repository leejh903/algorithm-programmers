package l41;

import java.util.Arrays;

class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int current = 1;
        for (int num : nums) {
            if(num < 1) continue;
            if(num == current) current++;
            if(num > current) break;
        }
        
        return current;
    }
}