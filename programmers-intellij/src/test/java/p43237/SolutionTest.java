package p43237;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int[] budgets = {120, 110, 140, 150};
        int M = 485;
        assertThat(problem.solution(budgets, M)).isEqualTo(127);
    }

    @Test
    public void test5() {
        int[] budgets = {120, 110, 140, 150};
        int M = 486;
        assertThat(problem.solution(budgets, M)).isEqualTo(128);
    }

    @Test
    public void test2() {
        int[] budgets = {110, 110, 110, 120};
        int M = 485;
        assertThat(problem.solution(budgets, M)).isEqualTo(120);
    }

    @Test
    public void test4() {
        int[] budgets = {110, 120, 100, 100};
        int M = 450;
        assertThat(problem.solution(budgets, M)).isEqualTo(120);
    }

    @Test
    public void makeNewBudget() {
        int[] budgets = {120, 110, 140, 150};
        int mid = 120;
        assertThat(problem.makeNewBudet(budgets, mid)).isEqualTo(470);
    }

    @Test
    public void test3() {
        int[] budgets = {9, 8, 5, 6, 7};
        int M = 5;
        assertThat(problem.solution(budgets, M)).isEqualTo(1);
    }
}