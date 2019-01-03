package p43105;

class Solution {
    private int maxSum;
    private int[] firstVal;

    public int solution(int[][] triangle) {
        search(triangle, 0, 0, 0);
        return maxSum;
    }

    public void search(int[][] triangle, int point, int height, int sum) {
        if (height == triangle.length) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        sum += triangle[height][point];

        search(triangle, point, height + 1, sum);
        search(triangle, point + 1, height + 1, sum);
    }
}
