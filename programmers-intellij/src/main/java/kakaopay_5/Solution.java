package kakaopay_5;


import java.util.*;

class Solution {
    public int solution(int[][] land, int height) {
        int answer = 0;
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};
        Point[][] map = init(land);
        Queue<Point> queue = new LinkedList<>();
        List<Ladder> ladders = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j].visited) continue;

                count++;
                map[i][j].team = count;
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
                        temp.team = count;
                        queue.offer(temp);
                        sameColor.add(temp);
                    }
                }
            }
        }

        for (Point[] points : map) {
            for (Point point : points) {
                for (int k = 0; k < row.length; k++) {
                    int tempRow = point.row + row[k];
                    int tempCol = point.col + col[k];
                    if (tempRow < 0 || tempRow >= map.length || tempCol < 0 || tempCol >= map.length) continue;
                    Point temp = map[tempRow][tempCol];
                    if (temp.team == point.team) continue;
                    Set<Integer> tempSet = new HashSet<>();
                    tempSet.add(point.team);
                    tempSet.add(temp.team);
                    Ladder maybeLadder = new Ladder(tempSet, Math.abs(point.val - temp.val));
                    if (ladders.contains(maybeLadder)) {
                        Ladder original = ladders.get(ladders.indexOf(maybeLadder));
                        if (original.cost > maybeLadder.cost) {
                            ladders.remove(original);
                            ladders.add(maybeLadder);
                        }
                    } else {
                        ladders.add(maybeLadder);
                    }
                }
            }
        }

        Collections.sort(ladders);

        boolean[] m = new boolean[count + 1];
        for (Ladder ladder : ladders) {
            Integer[] a = ladder.connectedTeams.toArray(new Integer[2]);
            if (!m[a[0]] || !m[a[1]]) {
                m[a[0]] = true;
                m[a[1]] = true;
                answer += ladder.cost;
            }
        }

        return answer;
    }

    private Point[][] init(int[][] land) {
        Point[][] points = new Point[land.length][land.length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land.length; j++) {
                points[i][j] = new Point(i, j, land[i][j], 0, false);
            }
        }
        return points;
    }
}

class Point {
    int row;
    int col;
    int val;
    int team;
    boolean visited;

    public Point(int row, int col, int val, int team, boolean visited) {
        this.row = row;
        this.col = col;
        this.val = val;
        this.team = team;
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Point{" +
                "row=" + row +
                ", col=" + col +
                ", val=" + val +
                ", team=" + team +
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

class Ladder implements Comparable<Ladder> {
    Set<Integer> connectedTeams;
    int cost;

    public Ladder(Set<Integer> connectedTeams, int cost) {
        this.connectedTeams = connectedTeams;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return connectedTeams.equals(ladder.connectedTeams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectedTeams);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "connectedTeams=" + connectedTeams +
                ", cost=" + cost +
                '}';
    }

    @Override
    public int compareTo(Ladder o) {
        return this.cost - o.cost;
    }
}
