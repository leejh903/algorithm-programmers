package p42861;

import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Queue<Cost> queue = initCost(costs);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        int node = 0;
        int curIslandCount = n;

        while (node < n - 1) {
            Cost cost = queue.poll();
            int temp = getIslandCount(curIslandCount, n, list, cost);
            if(curIslandCount > temp) {
                curIslandCount = temp;
                answer += cost.cost;
                node++;
            }
        }

        return answer;
    }

    private int getIslandCount(int curIslandCount, int n, List<List<Integer>> list, Cost cost) {
        int city1 = cost.city1;
        int city2 = cost.city2;

        list.get(city1).add(city2);
        list.get(city2).add(city1);

        Queue<Integer> queue = new LinkedList<>();
        int thisIslandCount = 0;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visit[i] == false && list.get(i).size() == 0) {
                visit[i] = true;
                thisIslandCount++;
                continue;
            }
            if(visit[i]) continue;

            visit[i] = true;
            queue.addAll(list.get(i));
            for (Integer integer : list.get(i)) {
                visit[integer] = true;
            }
            while (!queue.isEmpty()) {
                int city = queue.poll();
                for (Integer integer : list.get(city)) {
                    if(!visit[integer]) {
                        visit[integer] = true;
                        queue.add(integer);
                    }
                }
            }
            thisIslandCount++;
        }

        if(curIslandCount == thisIslandCount) {
            list.get(city1).remove(list.get(city1).indexOf(city2));
            list.get(city2).remove(list.get(city2).indexOf(city1));
        }
        return thisIslandCount;
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