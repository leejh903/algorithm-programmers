package l85;

class Solution {
	public int maximalRectangle(char[][] matrix) {
		int answer = 0;

		boolean isFull = true;
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] == '0') {
					isFull = false;
					break;
				}
			}
			if (!isFull)
				break;
		}
		if (isFull) {
			return matrix.length * matrix[0].length;
		}

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] != '1')
					continue;

				int h = row;
				while (h < matrix.length - 1) {
					if (matrix[h][col] != '1')
						break;
					h++;
				}
				int w = col;
				while (w < matrix[0].length - 1) {
					if (matrix[row][w] != '1')
						break;
					w++;
				}

				for (int i = row; i <= h; i++) {
					for (int j = col; j <= w; j++) {

						boolean isRectangle = true;
						for (int a = row; a <= i; a++) {
							for (int b = col; b <= j; b++) {
								if (matrix[a][b] == '1') {
									continue;
								}
								isRectangle = false;
								break;
							}
							if (!isRectangle)
								break;
						}

						if (isRectangle) {
							answer = Math.max(answer, (i - row + 1) * (j - col + 1));
						}
					}
				}

			}
		}

		return answer;
	}
}
