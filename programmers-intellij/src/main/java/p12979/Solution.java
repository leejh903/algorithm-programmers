package p12979;

// O(2n)은 안되고 O(n)이어야 통과
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int past = 1;
        for (int i = 0; i < stations.length; i++) {
            int left = stations[i] - w - past;
            if (left > 0) {
                answer += installCount(left, 2 * w + 1);
            }

            past = stations[i] + w + 1;

            // last one
            if (i == stations.length - 1) {
                int right = n - past + 1;
                if (right > 0) {
                    answer += installCount(right, 2 * w + 1);
                }
            }
        }

        return answer;
    }

    public int installCount(int length, int cover) {
        double f = length / (double) (cover);
        int r = (int) f;
        if (f > r) {
            r += 1;
        }
        return r;
    }
}
