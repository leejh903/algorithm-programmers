package p42627;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        assertThat(problem.solution(jobs)).isEqualTo(9);
    }
}