package l50;

class Solution {
	public double myPow(double x, int n) {
		double answer = 1;
		if (x == 1 || n == 0) {
			return answer;
		}
		if (x == -1) {
			if (n % 2 == 0)
				return 1;
			else
				return -1;
		}
		if (n > 1 && n == Integer.MIN_VALUE)
			return 0;

		String operation = "multiply";
		if (n < 0) {
			operation = "divide";
			n = Math.abs(n);
		}

		int i = 1;
		while (i <= n) {
			if (operation == "divide") {
				if (i != 1 && 2 * (i - 1) <= n) {
					answer /= answer;
					i = 2 * (i - 1);
				} else {
					answer /= x;
					i++;
				}
			} else {
				if (i != 1 && 2 * (i - 1) <= n) {
					answer *= answer;
					i = 2 * (i - 1);
				} else {
					answer *= x;
					i++;
				}
			}
		}
		return answer;
	}
}
