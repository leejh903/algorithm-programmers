package p42899;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int K = 1650;
        int[][] travel = {{500, 200, 200, 100}, {800, 370, 300, 120}, {700, 250, 300, 90}};
        assertThat(problem.solution(K, travel)).isEqualTo(660);
    }

    @Test
    public void test2() {
        int K = 3000;
        int[][] travel = {{1000, 2000, 300, 700}, {1100, 1900, 400, 900}, {900, 1800, 400, 700}, {1200, 2300, 500, 1200}};
        assertThat(problem.solution(K, travel)).isEqualTo(5900);
    }
}