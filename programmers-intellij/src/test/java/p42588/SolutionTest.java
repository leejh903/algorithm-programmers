package p42588;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution problem;

    @Before
    public void setUp() throws Exception {
        problem = new Solution();
    }

    @Test
    public void solution() {
        int[] heights = {6,9,5,7,4};
        problem.solution(heights);
    }
}