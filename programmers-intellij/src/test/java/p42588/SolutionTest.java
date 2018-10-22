package p42588;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem;

    @Before
    public void setUp() throws Exception {
        problem = new Solution();
    }

    @Test
    public void ex1() {
        int[] heights = {6,9,5,7,4};
        assertThat(problem.solution(heights)).isEqualTo(new int[]{0,0,2,2,4});
    }

    @Test
    public void ex2() {
        int[] heights = {3,9,9,3,5,7,2};
        assertThat(problem.solution(heights)).isEqualTo(new int[]{0,0,0,3,3,3,6});
    }

    @Test
    public void ex3() {
        int[] heights = {1,5,3,6,7,6,5};
        assertThat(problem.solution(heights)).isEqualTo(new int[]{0,0,2,0,0,5,6});
    }
}