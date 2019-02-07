package p12905;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        assertThat(problem.solution(board)).isEqualTo(9);
    }

    @Test
    public void squareCheck() {
        int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        assertThat(problem.getValue(board, 2, 3)).isEqualTo(2);
    }

    @Test
    public void test2() {
        int[][] board = {{0, 0, 1, 1}, {1, 1, 1, 1}};
        assertThat(problem.solution(board)).isEqualTo(4);
    }

    @Test
    public void test3() {
        int[][] board = {{0, 0, 0, 0}, {0, 0, 0, 0}};
        assertThat(problem.solution(board)).isEqualTo(0);
    }

    @Test
    public void test4() {
        int[][] board = {{1, 0, 0, 0}, {0, 0, 0, 0}};
        assertThat(problem.solution(board)).isEqualTo(1);
    }
}