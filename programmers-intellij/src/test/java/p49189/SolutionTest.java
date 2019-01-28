package p49189;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void init() {
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        Map<Integer, List<Integer>> map = problem.init(edge);
        assertThat(map.get(3).contains(6)).isTrue();
        for (Integer integer : map.keySet()) {
            for (Integer integer1 : map.get(integer)) {
                System.out.print(integer1 + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void test() {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        assertThat(problem.solution(n, edge)).isEqualTo(3);
    }
}