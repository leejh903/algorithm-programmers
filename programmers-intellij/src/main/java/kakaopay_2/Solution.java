package kakaopay_2;

public class Solution {
    public int solution(String[] moves) {
        int answer = 0;
        Point[][] map = new Point[1001][1001];

        for (Point[] points : map) {
            for (Point point : points) {
            }
        }

        Point start = map[500][500];
        for (String move : moves) {
            if(move.equals("U")) {
            }
        }

        return answer;
    }
}

class Point {
    boolean checked;
    int x;
    int y;
    boolean up;
    boolean down;
    boolean left;
    boolean right;

    public Point(int x, int y, boolean checked, boolean up, boolean down, boolean left, boolean right) {
        this.x = x;
        this.y = y;
        this.checked = checked;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Point{" +
                "checked=" + checked +
                ", up=" + up +
                ", down=" + down +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
