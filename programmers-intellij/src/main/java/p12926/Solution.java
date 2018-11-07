package p12926;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if(target >= 'A' && target <= 'Z') sb.append((char)((target - 65 + n) % 26 + 65));
            if(target >= 97 && target <= 122) sb.append((char)((target - 97 + n) % 26 + 97));
            if(target == 32) sb.append(target);
        }

        return sb.toString();
    }
}
