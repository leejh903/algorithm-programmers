package p42886;

import java.util.Arrays;

class Solution {
    public int solution(int[] weight) {
        int answer = 1;
        Arrays.sort(weight);

        for (int i : weight) {
            if(answer < i) break;
            answer += i;
        }
        
        return answer;
    }
}
