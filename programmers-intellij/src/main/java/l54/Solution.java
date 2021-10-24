package l54;

import java.util.ArrayList;
import java.util.List;

class Solution {
	private final int RIGHT = 0;
	private final int DOWN = 1;
	private final int LEFT = 2;
	private final int UP = 3;

	public List<Integer> spiralOrder(int[][] matrix) {
		return simulate(matrix, RIGHT, new int[] {0, -1}, new ArrayList<>());
	}

	public List<Integer> simulate(int[][] matrix, int direction, int[] pos, List<Integer> answer) {
		int[] current = next(direction, pos);
		if (isOutOfIndex(matrix, current) || matrix[current[0]][current[1]] == 101) {
			return answer;
		}

		answer.add(matrix[current[0]][current[1]]);
		matrix[current[0]][current[1]] = 101;

		int[] next = next(direction, current);
		if (isOutOfIndex(matrix, next) || matrix[next[0]][next[1]] == 101) {
			// convert direction
			direction = (direction + 1) % 4;
		}
		return simulate(matrix, direction, current, answer);
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
