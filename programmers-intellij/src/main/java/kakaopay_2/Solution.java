package kakaopay_2;

public class Solution {
    public int solution(String[] moves) {
        int answer = 0;
        Point[][] map = new Point[1002][1002];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = new Point(i, j, false, false, false, false);
            }
        }

        Point spot = map[500][500];
        for (String move : moves) {
            switch(move) {
                case "U" :
                    spot.row--;
                    map[spot.row][spot.col].left = true;
                    map[spot.row][spot.col - 1].right = true;
                    break;
                case "D" :
                    map[spot.row][spot.col].left = true;
                    map[spot.row][spot.col - 1].right = true;
                    spot.row++;
                    break;
                case "L" :
                    spot.col--;
                    map[spot.row][spot.col].up = true;
                    map[spot.row - 1][spot.col].down = true;
                    break;
                case "R" :
                    map[spot.row][spot.col].up = true;
                    map[spot.row - 1][spot.col].down = true;
                    spot.col++;
                    break;
            }
        }

        for (Point[] points : map) {
            for (Point point : points) {
                if(point.up && point.down && point.left && point.right) answer++;
            }
        }

        return answer;
    }
}

class Point {
    int row;
    int col;
    boolean up;
    boolean down;
    boolean left;
    boolean right;

    public Point(int row, int col, boolean up, boolean down, boolean left, boolean right) {
        this.row = row;
        this.col = col;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Point{" +
                "row=" + row +
                ", col=" + col +
                ", up=" + up +
                ", down=" + down +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
