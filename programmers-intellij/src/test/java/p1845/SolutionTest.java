package p1845;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    Solution problem = new Solution();

    @Test
    public void test() {
      int[] data = new int[]{3, 1, 2, 3};
      assertEquals(2, problem.solution(data));
    }

    @Test
    public void test2() {
        int[] data = new int[]{3, 3, 3, 2, 2, 4};
        assertEquals(3, problem.solution(data));
    }

    @Test
    public void test3() {
        int[] data = new int[]{3, 3, 3, 2, 2, 2};
        assertEquals(2, problem.solution(data));
    }
}