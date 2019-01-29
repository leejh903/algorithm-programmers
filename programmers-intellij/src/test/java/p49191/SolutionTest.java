package p49191;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int n = 5;
        int[][] result = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        assertThat(problem.solution(n, result)).isEqualTo(2);
    }

    @Test
    public void test2() {
        int n = 7;
        int[][] result = {{3, 7}, {4, 6}, {2, 3}, {6, 2}, {7, 1}, {1, 5}};
        assertThat(problem.solution(n, result)).isEqualTo(7);
    }

}