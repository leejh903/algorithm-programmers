package l66;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	public int[] plusOne(int[] digits) {
		List<Integer> nums = new ArrayList<>();

		int upper = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			int num = digits[i] + upper;

			if (i == digits.length - 1) {
				num += 1;
			}
			upper = num / 10;
			nums.add(num % 10);
		}
		if (upper > 0) {
			nums.add(upper);
		}

		Collections.reverse(nums);
		return nums.stream().mapToInt(i -> i).toArray();
	}
}
