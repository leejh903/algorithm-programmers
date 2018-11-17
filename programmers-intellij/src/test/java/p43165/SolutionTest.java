package p43165;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    int answer = 0;
    int target = 3;

    @Test
    public void 한번은_더하기_한번은_빼기() {
        int[] numbers = {1, 1, 1, 1, 1};
        int[] sign = {-1, 1};

        int test = 0;
        test += visit(numbers, sign, numbers.length - 1, 0);

        System.out.println(test);
    }

    public int visit(int[] numbers, int[] sign, int index, int sum) {
        if(index == -1) {
            if(sum == target) answer++;
            return 1;
        }
        for (int i = 0; i < sign.length; i++) {
            visit(numbers, sign, index - 1, sum + (numbers[index] * sign[i]));
        }

        System.out.println("index : " + index);
        return sum;
    }

    @Test
    public void test1() {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        assertThat(problem.solution(numbers, target)).isEqualTo(5);
    }
}