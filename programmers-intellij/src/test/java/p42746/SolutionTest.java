package p42746;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void solution() {
        int[] numbers = {0, 0, 0, 0};
        Solution problem = new Solution();
        String answer = problem.solution(numbers);
        assertThat(answer).isEqualTo("0");
    }
}