package p12987;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        int[] A = new int[]{5, 1, 3, 7};
        int[] B = new int[]{2, 2, 6, 8};
        assertThat(problem.solution(A, B)).isEqualTo(3);
    }

    @Test
    public void test2() {
        int[] A = new int[]{2, 2, 2, 2};
        int[] B = new int[]{1, 1, 1, 1};
        assertThat(problem.solution(A, B)).isEqualTo(0);
    }

    @Test
    public void test3() {
        int[] A = new int[]{5, 3, 2, 12};
        int[] B = new int[]{2, 4, 8, 2};
        assertThat(problem.solution(A, B)).isEqualTo(2);
    }
}