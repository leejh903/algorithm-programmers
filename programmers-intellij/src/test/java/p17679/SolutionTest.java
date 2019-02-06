package p17679;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int m = 4, n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        assertThat(problem.solution(m, n, board)).isEqualTo(14);
    }

    @Test
    public void test2() {
        int m = 6, n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        assertThat(problem.solution(m, n, board)).isEqualTo(15);
    }

    @Test
    public void canDelete() {
        int m = 6, n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        List<List<Point>> lists = problem.init(m, n, board);
        assertThat(problem.canDelete(lists, 0, 4)).isEqualTo(true);
    }

    @Test
    public void canDelete2() {
        int m = 6, n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        List<List<Point>> lists = problem.init(m, n, board);
        assertThat(problem.canDelete(lists, 4, 2)).isEqualTo(false);
    }

    @Test
    public void init() {
        int m = 6, n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        problem.init(m, n, board);
    }

    @Test
    public void contains_test() {
        List<String> list = new ArrayList<>();
        list.add("a");
        // 사이즈로 체크
        assertThat(list.size() - 1 >= 1).isFalse();
    }

    // 삭제할 수 있는 조건인지 확인
    // 삭제 가능한지
    // 삭제 할 때 또 다른 삭제가능한게 보이면 Queue에 넣고 대기
    // 만약 삭제 하는게 하나도 없으면 break
}