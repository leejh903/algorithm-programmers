package l40;

import org.junit.Test;
import static org.junit.Assert.*;

public class SolutionTest {
	Solution problem = new Solution();

	@Test
	public void test1() {
		int[] candidates = new int[] { 2, 5, 2, 1, 2 };
		int target = 5;

		System.out.println(problem.combinationSum2(candidates, target));
	}
}
