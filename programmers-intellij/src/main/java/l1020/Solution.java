package l1020;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static final int LAND = 1;
    static final int WATER = 0;
    static final int VISITED = 2;
    final Position[] directions = { new Position(0, 1), new Position(0, -1), new Position(1, 0), new Position(-1, 0) };

    public int numEnclaves(int[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == WATER || grid[i][j] == VISITED) {
                    continue;
                }
                answer += numEnclave(grid, new Position(i, j));
            }
        }
        return answer;
    }

    int numEnclave(int[][] grid, Position position) {
        int result = 0;
        Queue<Position> queue = new LinkedList<>();
        grid[position.row][position.col] = VISITED;
        queue.add(position);
        result++;

        boolean isEnclave = true;
        while (!queue.isEmpty()) {
            Position current = queue.poll();
            if (isBoundaryConnected(grid, current)) {
                isEnclave = false;
            }

            for (Position direction : directions) {
                Position next = new Position(current.row + direction.row, current.col + direction.col);
                if (isOutofIndex(grid, next)) {
                    continue;
                }
                if (grid[next.row][next.col] != LAND) {
                    continue;
                }

                grid[next.row][next.col] = VISITED;
                queue.add(next);
                result++;
            }
        }

        if (isEnclave) {
            return result;
        }
        return 0;
    }

    boolean isBoundaryConnected(int[][] grid, Position position) {
        for (Position direction : directions) {
            if (isOutofIndex(grid, new Position(position.row + direction.row, position.col + direction.col))) {
                return true;
            }
        }
        return false;
    }

    boolean isOutofIndex(int[][] grid, Position position) {
        return position.row < 0 || position.row >= grid.length || position.col < 0 || position.col >= grid[0].length;
    }

    class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
