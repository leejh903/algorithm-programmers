package p43104;

import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public long solution(int N) {
        LinkedList<Long> queue = new LinkedList<>(Arrays.asList(1L, 1L, 2L, 3L));
        if(N < 4) {
            switch (N){
                case 1:
                    return 4L;
                case 2:
                    return 6L;
                case 3:
                    return 10L;
            }
        }

        int count = 4;
        while(count < N) {
            queue.poll();
            long first = queue.pollLast();
            long second = queue.pollLast();
            queue.offer(second);
            queue.offer(first);
            queue.offer(first + second);
            count++;
        }

        return queue.poll() + queue.poll() * 2 + queue.poll() * 2 + queue.poll() * 3;
    }
}
