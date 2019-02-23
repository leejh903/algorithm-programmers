package jobfair_2;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] people, int[] tshirts) {
        int answer = 0;
        Queue<Integer> peopleQ = init(people);
        Queue<Integer> tshirtQ = init(tshirts);

        while(!peopleQ.isEmpty() && !tshirtQ.isEmpty()) {
            int tshirt = tshirtQ.poll();
            int person = peopleQ.peek();
            if(tshirt >= person) {
                answer++;
                peopleQ.poll();
            }
        }
        return answer;
    }

    public Queue<Integer> init(int[] sizes) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int person : sizes) {
            queue.offer(person);
        }
        return queue;
    }
}