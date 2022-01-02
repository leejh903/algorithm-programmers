package l79;

class Solution {
	private final int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public boolean exist(char[][] board, String word) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				visited[i][j] = true;
				if (dfs(board, word, visited, i, j, 0)) {
					return true;
				}
				visited[i][j] = false;
			}
		}
		return false;
	}

	boolean dfs(char[][] board, String word, boolean[][] visited, int row, int col, int index) {
		// mismatch
		if (board[row][col] != word.charAt(index)) {
			return false;
		}
		// last case
		if (index == word.length() - 1) {
			return true;
		}

		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextCol = col + direction[1];
			// out of index
			if (nextRow < 0 || nextCol < 0 || nextRow >= board.length
					|| nextCol >= board[0].length) {
				continue;
			}
			// already visited
			if (visited[nextRow][nextCol]) {
				continue;
			}

			visited[nextRow][nextCol] = true;
			if (dfs(board, word, visited, nextRow, nextCol, index + 1)) {
				return true;
			}
			visited[nextRow][nextCol] = false;
		}
		return false;
	}
}
