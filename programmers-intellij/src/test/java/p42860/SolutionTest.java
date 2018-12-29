package p42860;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static p42860.Solution.A;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void 앞이_빠를까_뒤로가_빠를까() {
        char data = 'J';

        System.out.println(minChangeCount(data));
    }

    @Test
    public void changedText() {
        String name = "JEROEN";
        StringBuilder sb = new StringBuilder(name);
        sb.setCharAt(0, 'A');
        System.out.println(sb.charAt(2));  // 값을 가져올때는 charAt(index)
        System.out.println(sb.toString().equals("AEROEN"));  // toStirng() 해야 true
    }

    public int minChangeCount(char data) {
        return Math.min(data - A, 'Z' - data + 1);
    }

    @Test
    public void target_만들기() {
        String name = "AAAAA";
        StringBuilder sb = new StringBuilder(name);
        StringBuilder target = new StringBuilder();

        for (int i = 0; i < name.length(); i++) {
            target.append('A');
        }

        assertThat(sb.toString().equals(target.toString())).isEqualTo(true);
    }

    @Test
    public void test() {
        String name = "AAAA";
        assertThat(problem.solution(name)).isEqualTo(0);
    }

    @Test
    public void test2() {
        String name = "JEROEN";
        assertThat(problem.solution(name)).isEqualTo(56);
    }

    @Test
    public void test3() {
        String name = "JAN";
        assertThat(problem.solution(name)).isEqualTo(23);
    }

    @Test
    public void test4() {
        String name = "BBAAAAAAAAAAAAAAAAAAAAAAAAAAZ";
        assertThat(problem.solution(name)).isEqualTo(6);
    }

    @Test
    public void test5() {
        String name = "JAAZA";
        assertThat(problem.solution(name)).isEqualTo(12);
    }

    @Test
    public void test6() {
        String name = "ABBAAAAAAAAAAAAAAAAAAB";
        System.out.println(problem.solution(name));
    }

    @Test
    public void test7() {
        String name = "ABABABABABABAAAA";
        System.out.println(problem.solution(name));
    }
}