package p17687;

public class Solution {
    String[] expressions = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        StringBuilder sb = new StringBuilder();

        int num = 0;
        while (sb.length() < t * m) {
            sb.append(makeNnotation(n, num));
            num++;
        }

        int index = p - 1;
        for (int i = 0; i < t; i++) {
            answer.append(sb.charAt(index));
            index += m;
        }

        return answer.toString();
    }

    public String makeNnotation(int N, int num) {
        StringBuilder sb = new StringBuilder();

        while (num / N != 0) {
            int temp = num % N;
            sb.insert(0, expressions[temp]);
            num /= N;
        }
        sb.insert(0, expressions[num]);

        return sb.toString();
    }

}
