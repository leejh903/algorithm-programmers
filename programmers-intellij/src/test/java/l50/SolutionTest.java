package l50;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class SolutionTest {
	Solution problem = new Solution();

	@Test
	public void test1() {
		double x = 34.00515;
		int n = -3;
		// assertThat(problem.myPow(x, n)).isEqualTo(0.000025);
	}

	@Test
	public void test2() {
		double x = -1.00000;
		int n = -2147483648;
		assertThat(problem.myPow(x, n)).isEqualTo(1);
	}

	@Test
	public void test3() {
		double x = 2.00000;
		int n = 10;
		assertThat(problem.myPow(x, n)).isEqualTo(1024.00000);
	}
}
