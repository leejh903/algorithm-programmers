package p12982;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void testcase1() {
        int[] d = {1, 3, 2, 5, 4};
        int budget = 9;

        assertThat(problem.solution(d, budget)).isEqualTo(3);
    }

    @Test
    public void testcase2() {
        int[] d = {2, 2, 3, 3};
        int budget = 10;

        assertThat(problem.solution(d, budget)).isEqualTo(4);
    }
}