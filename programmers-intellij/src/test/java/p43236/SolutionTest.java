package p43236;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;
        assertThat(problem.solution(distance, rocks, n)).isEqualTo(4);
    }
}