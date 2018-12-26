package p42860;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static final char A = 'A';
    public String target;
    public int answer;

    public int solution(String name) {
        answer = Integer.MAX_VALUE;
        StringBuilder changingText = new StringBuilder(name);
        StringBuilder target = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            target.append(A);
        }
        this.target = target.toString();

        Queue<Job> queue = new LinkedList<>();
        queue.offer(new Job(new StringBuilder(name), 1, 0, 0));
        while(!queue.isEmpty()) {
            Job job = queue.poll();
            while(!isSame(job.text)) {
                char data = job.text.charAt(job.curIndex);
                if(data != A) {
                    job.count += Math.min(data - A, 'Z' - data + 1);
                    job.text.setCharAt(job.curIndex, A);
                }

                if(job.curIndex <= (job.text.length() - 1) / 2 - 1 && job.direction != -1) {
                    int temp = job.curIndex;
                    if(temp == 0) temp = job.text.length() - 1;
                    queue.add(new Job(new StringBuilder(job.text), -1, temp, job.count + 1));
                }

                if(!isSame(job.text)) {
                    job.count++;
                    if(job.curIndex == 0 && job.direction == -1) job.curIndex = job.text.length();
                    job.curIndex += job.direction;
                }
            }
            answer = Math.min(answer, job.count);
        }

        if (answer == Integer.MAX_VALUE) return 0;

        return answer;

    }

    private boolean isSame(StringBuilder text) {
        return text.toString().equals(target);
    }
}

class Job {
    StringBuilder text;
    int direction;
    int curIndex;
    int count;

    public Job(StringBuilder text, int direction, int curIndex, int count) {
        this.text = text;
        this.direction = direction;
        this.curIndex = curIndex;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Job{" +
                "text=" + text +
                ", direction=" + direction +
                ", curIndex=" + curIndex +
                ", count=" + count +
                '}';
    }
}
