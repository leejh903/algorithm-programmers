package p49995;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        int[] cookies = new int[]{1, 1, 2, 3};
        assertThat(problem.solution(cookies)).isEqualTo(3);
    }

    @Test
    public void test2() {
        int[] cookies = new int[]{1, 2, 4, 5};
        assertThat(problem.solution(cookies)).isEqualTo(0);
    }
}