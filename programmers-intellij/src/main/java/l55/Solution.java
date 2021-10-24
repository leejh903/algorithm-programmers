package l55;

class Solution {
	private boolean[] visited;

	public boolean canJump(int[] nums) {
		visited = new boolean[nums.length];
		return jump(nums, 0);
	}

	public boolean jump(int[] nums, int pos) {
		if (pos == nums.length - 1) {
			return true;
		}
		if (pos >= nums.length || nums[pos] == 0) {
			return false;
		}

		boolean result = false;
		for (int i = 1; i <= nums[pos]; i++) {
			if (visited[pos + i])
				continue;
			if (jump(nums, pos + i)) {
				result = true;
				break;
			}
		}

		visited[pos] = true;
		return result;
	}
}
