package p42897;

class Solution {
    int answer = 0;
    public int solution(int[] money) {
        boolean[] visit = new boolean[money.length];
        check(money, visit, 0, 0);

        return answer;
    }

    private void check(int[] money, boolean[] visit, int sum, int index) {
        if (index == money.length - 1) {
            if(visit[0] == false && visit[index - 1] == false) {
                answer = Math.max(sum + money[index], answer);
                return;
            }
            answer = Math.max(sum, answer);
            return;
        }

        // 해당 자리 체크 안함
        check(money, visit.clone(), sum, index + 1);

        // 해당 자리 체크
        if (index == 0 || !visit[index - 1]) {
            visit[index] = true;
            check(money, visit.clone(), sum + money[index], index + 1);
        }
    }
}