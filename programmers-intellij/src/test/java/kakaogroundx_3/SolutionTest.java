package kakaogroundx_3;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int[] gold_prices = {2, 5, 1, 3, 4};
        assertThat(problem.solution(gold_prices)).isEqualTo(4);
    }

    @Test
    public void test2() {
        int[] gold_prices = {7, 2, 5, 6, 1, 4, 2, 8};
        assertThat(problem.solution(gold_prices)).isEqualTo(10);
    }
}