package l417;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static final int[][] DIRECTIONS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                boolean[] result = dfs(heights, i, j, new boolean[m][n]);
                if (result[0] && result[1]) {
                    answer.add(List.of(i, j));
                }
            }
        }
        return answer;
    }

    // return's first index is Pacific and second is Atlantic
    boolean[] dfs(int[][] heights, int row, int col, boolean[][] visited) {
        boolean[] result = new boolean[2];
        if (isAdjacentToPacific(row, col)) {
            result[0] = true;
        }
        if (isAdjacentToAtlantic(row, col)) {
            result[1] = true;
        }

        for (int i = 0; i < DIRECTIONS.length; i++) {
            int newRow = row + DIRECTIONS[i][0];
            int newCol = col + DIRECTIONS[i][1];

            if (newRow < 0 || newRow >= heights.length || newCol < 0 || newCol >= heights[0].length) {
                continue;
            }
            if (visited[newRow][newCol]) {
                continue;
            }
            if (heights[newRow][newCol] > heights[row][col]) {
                continue;
            }

            visited[newRow][newCol] = true;
            boolean[] res = dfs(heights, newRow, newCol, visited);
            visited[newRow][newCol] = false;
            if (res[0]) {
                result[0] = true;
            }
            if (res[1]) {
                result[1] = true;
            }
        }

        return result;
    }

    boolean isAdjacentToPacific(int row, int col) {
        return row == 0 || col == 0;
    }

    boolean isAdjacentToAtlantic(int row, int col) {
        return row == m - 1 || col == n - 1;
    }
}
