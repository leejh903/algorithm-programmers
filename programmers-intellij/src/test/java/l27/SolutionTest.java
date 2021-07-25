package l27;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        int[] nums = new int[]{3, 2, 2, 3};
        int res = problem.removeElement(nums, 3);
        assertEquals(2, res);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int res = problem.removeElement(nums, 2);
        assertEquals(5, res);
    }
}