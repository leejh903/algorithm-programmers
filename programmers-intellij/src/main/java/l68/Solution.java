package l68;

import java.util.ArrayList;
import java.util.List;

class Solution {
	private final String SPACE_STR = " ";
	private List<String> answer = new ArrayList<>();

	public List<String> fullJustify(String[] words, int maxWidth) {
		int spaceCount = 0;
		int width = 0;
		List<String> row = new ArrayList<>();
		for (String word : words) {
			// process space justification
			if (!row.isEmpty() && width + SPACE_STR.length() + word.length() > maxWidth) {
				answer.add(justifyRow(maxWidth, spaceCount, width, row));

				// after process
				spaceCount = 0;
				width = 0;
				row = new ArrayList<>();
			}

			// update local variables
			if (!row.isEmpty()) {
				spaceCount++;
				width += SPACE_STR.length();
				row.add(SPACE_STR);
			}
			row.add(word);
			width += word.length();
		}

		// process last line
		if (!row.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (String r : row) {
				sb.append(r);
			}
			sb.append(createSpace(maxWidth - width));
			answer.add(sb.toString());
		}

		return answer;
	}

	private String justifyRow(int maxWidth, int spaceCount, int width, List<String> row) {
		// only one word added. empty space should be appended
		if (spaceCount == 0) {
			// when there is no left space to justify row and only one word in row, just return index 0th value
			if (width == maxWidth) {
				return row.get(0);
			}

			row.add(SPACE_STR);
			spaceCount++;
			width += SPACE_STR.length();
		}
		int leftSpace = maxWidth - width;
		int addSpace = leftSpace / spaceCount;
		int remaningSpace = leftSpace % spaceCount;

		String appendStr = createSpace(addSpace);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < row.size(); i++) {
			String str = row.get(i);
			if (str != SPACE_STR) {
				sb.append(str);
				continue;
			}
			String curAppendStr = appendStr;
			if (remaningSpace > 0) {
				curAppendStr += SPACE_STR;
				remaningSpace--;
			}
			sb.append(str + curAppendStr);
		}
		return sb.toString();
	}

	private String createSpace(int multiply) {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < multiply; j++) {
			sb.append(SPACE_STR);
		}
		return sb.toString();
	}

}
