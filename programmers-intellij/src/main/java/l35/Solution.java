package l35;

class Solution {
    public int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int start, int end) {
        int pivot = (start + end) / 2;
        int num = nums[pivot];
        if(num == target) {
            return pivot;
        }
        if(start == end) {
            if(target > num) return end + 1;
            return start;
        }

        int ans;
        if(num < target) {
            ans = search(nums, target, pivot + 1, end);
        } else {
            // pivot - 1 아닌 부분에 주의!!
            // pivot 값 설정에서 내림 계산하기 떄문
            ans = search(nums, target, start, pivot);
        }
        return ans;
    }
}
