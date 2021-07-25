package p49995;

class Solution {
    public int solution(int[] cookie) {
        int answer = 0;

        int N = cookie.length;
        int[] rangeSum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            rangeSum[i + 1] = rangeSum[i] + cookie[i];
        }

        for (int i = 0; i < N; i++) {
            int sum1 = rangeSum[i];
            for (int j = i + 1; j <= N; j++) {
                int sum2 = rangeSum[j] - sum1;
                if (answer >= sum2 || sum2 > sum1) continue;
                for (int k = 0; k < i; k++) {
                    if (sum2 == sum1 - rangeSum[k]) {
                        answer = sum2;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
