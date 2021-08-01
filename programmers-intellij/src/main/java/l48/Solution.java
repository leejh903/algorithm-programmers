package l48;

class Solution {
    private int N;

    public void rotate(int[][] matrix) {
        N = matrix.length;

        boolean[][] rotated = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (rotated[i][j]) continue;

                int val = matrix[i][j];
                int[] pos = new int[]{i, j};
                for (int k = 0; k < 4; k++) {
                    int[] nextPos = rotatePosition(pos);
                    if (rotated[nextPos[0]][nextPos[1]]) break;

                    int temp = matrix[nextPos[0]][nextPos[1]];
                    matrix[nextPos[0]][nextPos[1]] = val;
                    rotated[nextPos[0]][nextPos[1]] = true;
                    val = temp;
                    pos = nextPos;
                }
            }
        }
    }

    public int[] rotatePosition(int[] position) {
        int row = position[0];
        int col = position[1];
        return new int[]{col, N - 1 - row};
    }
}