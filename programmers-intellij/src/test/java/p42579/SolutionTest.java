package p42579;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        String[] genres = {"classic", "pop", "classic", "classic", "pop" };
        int[] plays = {500, 600, 150, 800, 2500};
        assertThat(problem.solution(genres, plays)).isEqualTo(new int[]{4, 1, 3, 0});
    }

    @Test
    public void test1() {
        String[] genres = {"classic", "pop", "pop", "classic", "pop"};
        int[] plays = {500, 600, 600, 3000, 5000};
        assertThat(problem.solution(genres, plays)).isEqualTo(new int[]{4, 1, 3, 0});
    }

    @Test
    public void test2() {
        String[] genres = {"classic", "pop", "classic", "pop", "classic", "classic" };
        int[] plays = {400, 600, 150, 2500, 500, 500};
        assertThat(problem.solution(genres, plays)).isEqualTo(new int[]{3, 1, 4, 5});
    }

    @Test
    public void test3() {
        String[] genres = {"classic"};
        int[] plays = {400};
        assertThat(problem.solution(genres, plays)).isEqualTo(new int[]{0});
    }
}