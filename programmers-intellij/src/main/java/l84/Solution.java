package l84;

class Solution {
	public int largestRectangleArea(int[] heights) {
		int n = heights.length;
		// 해당 인덱스부터 최대 왼쪽으로 뻗을 수 있는 인덱스
		int[] left = new int[n];
		// 해당 인덱스부터 최대 오른쪽으로 뻗을 수 있는 인덱스
		int[] right = new int[n];

		left[0] = 0;
		// 최대 왼쪽으로 뻗을 수 있는 인덱스 초기화
		for (int i = 0; i < n; i++) {
			int curLeft = i - 1;
			while (curLeft >= 0 && heights[curLeft] >= heights[i]) {
				// 기존 업데이트 된 값 사용(DP)
				curLeft = left[curLeft] - 1;
			}
			left[i] = curLeft + 1;
		}

		right[n - 1] = n - 1;
		for (int i = n - 2; i >= 0; i--) {
			int curRight = i + 1;
			while (curRight < n && heights[curRight] >= heights[i]) {
				curRight = right[curRight] + 1;
			}
			right[i] = curRight - 1;
		}

		int  result = 0;
		for(int i = 0; i < n; i++) {
			result = Math.max(result, (right[i] - left[i] + 1) * heights[i]);
		}
		return result;
	}
}
