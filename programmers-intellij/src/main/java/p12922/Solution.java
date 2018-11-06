package p12922;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String pattern = "수박";
        for (int i = 0; i < n; i++) {
            sb.append(pattern.charAt(i % 2));
        }
        return sb.toString();
    }
}