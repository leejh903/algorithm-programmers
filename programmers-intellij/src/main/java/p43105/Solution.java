package p43105;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        for (int i = 1; i < triangle.length; i++) {
            int eachSize = triangle[i].length;
            for (int j = 0; j < eachSize; j++) {

                if(j == 0) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if(j == eachSize - 1) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }

                if(i == triangle.length - 1) answer = Math.max(answer, triangle[i][j]);

            }
        }

        return answer;
    }
}
