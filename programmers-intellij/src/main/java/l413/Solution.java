package l413;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int answer = 0;
        if (nums.length < 3) {
            return answer;
        }

        int current = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                current++;
                // this is point!!
                answer += current;
            } else {
                current = 0;
            }
        }
        return answer;
    }
}
