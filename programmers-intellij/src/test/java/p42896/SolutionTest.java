package p42896;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution3 problem = new Solution3();

    @Test
    public void test() {
        int[] left = {3, 2, 5};
        int[] right = {2, 4, 1};
        assertThat(problem.solution(left, right)).isEqualTo(7);
    }

    @Test
    public void test2() {
        int[] left = {1, 2, 3, 4};
        int[] right = {4, 1, 2, 3};
        assertThat(problem.solution(left, right)).isEqualTo(6);
    }
}