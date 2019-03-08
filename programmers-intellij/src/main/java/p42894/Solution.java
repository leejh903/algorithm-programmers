package p42894;


class Solution {
    int[][] drow = {{0, 0, 0, 1, 1, 1}, {0, 0, 1, 1, 2, 2}};
    int[][] dcol = {{0, 1, 2, 0, 1, 2}, {0, 1, 0, 1, 0, 1}};

    public int solution(int[][] board) {
        int n = board.length;
        int answer = 0;
        int[][] map = createMap(board);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                for (int i = 0; i < 2; i++) {

                }
            }
        }
        return answer;
    }

    int[][] createMap(int[][] board) {
        int n = board.length;
        int[][] map = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if(board[row][col] > 0) map[row][col] = 1;
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