package kakao2020_60060;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void TrieKeyEquals() {
        Solution.TrieKey key1 = new Solution.TrieKey('a', 4);
        Solution.TrieKey key2 = new Solution.TrieKey('a', 4);
        Solution.TrieKey key3 = new Solution.TrieKey('a', 6);

        assertEquals(key1, key2);
        assertNotEquals(key2, key3);

        Map<Solution.TrieKey, Integer> map1 = new HashMap<>();
        map1.put(key1, 1);
        map1.put(key2, 3);
        assertEquals(map1.keySet().size(), 1);

        Map<Solution.TrieKey, Integer> map2 = new HashMap<>();
        map2.put(key2, 1);
        map2.put(key3, 3);
        assertEquals(map2.keySet().size(), 2);
    }

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
    public void queryTest3() {
        Solution.Trie root = new Solution.Trie();
        root.insert("frodo");
        root.insert("front");
        root.insert("frost");
        root.insert("frozen");
        root.insert("frame");
        root.insert("kakao");

        assertEquals(root.getNodeCountByLength("?????".length()), 5);
        assertEquals(root.getNodeCountByLength("??????".length()), 1);
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
        String[] words = {"a", "b", "c", "d", "a", "b", "ae"};
        String[] queries = {"?", "??"};
        int[] answers = {4, 1};
        assertTrue(Arrays.equals(solution.solution(words, queries), answers));
    }
}