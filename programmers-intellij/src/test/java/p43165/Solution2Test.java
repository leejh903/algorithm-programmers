package p43165;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution2Test {
    Solution2 problem = new Solution2();

    @Test
    public void test1() {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        assertThat(problem.solution(numbers, target)).isEqualTo(5);
    }
}