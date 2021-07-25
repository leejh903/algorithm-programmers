package p12984;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        int[][] land = new int[][]{{1, 2}, {2, 3}};
        int P = 3;
        int Q = 2;
        assertThat(problem.solution(land, P, Q)).isEqualTo(5);
    }

    @Test
    public void test2() {
        int[][] land = new int[][]{{4, 4, 3}, {3, 2, 2}, {2, 1, 0}};
        int P = 5;
        int Q = 3;
        assertThat(problem.solution(land, P, Q)).isEqualTo(33);
    }
}