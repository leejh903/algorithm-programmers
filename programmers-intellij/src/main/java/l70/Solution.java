package l70;

import java.util.HashMap;
import java.util.Map;

class Solution {
	Map<Integer, Integer> cache = new HashMap<>();

	public int climbStairs(int n) {
		if (cache.containsKey(n)) {
			return cache.get(n);
		}
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}

		int sum = 0;
		sum += climbStairs(n - 1);
		sum += climbStairs(n - 2);
		cache.put(n, sum);
		return sum;
	}
}
