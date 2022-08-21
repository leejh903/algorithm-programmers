package l1615;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> link = new HashMap<>();
        for (int[] road : roads) {
            Set<Integer> first = link.getOrDefault(road[0], new HashSet<>());
            first.add(road[1]);
            link.put(road[0], first);

            Set<Integer> second = link.getOrDefault(road[1], new HashSet<>());
            second.add(road[0]);
            link.put(road[1], second);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> iSet = link.getOrDefault(i, new HashSet<>());
                Set<Integer> jSet = link.getOrDefault(j, new HashSet<>());
                int temp = iSet.size() + jSet.size();
                if (iSet.contains(j)) {
                    temp--;
                }
                max = Math.max(max, temp);
            }
        }
        return max;
    }
}
