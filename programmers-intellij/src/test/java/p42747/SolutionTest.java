package p42747;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int[] citations = {3, 0, 6, 1, 5};
        assertThat(problem.solution(citations)).isEqualTo(3);
    }

    @Test
    public void test2() {
        int[] citations = {22, 42};
        assertThat(problem.solution(citations)).isEqualTo(2);
    }

    @Test
    public void test3() {
        int[] citations = {3,0,6,1,5};
        assertThat(problem.solution(citations)).isEqualTo(3);
    }
}