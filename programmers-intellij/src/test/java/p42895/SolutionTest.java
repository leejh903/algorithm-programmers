package p42895;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        assertThat(problem.solution(5, 12)).isEqualTo(4);
    }

    @Test
    public void test2() {
        System.out.println(problem.solution(13,1000));
    }
}