package p42626;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        assertThat(problem.solution(scoville, 7)).isEqualTo(2);
    }

    @Test
    public void test2() {
        int[] scoville = {0, 0, 1};
        assertThat(problem.solution(scoville, 2)).isEqualTo(2);
    }

    @Test
    public void arraList_remove_테스트() {
        List<Integer> list = new ArrayList(Arrays.asList(1, 2, 4, 4, 5, 6));
        list.remove(3);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}