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
            if(cache.containsKey(query)) {
                answer[i] = cache.get(query);
                continue;
            }

            int temp;
            if (query.startsWith("?")) {
                String reversed = new StringBuilder(query).reverse().toString();

                if(reversed.startsWith("?")) {
                    temp = normalTrie.getNodeCountByLength(reversed.length()); // all of char is ?
                }
                else temp = reversedTrie.getNodeCount(reversed);
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
                TrieKey tempKey = new TrieKey(keyword.charAt(i), keyword.length() - i - 1);
                current = current.getChildren().computeIfAbsent(tempKey, trieKey -> new TrieNode());
                current.passed();
            }
        }

        public int getNodeCount(String query) {
            TrieNode current = root;

            int count = 0;
            for (int i = 0; i < query.length(); i++) {
                char ch = query.charAt(i);
                TrieKey tempKey = new TrieKey(ch, query.length() - i - 1);
                TrieNode node = current.getChildren().get(tempKey);
                if (node == null) break;  // when ch has '?' or char which has not been

                count = node.getPasses();
                current = node;
            }
            return count;
        }

        public int getNodeCountByLength(int length) {
            Set<TrieKey> keySet = root.getChildren().keySet();

            int count = 0;
            for (TrieKey trieKey : keySet) {
                if(trieKey.lefts == length - 1) count += root.getChildren().get(trieKey).getPasses();
            }
            return count;
        }

    }

    public static class TrieNode {
        private final Map<TrieKey, TrieNode> children = new HashMap<>();
        private int passes = 0;

        public Map<TrieKey, TrieNode> getChildren() {
            return children;
        }

        public void passed() {
            passes++;
        }

        public int getPasses() {
            return passes;
        }
    }

    public static class TrieKey {
        private Character character;
        private int lefts;

        public TrieKey(Character character, int lefts) {
            this.character = character;
            this.lefts = lefts;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TrieKey trieKey = (TrieKey) o;
            return lefts == trieKey.lefts &&
                    Objects.equals(character, trieKey.character);
        }

        @Override
        public int hashCode() {
            return Objects.hash(character, lefts);
        }
    }
}

