package l93;

import java.util.ArrayList;
import java.util.List;

class Solution {
	private List<String> answer = new ArrayList<>();

	public List<String> restoreIpAddresses(String s) {
		dfs(s, 0, 1, new ArrayList<>());
		return answer;
	}

	private void dfs(String s, int start, int end, List<String> collection) {
		if (start == s.length()) {
			if (collection.size() != 4)
				return;

			answer.add(String.join(".", collection));
		}
		if (end >= s.length() + 1) {
			return;
		}

		String numStr = s.substring(start, end);
		// cannot have leading zeros
		if (numStr.startsWith("0") && numStr.length() > 1)
			return;
		if (numStr.length() > 3)
			return;
		int num = Integer.parseInt(numStr);
		if (num < 0 || num > 255)
			return;

		collection.add(numStr);
		// start from end
		dfs(s, end, end + 1, collection);
		collection.remove(collection.size() - 1);
		// extend end index
		dfs(s, start, end + 1, collection);
	}
}
