package p43162;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                queue.offer(i);
                visit[i] = true;
                answer++;

                bfs(computers, queue, visit);
            }
        }
        return answer;
    }

    private void bfs(int[][] computers, Queue<Integer> queue, boolean[] visit) {
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int j = 0; j < computers[num].length; j++) {
                if (computers[num][j] == 1 && visit[j] == false) {
                    queue.offer(j);
                    visit[j] = true;
                }
            }
        }
    }
}
