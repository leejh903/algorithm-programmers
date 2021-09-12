package l42;

class Solution {
	public int trap(int[] height) {
		int left = 0;
		int right = height.length - 1;

		int ans = 0;
		int left_max = 0;
		int right_max = 0;
		while (left < right) {
			// right에서 어떻게든 막아줄거라 기대될 때
			if (height[left] < height[right]) {
				if (height[left] >= left_max)
					left_max = height[left];
				else
					ans += (left_max - height[left]);
				left++;
			} else { // left에서 어떻게든 막아줄거라 기대될 때
				if (height[right] >= right_max)
					right_max = height[right];
				else
					ans += (right_max - height[right]);
				right--;
			}
		}
		return ans;
	}
}
