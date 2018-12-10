package p42628;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
    private Queue<Integer> minHeap = new PriorityQueue<>();
    private Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private int deleted = 0;
    private int added = 0;

    public int[] solution(String[] operations) {
        for (String operation : operations) {
            parse(operation);
        }

        int[] answer = new int[2];
        if(maxHeap.isEmpty() || minHeap.isEmpty() || added == deleted) {
             answer[0] = 0; answer[1] = 0;
        } else {
            answer[0] = maxHeap.poll(); answer[1] = minHeap.poll();
        }

        return answer;
    }

    private void parse(String operation) {
        StringTokenizer stk = new StringTokenizer(operation);
        String sign = stk.nextToken();
        int num = Integer.parseInt(stk.nextToken());
        if(added == deleted) {
            minHeap.clear();
            maxHeap.clear();
        }
        if(sign.equals("I")) {
            added++;
            minHeap.offer(num);
            maxHeap.offer(num);
        }
        if(sign.equals("D") && !maxHeap.isEmpty() && !minHeap.isEmpty()) {
            deleted++;
            if(num == -1) minHeap.poll();
            if(num == 1) maxHeap.poll();
        }
    }
}
