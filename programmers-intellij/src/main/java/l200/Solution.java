package l200;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    Position[] direction = new Position[] { new Position(1, 0), new Position(-1, 0), new Position(0, 1),
            new Position(0, -1) };
    char visited = '2';

    public int numIslands(char[][] grid) {
        Queue<Position> queue = new LinkedList<>();
        int answer = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == visited || grid[row][col] == '0') {
                    continue;
                }

                answer++;
                queue.add(new Position(row, col));
                while (!queue.isEmpty()) {
                    Position pos = queue.poll();
                    grid[pos.row][pos.col] = visited;

                    for (int i = 0; i < direction.length; i++) {
                        int newRow = pos.row + direction[i].row;
                        int newCol = pos.col + direction[i].col;

                        // out of index
                        if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) {
                            continue;
                        }
                        if (grid[newRow][newCol] != '1') {
                            continue;
                        }

                        queue.add(new Position(newRow, newCol));
                    }
                }
            }
        }

        return answer;
    }

    class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.col = col;
            this.row = row;
        }
    }
}
