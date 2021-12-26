package l74;

class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = 0;
		while (row < matrix.length) {
			if (target >= matrix[row][0] && target <= matrix[row][matrix[0].length - 1]) {
				break;
			}
			row++;
		}
		if (row == matrix.length)
			return false;

		return binarySearch(matrix[row], target, 0, matrix[row].length - 1);
	}

	boolean binarySearch(int[] arr, int key, int low, int high) {
		int mid;

		if (low <= high) {
			mid = (low + high) / 2;

			if (key == arr[mid]) {
				return true;
			} else if (key < arr[mid]) {
				return binarySearch(arr, key, low, mid - 1);
			} else {
				return binarySearch(arr, key, mid + 1, high);
			}
		}
		return false;
	}
}
