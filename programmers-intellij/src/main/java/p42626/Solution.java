package p42626;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        List<Integer> scovilleList = Arrays.stream(scoville).boxed().collect(Collectors.toList());

        while(Collections.min(scovilleList) < K) {
            Collections.sort(scovilleList);
            int temp1 = scovilleList.remove(0);
            int temp2 = scovilleList.remove(0);
            int newScoville = temp1 + (temp2 * 2);
            scovilleList.add(newScoville);
            if(newScoville < K && scovilleList.size() == 1) return -1;
            answer++;
        }
        return answer;
    }
}