package p42896;

public class Solution2 {
    public int solution(int[] left, int[] right) {
        int nl = left.length;
        int nr = right.length;
        int[][] answer = new int[nl + 1][nr + 1];

        for (int i = 0; i <= nl; i++) {
            answer[i][0] = 0;
        }
        for (int i = 0; i <= nr; i++) {
            answer[0][i] = 0;
        }

        for (int i = 1; i <= nl; i++) {
            for (int j = 1; j <= nl; j++) {
                answer[i][j] = Math.max(answer[i - 1][j], answer[i - 1][j - 1]);
                if (left[i - 1] > right[j - 1]) {
                    answer[i][j] = Math.max(answer[i][j], answer[i][j - 1] + right[j - 1]);
                }
            }
        }

        for (int[] ints : answer) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        return answer[nl][nr];
    }
}
