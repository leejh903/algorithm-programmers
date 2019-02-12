package p17678;

import org.junit.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int n = 1, t = 1, m = 5;
        String[] timeTable = {"08:00", "08:01", "08:02", "08:03"};
        assertThat(problem.solution(n, t, m, timeTable)).isEqualTo("09:00");
    }

    @Test
    public void test_1() {
        int n = 1, t = 1, m = 5;
        String[] timeTable = {"08:00", "08:01", "08:02", "08:03", "08:03"};
        assertThat(problem.solution(n, t, m, timeTable)).isEqualTo("08:02");
    }

    @Test
    public void test_2() {
        int n = 3, t = 60, m = 2;
        String[] timeTable = {"08:00", "09:01", "10:00", "11:00"};
        assertThat(problem.solution(n, t, m, timeTable)).isEqualTo("11:00");
    }

    @Test
    public void test_3() {
        int n = 3, t = 60, m = 1;
        String[] timeTable = {"08:00", "08:03", "10:59"};
        assertThat(problem.solution(n, t, m, timeTable)).isEqualTo("10:58");
    }

    @Test
    public void test2() {
        int n = 2, t = 10, m = 2;
        String[] timeTable = {"09:10", "09:09", "08:00"};
        assertThat(problem.solution(n, t, m, timeTable)).isEqualTo("09:09");
    }

    @Test
    public void test3() {
        int n = 2, t = 1, m = 2;
        String[] timeTable = {"09:00", "09:00", "09:00", "09:00"};
        assertThat(problem.solution(n, t, m, timeTable)).isEqualTo("08:59");
    }

    @Test
    public void test3_1() {
        int n = 2, t = 1, m = 2;
        String[] timeTable = {"09:00", "09:00", "09:00", "09:01"};
        assertThat(problem.solution(n, t, m, timeTable)).isEqualTo("09:00");
    }

    @Test
    public void test3_2() {
        int n = 40, t = 1, m = 4;
        String[] timeTable = {"09:00", "09:00", "09:00", "09:01", "09:03", "09:03", "09:03", "09:05"};
        assertThat(problem.solution(n, t, m, timeTable)).isEqualTo("09:39");
    }

    @Test
    public void test4() {
        int n = 1, t = 1, m = 5;
        String[] timeTable = {"00:01", "00:01", "00:01", "00:01", "00:01"};
        assertThat(problem.solution(n, t, m, timeTable)).isEqualTo("00:00");
    }

    @Test
    public void test4_4() {
        int n = 1, t = 1, m = 6;
        String[] timeTable = {"00:01", "00:05", "00:03", "00:02", "00:01"};
        assertThat(problem.solution(n, t, m, timeTable)).isEqualTo("09:00");
    }

    @Test
    public void test4_5() {
        int n = 6, t = 1, m = 1;
        String[] timeTable = {"00:01", "00:05", "00:03", "00:02", "00:01", "09:01"};
        assertThat(problem.solution(n, t, m, timeTable)).isEqualTo("09:00");
    }

    @Test
    public void test4_6() {
        int n = 6, t = 1, m = 1;
        String[] timeTable = {"00:01", "00:05", "00:03", "00:02", "00:01", "09:01"};
        assertThat(problem.solution(n, t, m, timeTable)).isEqualTo("09:00");
    }

    @Test
    public void test4_1() {
        int n = 1, t = 1, m = 5;
        String[] timeTable = {"00:00", "00:00", "00:00", "00:00"};
        assertThat(problem.solution(n, t, m, timeTable)).isEqualTo("09:00");
    }

    @Test
    public void test4_2() {
        int n = 1, t = 1, m = 5;
        String[] timeTable = {"00:01", "00:01", "00:01", "00:01"};
        assertThat(problem.solution(n, t, m, timeTable)).isEqualTo("09:00");
    }

    @Test
    public void test4_3() {
        int n = 2, t = 1, m = 5;
        String[] timeTable = {"00:01", "00:01", "00:01", "00:01", "00:01"};
        assertThat(problem.solution(n, t, m, timeTable)).isEqualTo("09:01");
    }

    @Test
    public void test5() {
        int n = 1, t = 1, m = 1;
        String[] timeTable = {"23:59"};
        assertThat(problem.solution(n, t, m, timeTable)).isEqualTo("09:00");
    }

    @Test
    public void test5_1() {
        int n = 1, t = 1, m = 1;
        String[] timeTable = {"23:59", "23:59", "23:59", "23:59", "23:59"};
        assertThat(problem.solution(n, t, m, timeTable)).isEqualTo("09:00");
    }

    @Test
    public void test6() {
        int n = 10, t = 60, m = 45;
        String[] timeTable = {"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
                            "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
        assertThat(problem.solution(n, t, m, timeTable)).isEqualTo("18:00");
    }

    @Test
    public void test6_1() {
        int n = 1, t = 60, m = 45;
        String[] timeTable = {"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
                "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
        assertThat(problem.solution(n, t, m, timeTable)).isEqualTo("09:00");
    }

    @Test
    public void test7() {
        int n = 1, t = 60, m = 1;
        String[] timeTable = {};
        assertThat(problem.solution(n, t, m, timeTable)).isEqualTo("09:00");
    }

    @Test
    public void localTime() {
        LocalTime localTime = LocalTime.of(7, 59);
        LocalTime localTime2 = LocalTime.of(7, 59);
        System.out.println(localTime2.compareTo(localTime));
    }
}