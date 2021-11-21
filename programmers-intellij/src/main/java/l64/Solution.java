package l64;

class Solution {
	private int minSum = Integer.MAX_VALUE;

	public int minPathSum(int[][] grid) {
		dfs(grid, 0, 0, 0);
		return minSum;
	}

	private void dfs(int[][] grid, int row, int col, int sum) {
		// finish meaningless recursive
		if (sum >= minSum) {
			return;
		}
		// out of index
		if (row >= grid.length || col >= grid[0].length) {
			return;
		}

		sum += grid[row][col];
		// reached bottom right
		if (row == grid.length - 1 && col == grid[0].length - 1) {
			minSum = Math.min(minSum, sum);
			return;
		}

		// right
		dfs(grid, row, col + 1, sum);

		// below
		dfs(grid, row + 1, col, sum);
	}
}
