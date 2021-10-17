package l51;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class Solution {
	private Stack<Point> points = new Stack<>();
	private Set<Integer> rows = new HashSet<>();
	private Set<Integer> cols = new HashSet<>();
	private Set<Integer> rightDown = new HashSet<>();
	private Set<Integer> rightUp = new HashSet<>();
	private List<List<String>> answer = new ArrayList<>();
	private String emptyRow;

	public List<List<String>> solveNQueens(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(".");
		}
		emptyRow = sb.toString();

		dfs(n, 0, 0);
		return answer;
	}

	public void dfs(int n, int r, int c) {
		// base case
		if (points.size() == n) {
			List<String> outer = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				outer.add(emptyRow);
			}

			for (Point point : points) {
				StringBuilder origin = new StringBuilder(outer.get(point.row));
				origin.setCharAt(point.col, 'Q');
				outer.set(point.row, origin.toString());
			}
			answer.add(outer);
			return;
		}

		// update row, col number
		if (c >= n) {
			r++;
			c = 0;
		}
		// nothing to explore
		if (r >= n) {
			return;
		}

		// pass this position
		if (rows.contains(r) || cols.contains(c) || rightDown.contains(r - c)
				|| rightUp.contains(r + c)) {
			dfs(n, r, c + 1);
			return;
		}

		// select this position
		rows.add(r);
		cols.add(c);
		rightDown.add(r - c);
		rightUp.add(r + c);
		points.push(new Point(r, c));
		dfs(n, r, c + 1);

		// deselect this position
		rows.remove(r);
		cols.remove(c);
		rightDown.remove(r - c);
		rightUp.remove(r + c);
		points.pop();
		dfs(n, r, c + 1);
	}

	class Point {
		int row;
		int col;

		Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
