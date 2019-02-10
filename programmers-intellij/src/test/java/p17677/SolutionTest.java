package p17677;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
       String str1 = "FRANCE";
       String str2 = "french";
       assertThat(problem.solution(str1, str2)).isEqualTo(16384);
    }

    @Test
    public void test2() {
        String str1 = "handshake";
        String str2 = "shake hands";
        assertThat(problem.solution(str1, str2)).isEqualTo(65536);
    }

    @Test
    public void test3() {
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        assertThat(problem.solution(str1, str2)).isEqualTo(43690);
    }

    @Test
    public void test4() {
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";
        assertThat(problem.solution(str1, str2)).isEqualTo(65536);
    }

    @Test
    public void split() {
        String str1 = "handshake";
        String str2 = "e=m*c^2";
        problem.init(str1);
    }

    @Test
    public void isValid() {
        assertThat(problem.isValid('*')).isFalse();
    }

    @Test
    public void isValid2() {
        assertThat(problem.isValid('A')).isTrue();
    }

    @Test
    public void toUpperCase() {
        assertThat(problem.toUpperCase('a')).isEqualTo('A');
    }

    @Test
    public void toUpperCase2() {
        assertThat(problem.toUpperCase('c')).isEqualTo('C');
    }
}