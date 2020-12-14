package p12977;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 4};
        assertEquals(1, problem.solution(nums));
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 7, 6, 4};
        assertEquals(4, problem.solution(nums));
    }
}