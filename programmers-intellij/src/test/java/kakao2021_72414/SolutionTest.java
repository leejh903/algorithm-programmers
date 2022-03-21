package kakao2021_72414;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SolutionTest {
	Solution solution = new Solution();

	@Test
	public void testConvertToSecond() {
		assertEquals(1 * 60 * 60 + 20 * 60 + 15, Solution.convertToSecond("01:20:15"));
	}

	@Test
	public void testConvertToTimeFormat() {
		assertEquals("01:20:15", Solution.convertToTimeFormat(1 * 60 * 60 + 20 * 60 + 15));
	}

	@Test
	public void testCase1() {
		String[] logs = new String[] {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29",
				"01:30:59-01:53:29", "01:37:44-02:02:30"};
		String actual = solution.solution("02:03:55", "00:14:15", logs);
		assertEquals("01:30:59", actual);
	}

	@Test
	public void testCase2() {
		String[] logs = new String[] {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59",
				"11:00:00-31:00:00"};
		String actual = solution.solution("99:59:59", "25:00:00", logs);
		assertEquals("01:00:00", actual);
	}

	@Test
	public void testCase3() {
		String[] logs =
				new String[] {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"};
		String actual = solution.solution("50:00:00", "50:00:00", logs);
		assertEquals("00:00:00", actual);
	}
}
