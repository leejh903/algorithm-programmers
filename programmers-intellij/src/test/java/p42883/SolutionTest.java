package p42883;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        String number = "4177252841";
        int k = 4;

        StringBuilder sb = new StringBuilder(number);
        while(k > 0) {
            boolean deleted = false;
            for (int i = 0; i < sb.length() - 1; i++) {
                if(sb.charAt(i) < sb.charAt(i + 1)) {
                    sb.deleteCharAt(i);
                    deleted = true;
                    break;
                }
            }

            if(!deleted) sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        assertThat(sb.toString().equals("775841")).isTrue();
    }

    @Test
    public void test2() {
        String number = "1924";
        int k = 2;
        assertThat(problem.solution(number, k)).isEqualTo("94");
    }

    @Test
    public void test3() {
        String number = "1231234";
        int k = 3;
        assertThat(problem.solution(number, k)).isEqualTo("3234");
    }

    @Test
    public void test4() {
        String number = "7777777";
        int k = 3;
        assertThat(problem.solution(number, k)).isEqualTo("7777");
    }
}