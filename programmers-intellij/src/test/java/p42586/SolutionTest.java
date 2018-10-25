package p42586;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem;

    @Before
    public void setUp() throws Exception {
        problem = new Solution();
    }

    @Test
    public void 결과_테스트1() {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] answer = {2, 1};
        assertThat(problem.solution(progresses, speeds)).isEqualTo(answer);
    }

    @Test
    public void 결과_테스트2() {
        int[] progresses = {40, 93, 30, 55, 60, 65};
        int[] speeds = {60, 1, 30, 5, 10, 7};
        int[] answer = {1, 2, 3};
        assertThat(problem.solution(progresses, speeds)).isEqualTo(answer);
    }

    @Test
    public void 결과_테스트3() {
        int[] progresses = {93, 30, 55, 60, 40, 65};
        int[] speeds = {1, 30, 5, 10, 60, 7};
        int[] answer = {2, 4};
        assertThat(problem.solution(progresses, speeds)).isEqualTo(answer);
    }


    @Test
    public void 큐_테스트() {
        LinkedList<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                System.out.print(queue.get(i));
            }
            System.out.println();
            queue.poll();
        }
    }

    @Test
    public void Job_넣고_증감시켜보기() {

        class Job {
            int progress;
            int speed;

            public Job(int progress, int speed) {
                this.progress = progress;
                this.speed = speed;
            }
        }

        LinkedList<Job> queue = new LinkedList<>();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};


        for (int i = 0; i < progresses.length; i++) {
            Job job = new Job(progresses[i], speeds[i]);
            queue.add(job);
        }


        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                System.out.print(queue.get(i).progress + " ");  // for debug
                queue.get(i).progress += queue.get(i).speed;
            }
            System.out.println();  // for debug

            int count = 0;
            while (!queue.isEmpty() && queue.peek().progress >= 100) {
                queue.poll();
                count++;
            }

            if (count > 0) {
                System.out.println(count);
            }
        }
    }
}