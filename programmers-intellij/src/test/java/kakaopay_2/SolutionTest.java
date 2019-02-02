package kakaopay_2;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        String[] moves = {"U", "R", "D", "L", "U", "R", "D", "L"};
        assertThat(problem.solution(moves)).isEqualTo(1);
    }

    @Test
    public void test2() {
        String[] moves = {"U", "U", "R", "D", "L", "L", "L", "U", "R", "D", "D", "D", "L", "U", "R", "R", "R", "D", "L", "U"};
        assertThat(problem.solution(moves)).isEqualTo(5);
    }

    @Test
    public void test3() {
        String[] moves = {"U", "L", "D", "R", "R", "D", "D", "L", "U", "U"};
        assertThat(problem.solution(moves)).isEqualTo(1);
    }
}