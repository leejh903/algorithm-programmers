package p12981;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        int n = 3;
        String[] words = new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        assertThat(problem.solution(n, words)).isEqualTo(new int[]{3, 3});
    }

    @Test
    public void test2() {
        int n = 5;
        String[] words = new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        assertThat(problem.solution(n, words)).isEqualTo(new int[]{0, 0});
    }

    @Test
    public void test3() {
        int n = 2;
        String[] words = new String[]{"hello", "one", "even", "never", "now", "world", "draw"};
        assertThat(problem.solution(n, words)).isEqualTo(new int[]{1, 3});
    }
}