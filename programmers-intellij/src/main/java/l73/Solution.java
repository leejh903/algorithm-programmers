package l73;

import java.util.HashSet;
import java.util.Set;

class Solution {
	private Set<Integer> rows = new HashSet<>();
	private Set<Integer> cols = new HashSet<>();

	public void setZeroes(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] == 0) {
					rows.add(row);
					cols.add(col);
				}
			}
		}

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (rows.contains(row) || cols.contains(col)) {
					matrix[row][col] = 0;
				}
			}
		}
	}
}
