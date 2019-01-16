package p42897;

class Solution {
    public int solution(int[] money) {
        int answer1 = lastVisit(money);
        int answer2 = notLastVisit(money);
        return Math.max(answer1, answer2);
    }

    private int notLastVisit(int[] money) {
        int[][] array = new int[money.length - 1][money.length - 1];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == 0 || j == 0) {
                    array[i][j] = money[0];
                    continue;
                }
                if (j > i) {
                    array[i][j] = array[i][j - 1];
                    continue;
                }
                if (j < i) {
                    array[i][j] = array[i - 1][j];
                    continue;
                }

                int before = array[i - 1][j];
                int temp = 0;
                if (j == 1) {
                    temp = money[j] + 0;
                } else {
                    temp = money[j] + array[i][j - 2];
                }
                if (temp > before) array[i][j] = temp;
                else array[i][j] = before;
            }
        }

        int length = array.length;
        return array[length - 1][length - 1];
    }

    private int lastVisit(int[] money) {
        int[][] array = new int[money.length - 2][money.length - 2];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == 0 || j == 0) {
                    array[i][j] = money[money.length - 1];
                    continue;
                }
                if (j > i) {
                    array[i][j] = array[i][j - 1];
                    continue;
                }
                if (j < i) {
                    array[i][j] = array[i - 1][j];
                    continue;
                }

                int before = array[i - 1][j];
                int temp = 0;
                if (j == 1) {
                    temp = money[j] + array[i][j - 1];
                } else {
                    temp = money[j] + array[i][j - 2];
                }
                if (temp > before) array[i][j] = temp;
                else array[i][j] = before;
            }
        }

        int length = array.length;
        return array[length - 1][length - 1];
    }
}