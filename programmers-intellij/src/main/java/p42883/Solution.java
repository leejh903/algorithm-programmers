package p42883;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        while (k > 0) {
            boolean deleted = false;
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) < sb.charAt(i + 1)) {
                    sb.deleteCharAt(i);
                    deleted = true;
                    break;
                }
            }

            if (!deleted) sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        return sb.toString();
    }
}
