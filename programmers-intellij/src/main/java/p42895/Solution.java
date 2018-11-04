package p42895;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;  // 최소값이 8보다 크면 -1 처리
        Set<Integer>[] setArr = new Set[9];
        int t = N;
        for (int i = 1; i < 9; i++) {
            setArr[i] = new HashSet<>();
            setArr[i].add(t);
            t = t * 10 + N;
        }
        for (int i = 1; i < 9; i++) {  // 전체 자리
            for (int j = 1; j < i; j++) {
                for (Integer a : setArr[j]) {  // 앞에 자리
                    for (Integer b : setArr[i - j]) {  // 뒤에 자리
                        setArr[i].add(a + b);
                        setArr[i].add(a - b);
                        setArr[i].add(b - a);
                        setArr[i].add(a * b);
                        if (b != 0) {
                            setArr[i].add(a / b);
                        }
                        if (a != 0) {
                            setArr[i].add(b / a);
                        }
                    }
                }
            }
        }
        for (int i = 1; i < 9; i++) {
            if (setArr[i].contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}