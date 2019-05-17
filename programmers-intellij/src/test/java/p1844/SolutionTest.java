package p1844;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    Solution problem = new Solution();

    @Test
    public void test1() {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        assertEquals(11, problem.solution(maps));
    }

    @Test
    public void test2() {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        assertEquals(-1, problem.solution(maps));
    }
}