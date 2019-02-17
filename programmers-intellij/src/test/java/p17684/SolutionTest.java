package p17684;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void init() {
        Map<String, Integer> map = problem.init();
        assertThat(map.get("A")).isEqualTo(1);
    }

    @Test
    public void init2() {
        Map<String, Integer> map = problem.init();
        assertThat(map.get("K")).isEqualTo(11);
    }

    @Test
    public void test() {
        String msg = "KAKAO";
        assertThat(problem.solution(msg)).isEqualTo(new int[]{11, 1, 27, 15});
    }

    @Test
    public void test2() {
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        assertThat(problem.solution(msg)).isEqualTo(new int[]{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34});
    }

    @Test
    public void test3() {
        String msg = "ABABABABABABABAB";
        assertThat(problem.solution(msg)).isEqualTo(new int[]{1, 2, 27, 29, 28, 31, 30});
    }
}