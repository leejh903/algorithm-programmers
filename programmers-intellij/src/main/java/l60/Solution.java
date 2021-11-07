package l60;

class Solution {
	private int count = 0;

	public String getPermutation(int n, int k) {
		int[] arr = new int[n];
		for (int i = 1; i <= n; i++) {
			arr[i - 1] = i;
		}
		int[] output = new int[n];
		boolean[] visited = new boolean[n];
		return permutate(arr, output, visited, 0, n, k);
	}

	public String permutate(int[] arr, int[] output, boolean[] visited, int depth, int n, int k) {
		if (depth == n) {
			StringBuilder sb = new StringBuilder();
			for (int o : output) {
				sb.append(o);
			}
			count++;
			if (count == k) {
				return sb.toString();
			}
			return "";
		}

		String res = "";
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				res = permutate(arr, output, visited, depth + 1, n, k);
				visited[i] = false;
				if (res != "") {
					break;
				}
			}
		}
		return res;
	}
}
