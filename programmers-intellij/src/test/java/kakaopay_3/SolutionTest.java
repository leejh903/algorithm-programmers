package kakaopay_3;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void init() {
        int N = 3;
        int[] coffee_times = {4, 2, 2, 5, 3};
        assertThat(problem.solution(N, coffee_times)).isEqualTo(new int[]{2, 3, 1, 5, 4});
    }

    @Test
    public void init2() {
        int N = 1;
        int[] coffee_times = {100, 1, 50, 1, 1};
        assertThat(problem.solution(N, coffee_times)).isEqualTo(new int[]{1, 2, 3, 4, 5});
    }
}