package p12905;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;

        for (int row = 1; row < board.length; row++) {
            for (int col = 1; col < board[row].length; col++) {
                int temp = board[row][col];
                if (temp == 0) continue;
                board[row][col] = getValue(board, row, col);
            }
        }

        for (int[] ints : board) {
            for (int anInt : ints) {
                answer = Math.max(anInt, answer);
            }
        }

        return (int) Math.pow(answer, 2);
    }

    public int getValue(int[][] board, int row, int col) {
        return Math.min(Math.min(board[row][col - 1], board[row - 1][col - 1]), board[row - 1][col]) + 1;
    }
}
