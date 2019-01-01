package p42885;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] people, int limit) {
        List<Integer> list = new ArrayList();
        for (int person : people) {
            list.add(person);
        }
        Collections.sort(list);

        int left = 0;
        int right = list.size() - 1;
        int count = 0;

        while(left < right) {
            if(list.get(left) + list.get(right) <= limit) {
                count++;
                left++;
                right--;
            } else {
                right--;
            }
        }
        return people.length - count;
    }
}