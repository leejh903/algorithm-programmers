package l31;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        int[] nums = new int[]{1,2,3};
        problem.nextPermutation(nums);
        int[] answer = new int[]{1,3,2};
        assertArrayEquals(nums, answer);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{3,2,1};
        problem.nextPermutation(nums);
        int[] answer = new int[]{1,2,3};
        assertArrayEquals(nums, answer);
    }

    @Test
    public void test3() {
        int[] nums = new int[]{1,1,5};
        problem.nextPermutation(nums);
        int[] answer = new int[]{1,5,1};
        assertArrayEquals(nums, answer);
    }

    @Test
    public void test4() {
        int[] nums = new int[]{1};
        problem.nextPermutation(nums);
        int[] answer = new int[]{1};
        assertArrayEquals(nums, answer);
    }
}