package p42884;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
        assertThat(problem.solution(routes)).isEqualTo(2);
    }

    @Test
    public void listTest() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);

        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list.get(0));
    }
}