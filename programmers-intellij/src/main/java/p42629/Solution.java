package p42629;

class Solution {
    int answer;
    int k;

    public int solution(int stock, int[] dates, int[] supplies, int k) {
        this.k = k;
        this.answer = supplies.length;
        dfs(stock, dates, supplies, 0, 0, 0);
        return answer;
    }

    public void dfs(int stock, int[] dates, int[] supplies, int today, int index, int num) {
        int nextSupplyDay = index + 1;
        if(nextSupplyDay < supplies.length) {
            if(dates[index] - today > stock) {  // 안되는 경우
                return;
            } else {  // 공급이 필요없는 경우
                stock = stock - today;
                boolean flag = false;
                if(!flag) {
                    dfs(stock + supplies[index], dates, supplies, dates[index], index + 1, num + 1);
                    flag = true;
                }
                if(!flag) {
                    dfs(stock, dates, supplies, dates[index], index + 1, num);
                }
            }
        } else {  // 마지막인 경우
            if(k - dates[index] > stock) {
                answer = Math.min(answer, num + 1);
            } else {
                answer = Math.min(answer, num);
            }
        }
    }
}
