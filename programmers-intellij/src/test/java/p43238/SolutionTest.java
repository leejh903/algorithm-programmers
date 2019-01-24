package p43238;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int n = 6;
        int[] times = {7, 10};
        assertThat(problem.solution(n, times)).isEqualTo(28);
    }

    @Test
    public void test2() {
        int n = 10;
        int[] times = {3, 8, 3, 6, 9, 2, 4};
        assertThat(problem.solution(n, times)).isEqualTo(8);
    }

    @Test
    public void test3() {
        int n = 6;
        int[] times = {6, 10};
        assertThat(problem.solution(n, times)).isEqualTo(24);
    }

    @Test
    public void test4() {
        int n = 6;
        int[] times = {8, 10};
        assertThat(problem.solution(n, times)).isEqualTo(30);
    }

    @Test
    public void test5() {
        int n = 6;
        int[] times = {4, 10};
        assertThat(problem.solution(n, times)).isEqualTo(20);
    }

    @Test
    public void test6() {
        int n = 11;
        int[] times = {3, 4, 10};
        assertThat(problem.solution(n, times)).isEqualTo(18);
    }

    @Test
    public void test7() {
        int n = 5;
        int[] times = {1, 1, 10};
        assertThat(problem.solution(n, times)).isEqualTo(3);
    }

    @Test
    public void test8() {
        int n = 4;
        int[] times = {2, 2, 2};
        assertThat(problem.solution(n, times)).isEqualTo(4);
    }


    @Test
    public void passCount() {
        int mid = 7;
        int[] times = {3, 8, 3, 6, 9, 2, 4};
        assertThat(problem.passCount(mid, times)).isEqualTo(9);
    }
}