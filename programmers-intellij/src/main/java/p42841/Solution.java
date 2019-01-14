package p42841;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[][] baseball) {
        int answer = 0;
        for (int i = 111; i < 1000; i++) {
            Set<Integer> set = setInit(i);
            if(set.contains(0) || set.size() != 3) continue;

            boolean flag = true;
            for (int[] ints : baseball) {
                int target = ints[0];
                int num = i;
                int strike = 0;
                int ball = 0;

                while(num != 0) {
                    int temp = target % 10;
                    if(num % 10 == temp) strike++;
                    else if(set.contains(temp)) ball++;
                    num /= 10; target /= 10;
                }

                if(strike != ints[1] || ball != ints[2]) {
                    flag = false;
                    break;
                }
            }

            if(flag) answer++;
        }
        return answer;
    }

    private Set<Integer> setInit(int i) {
        Set<Integer> set = new HashSet<>();
        String[] numText = String.valueOf(i).split("");
        for (String s : numText) {
            set.add(Integer.valueOf(s));
        }
        return set;
    }
}
