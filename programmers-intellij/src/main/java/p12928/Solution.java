package p12928;

import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        return IntStream.range(1, n / 2 + 1)
                .boxed()
                .filter(i -> n % i == 0)
                .mapToInt(Integer::intValue)
                .sum() + n;
    }
}
