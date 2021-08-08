package l32;

import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        int answer = 0;
        int candidate = 0;
        for (char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
                continue;
            }

            if(!stack.isEmpty()) {
                stack.pop();
                candidate += 2;

                if(stack.isEmpty()) {
                    answer += candidate;
                    candidate = 0;
                }
            }
        }
        return answer;
    }
}
