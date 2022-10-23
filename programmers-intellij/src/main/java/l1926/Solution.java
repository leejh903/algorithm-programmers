package l1926;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static final int[][] DIRECTIONS = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private static final char WALL = '+';
    private static final char EMTPY = '.';

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { entrance[0], entrance[1], 0 });
        maze[entrance[0]][entrance[1]] = WALL;

        int answer = -1;
        while (!queue.isEmpty()) {
            int[] out = queue.poll();

            for (int i = 0; i < DIRECTIONS.length; i++) {
                int newRow = out[0] + DIRECTIONS[i][0];
                int newCol = out[1] + DIRECTIONS[i][1];

                if (newRow < 0 || newRow >= maze.length || newCol < 0 || newCol >= maze[0].length) {
                    continue;
                }
                if (maze[newRow][newCol] == WALL) {
                    continue;
                }

                int nextStep = out[2] + 1;
                queue.add(new int[] { newRow, newCol, nextStep });
                maze[newRow][newCol] = WALL;

                if (newRow == 0 || newCol == 0 || newRow == maze.length - 1 || newCol == maze[0].length - 1) {
                    return nextStep;
                }
            }
        }
        return answer;
    }
}
