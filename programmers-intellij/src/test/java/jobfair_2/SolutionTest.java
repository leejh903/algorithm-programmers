package jobfair_2;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void name() {
        int[] people = new int[]{2, 3};
        Queue<Integer> peopleQ = problem.init(people);
        while(!peopleQ.isEmpty()){
            System.out.println(peopleQ.poll());
        }
    }

    @Test
    public void test() {
        int[] people = new int[]{2, 3};
        int[] tshirts = new int[]{1, 2, 3};
        assertThat(problem.solution(people, tshirts)).isEqualTo(2);
    }

    @Test
    public void test2() {
        int[] people = new int[]{1, 2, 3};
        int[] tshirts = new int[]{1, 1};
        assertThat(problem.solution(people, tshirts)).isEqualTo(1);
    }
}