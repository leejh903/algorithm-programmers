package estsoft3;

class Solution {
    private int beatNum = 0;

    public int solution(String[] B) {
        Point point = findPawn(B);
        int beatTemp = 0;
        move(B, point.row, point.col, beatTemp);
        return beatNum;
    }

    void move(String[] b, int row, int col, int beatTemp) {
        if (isOutofBoard(b, row, col) || nothingToBeat(b, row, col)) {
            beatNum = Math.max(beatTemp, beatNum);
            return;
        }

        if(getChar(b, row - 2, col - 2) != 'X' && getChar(b, row - 1, col - 1) == 'X') move(b, row - 2, col - 2, beatTemp + 1);
        if(getChar(b, row - 2, col + 2) != 'X' && getChar(b, row - 1, col + 1) == 'X') move(b, row - 2, col + 2, beatTemp + 1);
    }

    boolean nothingToBeat(String[] b, int row, int col) {
        if(isOutofBoard(b, row - 1, col - 1) && isOutofBoard(b, row - 1, col + 1)) return true;
        if(getChar(b, row - 1, col - 1) != 'X' && getChar(b, row - 1, col + 1) != 'X') return true;

        if(isOutofBoard(b, row - 2, col - 2) && isOutofBoard(b, row - 2, col + 2)) return true;
        if((getChar(b, row - 1, col - 1) == 'X' && getChar(b, row - 2, col - 2) == 'X') &&
            (getChar(b, row - 1, col + 1) == 'X' && getChar(b, row - 2, col + 2) == 'X')) return true;

        return false;
    }

    char getChar(String[] b, int row, int col) {
        if(isOutofBoard(b, row, col)) return '.';
        return b[row].charAt(col);
    }

    boolean isOutofBoard(String[] b, int row, int col) {
        return row < 0 || row >= b.length || col < 0 || col >= b.length;
    }

    Point findPawn(String[] b) {
        Point point = null;
        for (int i = 0; i < b.length; i++) {
            if (b[i].contains("O")) {
                point = new Point(i, b[i].indexOf("O"));
                break;
            }
        }
        return point;
    }
}

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "Point{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}