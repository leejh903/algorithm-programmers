package p42842;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void red_combination() {
        int red = 24;
        // 24x1, 12x2, 8x3, 6x4 만 나오도록

        int width = red;
        int height = 0;
        while(red <= width * width) {
            if(red % width == 0) {
                height = red / width;
                System.out.println(String.format("width : %d, height : %d", width, height));
            }
           width--;
        }
    }

    @Test
    public void test1() {
        int brown = 10, red = 2;
        assertThat(problem.solution(brown, red)).isEqualTo(new int[]{4, 3});
    }

    @Test
    public void test2() {
        int brown = 8, red = 1;
        assertThat(problem.solution(brown, red)).isEqualTo(new int[]{3, 3});
    }

    @Test
    public void test3() {
        int brown = 24, red = 24;
        assertThat(problem.solution(brown, red)).isEqualTo(new int[]{8, 6});
    }
}