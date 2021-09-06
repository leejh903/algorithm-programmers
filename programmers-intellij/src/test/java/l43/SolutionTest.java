package l43;

import org.junit.Test;
import static org.junit.Assert.*;

public class SolutionTest {
	Solution problem = new Solution();

	@Test
	public void test1() {
		String num1 = "2";
		String num2 = "3";

		assertEquals("6", problem.multiply(num1, num2));
	}

	@Test
	public void test2() {
		String num1 = "123";
		String num2 = "456";

		assertEquals("56088", problem.multiply(num1, num2));
	}
}
