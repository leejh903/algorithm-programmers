package l139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    Boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        return dfs(s, 0, new HashSet<String>(wordDict));
    }

    boolean dfs(String s, int index, Set<String> dict) {
        if (index >= s.length()) {
            return true;
        }
        if (dp[index] != null) {
            return dp[index];
        }

        StringBuilder sb = new StringBuilder();
        dp[index] = false;
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));

            // i + 1부터 새롭게 시작하는 케이스, 그냥 계속 덧붙여 나가는 케이스 모두 고려
            if (dict.contains(sb.toString())) {
                // i + 1부터 새롭게 시작하는 케이스
                if (dfs(s, i + 1, dict)) {
                    dp[index] = true;
                    break;
                }
            }
        }

        return dp[index];
    }
}
