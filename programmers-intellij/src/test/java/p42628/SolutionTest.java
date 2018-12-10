package p42628;

import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    private Queue<Integer> minHeap = new PriorityQueue<>();
    private Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    @Test
    public void test1() {
        String[] operations = {"I 16", "D 1"};
        int[] answer = {0, 0};
        assertThat(problem.solution(operations)).isEqualTo(answer);
    }

    @Test
    public void test2() {
        String[] operations = {"I 7", "I 5", "I -5", "D -1"};
        int[] answer = {7, 5};
        assertThat(problem.solution(operations)).isEqualTo(answer);
    }

    @Test
    public void test3() {
        String[] operations = {"I 7", "I 5", "I -5", "D -1", "D -1"};
        int[] answer = {7, 7};
        assertThat(problem.solution(operations)).isEqualTo(answer);
    }

    @Test
    public void test4() {
        String[] operations = {"I 7", "I 5", "I -5", "D -1", "D -1", "D 1"};
        int[] answer = {0, 0};
        assertThat(problem.solution(operations)).isEqualTo(answer);
    }

    @Test
    public void test5() {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int[] answer = {0, 0};
        assertThat(problem.solution(operations)).isEqualTo(answer);
    }

}