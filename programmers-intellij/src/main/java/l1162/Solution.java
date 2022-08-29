package l1162;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    private static final int[][] DIRECTIONS = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int answer = -1;

    public int maxDistance(int[][] grid) {
        boolean hasLand = false;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    hasLand = true;
                }
            }
        }
        if (!hasLand)
            return -1;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    answer = Math.max(answer, bfs(grid, r, c));
                }
            }
        }
        return answer;
    }

    // bfs find nearlest land from row and col
    int bfs(int[][] grid, int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        Point start = new Point(row, col);
        Set<Point> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        int res = -1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < DIRECTIONS.length; i++) {
                int newRow = p.row + DIRECTIONS[i][0];
                int newCol = p.col + DIRECTIONS[i][1];

                if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) {
                    continue;
                }
                if (visited.contains(new Point(newRow, newCol))) {
                    continue;
                }

                if (grid[newRow][newCol] == 1) {
                    return distance(col, row, newCol, newRow);
                }
                if (grid[newRow][newCol] == 0) {
                    Point next = new Point(newRow, newCol);
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        return res;
    }

    int distance(int x0, int y0, int x1, int y1) {
        return Math.abs(x0 - x1) + Math.abs(y0 - y1);
    }

}

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Point point = (Point) object;
            result = (this.row == point.row && this.col == point.col);
        }
        return result;
    }
}
