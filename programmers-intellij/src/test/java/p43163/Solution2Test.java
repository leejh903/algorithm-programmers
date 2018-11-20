package p43163;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution2Test {
    Solution2 problem = new Solution2();

    @Test
    public void test1() {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        assertThat(problem.solution(begin, target, words)).isEqualTo(4);
    }

    @Test
    public void test2() {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};

        assertThat(problem.solution(begin, target, words)).isEqualTo(0);
    }

    @Test
    public void test3() {
        String begin = "aaaa";
        String target = "bbbb";
        String[] words = {"aaab", "aabb", "abbb", "bbbb"};

        assertThat(problem.solution(begin, target, words)).isEqualTo(4);
    }

    @Test
    public void test4() {
        String begin = "aaaa";
        String target = "bbbb";
        StringBuilder temp = new StringBuilder(begin);
        temp.setCharAt(0, 'c');
        System.out.println(temp);
        System.out.println(temp.equals("caaa"));
    }
}