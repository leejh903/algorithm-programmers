package l54;

import org.junit.Test;

public class SolutionTest {
	Solution problem = new Solution();

	@Test
	public void test() {
		int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(problem.spiralOrder(matrix));
	}
}
