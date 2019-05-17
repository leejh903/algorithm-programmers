package p1844;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[] directionCol = {0, 0, -1, 1};
    int[] directionRow = {-1, 1, 0, 0};

    public int solution(int[][] maps) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1));
        while(!queue.isEmpty()) {
            Point target = queue.poll();
            maps[target.row][target.col] = 0;

            for (int i = 0; i < directionCol.length; i++) {
                int nextCol = target.col + directionCol[i];
                int nextRow = target.row + directionRow[i];
                if(nextCol + 1 == maps[0].length && nextRow + 1 == maps.length) return target.count + 1;
                if(!isOutOfMap(maps, nextCol, nextRow) && maps[nextRow][nextCol] == 1) {
                    queue.add(new Point(nextRow, nextCol, target.count + 1));
                    maps[nextRow][nextCol] = 0;
                }
            }
        }
        return -1;
    }

    private boolean isOutOfMap(int[][] maps, int nextCol, int nextRow) {
        return 0 > nextCol || 0 > nextRow || maps.length <= nextRow || maps[0].length <= nextCol;
    }

    public static class Point {
        private int col;
        private int row;
        private int count;

        public Point(int row, int col, int count) {
            this.col = col;
            this.row = row;
            this.count = count;
        }
    }
}