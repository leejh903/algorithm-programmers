package l139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
        }

        return dfs(s, 0, dict, new StringBuilder());
    }

    boolean dfs(String s, int index, Set<String> dict, StringBuilder sb) {
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));

            if (dict.contains(sb.toString())) {
                if (dfs(s, i + 1, dict, sb)) {
                    return true;
                }
                sb = new StringBuilder();
            }
        }

        return sb.length() == 0;
    }
}
