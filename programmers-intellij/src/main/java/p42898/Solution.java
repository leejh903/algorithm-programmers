package p42898;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        boolean[][] visit = new boolean[n][m];
        int[] row = {0, 0, -1, 1};
        int[] col = {1, -1, 0, 0};
        Point target = new Point(n - 1, m - 1);
        Queue<Point> queue = new LinkedList<>();

        init(puddles, visit);
        queue.add(new Point(0, 0, 0));


        while (!queue.isEmpty()) {

            //debug
            for (Point point : queue) {
                System.out.println(point);
            }
            System.out.println("--------------------------------");


            Point point = queue.poll();
            for (int i = 0; i < row.length; i++) {
                int nextRow = point.row + row[i];
                int nextCol = point.col + col[i];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) continue;
                if(nextRow == n - 1 && nextCol == m - 1) {
                    answer++;
                    answer = answer % 1000000007;
                    continue;
                }
                if (!visit[nextRow][nextCol]) {
                    queue.add(new Point(nextRow, nextCol, point.count + 1));
                    if(nextRow == n - 2 && nextCol == m - 1) continue;
                    if(nextRow == n - 1 && nextCol == m - 2) continue;
                    visit[nextRow][nextCol] = true;
                }
            }

        }
        return answer % 1000000007;
    }

    private void init(int[][] puddles, boolean[][] visit) {
        for (int[] puddle : puddles) {
            visit[puddle[0] - 1][puddle[1] - 1] = true;
        }
    }
}

class Point {
    int row;
    int col;
    int count;

    Point(int row, int col, int count) {
        this.row = row;
        this.col = col;
        this.count = count;
    }

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return row == point.row &&
                col == point.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return "Point{" +
                "row=" + row +
                ", col=" + col +
                ", count=" + count +
                '}';
    }
}
