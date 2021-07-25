package l49;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test1() {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(problem.groupAnagrams(strs));
    }

    @Test
    public void test2() {
        String[] strs = new String[]{""};
        System.out.println(problem.groupAnagrams(strs));
    }

    @Test
    public void test3() {
        String[] strs = new String[]{"a"};
        System.out.println(problem.groupAnagrams(strs));
    }
}