package l33;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        assertEquals(4, problem.search(nums, target));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 3;
        assertEquals(-1, problem.search(nums, target));
    }

    @Test
    public void test3() {
        int[] nums = new int[]{1};
        int target = 0;
        assertEquals(-1, problem.search(nums, target));
    }

    @Test
    public void test4() {
        int[] nums = new int[]{3, 5, 1};
        int target = 3;
        assertEquals(0, problem.search(nums, target));
    }

    @Test
    public void test5() {
        int[] nums = new int[]{5, 1, 3};
        int target = 3;
        assertEquals(2, problem.search(nums, target));
    }

    @Test
    public void test6() {
        int[] nums = new int[]{5, 1, 3};
        int target = 5;
        assertEquals(0, problem.search(nums, target));
    }

    @Test
    public void test7() {
        int[] nums = new int[]{4,5,6,7,8,1,2,3};
        int target = 8;
        assertEquals(4, problem.search(nums, target));
    }
}