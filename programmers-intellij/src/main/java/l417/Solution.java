package l417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    static final int[][] DIRECTIONS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int row, col;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        row = heights.length;
        col = heights[0].length;

        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        for (int i = 0; i < col; i++) {
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
            dfs(heights, row - 1, i, Integer.MIN_VALUE, atlantic);
        }

        for (int i = 0; i < row; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, col - 1, Integer.MIN_VALUE, atlantic);
        }

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    answer.add(Arrays.asList(i, j));
                }
            }
        }
        return answer;
    }

    void dfs(int[][] heights, int i, int j, int prev, boolean[][] ocean) {
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return;
        }
        if (heights[i][j] < prev || ocean[i][j]) {
            return;
        }

        ocean[i][j] = true;
        for (int k = 0; k < DIRECTIONS.length; k++) {
            dfs(heights, i + DIRECTIONS[k][0], j + DIRECTIONS[k][1], heights[i][j], ocean);
        }
    }
}
