package l3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        assertThat(problem.lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
    }

    @Test
    public void test2() {
        assertThat(problem.lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
    }

    @Test
    public void test3() {
        assertThat(problem.lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
    }

    @Test
    public void test4() {
        assertThat(problem.lengthOfLongestSubstring(" ")).isEqualTo(1);
    }

    @Test
    public void test5() {
        assertThat(problem.lengthOfLongestSubstring("dvdf")).isEqualTo(3);
    }
}