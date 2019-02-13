package codility_test;

class Solution {
    public int solution(int N) {
        int answer = 0;
        String binary = Integer.toBinaryString(N);
        boolean start = false;
        int num = 0;
        for (int i = 0; i < binary.length(); i++) {
            char temp = binary.charAt(i);

            if(start && temp == '0') num++;
            if(start && temp == '1') {
                start = false;
                answer = Math.max(answer, num);
                num = 0;
            }

            if(temp == '1' && i <= binary.length() - 2 && binary.charAt(i + 1) == '0') {
                start = true;
            }
        }

        return answer;
    }
}
