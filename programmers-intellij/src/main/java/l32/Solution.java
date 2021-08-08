package l32;

import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
                continue;
            }

            if(!stack.isEmpty()) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                answer = Math.max(answer, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return answer;
    }

}
