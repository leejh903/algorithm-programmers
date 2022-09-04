package l221;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int answer = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] != '1')
                    continue;

                int col = matrix[0].length;
                int row = 0;
                for (int r2 = r; r2 < matrix.length; r2++) {
                    if (matrix[r2][c] == '0') {
                        break;
                    }

                    int tempCol = 0;
                    for (int c2 = c; c2 < matrix[0].length; c2++) {
                        if (matrix[r2][c2] == '0')
                            break;
                        tempCol++;
                    }
                    col = Math.min(col, tempCol);
                    row++;

                    int len = Math.min(col, row);
                    answer = Math.max(answer, len * len);
                }
            }
        }
        return answer;
    }
}
