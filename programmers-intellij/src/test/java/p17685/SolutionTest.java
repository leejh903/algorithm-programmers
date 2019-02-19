package p17685;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void init() {
        String[] words = new String[]{"go", "gone", "guild"};
        List<Node> list = problem.init(words);
        Node temp = new Node('g', new ArrayList<>());
        list = list.get(list.indexOf(temp)).list;
        Node temp2 = new Node('o', new ArrayList<>());
        System.out.println(list.get(list.indexOf(temp2)).list);
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