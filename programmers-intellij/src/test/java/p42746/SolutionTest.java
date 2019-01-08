package p42746;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution2 problem = new Solution2();

    @Test
    public void solution() {
        int[] numbers = {0, 0, 0, 0};
        String answer = problem.solution(numbers);
        assertThat(answer).isEqualTo("0");
    }

    @Test
    public void text2() {
        int[] numbers = {3, 30, 34, 5, 9};
        assertThat(problem.solution(numbers)).isEqualTo("9534330");
    }
}