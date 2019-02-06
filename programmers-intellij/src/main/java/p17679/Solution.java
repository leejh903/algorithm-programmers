package p17679;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        List<List<Point>> lists = init(m, n, board);

        while (true) {
            int deleted = 0;

            for (int col = 0; col < n - 1; col++) {
                List<Point> list = lists.get(col);
                for (int row = list.size() - 1; row > 0; row--) {
                    if (haveSquare(lists, col, row) && canDelete(lists, col, row)) {
                        list.get(row).shouldBeDeleted = true;
                        list.get(row - 1).shouldBeDeleted = true;
                        lists.get(col + 1).get(row).shouldBeDeleted = true;
                        lists.get(col + 1).get(row - 1).shouldBeDeleted = true;
                    }
                }
            }

            for (int col = 0; col < n; col++) {
                for (int row = lists.get(col).size() - 1; row >= 0; row--) {
                    Point point = lists.get(col).get(row);
                    if (point.shouldBeDeleted) {
                        lists.get(col).remove(point);
                        deleted++;
                    }
                }
            }

            answer += deleted;
            if (deleted == 0) break;
        }

        return answer;
    }

    private void printList(List<List<Point>> lists) {
        for (List<Point> list : lists) {
            for (Point point : list) {
                System.out.print(point);
            }
            System.out.println();
        }
    }

    boolean canDelete(List<List<Point>> lists, int col, int row) {
        String s1 = lists.get(col).get(row).value;
        String s2 = lists.get(col).get(row - 1).value;
        String s3 = lists.get(col + 1).get(row).value;
        String s4 = lists.get(col + 1).get(row - 1).value;
        return s1.equals(s2) && s2.equals(s3) && s3.equals(s4);
    }

    private boolean haveSquare(List<List<Point>> lists, int col, int row) {
        return lists.get(col + 1).size() - 1 >= row;
    }

    public List<List<Point>> init(int m, int n, String[] board) {
        List<List<Point>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Point> list = new ArrayList<>();
            lists.add(list);
        }

        for (int i = m - 1; i >= 0; i--) {
            String[] splitted = board[i].split("");
            for (int j = 0; j < n; j++) {
                lists.get(j).add(new Point(i, j, splitted[j]));
            }
        }

        return lists;
    }
}

class Point {
    int row;
    int col;
    String value;
    boolean shouldBeDeleted = false;

    public Point(int row, int col, String value) {
        this.row = row;
        this.col = col;
        this.value = value;
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
    public String toString() {
        return "Point{" +
                "value='" + value + '\'' +
                '}';
    }
}
