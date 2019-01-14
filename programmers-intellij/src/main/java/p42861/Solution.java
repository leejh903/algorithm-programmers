package p42861;

import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Queue<Cost> queue = initCost(costs);
        boolean[] visits = new boolean[n];

        int check = 0;
        while(check < n - 1) {
            boolean visit = false;
            Cost cost = queue.poll();
            if(!visits[cost.city1]) {
                visits[cost.city1] = true;
                visit = true;
            }
            if(!visits[cost.city2]) {
                visits[cost.city2] = true;
                visit = true;
            }
            if(visit || (visits[cost.city1] && visits[cost.city2])) {
                check++;
                answer += cost.cost;
            }
        }
        return answer;
    }

    private Queue<Cost> initCost(int[][] costs) {
        Queue<Cost> costList = new PriorityQueue<>();
        for (int[] cost : costs) {
            costList.add(new Cost(cost[0], cost[1], cost[2]));
        }
        return costList;
    }
}

class Cost implements Comparable<Cost> {
    int city1;
    int city2;
    int cost;

    public Cost(int city1, int city2, int cost) {
        this.city1 = city1;
        this.city2 = city2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Cost o) {
        return this.cost - o.cost;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "city1=" + city1 +
                ", city2=" + city2 +
                ", cost=" + cost +
                '}';
    }
}