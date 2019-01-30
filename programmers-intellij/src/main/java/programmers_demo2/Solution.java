package programmers_demo2;

class Solution {
    public int[] solution(int[][] v) {
        int[] answer = new int[2];

        int[] middle = getMiddleArray(v);
        for (int i = 0; i < v.length; i++) {
            int[] temp = v[i];
            if(middle[0] == temp[0] && middle[1] == temp[1]) continue;
            if(middle[0] == temp[0]) answer[1] = temp[1];
            if(middle[1] == temp[1]) answer[0] = temp[0];
        }

        return answer;
    }

    public int[] getMiddleArray(int[][] v) {
        int num;
        for (num = 0; num < v.length; num++) {
            boolean flag = true;
            int[] numArray = v[num];
            for (int i = 0; i < v.length; i++) {
                if(i == num) continue;
                int[] otherNum = v[i];
                if(numArray[0] - otherNum[0] != 0 && numArray[1] - otherNum[1] != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) break;
        }
        return v[num];
    }
}