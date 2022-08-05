package l120;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] before = new int[triangle.size()];
        before[0] = triangle.get(0).get(0);

        int answer = before[0];
        for (int i = 1; i < triangle.size(); i++) {
            int[] current = new int[triangle.size()];

            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                if (j == 0) {
                    current[j] = before[j] + row.get(j);
                    answer = current[j]; // re-initialize
                } else if (j == row.size() - 1) {
                    current[j] = before[j - 1] + row.get(j);
                } else {
                    current[j] = Math.min(before[j - 1], before[j]) + row.get(j);
                }
                answer = Math.min(answer, current[j]);
            }
            before = current;
        }
        return answer;
    }
}
