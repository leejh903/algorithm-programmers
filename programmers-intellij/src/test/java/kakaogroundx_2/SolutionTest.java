package kakaogroundx_2;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void getY() {
        int W = 8;
        int H = 12;
        assertThat(problem.getY(W, H, 8)).isEqualTo(12);
    }

    @Test
    public void getY2() {
        int W = 8;
        int H = 12;
        assertThat(problem.getY(W, H, 0)).isEqualTo(0);
    }

    @Test
    public void getY3() {
        int W = 8;
        int H = 12;
        assertThat(problem.getY(W, H, 1)).isEqualTo(1.5);
    }

    @Test
    public void test() {
        int W = 8;
        int H = 12;
        assertThat(problem.solution(W, H)).isEqualTo(80);
    }

    @Test
    public void test2() {
        int W = 4;
        int H = 3;
        assertThat(problem.solution(W, H)).isEqualTo(6);
    }

    @Test
    public void test3() {
        int W = 2;
        int H = 12;
        assertThat(problem.solution(W, H)).isEqualTo(12);
    }
}