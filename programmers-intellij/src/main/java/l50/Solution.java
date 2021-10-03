package l50;

import java.util.ArrayList;
import java.util.List;

class Solution {
	List<Data> cache = new ArrayList<>();

	public double myPow(double x, int n) {
		int originN = n;
		double answer = 1;
		if (n == 0) {
			return answer;
		}

		cache.add(new Data(0, 1));
		if (n > 0) {
			cache.add(new Data(1, x));
		} else {
			cache.add(new Data(1, 1 / x));
		}

		int i = 0;
		if (n == Integer.MIN_VALUE) {
			n++;
			i++;
			answer /= x;
		}
		n = Math.abs(n);
		while (i < n) {
			for (int j = cache.size() - 1; j > 0; j--) {
				int e = cache.get(j).exponential;
				if (i + e <= n && i + e > 0) {
					answer *= cache.get(j).num;
					i += e;
					break;
				}
			}
			cache.add(new Data(i, answer));
		}

		// multiply first cache to calculate 2147483648th
		if (originN == Integer.MIN_VALUE) {
			answer *= cache.get(1).num;
		}
		return answer;
	}

	class Data {
		private int exponential;
		private double num;

		public Data(int exponential, double num) {
			this.exponential = exponential;
			this.num = num;
		}
	}
}
