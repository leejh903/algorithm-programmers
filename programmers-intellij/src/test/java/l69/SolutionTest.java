package l69;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SolutionTest {
	Solution problem = new Solution();

	@Test
	public void test() {
		assertEquals(2, problem.mySqrt(8));
	}
}
