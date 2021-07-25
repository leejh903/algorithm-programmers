package p12984;

import java.util.Arrays;

public class Solution {
    public long solution(int[][] land, int P, int Q) {
        long answer = Long.MAX_VALUE;
        int N = land.length;

        long after = 0;
        long before = 0;
        int[] lands = new int[N * N];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                int val = land[i][j];
                lands[i * N + j] = val;
                after += val;
            }
        }
        Arrays.sort(lands);

        for (int i = 0; i < lands.length; i++) {
            long val = lands[i];
            if (i > 0) {
                before += lands[i - 1];
            }
            after -= val;

            long beforeGap = (i * val) - before;
            long afterGap = after - (lands.length - i - 1) * val;
            answer = Math.min(answer, beforeGap * P + afterGap * Q);
        }
        return answer;
    }
}