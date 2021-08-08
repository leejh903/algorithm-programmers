package l32;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        String s = "(()";
        assertEquals(2, problem.longestValidParentheses(s));
    }

    @Test
    public void test2() {
        String s = ")()())";
        assertEquals(4, problem.longestValidParentheses(s));
    }

    @Test
    public void test3() {
        String s = "";
        assertEquals(0, problem.longestValidParentheses(s));
    }

    @Test
    public void test4() {
        String s = "()(()";
        assertEquals(2, problem.longestValidParentheses(s));
    }
}