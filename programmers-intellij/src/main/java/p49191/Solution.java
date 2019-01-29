package p49191;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;

        int[] m = new int[n + 1];
        Map<Integer, List<Integer>> map = init(results);

        for (int i = 1; i <= n; i++) {
            boolean[] visit = new boolean[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visit[i] = true;
            m[i]++;
            while(!queue.isEmpty()) {
                int num = queue.poll();
                List<Integer> list = map.getOrDefault(num, new ArrayList<>());
                for (Integer integer : list) {
                    if(!visit[integer]) {
                        visit[integer] = true;
                        m[integer]++;
                        queue.add(integer);
                    }
                }
            }
        }

        List<Integer> newList = Arrays.stream(m).boxed().collect(Collectors.toList());
        for (int i = n; i > 0; i--) {
            if(!newList.contains(i)) break;
            answer++;
        }

        return answer;
    }

    public Map<Integer, List<Integer>> init(int[][] result) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] ints : result) {
            List<Integer> list = map.getOrDefault(ints[0], new ArrayList<>());
            list.add(ints[1]);
            map.put(ints[0], list);
        }
        return map;
    }
}
