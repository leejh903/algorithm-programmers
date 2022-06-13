package l695;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    final int visited = 2;
    final Position[] directions = { new Position(0, 1), new Position(0, -1), new Position(1, 0), new Position(-1, 0) };

    public int maxAreaOfIsland(int[][] grid) {
        int answer = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0 || grid[row][col] == visited) {
                    System.out.printf("row: %d, col: %d\n", row, col);
                    continue;
                }
                answer = Math.max(answer, bfs(grid, row, col));
            }
        }
        return answer;
    }

    int bfs(int[][] grid, int row, int col) {
        int candidate = 0;
        Queue<Position> queue = new LinkedList<>();

        candidate++;
        grid[row][col] = visited;
        queue.add(new Position(row, col));

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            for (Position direction : directions) {
                Position newPos = new Position(pos.row + direction.row, pos.col + direction.col);

                // out of index
                if (newPos.row < 0 || newPos.row >= grid.length || newPos.col < 0 || newPos.col >= grid[0].length) {
                    continue;
                }
                if (grid[newPos.row][newPos.col] == 0 || grid[newPos.row][newPos.col] == visited) {
                    continue;
                }

                candidate++;
                grid[newPos.row][newPos.col] = visited;
                queue.add(newPos);
            }
        }

        return candidate;
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
