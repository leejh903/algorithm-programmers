package l53;

class Solution {
    public int maxSubArray(int[] nums) {
        int current = 0;
        int result = Integer.MIN_VALUE;

        for (int num : nums) {
            current = Math.max(current + num, current);
            result = Math.max(result, current);
        }
        return result;
    }
}
