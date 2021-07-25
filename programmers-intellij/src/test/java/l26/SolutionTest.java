package l26;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        int[] nums = new int[]{1, 1, 2};
        int out = problem.removeDuplicates(nums);
        assertEquals(2, out);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int out = problem.removeDuplicates(nums);
        assertEquals(5, out);
    }

    @Test
    public void test3() {
        int[] nums = new int[]{};
        int out = problem.removeDuplicates(nums);
        assertEquals(0, out);
    }
}