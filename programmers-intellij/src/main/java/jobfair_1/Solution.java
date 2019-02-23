package jobfair_1;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int answer = 0;
    int target = 0;

    public int solution(int n) {
        target = n;
        int[] decimals = getDecimals(n);
        int r = 3;
        int[] data = new int[r];
        int num = decimals.length;
        combination(decimals, data, 0, num, 0, r);
        return answer;
    }

    int[] getDecimals(int n) {
        List<Integer> list = new ArrayList<>();
        boolean[] visit = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (!visit[i]) {
                list.add(i);
                for (int j = i + i; j <= n; j += i) {
                    visit[j] = true;
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    void combination(int[] arr, int[] data, int start, int end, int index, int r) {
        if (index == r) {
            int temp = 0;
            for (int datum : data) temp += datum;
            if (temp == target) answer++;
            return;
        }

        for (int i = start; i < end && end - i >= r - index; i++) {
            data[index] = arr[i];
            combination(arr, data, i + 1, end, index + 1, r);
        }
    }
}
