package p43236;

import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int a = 0;
        int b = distance;

        while(a < b) {
            int c = (a + b + 1) / 2;

            int p = 0;
            int hits = 0;
            for (int i = 0; i < rocks.length; i++) {
                if(rocks[i] - p < c) {
                    ++hits;
                } else {
                    p = rocks[i];
                }
            }

            if(hits > n) {
                b = c - 1;
            } else {
                a = c;
            }
        }

        return a;
    }
}
