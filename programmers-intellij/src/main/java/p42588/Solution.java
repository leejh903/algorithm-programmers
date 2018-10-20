package p42588;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] heights) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = heights.length - 1; i >= 0; i--) {
            queue.add(heights[i]);
        }

        System.out.println(queue.peek());

        return answer;

    }
}
