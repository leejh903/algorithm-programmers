package l60;

import java.util.ArrayList;
import java.util.List;

class Solution {
	private List<String> permutations = new ArrayList<>();

	public String getPermutation(int n, int k) {
		int[] arr = new int[n];
		for (int i = 1; i <= n; i++) {
			arr[i - 1] = i;
		}
		int[] output = new int[n];
		boolean[] visited = new boolean[n];
		permutate(arr, output, visited, 0, n, n);
		return permutations.get(k - 1);
	}

	public void permutate(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		if (depth == r) {
			StringBuilder sb = new StringBuilder();
			for (int o : output) {
				sb.append(o);
			}
			permutations.add(sb.toString());
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] != true) {
				visited[i] = true;
				output[depth] = arr[i];
				permutate(arr, output, visited, depth + 1, n, r);
				visited[i] = false;
			}
		}
	}

}
