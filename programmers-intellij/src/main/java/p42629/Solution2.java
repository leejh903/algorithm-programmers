package p42629;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution2 {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue(Collections.reverseOrder());

        int index = 0;
        for (int day = 0; day < k; day++) {
            if(index < dates.length && day == dates[index]) {
                queue.offer(supplies[index]);
                index++;
            }
            if(stock <= 0) {
                answer++;
                stock += queue.poll();
            }
            stock--;
        }
        return answer;
    }
}

