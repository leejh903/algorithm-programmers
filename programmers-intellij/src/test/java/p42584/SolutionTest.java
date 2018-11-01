package p42584;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();
    int[] prices = new int[]{498, 501, 470, 489};

    @Test
    public void 큐에_넣기() {
        Queue<Integer> queue = new LinkedList<>();

        for (int price : prices) {
            queue.offer(price);
        }

        for (Integer integer : queue) {
            System.out.println(integer);
        }
    }

    @Test
    public void 시간_구하기() {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> timeArray = new ArrayList<>();
        for (int price : prices) {
            queue.offer(price);
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();
            int time = 0;
            for (Integer integer : queue) {
                time++;
                if (integer < num) {
                    break;
                }
            }
            timeArray.add(time);
        }

        assertThat(timeArray.get(0)).isEqualTo(2);
        assertThat(timeArray.get(1)).isEqualTo(1);
        assertThat(timeArray.get(2)).isEqualTo(1);
        assertThat(timeArray.get(3)).isEqualTo(0);
    }

    @Test
    public void 구현() {
        int[] prices = new int[]{498, 501, 470, 489};
        assertThat(problem.solution(prices)).isEqualTo(new int[]{2, 1, 1, 0});
    }
}