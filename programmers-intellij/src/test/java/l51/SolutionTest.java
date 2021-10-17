package l51;

import java.util.List;
import org.junit.Test;

public class SolutionTest {
	Solution problem = new Solution();

	@Test
	public void test1() {
		List<List<String>> answer = problem.solveNQueens(1);
		for (List<String> l : answer) {
			for (String r : l) {
				System.out.println(r);
			}
		}
	}
}
