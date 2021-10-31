package l59;

class Solution {
	private final int RIGHT = 0;
	private final int DOWN = 1;
	private final int LEFT = 2;
	private final int UP = 3;

	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		return simulate(matrix, RIGHT, new int[] {0, -1}, 1);
	}

	public int[][] simulate(int[][] matrix, int direction, int[] pos, int num) {
		int[] current = next(direction, pos);
		if (isOutOfIndex(matrix, current) || matrix[current[0]][current[1]] != 0) {
			return matrix;
		}

		matrix[current[0]][current[1]] = num;
		num++;

		int[] next = next(direction, current);
		if (isOutOfIndex(matrix, next) || matrix[next[0]][next[1]] != 0) {
			// convert direction
			direction = (direction + 1) % 4;
		}
		return simulate(matrix, direction, current, num);
	}

	public boolean isOutOfIndex(int[][] matrix, int[] pos) {
		return (pos[0] < 0 || pos[0] >= matrix.length || pos[1] < 0 || pos[1] >= matrix[0].length);
	}

	public int[] next(int direction, int[] pos) {
		if (direction == RIGHT) {
			return new int[] {pos[0], pos[1] + 1};
		}
		if (direction == LEFT) {
			return new int[] {pos[0], pos[1] - 1};
		}
		if (direction == UP) {
			return new int[] {pos[0] - 1, pos[1]};
		}
		return new int[] {pos[0] + 1, pos[1]};
	}
}
