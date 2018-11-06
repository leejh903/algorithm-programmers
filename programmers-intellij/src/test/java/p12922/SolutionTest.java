package p12922;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        assertThat(problem.solution(3)).isEqualTo("수박수");
    }

    @Test
    public void test2() {
        assertThat(problem.solution(4)).isEqualTo("수박수박");
    }
}