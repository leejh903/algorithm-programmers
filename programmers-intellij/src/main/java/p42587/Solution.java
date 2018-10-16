package p42587;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Job> queue = new LinkedList();
        List<Integer> answerArray = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Job(priorities[i], i));
        }

        while(!queue.isEmpty()) {
            boolean pass = true;
            Job firstJob = queue.poll();
            for (Job job : queue) {
                if(job.priorities > firstJob.priorities) {
                    queue.offer(firstJob);
                    pass = false;
                    break;
                }
            }

            if(pass) {
                answerArray.add(firstJob.position);
            }

        }

        return answerArray.indexOf(location) + 1;

    }
}

class Job {
    int priorities;
    int position;

    public Job(int priorities, int position) {
        this.priorities = priorities;
        this.position = position;
    }
}