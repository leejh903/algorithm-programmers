package p42841;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int strike = 0;
        int ball = 0;

        int i = 345;
        int target = 354;
        Set<Integer> set = setInit(i);
        while(i != 0) {
            int temp = target % 10;
            if(i % 10 == temp) strike++;
            else if(set.contains(temp)) ball++;
            i /= 10; target /= 10;
        }

        System.out.println(strike + " " + ball);
    }

    private Set<Integer> setInit(int i) {
        Set<Integer> set = new HashSet<>();
        String[] numText = String.valueOf(i).split("");
        for (String s : numText) {
            set.add(Integer.valueOf(s));
        }
        return set;
    }

    @Test
    public void test2() {
        int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        assertThat(problem.solution(baseball)).isEqualTo(2);
    }
}