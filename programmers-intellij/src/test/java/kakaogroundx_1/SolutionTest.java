package kakaogroundx_1;

import org.junit.Test;

import java.util.Queue;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void init() {
        int[] openA = {3, 5, 7};
        Queue<Integer> queue = problem.init(openA);
    }

    @Test
    public void test() {
        int[] openA = {3, 5, 7};
        int[] closeB = {4, 10, 12};
        assertThat(problem.solution(openA, closeB)).isEqualTo(6);
    }

    @Test
    public void test2() {
        int[] openA = {4, 7, 9, 16};
        int[] closeB = {2, 5, 12, 14, 20};
        assertThat(problem.solution(openA, closeB)).isEqualTo(10);
    }
}