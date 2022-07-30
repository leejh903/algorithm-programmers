package l1905;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    final int visited = 2;
    final Position[] directions = { new Position(0, 1), new Position(0, -1), new Position(1, 0), new Position(-1, 0) };

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int answer = 0;
        for (int row = 0; row < grid2.length; row++) {
            for (int col = 0; col < grid2[0].length; col++) {
                if (grid2[row][col] == 0 || grid2[row][col] == visited) {
                    continue;
                }

                if (isSubIsland(grid1, grid2, row, col)) {
                    answer++;
                }
            }
        }
        return answer;
    }

    boolean isSubIsland(int[][] grid1, int[][] grid2, int row, int col) {
        Queue<Position> queue = new LinkedList<>();
        grid2[row][col] = visited;
        queue.add(new Position(row, col));

        boolean result = true;
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            if (grid1[pos.row][pos.col] != 1) {
                result = false;
            }

            for (Position direction : directions) {
                Position newPos = new Position(pos.row + direction.row, pos.col + direction.col);

                // out of index
                if (newPos.row < 0 || newPos.row >= grid2.length || newPos.col < 0 || newPos.col >= grid2[0].length) {
                    continue;
                }
                if (grid2[newPos.row][newPos.col] == 0 || grid2[newPos.row][newPos.col] == visited) {
                    continue;
                }

                grid2[newPos.row][newPos.col] = visited;
                queue.add(newPos);
            }
        }

        return result;
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
