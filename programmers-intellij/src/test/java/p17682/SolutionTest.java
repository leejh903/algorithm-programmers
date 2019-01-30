package p17682;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void split() {
        String dartResult = "1S10D*10T";
        int[] value = new int[3];
        String[][] result = problem.split(dartResult, value);
        for (String[] strings : result) {
            for (String string : strings) {
                System.out.print(string + "  ");
            }
            System.out.println();
        }

        for (int i : value) {
            System.out.print(i + " ");
        }
    }

    @Test
    public void test() {
        String dartReuslt = "1S2D*3T";
        assertThat(problem.solution(dartReuslt)).isEqualTo(37);
    }

    @Test
    public void test3() {
        String dartReuslt = "1D2S#10S";
        assertThat(problem.solution(dartReuslt)).isEqualTo(9);
    }

    @Test
    public void test4() {
        String dartReuslt = "1D2S0T";
        assertThat(problem.solution(dartReuslt)).isEqualTo(3);
    }

    @Test
    public void test5() {
        String dartReuslt = "1S*2T*3S";
        assertThat(problem.solution(dartReuslt)).isEqualTo(23);
    }

    @Test
    public void test6() {
        String dartReuslt = "1D#2S*3S";
        assertThat(problem.solution(dartReuslt)).isEqualTo(5);
    }

    @Test
    public void test7() {
        String dartReuslt = "1T2D3D#";
        assertThat(problem.solution(dartReuslt)).isEqualTo(-4);
    }

    @Test
    public void test8() {
        String dartReuslt = "1D2S3T*";
        assertThat(problem.solution(dartReuslt)).isEqualTo(59);
    }
}