package p42627;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        assertThat(problem.solution(jobs)).isEqualTo(9);
    }

    @Test
    public void Job_정렬_테스트() {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        Queue<Job> queue = new PriorityQueue<>();

        for (int i = 0; i < jobs.length; i++) {
            Job job = new Job(jobs[i][0], jobs[i][1]);
            queue.add(job);
        }

        printQueue(queue);
    }

    @Test
    public void init() {
        int[][] jobs = {{0, 3}, {1, 9}, {1, 6}, {2, 6}, {2, 7}};

        Map<Integer, Queue<Job>> map = new HashMap<>();
        Queue<Job> queue = new PriorityQueue<>();
        init(jobs, map);
        queue.addAll(map.get(1));
        printQueue(queue);
        System.out.println("--------");
        queue.addAll(map.get(1));
        queue.addAll(map.get(2));
        printQueue(queue);


    }

    private void printQueue(Queue<Job> queue) {
        while(!queue.isEmpty()) {
            Job job = queue.poll();
            System.out.println(job.startTime + " : " + job.operationTime);
        }
    }

    private void print(Map<Integer, Queue<Job>> map) {
        for (Integer integer : map.keySet()) {
            System.out.print(integer + " : ");
            for (Job job : map.get(integer)) {
                System.out.print(job.operationTime + " ");
            }
            System.out.println();
        }
    }

    private void init(int[][] jobs, Map<Integer, Queue<Job>> map) {
        for (int i = 0; i < jobs.length; i++) {
            int startTime = jobs[i][0];
            int operationTime = jobs[i][1];
            Job job = new Job(startTime, operationTime);

            if(!map.containsKey(startTime)) {
                Queue<Job> part = new PriorityQueue<>();
                part.offer(job);
                map.put(startTime, part);
            } else {
                map.get(startTime).add(job);
            }
        }
    }

    class Job implements Comparable<Job>{
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