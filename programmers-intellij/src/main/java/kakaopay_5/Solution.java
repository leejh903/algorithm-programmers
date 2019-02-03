package kakaopay_5;


import java.util.*;

class Solution {
    public int solution(int[][] land, int height) {
        int answer = 0;
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};
        Point[][] map = init(land);
        Queue<Point> queue = new LinkedList<>();
        Set<Ladder> ladders = new HashSet<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j].visited) continue;

                queue.add(map[i][j]);
                queue.peek().visited = true;

                List<Point> sameColor = new ArrayList<>();
                sameColor.add(map[i][j]);

                while (!queue.isEmpty()) {
                    Point point = queue.poll();

                    for (int k = 0; k < row.length; k++) {
                        int tempRow = point.row + row[k];
                        int tempCol = point.col + col[k];
                        if (tempRow < 0 || tempRow >= map.length || tempCol < 0 || tempCol >= map.length) continue;
                        Point temp = map[tempRow][tempCol];
                        if (temp.visited) continue;
                        if (Math.abs(point.val - temp.val) > height) continue;
                        temp.visited = true;
                        queue.offer(temp);
                        sameColor.add(temp);
                    }

                }

                int min = 10000;
                Ladder maybeLadder = null;
                for (Point point : sameColor) {
                    for (int k = 0; k < row.length; k++) {
                        int tempRow = point.row + row[k];
                        int tempCol = point.col + col[k];
                        if (tempRow < 0 || tempRow >= map.length || tempCol < 0 || tempCol >= map.length) continue;
                        Point temp = map[tempRow][tempCol];
                        if(sameColor.contains(temp)) continue;
                        if(min > Math.abs(point.val - temp.val)) {
                            List<Point> points = new ArrayList();
                            points.add(point);
                            points.add(temp);
                            maybeLadder = new Ladder(points, Math.abs(point.val - temp.val));
                        }
                    }
                }
                ladders.add(maybeLadder);

            }
        }

        for (Ladder ladder : ladders) {
            System.out.println(ladder);
        }

        return answer;
    }

    private Point[][] init(int[][] land) {
        Point[][] points = new Point[land.length][land.length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land.length; j++) {
                points[i][j] = new Point(i, j, land[i][j], false);
            }
        }
        return points;
    }
}

class Point {
    int row;
    int col;
    int val;
    boolean visited;

    public Point(int row, int col, int val, boolean visited) {
        this.row = row;
        this.col = col;
        this.val = val;
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Point{" +
                "row=" + row +
                ", col=" + col +
                ", val=" + val +
                ", visited=" + visited +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return row == point.row &&
                col == point.col &&
                val == point.val;
    }
}

class Ladder {
    List<Point> points;
    int cost;

    public Ladder(List<Point> points, int cost) {
        this.points = points;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return cost == ladder.cost &&
                Objects.equals(points, ladder.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, cost);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "points=" + points +
                ", cost=" + cost +
                '}';
    }
}
