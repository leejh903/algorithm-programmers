package l31;

// 1. 앞에 값이 그 뒤의 값보다 작은 것(i번째)을 찾는다
// 2. 그 작은 값(i번째)부터 그 뒤의 값 중 그 수보다 큰 값(j번째) 찾아 swap 한다
// 3. i번째 뒤의 값들은 뒤에 나올 수 있는 수 중에서 가장 값이므로 reverse 통해 가장 작은 값으로 만든다
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i+1] <= nums[i]) {
            i--;
        }
        if(i >= 0) {
            int j = nums.length - 1;
            while(nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i , j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int from) {
        int i = from;
        int j = nums.length - 1;
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}