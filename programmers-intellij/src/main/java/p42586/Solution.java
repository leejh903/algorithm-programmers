package p42586;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> tempAnswer = new ArrayList<>();
        LinkedList<Job> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            Job job = new Job(progresses[i], speeds[i]);
            queue.add(job);
        }

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                queue.get(i).progress += queue.get(i).speed;
            }

            int count = 0;
            while(!queue.isEmpty() && queue.peek().progress >= 100) {
                queue.poll();
                count++;
            }

            if(count > 0) {
                tempAnswer.add(count);
            }
        }

        int[] answer = new int[tempAnswer.size()];
        for (int i = 0; i < tempAnswer.size(); i++) {
            answer[i] = tempAnswer.get(i);
        }

        return answer;
    }

    class Job {
        int progress;
        int speed;

        public Job(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }
}

