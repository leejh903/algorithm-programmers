package p42860;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static final char A = 'A';

    public int solution(String name) {
        int answer = Integer.MAX_VALUE;
        StringBuilder changingText = new StringBuilder(name);
        StringBuilder targetText = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            targetText.append(A);
        }
        String target = targetText.toString();

        Queue<Job> queue = new LinkedList<>();
        queue.offer(new Job(new StringBuilder(name), 1, 0, 0));

        while (!queue.isEmpty()) {
            Job job = queue.poll();

            while (!isSame(job.text, target)) {
                char data = job.text.charAt(job.curIndex);
                if (data != A) {
                    job.count += minChangeCount(data);
                    job.text.setCharAt(job.curIndex, A);
                }

                if (job.curIndex <= (job.text.length() - 1) / 2 - 1 && job.direction != -1) {
                    int temp = (job.curIndex == 0 ? job.text.length() - 1 : job.curIndex);
                    queue.add(new Job(new StringBuilder(job.text), -1, temp, job.count + 1));
                }

                if (!isSame(job.text, target)) {
                    job.count++;
                    if (job.curIndex == 0 && job.direction == -1) job.curIndex = job.text.length();
                    job.curIndex += job.direction;
                }
            }
            answer = Math.min(answer, job.count);
        }

        if (answer == Integer.MAX_VALUE) return 0;

        return answer;

    }

    private int minChangeCount(char data) {
        return Math.min(data - A, 'Z' - data + 1);
    }

    private boolean isSame(StringBuilder text, String target) {
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
