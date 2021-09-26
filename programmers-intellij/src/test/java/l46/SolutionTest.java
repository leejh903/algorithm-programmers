package l46;

import java.util.List;
import org.junit.Test;

public class SolutionTest {
	Solution problem = new Solution();

	@Test
	public void test1() {
		int[] nums = new int[] { 1, 2, 3 };
		List<List<Integer>> answer = problem.permute(nums);
		for (List<Integer> ans : answer) {
			System.out.println(ans);
		}
	}
}
