package l47;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	private Set<List<Integer>> preAnswer = new HashSet<>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		boolean[] visited = new boolean[nums.length];
		permutation(nums, visited, null);

		List<List<Integer>> answer = new ArrayList<>();
		for (List<Integer> ans : preAnswer) {
			answer.add(ans);
		}
		return answer;
	}

	public void permutation(int[] nums, boolean[] visited, List<Integer> current) {
		if (current != null && current.size() == nums.length) {
			preAnswer.add(new ArrayList(current));
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
