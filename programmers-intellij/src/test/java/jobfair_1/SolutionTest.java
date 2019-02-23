package jobfair_1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void decimals() {
        int n = 33;
        int[] decimals = problem.getDecimals(n);
        for (int decimal : decimals) {
            System.out.println(decimal);
        }
    }

    @Test
    public void test() {
        assertThat(problem.solution(33)).isEqualTo(4);
    }

    @Test
    public void test2() {
        assertThat(problem.solution(9)).isEqualTo(0);
    }

    @Test
    public void test3() {
        assertThat(problem.solution(10)).isEqualTo(1);
    }
}