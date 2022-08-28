package l304;

class NumMatrix {
    int[][] sum;
    int colLength;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length * matrix[0].length;
        sum = new int[n][n];
        colLength = matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int p1 = matrix[0].length * i + j;

                for (int r = i; r < matrix.length; r++) {
                    for (int c = j; c < matrix[0].length; c++) {
                        int s = calculateSum(matrix, i, j, r, c);
                        int p2 = matrix[0].length * r + c;
                        sum[p1][p2] = s;
                    }
                }

            }
        }
    }

    private int calculateSum(int[][] matrix, int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int p1 = colLength * row1 + col1;
        int p2 = colLength * row2 + col2;
        return sum[p1][p2];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such: NumMatrix obj
 * = new NumMatrix(matrix); int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
