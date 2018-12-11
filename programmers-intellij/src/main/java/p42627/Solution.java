package p42627;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue();
        Map<Integer, List<Integer>> map = new HashMap<>();

        int maxStartTime = 0;
        for (int i = 0; i < jobs.length; i++) {
            int startTime = jobs[i][0];
            maxStartTime = Math.max(startTime, maxStartTime);
            int operationTime = jobs[i][1];

            if(!map.containsKey(startTime)) {
                List<Integer> part = new ArrayList<>();
                part.add(operationTime);
                map.put(startTime, part);
            } else {
                map.get(startTime).add(operationTime);
            }
        }

        int finishedWork = 0;
        int elapsedTime = 0;
        while(finishedWork != jobs.length){
            if(map.containsKey(elapsedTime)) {

            }
            elapsedTime++;
        }

        return answer;
    }
}
