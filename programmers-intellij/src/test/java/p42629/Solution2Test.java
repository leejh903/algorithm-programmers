package p42629;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution2Test {
    Solution2 problem = new Solution2();

    @Test
    public void test1() {
        int stock = 4;
        int[] dates = {4, 10, 15};
        int[] supplies = {20, 5, 10};
        int k = 30;
        assertThat(problem.solution(stock, dates, supplies, k)).isEqualTo(2);
    }

    @Test
    public void test2() {
        int stock = 4;
        int[] dates = {1, 2, 3, 4};
        int[] supplies = {10, 40, 30, 20};
        int k = 100;
        assertThat(problem.solution(stock, dates, supplies, k)).isEqualTo(4);
    }
}