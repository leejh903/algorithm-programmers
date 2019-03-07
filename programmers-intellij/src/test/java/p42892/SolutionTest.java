package p42892;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void arraysSort() {
        int[][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        Queue<Node> queue = problem.init(nodeinfo);
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }

    @Test
    public void injectNode() {
        int[][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        Node root = problem.injectNode(problem.init(nodeinfo));
        List<Integer> preList = new ArrayList<>();
        problem.preOrder(preList, root);
        for (Integer integer : preList) {
            System.out.println(integer);
        }
    }

    @Test
    public void test() {
        int[][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        int[][] answer = problem.solution(nodeinfo);
        for (int[] ints : answer) {
            System.out.println(Arrays.toString(ints));
        }
    }
}