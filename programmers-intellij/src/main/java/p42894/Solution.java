package p42894;


class Solution {
    int n = 0;
    int[][] dRow = {{0, 0, 0, 1, 1, 1}, {0, 0, 1, 1, 2, 2}};
    int[][] dCol = {{0, 1, 2, 0, 1, 2}, {0, 1, 0, 1, 0, 1}};

    public int solution(int[][] board) {
        n = board.length;
        int answer = 0;

        while (true) {
            boolean flag = false;
            int[][] map = init(board);
            int[][] check = new int[n][n];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    for (int k = 0; k < 2; k++) {
                        if (isValid(row, col, k, board, map, check)) {
                            flag = true;
                            answer++;
                        }
                    }
                }
            }

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (check[row][col] > 0) {
                        board[row][col] = 0;
                    }
                }
            }

            if (!flag) break;
        }
        return answer;
    }

    private boolean isValid(int row, int col, int k, int[][] board, int[][] map, int[][] check) {
        int kindOfNum = -1;
        int zeroCount = 0;

        for (int i = 0; i < dRow[0].length; i++) {
            int dr = row + dRow[k][i];
            int dc = col + dCol[k][i];

            if (isOutOfBound(dr) || isOutOfBound(dc)) return false;
            int num = board[dr][dc];

            if (num > 0) {
                if (kindOfNum == -1) kindOfNum = num;
                if (kindOfNum != -1 && kindOfNum != num) return false;
            }

            if (num == 0) {
                zeroCount++;
                if (map[dr][dc] > 0) return false;
            }

        }

        if (zeroCount != 2) return false;

        for (int i = 0; i < dRow[0].length; i++) {
            int dr = row + dRow[k][i];
            int dc = col + dCol[k][i];
            check[dr][dc] = 1;
        }

        return true;
    }


    private boolean isOutOfBound(int num) {
        return num < 0 || num >= n;
    }

    int[][] init(int[][] board) {
        int[][] map = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] > 0) map[row][col] = 1;
            }
        }

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                map[row][col] += map[row - 1][col];
            }
        }

        return map;
    }
}