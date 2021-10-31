package l56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		List<List<Integer>> preAnswer = new ArrayList<>();

		for (int[] interval : intervals) {
			if (preAnswer.size() == 0) {
				preAnswer.add(Arrays.asList(new Integer[] {interval[0], interval[1]}));
				continue;
			}

			List<Integer> last = preAnswer.get(preAnswer.size() - 1);
			if (interval[0] <= last.get(1)) {
				last.set(1, Math.max(last.get(1), interval[1]));
			} else {
				preAnswer.add(Arrays.asList(new Integer[] {interval[0], interval[1]}));
			}
		}

		int[][] answer = new int[preAnswer.size()][2];
		for (int i = 0; i < preAnswer.size(); i++) {
			answer[i] = new int[] {preAnswer.get(i).get(0), preAnswer.get(i).get(1)};
		}
		return answer;
	}
}
