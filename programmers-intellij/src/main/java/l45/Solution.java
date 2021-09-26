package l45;

class Solution {
	private int answer = Integer.MAX_VALUE;

	public int jump(int[] nums) {
		dfs(nums, 0, 0);
		return answer;
	}

	public void dfs(int[] nums, int index, int jump) {
		if (index == nums.length - 1) {
			answer = Math.min(answer, jump);
			return;
		}
		if (jump >= answer)
			return;

		for (int i = 1; i <= nums[index]; i++) {
			int next = index + i;
			if (next >= nums.length || (next != nums.length - 1 && nums[next] == 0))
				continue;

			dfs(nums, next, jump + 1);
		}
	}
}
