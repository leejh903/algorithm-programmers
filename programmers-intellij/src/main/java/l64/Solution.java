package l64;

class Solution {
	private int[][] visited;

	public int minPathSum(int[][] grid) {
		visited = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				visited[i][j] = -1;
			}
		}
		return dfs(grid, 0, 0);
	}

	private int dfs(int[][] grid, int row, int col) {
		// if visited before, it returns value which is calculated before
		if (visited[row][col] != -1) {
			return visited[row][col];
		}

		int sum = 0;
		// reached bottom right
		if (row == grid.length - 1 && col == grid[0].length - 1) {
			return grid[row][col];
		}

		sum += grid[row][col];
		// right
		int right = Integer.MAX_VALUE;
		if (col + 1 < grid[0].length) {
			right = dfs(grid, row, col + 1);
		}

		// below
		int below = Integer.MAX_VALUE;
		if (row + 1 < grid.length) {
			below = dfs(grid, row + 1, col);
		}

		visited[row][col] = sum + Math.min(right, below);
		return visited[row][col];
	}
}
