package p12987;

import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int bIndex = 0;
        for (int aValue : A) {
            while (bIndex < B.length) {
                int bValue = B[bIndex];
                bIndex++;

                if (aValue >= bValue) continue;

                answer++;
                break;
            }
            if (bIndex == B.length) break;
        }
        return answer;
    }
}
