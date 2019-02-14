package estsoft1;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void init() {
        int[] ranks = {3, 4, 3, 0, 2, 2, 3, 0, 0};
        Map<Integer, Integer> map = problem.init(ranks);
        for (Integer integer : map.keySet()) {
            System.out.println(integer + " " + map.get(integer));
        }
    }

    @Test
    public void test() {
        int[] ranks = {3, 4, 3, 0, 2, 2, 3, 0, 0};
        assertThat(problem.solution(ranks)).isEqualTo(5);
    }

    @Test
    public void test2() {
        int[] ranks = {4, 2, 0};
        assertThat(problem.solution(ranks)).isEqualTo(0);
    }
}