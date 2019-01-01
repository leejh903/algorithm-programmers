package p42885;

import org.junit.Test;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        assertThat(problem.solution(people, limit)).isEqualTo(3);
    }

    @Test
    public void test2() {
        int[] people = {70, 80, 50};
        int limit = 100;
        assertThat(problem.solution(people, limit)).isEqualTo(3);
    }

    @Test
    public void test3() {
        int[] people = {30, 70, 50, 70, 50};
        int limit = 100;
        assertThat(problem.solution(people, limit)).isEqualTo(3);
    }

    @Test
    public void minHeapTest() {
        int[] people = {70, 80, 50};
        Queue<Integer> queue = new PriorityQueue();
        for (int person : people) {
            queue.offer(person);
        }
        Iterator<Integer> iterator = queue.iterator();
    }
}