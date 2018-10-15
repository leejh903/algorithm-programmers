package p42585;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void solution() {
//        assertThat(problem.solution("()(((()())(())()))(())")).isEqualTo(17);
        assertThat(problem.solution("(((()(()()))(())()))(()())")).isEqualTo(24);
//        assertThat(problem.solution("((())())")).isEqualTo(5);

    }
}