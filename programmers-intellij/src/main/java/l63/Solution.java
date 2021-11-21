package l63;

class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] records = new int[m][n];

		// pre-calculate value when row or column are 0
		boolean hasObstacle = false;
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				hasObstacle = true;
			}
			if (hasObstacle) {
				records[i][0] = 0;
				break;
			}
			records[i][0] = 1;
		}
		hasObstacle = false;
		for (int i = 0; i < n; i++) {
			if (obstacleGrid[0][i] == 1) {
				hasObstacle = true;
			}
			if (hasObstacle) {
				records[0][i] = 0;
				break;
			}
			records[0][i] = 1;
		}

		for (int row = 1; row < m; row++) {
			for (int col = 1; col < n; col++) {
				if (obstacleGrid[row][col] == 1) {
					records[row][col] = 0;
					continue;
				}
				records[row][col] = records[row - 1][col] + records[row][col - 1];
			}
		}
		return records[m - 1][n - 1];
	}
}
