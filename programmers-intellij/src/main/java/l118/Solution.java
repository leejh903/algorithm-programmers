package l118;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> part = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    part.add(1);
                    continue;
                }
                part.add(answer.get(i - 1).get(j - 1) + answer.get(i - 1).get(j));
            }
            answer.add(part);
        }
        return answer;
    }
}
