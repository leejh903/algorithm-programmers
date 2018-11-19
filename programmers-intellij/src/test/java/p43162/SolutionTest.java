package p43162;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void boolean_기본값() {  // false
        boolean[] test = new boolean[3];
        System.out.println(test[1]);
    }

    @Test
    public void bfs_구현() {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                queue.offer(i);
                visit[i] = true;
                answer++;

                while (!queue.isEmpty()) {
                    int num = queue.poll();
                    for (int j = 0; j < computers[num].length; j++) {
                        if(num == j) continue;  // 자기자신은 건너띄고
                        if(computers[num][j] == 1 && visit[j] == false) {
                            queue.offer(j);
                            visit[j] = true;
                        }
                    }
                }
            }
        }

        assertThat(problem.solution(n, computers)).isEqualTo(2);
    }

    @Test
    public void test() {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        assertThat(problem.solution(n, computers)).isEqualTo(1);
    }
}