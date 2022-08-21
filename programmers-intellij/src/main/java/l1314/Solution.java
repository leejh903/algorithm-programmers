package l1314;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<String, Integer> cache = new HashMap<>();
    final String cacheKeyFormat = "r:(%d,%d),c:(%d,%d)";

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] answer = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int rStart = i - k < 0 ? 0 : i - k;
                int rEnd = i + k >= mat.length ? mat.length - 1 : i + k;
                int cStart = j - k < 0 ? 0 : j - k;
                int cEnd = j + k >= mat[0].length ? mat[0].length - 1 : j + k;

                String key = String.format(cacheKeyFormat, rStart, rEnd, cStart, cEnd);
                if (cache.containsKey(key)) {
                    answer[i][j] = cache.get(key);
                    continue;
                }
                int sum = calculateBlockSum(mat, rStart, rEnd, cStart, cEnd);
                cache.put(key, sum);
                answer[i][j] = sum;
            }
        }
        return answer;
    }

    int calculateBlockSum(int[][] mat, int rStart, int rEnd, int cStart, int cEnd) {
        int sum = 0;
        for (int r = rStart; r <= rEnd; r++) {
            for (int c = cStart; c <= cEnd; c++) {
                sum += mat[r][c];
            }
        }
        return sum;
    }
}
