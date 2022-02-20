package l91;

import java.util.HashMap;
import java.util.Map;

class Solution {
	String[] alphabets = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
			"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	Map<String, String> letters = new HashMap<>();

	public int numDecodings(String s) {
		for (int i = 1; i <= alphabets.length; i++) {
			letters.put(Integer.toString(i), alphabets[i - 1]);
		}
		return dfs(s, 0, 1) + dfs(s, 0, 2);
	}

	int dfs(String s, int beginIndex, int endIndex) {
		if (endIndex > s.length()) {
			return 0;
		}

		int count = 0;

		String sub = s.substring(beginIndex, endIndex);
		if (!letters.containsKey(sub)) {
			return 0;
		}
		if (endIndex == s.length()) {
			return 1;
		}

		count += dfs(s, endIndex, endIndex + 1);

		count += dfs(s, endIndex, endIndex + 2);

		return count;
	}
}
