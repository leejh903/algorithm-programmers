package p12971;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        int[] sticker = new int[]{14, 6, 5, 11, 3, 9, 2, 10};
        assertThat(problem.solution(sticker)).isEqualTo(36);
    }

    @Test
    public void test2() {
        int[] sticker = new int[]{1, 3, 2, 5, 4};
        assertThat(problem.solution(sticker)).isEqualTo(8);
    }

    @Test
    public void test3() {
        int[] sticker = new int[]{1, 2, 3, 4, 99};
        assertThat(problem.solution(sticker)).isEqualTo(102);
    }
}