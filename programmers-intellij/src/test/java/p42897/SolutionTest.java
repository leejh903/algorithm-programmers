package p42897;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int[] money = {1, 2, 3, 1};
        assertThat(problem.solution(money)).isEqualTo(4);
    }

    @Test
    public void test2() {
        int[] money = {10, 8, 3, 5, 7, 7};
        assertThat(problem.solution(money)).isEqualTo(20);
    }

    @Test
    public void test3() {
        int[] money = {1, 2, 3, 5, 1};
        assertThat(problem.solution(money)).isEqualTo(7);
    }
}