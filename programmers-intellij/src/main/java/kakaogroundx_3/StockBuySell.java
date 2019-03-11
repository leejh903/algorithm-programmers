package kakaogroundx_3;

class StockBuySell {
    public int stockBuySell(int price[]) {
        int answer = 0;
        int n = price.length;

        if(n == 1) return 0;

        int index = 0;
        while(index < n - 1) {
            while(index < n - 1 && price[index] >= price[index + 1]) index++;

            int buy = price[index];
            index++;

            while(index < n && price[index - 1] <= price[index]) index++;

            int sell = price[index - 1];
            index++;

            answer += (sell - buy);
        }

        return answer;
    }
}

