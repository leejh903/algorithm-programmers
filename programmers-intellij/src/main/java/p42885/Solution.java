package p42885;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue();
        for (int person : people) {
            queue.offer(person);
        }

        while(!queue.isEmpty()) {
            int curWeight = 0;

            curWeight += queue.poll();

            if(!queue.isEmpty() && queue.peek() + curWeight <= limit) {
                int max = 0;
                for (Integer integer : queue) {
                    if(curWeight + integer <= limit) max = integer;
                }
                queue.remove(max);
            }

            answer++;
        }

        return answer;
    }
}