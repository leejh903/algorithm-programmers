package p42891;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void init() {
        int[] food_times = {3, 1, 2};
        List<Food> list = problem.init(food_times);
        for (Food food : list) {
            System.out.println(food);
        }
    }

    @Test
    public void subList() {
        List<String> list = new ArrayList<String>();
        list.add("bbb");
        list.add("ccc");
        list.add("aaa");

        List<String> subList = list.subList(1, 2);

        System.out.println(subList.size());
    }

    @Test
    public void test() {
        int[] food_times = {3, 1, 2};
        int k = 5;
        assertThat(problem.solution(food_times, k)).isEqualTo(1);
    }
}