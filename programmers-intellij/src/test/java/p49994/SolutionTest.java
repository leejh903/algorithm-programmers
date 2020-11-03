package p49994;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static p49994.Solution.Movement.GetHistoryData;
import static p49994.Solution.Movement.GetReverseHistoryData;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void example1() {
        String dirs = "ULURRDLLU";
        assertThat(problem.solution(dirs)).isEqualTo(7);
    }

    @Test
    public void example2() {
        String dirs = "LULLLLLLU";
        assertThat(problem.solution(dirs)).isEqualTo(7);
    }

    @Test
    public void example3() {
        String dirs = "LRLRL";
        assertThat(problem.solution(dirs)).isEqualTo(1);
    }

    @Test
    public void example4() {
        String dirs = "UDU";
        assertThat(problem.solution(dirs)).isEqualTo(1);
    }

    @Test
    public void getHistoryData() {
        assertThat(GetHistoryData(1, 1, 'L')).isEqualTo("(1,1)L");
    }

    @Test
    public void getReverseHistoryData() {
        assertThat(GetReverseHistoryData(4, 5, 'D')).isEqualTo("(3,5)U");
        assertThat(GetReverseHistoryData(4, 5, 'U')).isEqualTo("(5,5)D");
        assertThat(GetReverseHistoryData(5, 5, 'L')).isEqualTo("(5,4)R");
        assertThat(GetReverseHistoryData(5, 4, 'R')).isEqualTo("(5,5)L");
    }
}