package l39;

import org.junit.Test;

import java.util.List;

public class SolutionTest {
    Solution problem = new Solution();

    @Test
    public void test() {
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        List<List<Integer>> answer = problem.combinationSum(candidates, target);
        System.out.println(answer);
    }

    @Test
    public void test2() {
        int[] candidates = new int[]{2};
        int target = 1;
        List<List<Integer>> answer = problem.combinationSum(candidates, target);
        System.out.println(answer);
    }

    @Test
    public void test3() {
        int[] candidates = new int[]{1};
        int target = 1;
        List<List<Integer>> answer = problem.combinationSum(candidates, target);
        System.out.println(answer);
    }

    @Test
    public void test4() {
        int[] candidates = new int[]{1};
        int target = 2;
        List<List<Integer>> answer = problem.combinationSum(candidates, target);
        System.out.println(answer);
    }
}