package p42627;

import java.util.*;

class Solution {
    int minTime = 0;

    public int solution(int[][] jobs) {
        int answer = 0;

        Queue<Job> queue = new PriorityQueue<>();
        Map<Integer, Queue<Job>> map = new HashMap<>();
        init(jobs, map);

        queue.addAll(map.get(minTime));
        map.remove(minTime);
        Job tempJob = queue.peek();
        int elapsedTime = tempJob.startTime;
        int remainingTime = 0;

        while(!map.isEmpty() || !queue.isEmpty()) {
            if(map.containsKey(elapsedTime)) {
                queue.addAll(map.get(elapsedTime));
                map.remove(elapsedTime);
            }

            if(!queue.isEmpty() && remainingTime == 0) {
                Job job = queue.poll();
                remainingTime = job.operationTime;
                answer += (elapsedTime + job.operationTime - job.startTime);
            }
            elapsedTime++;
            if(remainingTime != 0) remainingTime--;
        }

        return answer / jobs.length;
    }

    private void init(int[][] jobs, Map<Integer, Queue<Job>> map) {
        minTime = jobs[0][0];
        for (int i = 0; i < jobs.length; i++) {
            minTime = Math.min(minTime, jobs[i][0]);
            int startTime = jobs[i][0];
            int operationTime = jobs[i][1];
            Job job = new Job(startTime, operationTime);

            if (!map.containsKey(startTime)) {
                Queue<Job> part = new PriorityQueue<>();
                part.offer(job);
                map.put(startTime, part);
            } else {
                map.get(startTime).add(job);
            }
        }
    }


    class Job implements Comparable<Job> {
        int startTime;
        int operationTime;

        public Job(int startTime, int operationTime) {
            this.startTime = startTime;
            this.operationTime = operationTime;
        }

        @Override
        public int compareTo(Job o) {
            return this.operationTime - o.operationTime;
        }
    }
}
