package l40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<Integer> part = new ArrayList<>();
		List<List<Integer>> answer = new ArrayList<>();

		combination(candidates, 0, target, part, answer);
		return answer;
	}

	static void combination(int[] arr, int start, int target, List<Integer> part, List<List<Integer>> answer) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			answer.add(new ArrayList(part));
			return;
		}

		for (int i = start; i < arr.length; i++) {
			// this is already done at index i - 1
			if (i > start && arr[i] == arr[i - 1])
				continue;
			part.add(arr[i]);
			combination(arr, i + 1, target - arr[i], part, answer);
			part.remove(part.size() - 1);
		}
	}
}
