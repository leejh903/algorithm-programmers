package jobfair_3;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void init() {
        int[][] items = new int[][]{{30, 100}, {500, 30}, {100, 400}};
        Queue<Item> itemQ = problem.init(items);

        while (!itemQ.isEmpty()) {
            System.out.println(itemQ.poll());
        }
    }

    @Test
    public void list() {
        int[] healths = new int[]{200, 120, 150};
        List<Integer> heals = Arrays.stream(healths).boxed().collect(Collectors.toList());
        Collections.sort(heals);
        for (Integer heal : heals) {
            System.out.println(heal);
        }
    }

    @Test
    public void test() {
        int[] healths = new int[]{200, 120, 150};
        int[][] items = new int[][]{{30, 100}, {500, 30}, {100, 400}};
        assertThat(problem.solution(healths, items)).isEqualTo(new int[]{1, 2});
    }

    @Test
    public void test2() {
        int[] healths = new int[]{300, 200, 500};
        int[][] items = new int[][]{{1000, 600}, {400, 500}, {300, 100}};
        assertThat(problem.solution(healths, items)).isEqualTo(new int[]{3});
    }
}