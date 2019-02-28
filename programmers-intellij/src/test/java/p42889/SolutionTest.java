package p42889;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void stage() {
        Stage stage = new Stage(2);
        stage.increasePass();
        stage.increasePass();
        stage.increaseChallenging();
    }

    @Test
    public void init() {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        List<Stage> list = problem.init(N);
        problem.calculate(list, stages);
    }

    @Test
    public void test() {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        assertThat(problem.solution(N, stages)).isEqualTo(new int[]{3, 4, 2, 1, 5});
    }

    @Test
    public void test2() {
        int N = 4;
        int[] stages = {4, 4, 4, 4, 4};
        assertThat(problem.solution(N, stages)).isEqualTo(new int[]{4, 1, 2, 3});
    }
}