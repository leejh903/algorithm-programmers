package p42886;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int[] weight = {3, 1, 6, 2, 7, 30, 1};
        assertThat(problem.solution(weight)).isEqualTo(21);
    }

    @Test
    public void test2() {
        int[] weight = {3, 1, 6, 2, 7, 30, 1, 32, 1, 3, 5, 1, 5, 6, 2, 4, 9};
        assertThat(problem.solution(weight)).isEqualTo(21);
    }

}