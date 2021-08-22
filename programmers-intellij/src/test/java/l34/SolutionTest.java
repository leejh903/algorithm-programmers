package l34;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        assertArrayEquals(new int[]{3,4}, problem.searchRange(nums, target));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 6;
        assertArrayEquals(new int[]{-1,-1}, problem.searchRange(nums, target));
    }

    @Test
    public void test3() {
        int[] nums = new int[]{};
        int target = 0;
        assertArrayEquals(new int[]{-1,-1}, problem.searchRange(nums, target));
    }

    @Test
    public void test4() {
        int[] nums = new int[]{1};
        int target = 0;
        assertArrayEquals(new int[]{-1, -1}, problem.searchRange(nums, target));
    }

    @Test
    public void test5() {
        int[] nums = new int[]{1};
        int target = 1;
        assertArrayEquals(new int[]{0, 0}, problem.searchRange(nums, target));
    }

    @Test
    public void test6() {
        int[] nums = new int[]{2,2};
        int target = 1;
        assertArrayEquals(new int[]{-1, -1}, problem.searchRange(nums, target));
    }
}