package l733;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    Position[] direction = new Position[] { new Position(1, 0), new Position(-1, 0), new Position(0, 1),
            new Position(0, -1) };
    int visited = -1;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(sr, sc));
        int oldColor = image[sr][sc];

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            image[pos.row][pos.col] = visited;

            for (int i = 0; i < direction.length; i++) {
                int newRow = pos.row + direction[i].row;
                int newCol = pos.col + direction[i].col;

                // out of index
                if (newRow < 0 || newRow >= image.length || newCol < 0 || newCol >= image[0].length) {
                    continue;
                }
                if (image[newRow][newCol] != oldColor || image[newRow][newCol] == visited) {
                    continue;
                }

                queue.add(new Position(newRow, newCol));
            }
        }

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (image[i][j] == visited) {
                    image[i][j] = newColor;
                }
            }
        }

        return image;
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
