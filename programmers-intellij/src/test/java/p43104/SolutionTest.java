package p43104;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        Queue<Integer> queue = new LinkedList<Integer>(Arrays.asList(1, 2, 3));
        for (Integer integer : queue) {
            System.out.println(integer);
        }
    }

    @Test
    public void test2() {
        assertThat(problem.solution(5)).isEqualTo(26);
    }

    @Test
    public void test3() {
        assertThat(problem.solution(6)).isEqualTo(42);
    }

    @Test
    public void test4() {
        System.out.println(problem.solution(80));
    }
}