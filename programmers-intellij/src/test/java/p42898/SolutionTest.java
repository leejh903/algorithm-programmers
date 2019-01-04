package p42898;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int n = 3, m = 4;
        int[][] puddles = {{2,2}};
        boolean[][] visit = new boolean[n][m];
//        System.out.println(visit[2][2]);

        for (int[] puddle : puddles) {
            visit[puddle[0] - 1][puddle[1] - 1] = true;
        }

        for (boolean[] booleans : visit) {
            for (boolean aBoolean : booleans) {
                System.out.print(aBoolean + "  ");
            }
            System.out.println();
        }
    }

    @Test
    public void test1() {
        int n = 3, m = 4;
        int[][] puddles = {{2,2}};
        assertThat(problem.solution(m, n, puddles)).isEqualTo(4);
    }
}