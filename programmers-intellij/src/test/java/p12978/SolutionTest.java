package p12978;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void testSaveHistory() {
        Solution.History history = new Solution.History();
        history.saveHistory(1, 3);
        assertThat(history.hasHistory(1, 3)).isTrue();
        history.removeHistory(1, 3);
        assertThat(history.hasHistory(1, 3)).isFalse();
        assertThat(history.hasHistory(1, 4)).isFalse();
    }

    @Test
    public void testcase1() {
        int N = 5;
        int K = 3;
        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};

        assertThat(problem.solution(N, road, K)).isEqualTo(4);
    }

    @Test
    public void testcase2() {
        int N = 6;
        int K = 4;
        int[][] road = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};

        assertThat(problem.solution(N, road, K)).isEqualTo(4);
    }

    @Test
    public void extractTo() {
        assertThat(Solution.History.extractTo("(1,2)")).isEqualTo(2);
    }

    @Test
    public void extractFrom() {
        assertThat(Solution.History.extractFrom("(1,2)")).isEqualTo(1);
    }
}