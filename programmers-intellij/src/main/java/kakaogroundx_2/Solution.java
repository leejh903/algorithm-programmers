package kakaogroundx_2;

import java.math.BigInteger;

class Solution {
    public long solution(int w, int h) {
        BigInteger answer = BigInteger.valueOf(w).multiply(BigInteger.valueOf(h));

        for (int i = 0; i < w; i++) {
            long bottom = (long)Math.floor(getY(w, h, i));
            long up = (long)Math.ceil(getY(w, h, i + 1));
            answer = answer.subtract(BigInteger.valueOf(up - bottom));
        }

        return answer.longValue();
    }

    public double getY(int W, int H, int x) {
        return ((double)H / W) * x;
    }
}