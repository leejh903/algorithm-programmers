package p42585;

import java.util.Stack;

class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        Stack<String> arrageStack = new Stack<>();
        String[] arragements = arrangement.split("");
        for(int i = 0; i < arragements.length; i++) {
            if(arragements[i].equals("(")) {
                arrageStack.push(arragements[i]);
                answer++;
            }
            if(arragements[i].equals(")")) {
                if(arragements[i-1].equals("(")) {
                    answer--;
                    arrageStack.pop();
                    answer = answer + arrageStack.size();
                } else {
                    arrageStack.pop();
                }
            }

        }
        return answer;
    }
}
