package p12931;

import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = Arrays.stream(String.valueOf(n).split(""))
                .map(s -> Integer.parseInt(s))
                .mapToInt(Integer::intValue)
                .sum();
        return answer;
    }
}
