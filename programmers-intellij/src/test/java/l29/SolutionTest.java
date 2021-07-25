package l29;

import org.junit.Test;
import static org.junit.Assert.*;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        assertEquals(problem.divide(10, 3), 3);
        assertEquals(problem.divide(7, -3), -2);
        assertEquals(problem.divide(0, 1), 0);
        assertEquals(problem.divide(1, 1), 1);
        assertEquals(problem.divide(-1, 1), -1);
        assertEquals(problem.divide(Integer.MIN_VALUE, -1), Integer.MAX_VALUE);
        System.out.println(1 >> 1);
    }
}