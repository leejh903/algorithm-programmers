package p17683;

import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void makeSong() {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        assertThat(problem.solution(m, musicinfos)).isEqualTo("HELLO");
    }

    @Test
    public void difference() {
        String time1 = "11:59";
        String time2 = "12:14";
        assertThat(problem.timeDifference(time1, time2)).isEqualTo(15);
    }

    @Test
    public void isEmpty() {
        List<Integer> list = new ArrayList<>();
        assertThat(list.isEmpty()).isEqualTo(true);
    }

    @Test
    public void matchCheck() {
        assertThat(problem.matchCheck(problem.parse("ABCDEFG"), problem.parse("CDEFGAB"))).isEqualTo(true);
    }

    @Test
    public void matchCheck2() {
        assertThat(problem.matchCheck(problem.parse("CC#BCC#BCC#BCC#B"), problem.parse("CC#BCC#BCC#B"))).isEqualTo(true);
    }

    @Test
    public void test() {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        assertThat(problem.solution(m, musicinfos)).isEqualTo("HELLO");
    }

    @Test
    public void test2() {
        String m = "CC#BCC#BCC#BCC#B";
        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        assertThat(problem.solution(m, musicinfos)).isEqualTo("FOO");
    }

    @Test
    public void test3() {
        String m = "ABC";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        assertThat(problem.solution(m, musicinfos)).isEqualTo("WORLD");
    }

    @Test
    public void test4() {
        String m = "F";
        String[] musicinfos = {"12:00,12:01,HELLO,F", "13:00,13:05,WORLD,ABCDEF"};
        assertThat(problem.solution(m, musicinfos)).isEqualTo("WORLD");
    }

    @Test
    public void 샵_분류() {
        String s = "C#DEFGAB#";
        List<String> list = problem.parse(s);
        for (String s1 : list) {
            System.out.println(s1);
        }
    }

    @Test
    public void parse() {
        List<String> list = problem.parse("CC#BCC#BCC#BCC#B");
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void localTime() {
        System.out.println(problem.timeDifference("12:00", "13:20"));
    }
}