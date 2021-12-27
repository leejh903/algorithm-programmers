package l77;

import java.util.ArrayList;
import java.util.List;

class Solution {
	private List<List<Integer>> answer;

	public List<List<Integer>> combine(int n, int k) {
		answer = new ArrayList<>();
		combination(n, k, 1, new ArrayList<>());
		return answer;
	}

	void combination(int n, int k, int current, List<Integer> combined) {
		if (combined.size() == k) {
			answer.add(new ArrayList<>(combined));
			return;
		}
		if (current > n) {
			return;
		}

		for (int i = current; i <= n; i++) {
			// choose
			combined.add(i);
			combination(n, k, i + 1, combined);

			// not choose
			combined.remove(combined.size() - 1);
		}
	}
}
