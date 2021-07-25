package l53;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        assertThat(problem.maxSubArray(new int[]{-1000})).isEqualTo(-1000);
    }
}