package codility_test;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void toBinaryString() {
        String binary = Integer.toBinaryString(24);
        for (int i = 0; i < binary.length(); i++) {
            System.out.println(binary.charAt(i));
        }
    }

    @Test
    public void test() {
        assertThat(problem.solution(32)).isEqualTo(0);
    }

    @Test
    public void test2() {
        assertThat(problem.solution(529)).isEqualTo(4);
    }

    @Test
    public void test3() {
        assertThat(problem.solution(20)).isEqualTo(1);
    }
}