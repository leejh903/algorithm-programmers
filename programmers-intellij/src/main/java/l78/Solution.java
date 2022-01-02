package l78;

import java.util.ArrayList;
import java.util.List;

class Solution {
	private List<List<Integer>> answer;

	public List<List<Integer>> subsets(int[] nums) {
		answer = new ArrayList<>();
		combination(nums, 0, new ArrayList<>());
		return answer;
	}

	void combination(int[] nums, int current, List<Integer> combined) {
		answer.add(new ArrayList<>(combined));

		for (int i = current; i < nums.length; i++) {
			// choose
			combined.add(nums[i]);
			combination(nums, i + 1, combined);

			// not choose
			combined.remove(combined.size() - 1);
		}
	}
}
