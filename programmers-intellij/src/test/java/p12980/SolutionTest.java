package p12980;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        assertThat(problem.solution(5)).isEqualTo(2);
    }

    @Test
    public void test2() {
        assertThat(problem.solution(6)).isEqualTo(2);
    }

    @Test
    public void test3() {
        assertThat(problem.solution(5000)).isEqualTo(5);
    }
}