package l28;

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.length() - i < needle.length()) break;

            for (int j = 0; j < needle.length(); j++) {
                char c1 = haystack.charAt(i + j);
                char c2 = needle.charAt(j);
                if (c1 != c2) break;
                if (j == needle.length() - 1) return i;
            }
        }
        return -1;
    }
}
