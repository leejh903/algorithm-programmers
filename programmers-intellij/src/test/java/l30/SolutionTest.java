package l30;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","word"};
        List<Integer> answer = problem.findSubstring(s, words);
        System.out.println(answer);
    }

    @Test
    public void test2() {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};
        List<Integer> answer = problem.findSubstring(s, words);
        System.out.println(answer);
    }

    @Test
    public void test3() {
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","good"};
        List<Integer> answer = problem.findSubstring(s, words);
        System.out.println(answer);
    }

    @Test
    public void test4() {
        String s = "foobarfoobar";
        String[] words = new String[]{"foo","bar"};
        List<Integer> answer = problem.findSubstring(s, words);
        System.out.println(answer);
    }

    @Test
    public void test5() {
        String s = "aaaaaaaaaaaaaa";
        String[] words = new String[]{"aa","aa"};
        List<Integer> answer = problem.findSubstring(s, words);
        System.out.println(answer);
    }
}