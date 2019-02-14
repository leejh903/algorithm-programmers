package estsoft2;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] A) {
        int answer = 0;
        boolean[] visit = new boolean[A.length];

        for (int i = 0; i < A.length; i++) {
            if (visit[i]) continue;

            Queue<Integer> queue = new LinkedList<>();
            int now = A[i];
            visit[i] = true;
            if(now != i) {
                queue.offer(now);
                visit[now] = true;
            }
            int temp = 1;
            while (!queue.isEmpty()) {
                int next = queue.poll();
                temp++;
                if(visit[A[next]]) break;
                queue.offer(A[next]);
                visit[A[next]] = true;
            }
            answer = Math.max(answer, temp);
        }

        return answer;
    }
}