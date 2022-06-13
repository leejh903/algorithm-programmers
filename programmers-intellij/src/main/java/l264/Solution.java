package l264;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Integer> dp;

    public int nthUglyNumber(int n) {
        dp = new HashMap<>();
        int num = 1;
        while (true) {
            int result = divideUglyNumer(num);
            dp.put(num, result);

            if (result == 1) {
                n--;
            }
            if (n == 0) {
                break;
            }
            num++;
        }
        return num;
    }

    int divideUglyNumer(int num) {
        if (dp.containsKey(num)) {
            return dp.get(num);
        }

        if (num % 2 == 0) {
            num = divideUglyNumer(num / 2);
        }
        if (num % 3 == 0) {
            num = divideUglyNumer(num / 3);
        }
        if (num % 5 == 0) {
            num = divideUglyNumer(num / 5);
        }
        return num;
    }
}
