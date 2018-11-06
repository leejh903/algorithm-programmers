package p12921;

class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] arr = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = true;
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i]) {
                for (int j = i + i; j <= n; j += i) {
                    arr[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i]) answer++;
        }

        return answer;
    }
}
