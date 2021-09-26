package l46;

import java.util.ArrayList;
import java.util.List;

class Solution {
	private List<List<Integer>> answer = new ArrayList<>();

	public List<List<Integer>> permute(int[] nums) {
		boolean[] visited = new boolean[nums.length];
		permutation(nums, visited, null);
		return answer;
	}

	public void permutation(int[] nums, boolean[] visited, List<Integer> current) {
		if (current != null && current.size() == nums.length) {
			answer.add(new ArrayList(current));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i])
				continue;
			if (current == null)
				current = new ArrayList<>();

			visited[i] = true;
			current.add(nums[i]);
			permutation(nums, visited, current);
			visited[i] = false;
			current.remove(current.size() - 1);
		}

	}
}
