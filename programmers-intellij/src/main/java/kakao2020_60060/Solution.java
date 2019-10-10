package kakao2020_60060;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = {};


        return answer;
    }

    public static class Tri {
        private TrieNode root;

        public Tri() {
            root = new TrieNode();
        }

        public void insert(String keyword) {
            TrieNode current = root;

            for (int i = 0; i < keyword.length(); i++) {
                TrieNode temp = current;
                current = current.getChildren().computeIfAbsent(keyword.charAt(i), c -> new TrieNode());
                System.out.println(temp.getChildren().get('d').getChildren());
            }
            current.setEndOfWord(true);
        }

        public boolean containsNode(String query) {
            TrieNode current = root;

            for (int i = 0; i < query.length(); i++) {
                char ch = query.charAt(i);
                TrieNode node = current.getChildren().get(ch);
                if (node == null) {
                    return false;
                }
                current = node;
            }
            return current.isEndOfWord();
        }

        public boolean isEmpty() {
            return root == null;
        }

    }

    public static class TrieNode {

        private final Map<Character, TrieNode> children = new HashMap<>();
        private boolean endOfWord;
        private int lefts;

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public boolean isEndOfWord() {
            return endOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            this.endOfWord = endOfWord;
        }

        public int getLefts() {
            return lefts;
        }

        public void setLefts(int lefts) {
            this.lefts = lefts;
        }
    }

    public static void main(String[] args) {
        Tri start = new Tri();
        start.insert("dictionary");
    }

}

