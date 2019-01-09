package p42747;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        List<Integer> list = new ArrayList();
        for (int citation : citations) {
            list.add(citation);
        }
        Collections.sort(list);

        int last = list.get(list.size() - 1);
        for (int h = 0; h <= last; h++) {
            int above = 0;
            for (Integer i : list) {
                if(i >= h) above++;
            }
            int below = list.size() - above;

            if(above >= h && below <= h) {
                answer = h;
            }
        }

        return answer;
    }
}
