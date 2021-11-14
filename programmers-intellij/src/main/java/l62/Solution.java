package l62;

class Solution {
	public int uniquePaths(int m, int n) {
		int[][] records = new int[m][n];

		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				if (row == 0 || col == 0) {
					records[row][col] = 1;
					continue;
				}
				records[row][col] = records[row - 1][col] + records[row][col - 1];
			}
		}
		return records[m - 1][n - 1];
	}
}
