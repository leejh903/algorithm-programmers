package p42588;

import java.util.Stack;

class Solution {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        Stack<Integer> tops = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            boolean pass = false;

            for (int j = 0; j < i; j++) {
                tops.add(heights[j]);  // 스택에 넣고
            }

            while(!tops.empty()) {
                if(tops.pop() > heights[i]) {
                    answer[i] = tops.size() + 1;  // 하나 pop()했으니 (남은 개수 + 1) 번째가 해당
                    pass = true;
                    break;
                }
            }

            if(!pass) {
                answer[i] = 0;
            }

            tops.clear();
        }
        return answer;
    }

}


