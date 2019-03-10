package kakaogroundx_3;

import java.util.ArrayList;

class StockBuySell {
    public int stockBuySell(int price[]) {
        int answer = 0;
        int n = price.length;
        if (n == 1)
            return 0;

        ArrayList<Interval> sol = new ArrayList<>();

        int i = 0;
        while (i < n - 1) {
            while ((i < n - 1) && (price[i + 1] <= price[i]))
                i++;

            if (i == n - 1)
                break;

            Interval e = new Interval();
            e.buy = i++;

            while ((i < n) && (price[i] >= price[i - 1]))
                i++;

            e.sell = i - 1;
            sol.add(e);
            i++;
        }

        for (Interval interval : sol) {
            answer += (price[interval.sell] - price[interval.buy]);
        }

        return answer;
    }
}

class Interval {
    int buy, sell;
}

