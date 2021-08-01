package l48;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void ceiling() {
        assertEquals(Math.ceil(4.0), 4.0, 0);
    }

    @Test
    public void test1() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        problem.rotate(matrix);
        int[][] answer = new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertArrayEquals(matrix, answer);
    }

    @Test
    public void test2() {
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        problem.rotate(matrix);
        int[][] answer = new int[][]{{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
        assertArrayEquals(matrix, answer);
    }

    @Test
    public void test3() {
        int[][] matrix = new int[][]{{1}};
        problem.rotate(matrix);
        int[][] answer = new int[][]{{1}};
        assertArrayEquals(matrix, answer);
    }

    @Test
    public void test4() {
        int[][] matrix = new int[][]{{1, 2}, {3, 4}};
        problem.rotate(matrix);
        int[][] answer = new int[][]{{3, 1}, {4, 2}};
        assertArrayEquals(matrix, answer);
    }
}