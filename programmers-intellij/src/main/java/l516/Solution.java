package l516;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String, int[]> dp = new HashMap<>();

    public int longestPalindromeSubseq(String s) {
        if (s.equals(""))
            return 0;

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i, 0);
            int len2 = expandAroundCenter(s, i, i + 1, 0);
            int len = Math.max(len1, len2);
            result = Math.max(result, len);
        }
        return result;
    }

    public int expandAroundCenter(String s, int left, int right, int len) {
        int L = left, R = right, LEN = len;
        String dpKey = String.format("%d-%d", left, right);
        if (dp.containsKey(dpKey)) {
            int[] val = dp.get(dpKey);
            if (val[0] > len) {
                return val[1];
            }
        }

        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            if (L == R) {
                LEN += 1;
            } else {
                LEN += 2;
            }
            L--;
            R++;
        }

        int out = LEN;
        if (L > 0 && R < s.length()) {
            out = Math.max(out, expandAroundCenter(s, L - 1, R, LEN));
        }
        if (L >= 0 && R < s.length() - 1) {
            out = Math.max(out, expandAroundCenter(s, L, R + 1, LEN));
        }

        dp.put(dpKey, new int[] { len, out });
        return out;
    }
}
