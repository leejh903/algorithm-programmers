package p42626;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue();
        for (int i : scoville) {
            queue.offer(i);
        }

        while(queue.peek() < K) {
            if(queue.size() == 1) return -1;
            int temp1 = queue.poll();
            int temp2 = queue.poll();
            int newFood = temp1 + (temp2 * 2);
            queue.offer(newFood);
            answer++;
        }
        return answer;
    }

}