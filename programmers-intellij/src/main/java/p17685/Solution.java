package p17685;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String[] words) {
        int answer = 0;

        List<Node> list = init(words);
        for (String word : words) {
            List<Node> innerList = list;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                Node newNode = new Node(chars[i], new ArrayList<>());
                Node thisNode = innerList.get(innerList.indexOf(newNode));
                innerList = thisNode.list;
                if (isFullWord(i, chars) || uniqueCheck(thisNode)) {
                    answer += i + 1;
                    break;
                }
            }
        }
        return answer;
    }

    public List<Node> init(String[] words) {
        List<Node> list = new ArrayList<>();
        for (String word : words) {
            List<Node> innerList = list;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (!innerList.contains(c)) {
                    Node newNode = new Node(c, new ArrayList<>());
                    innerList.add(newNode);
                    innerList = innerList.get(innerList.indexOf(newNode)).list;
                    if (i == chars.length - 1) newNode.isEnd = true;
                    continue;
                }
                Node temp = list.get(c);
                innerList = innerList.get(innerList.indexOf(temp)).list;
            }
        }
        return list;
    }

    public boolean uniqueCheck(Node node) {
        return !node.isEnd && node.list.size() == 1;
    }

    public boolean isFullWord(int index, char[] chars) {
        return chars.length - 1 == index;
    }
}

class Node {
    char text;
    List<Node> list;
    boolean isEnd = false;

    public Node(char text, List<Node> list) {
        this.text = text;
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return text == node.text;
    }

    @Override
    public String toString() {
        return "Node{" +
                "text=" + text +
                ", list=" + list +
                ", isEnd=" + isEnd +
                '}';
    }
}