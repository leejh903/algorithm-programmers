package p17685;

import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void init() {
        String[] words = new String[]{"go", "gone", "guild"};
        Map<Character, Node> map = problem.init(words);
        System.out.println(map.get('g').map.get('o').map.get('n').map);
    }

    @Test
    public void init2() {
        String[] words = new String[]{"word", "war", "warrior", "world"};
        Map<Character, Node> map = problem.init(words);
        System.out.println(map.get('w').map.get('o').map);
    }

    @Test
    public void test() {
        String[] words = new String[]{"go", "gone", "guild"};
        assertThat(problem.solution(words)).isEqualTo(7);
    }

    @Test
    public void test2() {
        String[] words = new String[]{"abc", "def", "ghi", "jklm"};
        assertThat(problem.solution(words)).isEqualTo(4);
    }

    @Test
    public void test3() {
        String[] words = new String[]{"word", "war", "warrior", "world"};
        assertThat(problem.solution(words)).isEqualTo(15);
    }

}