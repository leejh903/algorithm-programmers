package l264;

class Solution {
    // 1*2=2 | 1*3=3 | 1*5=5
    // 2*2=4 | 2*3=6 | 2*5=10
    // 3*2=6 | 3*3=9 | 3*5=15
    // 4*2=8 | 4*3=12| 4*5=20
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int index = 1, i2 = 0, i3 = 0, i5 = 0;
        while (index < n) {
            int num1 = dp[i2] * 2;
            int num2 = dp[i3] * 3;
            int num3 = dp[i5] * 5;

            int res = Math.min(Math.min(num1, num2), num3);
            if (res == num1)
                i2++;
            if (res == num2)
                i3++;
            if (res == num3)
                i5++;
            dp[index] = res;
            index++;
        }
        return dp[n - 1];
    }

}
