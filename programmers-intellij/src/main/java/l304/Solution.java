package l304;

class NumMatrix {
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        sum = new int[row][col];

        sum[0][0] = matrix[0][0];
        for(int i = 1; i < row; i++) {
            sum[i][0] = sum[i - 1][0] + matrix[i][0];
        }

        for(int i = 1; i < col; i++) {
            sum[0][i] = sum[0][i - 1] + matrix[0][i];
        }

        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                sum[i][j] = matrix[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = sum[row2][col2];

        if(col1 > 0) {
            res -= sum[row2][col1 - 1];
        }
        if(row1 > 0) {
            res -= sum[row1 - 1][col2];
        }

        if(row1 > 0 && col1 > 0) {
            res += sum[row1 - 1][col1 - 1];
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such: NumMatrix obj
 * = new NumMatrix(matrix); int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
