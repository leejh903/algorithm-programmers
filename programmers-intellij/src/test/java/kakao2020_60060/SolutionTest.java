package kakao2020_60060;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void queryTest() {
        Solution.Trie root = new Solution.Trie();
        root.insert("frodo");
        root.insert("front");
        root.insert("frost");
        root.insert("frozen");
        root.insert("frame");
        root.insert("kakao");

        assertEquals(root.getNodeCount("pro?"), 0);
    }

    @Test
    public void reverseTrie() {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        Solution.Trie reversedTrie = new Solution.Trie();
        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            reversedTrie.insert(reversed);
        }

        String target = "????o";
        String reversedTarget = new StringBuilder(target).reverse().toString();
        assertEquals(reversedTrie.getNodeCount(reversedTarget), 2);
    }

    @Test
    public void queryTest2() {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?", "?????"};
        int[] answers = {3, 2, 4, 1, 0, 5};
        assertTrue(Arrays.equals(solution.solution(words, queries), answers));
    }

    @Test
    public void queryTest4() {
        String[] words = {"ab", "cd", "de", "bw"};
        String[] queries = {"??", "???", "?", "???????"};
        int[] answers = {4, 0, 0, 0};
        assertTrue(Arrays.equals(solution.solution(words, queries), answers));
    }

    @Test
    public void queryTest5() {
        String[] words = {"ab", "ab", "ab", "ab", "ab"};
        String[] queries = {"??", "???", "?", "a?", "?b"};
        int[] answers = {1, 0, 0, 1, 1};
        System.out.println(Arrays.toString(solution.solution(words, queries)));
        assertTrue(Arrays.equals(solution.solution(words, queries), answers));
    }

    @Test
    public void queryTest6() {
        String[] words = {"a", "b", "c", "d", "a", "b", "ae"};
        String[] queries = {"?", "??", "a??", "a?"};
        int[] answers = {4, 1, 0, 1};
        assertTrue(Arrays.equals(solution.solution(words, queries), answers));
    }

    @Test
    public void queryTest7() {
        String[] words = {"brandon", "colin", "conan", "jesse", "jess", "brad", "cry", "cay", "a"};
        String[] queries = {"br?", "????n", "??????n", "??y", "?", "???????????????a"};
        int[] answers = {0, 2, 1, 2, 1, 0};
        assertTrue(Arrays.equals(solution.solution(words, queries), answers));
    }

    @Test
    public void queryTest8() {
        String[] words = {"ab", "abc", "abd", "abe"};
        String[] queries = {"a??", "ab?", "abc?", "?abc", "?bc", "?ab", "???"};
        int[] answers = {3, 3, 0, 0, 1, 0, 3};
        assertTrue(Arrays.equals(solution.solution(words, queries), answers));
    }

    @Test
    public void equals() {
        assertTrue(Objects.equals(Character.valueOf('a'), 'a'));
    }

    @Test
    public void name() {
        System.out.println(Integer.MAX_VALUE);
    }
}