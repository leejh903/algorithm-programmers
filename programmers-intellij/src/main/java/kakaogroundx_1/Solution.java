package kakaogroundx_1;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] openA, int[] closeB) {
        int answer = 0;

        Queue<Integer> queueA = init(openA);
        Queue<Integer> queueB = init(closeB);

        while (!queueA.isEmpty()) {
            while(queueB.peek() < queueA.peek()) {
                queueB.poll();
            }

            int a = queueA.poll();
            int b = queueB.poll();

            while(!queueA.isEmpty() && queueA.peek() < b) {
                queueA.poll();
            }

            answer += b - a;
        }

        return answer;
    }

    public Queue<Integer> init(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i : arr) {
            queue.offer(i);
        }
        return queue;
    }
}