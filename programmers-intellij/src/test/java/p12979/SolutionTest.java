package p12979;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        int n = 11;
        int[] stations = {4, 11};
        int w = 1;
        assertEquals(3, problem.solution(n, stations, w));
    }

    @Test
    public void test2() {
        int n = 16;
        int[] stations = {9};
        int w = 2;
        assertEquals(3, problem.solution(n, stations, w));
    }
}