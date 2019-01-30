package programmers_demo2;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void 겹치는_좌표_찾기() {
        int[][] v = {{1, 4}, {3, 4}, {3, 10}};
        int num;
        for (num = 0; num < v.length; num++) {
            boolean flag = true;
            int[] numArray = v[num];
            for (int i = 0; i < v.length; i++) {
                if(i == num) continue;
                int[] otherNum = v[i];
                if(numArray[0] - otherNum[0] != 0 && numArray[1] - otherNum[1] != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.println(num);
        }
    }

    @Test
    public void test() {
        int[][] v = {{1, 4}, {3, 4}, {3, 10}};
        int[] result = {1, 10};
        assertThat(problem.solution(v)).isEqualTo(result);
    }

    @Test
    public void test2() {
        int[][] v = {{1, 1}, {2, 2}, {1, 2}};
        int[] result = {2, 1};
        assertThat(problem.solution(v)).isEqualTo(result);
    }
}