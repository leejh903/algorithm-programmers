package l3;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean[] characters = new boolean[256];
            int temp = 0;
            for (int j = i; j < s.length(); j++) {
                if(characters[s.charAt(j)]) {
                    break;
                }
                characters[s.charAt(j)] = true;
                temp++;
            }
            result = Math.max(result, temp);
        }

        return result;
    }
}