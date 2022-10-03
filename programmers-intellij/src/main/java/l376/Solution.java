package l376;

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int status = 0;
        int answer = 1;
        for (int i = 1; i < nums.length; i++) {
            int newStatus = nums[i] - nums[i - 1];

            if ((status == 0 && nums[i] != nums[i - 1]) || (status < 0 && newStatus > 0)
                    || (status > 0 && newStatus < 0)) {
                status = newStatus;
                answer++;
            }
        }
        return answer;
    }
}
