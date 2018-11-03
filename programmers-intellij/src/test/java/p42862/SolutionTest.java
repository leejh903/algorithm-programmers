package p42862;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void index_테스트() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(list.indexOf(3));

        System.out.println(list);
    }

    @Test
    public void 잃어버린_친구() {
        int n = 5;
        int[] lost = {2, 3, 4};
        int[] reserve = {3, 4, 5};

        assertThat(problem.solution(n, lost, reserve)).isEqualTo(4);
    }

    @Test
    public void test1() {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        assertThat(problem.solution(n, lost, reserve)).isEqualTo(5);
    }

    @Test
    public void test2() {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {3};

        assertThat(problem.solution(n, lost, reserve)).isEqualTo(4);
    }

    @Test
    public void test3() {
        int n = 5;
        int[] lost = {2, 4, 5};
        int[] reserve = {1, 4};

        assertThat(problem.solution(n, lost, reserve)).isEqualTo(4);
    }

    @Test
    public void test4() {
        int n = 5;
        int[] lost = {2, 4, 5};
        int[] reserve = {1, 4};

        assertThat(problem.solution(n, lost, reserve)).isEqualTo(4);
    }
}