package p43237;

import java.util.Arrays;

class Solution {
    public int solution(int[] budgets, int M) {
        int length = budgets.length;

        Arrays.sort(budgets);

        int low = budgets[0];
        int high = budgets[length - 1];

        if(low > (M / length)) return M / length;
        while(low + 1 < high) {
            int mid = (low + high) / 2;
            int newBudget = makeNewBudet(budgets, mid);
            if(newBudget >= M) high = mid;
            else low = mid;
        }

        return chooseBestChoice(budgets, M, low, high);
    }

    private int chooseBestChoice(int[] budgets, int M, int low, int high) {
        if(M <= makeNewBudet(budgets, high)) return low;
        return high;
    }

    int makeNewBudet(int[] budgets, int mid) {
        int temp = 0;
        for (int budget : budgets) {
            if(budget > mid) {
                temp += mid;
                continue;
            }
            temp += budget;
        }
        return temp;
    }
}