package l32;

import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() < 2) return 0;

        int answer = 0;
        for (int start = 0; start < s.length() - 1; start++) {
            for (int end = start + 1; end < s.length(); end++) {
                if(isValid(s.substring(start, end + 1))) {
                    answer = Math.max(answer, end - start + 1);
                }
            }
        }
        return answer;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
                continue;
            }

            if(stack.isEmpty()) return false;
            stack.pop();
        }
        return stack.isEmpty();
    }
}
