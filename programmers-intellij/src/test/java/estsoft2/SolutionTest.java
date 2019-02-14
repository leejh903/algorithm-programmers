package estsoft2;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int[] A = {5, 4, 0, 3, 1, 6, 2};
        assertThat(problem.solution(A)).isEqualTo(4);
    }

    @Test
    public void test2() {
        int[] A = {};
        assertThat(problem.solution(A)).isEqualTo(0);
    }

    @Test
    public void test3() {
        int[] A = {0, 1, 2, 3, 4, 5};
        assertThat(problem.solution(A)).isEqualTo(1);
    }

    @Test
    public void test4() {
        int[] A = {2, 4, 3, 0, 1, 6, 5};
        assertThat(problem.solution(A)).isEqualTo(3);
    }

    @Test
    public void test5() {
        int[] A = {1, 2, 3, 4, 5, 6, 0};
        assertThat(problem.solution(A)).isEqualTo(7);
    }

    @Test
    public void test6() {
        int[] A = {1, 0, 3, 2, 5, 6, 4};
        assertThat(problem.solution(A)).isEqualTo(3);
    }
}