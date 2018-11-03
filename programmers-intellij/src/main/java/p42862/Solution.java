package p42862;

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n + 2];
        List<Integer> reserveList = new ArrayList();
        for (Integer integer : reserve) {
            reserveList.add(integer);
        }
        int answer = 0;

        for (int i : lost) {
            student[i] = 1;
        }

            for (int i = 1; i <= n; i++) {
                if(student[i] == 1) {
                    if(reserveList.contains(i)) {
                        student[i] = 0;
                        reserveList.remove(reserveList.indexOf(i));
                        continue;
                    }

                    if(reserveList.contains(i+1) && student[i+1] == 0) {
                        student[i] = 0;
                        reserveList.remove(reserveList.indexOf(i+1));
                        continue;
                    }

                    if(reserveList.contains(i-1) && student[i-1] == 0) {
                        student[i] = 0;
                        reserveList.remove(reserveList.indexOf(i-1));
                        continue;
                    }

                }
            }

        for (int i = 1; i <= n; i++) {
            if(student[i] == 0) answer++;
        }

        return answer;
    }
}
