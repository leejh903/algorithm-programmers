package l41;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        int[] nums = new int[]{1, 2, 0};
        assertThat(problem.firstMissingPositive(nums)).isEqualTo(3);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{3, 4, -1, 1};
        assertThat(problem.firstMissingPositive(nums)).isEqualTo(2);
    }

    @Test
    public void test3() {
        int[] nums = new int[]{7, 8, 9, 11, 12};
        assertThat(problem.firstMissingPositive(nums)).isEqualTo(1);
    }
}