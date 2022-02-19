package l90;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
	private Set<String> subsetStrs = new HashSet<>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		dfs(nums, 0, new ArrayList<>());

		List<List<Integer>> answer = new ArrayList<>();
		for (String subsetStr : subsetStrs) {
			// exception case: any nums is not chosen
			if (subsetStr.equals("")) {
				answer.add(new ArrayList<>());
				continue;
			}

			String[] splitted = subsetStr.split(",");
			List<Integer> subset = new ArrayList<>();
			for (String numStr : splitted) {
				subset.add(Integer.parseInt(numStr));
			}
			answer.add(subset);
		}
		return answer;
	}

	void dfs(int[] nums, int index, List<Integer> picked) {
		if (index >= nums.length) {
			// recreated picked not to change order of picked
			List<Integer> newPicked = new ArrayList<>(picked);
			Collections.sort(newPicked);
			String subsetStr =
					newPicked.stream().map(String::valueOf).collect(Collectors.joining(","));
			subsetStrs.add(subsetStr);
			return;
		}

		// picked
		picked.add(nums[index]);
		dfs(nums, index + 1, picked);

		// unpicked
		picked.remove(picked.size() - 1);
		dfs(nums, index + 1, picked);
	}
}
