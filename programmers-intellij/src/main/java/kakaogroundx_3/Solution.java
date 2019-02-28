package kakaogroundx_3;

class Solution {
    int answer = 0;

    public int solution(int[] gold_prices) {

        recurrence(gold_prices, 0, 0, 0);

        return answer;
    }

    void recurrence(int[] prices, int left, int right, int temp) {
        if(left >= prices.length || right >= prices.length) {
            answer = Math.max(answer, temp);
            return;
        }

        while(right <= prices.length - 2 && right <= left) {
            right++;
            if(prices[right] - prices[left] <= 0) left++;
        }

        int gap = prices[right] - prices[left];
        if(gap < 0) return;
        recurrence(prices, left, right + 1, temp);
        recurrence(prices, right + 2, right + 2, temp + gap);
    }
}