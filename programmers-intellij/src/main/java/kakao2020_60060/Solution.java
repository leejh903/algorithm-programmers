package kakao2020_60060;

import java.util.*;

class Solution {
    private Map<String, Integer> cache = new HashMap<>();

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        Trie normalTrie = new Trie();
        Trie reversedTrie = new Trie();

        // insert to Trie
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        for (String word : uniqueWords) {
            normalTrie.insert(word);
            reversedTrie.insert(new StringBuilder(word).reverse().toString());
        }

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (cache.containsKey(query)) {
                answer[i] = cache.get(query);
                continue;
            }

            int temp;
            if (query.startsWith("?")) {
                String reversed = new StringBuilder(query).reverse().toString();
                temp = reversedTrie.getNodeCount(reversed);
            } else {
                temp = normalTrie.getNodeCount(query);
            }

            cache.put(query, temp);
            answer[i] = temp;
        }

        return answer;
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String keyword) {
            TrieNode current = root;

            for (int i = 0; i < keyword.length(); i++) {
                current = current.getChildren().computeIfAbsent(keyword.charAt(i), trieKey -> new TrieNode());
            }
            current.setEndOfWord(true);
        }

        public int getNodeCount(String query) {
            return search(root, query, 0);
        }

        private int search(TrieNode node, String query, int depth) {
            if (depth == query.length()) {
                if (node.isEndOfWord()) return 1;
                return 0;
            }

            int count = 0;
            for (char character : node.getChildren().keySet()) {
                if (query.charAt(depth) == character || query.charAt(depth) == '?') {
                    count += search(node.getChildren().get(character), query, depth + 1);
                }
            }
            return count;
        }

    }

    public static class TrieNode {
        private final Map<Character, TrieNode> children = new HashMap<>();
        private boolean isEndOfWord;

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            isEndOfWord = endOfWord;
        }
    }
}

