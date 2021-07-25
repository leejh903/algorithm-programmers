package l29;

//class Solution {
//    public int divide(int dividend, int divisor) {
//        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
//        return dividend / divisor;
//    }
//}

class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;

        int num = 0;
        for (int i = 0; i <= Integer.MAX_VALUE; i++) {
            num += divisor;
            if(num == Integer.MIN_VALUE) return Integer.MAX_VALUE;
            if(toNegative(num) < toNegative(dividend)) {
                if((dividend < 0 && num > 0) || (dividend > 0 && num < 0)) {
                    return ~i + 1;
                }
                return i;
            }
        }
        return 0;
    }

    private int toNegative(int num) {
        if(num < 0) return num;
        return ~num + 1;
    }
}
