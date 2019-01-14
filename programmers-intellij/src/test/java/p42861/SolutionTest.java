package p42861;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        assertThat(problem.solution(n, costs)).isEqualTo(4);
    }

    @Test
    public void test2() {
        int n = 4;
        int[][] costs = {{0, 1, 5}, {0, 2, 5}, {1, 2, 5}, {1, 3, 5}, {2, 3, 8}};
        assertThat(problem.solution(n, costs)).isEqualTo(15);
    }

    @Test
    public void test3() {
        int n = 6;
        int[][] costs = {{0, 1, 1}, {1, 2, 2}, {1, 4, 3}, {2, 3, 7}, {2, 5, 3}, {3, 5, 1}, {4, 2, 1}};
        assertThat(problem.solution(n, costs)).isEqualTo(8);
    }

}