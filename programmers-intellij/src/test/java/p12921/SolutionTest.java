package p12921;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        assertThat(problem.solution(10)).isEqualTo(4);
    }

    @Test
    public void test2() {
        assertThat(problem.solution(5)).isEqualTo(3);
    }
}