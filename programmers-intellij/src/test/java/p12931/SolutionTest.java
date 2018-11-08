package p12931;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        assertThat(problem.solution(123)).isEqualTo(6);
    }

    @Test
    public void test2() {
        assertThat(problem.solution(987)).isEqualTo(24);
    }
}