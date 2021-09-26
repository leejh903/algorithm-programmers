package l45;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {
	Solution problem = new Solution();

	@Test
	public void test() {
		int[] nums = new int[] { 2, 3, 1, 1, 4 };
		assertEquals(2, problem.jump(nums));
	}

	@Test
	public void test2() {
		int[] nums = new int[] { 2, 3, 0, 1, 4 };
		assertEquals(2, problem.jump(nums));
	}

	@Test
	public void test3() {
		int[] nums = new int[] { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 };
		assertEquals(3, problem.jump(nums));
	}
}
