package l89;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> grayCode(int n) {
		List<Integer> l = new ArrayList<>();
		double max = Math.pow(2, n);
		for (int i = 0; i < max; i++) {
			l.add(i ^ (i / 2));
		}
		return l;
	}
}
