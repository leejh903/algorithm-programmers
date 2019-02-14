package estsoft1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] ranks) {
        int answer = 0;
        Map<Integer, Integer> map = init(ranks);

        for (Integer integer : map.keySet()) {
            if(map.containsKey(integer + 1)) answer += map.get(integer);
        }

        return answer;
    }

    public Map<Integer, Integer> init(int[] ranks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int rank : ranks) {
            int val = map.getOrDefault(rank, 0);
            map.put(rank, val + 1);
        }
        return map;
    }
}