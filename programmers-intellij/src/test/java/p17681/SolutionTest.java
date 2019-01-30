package p17681;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();
    Solution2 problem2 = new Solution2();

    @Test
    public void 이진수로() {
        int a = 9;
        int n = 5;
        assertThat(problem.toBinary(n, a)).isEqualTo("01001");
    }

    @Test
    public void 이진수로2() {
        int a = 30;
        int n = 5;
        assertThat(problem.toBinary(n, a)).isEqualTo("11110");
    }

    @Test
    public void test() {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        problem.solution(n, arr1, arr2);
    }

    @Test
    public void test2() {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        problem2.solution(n, arr1, arr2);
    }
}