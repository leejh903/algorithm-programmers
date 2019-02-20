package p17687;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void n진수로_표현하기() {
        int N = 3;
        int num = 5;
        assertThat(problem.makeNnotation(N, num)).isEqualTo("12");
    }

    @Test
    public void n진수로_표현하기2() {
        int N = 16;
        int num = 12;
        assertThat(problem.makeNnotation(N, num)).isEqualTo("C");
    }

    @Test
    public void n진수로_표현하기3() {
        int N = 2;
        int num = 0;
        assertThat(problem.makeNnotation(N, num)).isEqualTo("0");
    }

    @Test
    public void n진수로_표현하기4() {
        int N = 3;
        int num = 37;
        assertThat(problem.makeNnotation(N, num)).isEqualTo("1101");
    }

    @Test
    public void 십넘는수_표현() {
        assertThat(problem.expressions[11]).isEqualTo("B");
    }

    @Test
    public void test1() {
        int n = 2, t = 4, m = 2, p = 1;
        assertThat(problem.solution(n, t, m, p)).isEqualTo("0111");
    }

    @Test
    public void test2() {
        int n = 16, t = 16, m = 2, p = 1;
        assertThat(problem.solution(n, t, m, p)).isEqualTo("02468ACE11111111");
    }

    @Test
    public void test3() {
        int n = 16, t = 16, m = 2, p = 2;
        assertThat(problem.solution(n, t, m, p)).isEqualTo("13579BDF01234567");
    }
}