package kakaopay_1;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        String phone_number = "01012345678";
        assertThat(problem.solution(phone_number)).isEqualTo(2);
    }

    @Test
    public void test_1() {
        String phone_number = "11012345678";
        assertThat(problem.solution(phone_number)).isEqualTo(-1);
    }

    @Test
    public void test2() {
        String phone_number = "010-1212-333";
        assertThat(problem.solution(phone_number)).isEqualTo(-1);
    }

    @Test
    public void test2_1() {
        String phone_number = "010-1212-3333";
        assertThat(problem.solution(phone_number)).isEqualTo(1);
    }

    @Test
    public void test3() {
        String phone_number = "+82-10-3434-2323";
        assertThat(problem.solution(phone_number)).isEqualTo(3);
    }

    @Test
    public void test4() {
        String phone_number = "+82-010-3434-2323";
        assertThat(problem.solution(phone_number)).isEqualTo(-1);
    }
}