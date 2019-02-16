package p17687;

public class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        StringBuilder sb = new StringBuilder();

        int num = 0;
        while(sb.length() < t * m) {
            sb.append(makeNnotation(n, num));
            num++;
        }

        System.out.println(sb.toString());

        int index = p - 1;
        for (int i = 0; i < t; i++) {
            answer.append(sb.charAt(index));
            index += m;
        }

        return answer.toString();
    }

    public String makeNnotation(int N, int num) {
        StringBuilder sb = new StringBuilder();

        while(num / N != 0) {
            int temp = num % N;
            if(temp >= 10) sb.insert(0, expressOverTen(temp));
            else sb.insert(0, temp);
            num /= N;
        }

        if(num >= 10) sb.insert(0, expressOverTen(num));
        else sb.insert(0, num);

        return sb.toString();
    }

    public String expressOverTen(int i) {
        if(i == 10) return "A";
        if(i == 11) return "B";
        if(i == 12) return "C";
        if(i == 13) return "D";
        if(i == 14) return "E";
        if(i == 15) return "F";
        return null;
    }
}
