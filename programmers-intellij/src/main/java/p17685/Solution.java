package p17685;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] words) {
        int answer = 0;

        Map<Character, Node> map = init(words);
        for (String word : words) {
            Map<Character, Node> innerMap = map;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                Node thisNode = innerMap.get(c);
                if (isFullWord(i, chars) || uniqueCheck(thisNode)) {
                    answer += i + 1;
                    break;
                }
                innerMap = thisNode.map;
            }
        }
        return answer;
    }

    private boolean uniqueCheck(Node thisNode) {
        return thisNode.passCount == 1;
    }

    private boolean isFullWord(int i, char[] chars) {
        return chars.length - 1 == i;
    }

    public Map<Character, Node> init(String[] words) {
        Map<Character, Node> map = new HashMap<>();
        for (String word : words) {
            Map<Character, Node> innerMap = map;
            for (char c : word.toCharArray()) {
                Node thisNode = innerMap.getOrDefault(c, new Node());
                thisNode.passCount++;
                innerMap.put(c, thisNode);
                innerMap = innerMap.get(c).map;
            }
        }
        return map;
    }

}

class Node {
    int passCount = 0;
    HashMap<Character, Node> map = new HashMap<>();
}