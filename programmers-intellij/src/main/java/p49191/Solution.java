package p49191;

import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;

        boolean[][] m = new boolean[n + 1][n + 1];
        Map<Integer, List<Integer>> map = init(results);

        for (int i = 1; i <= n; i++) {
            boolean[] visit = new boolean[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visit[i] = true;
            while(!queue.isEmpty()) {
                int num = queue.poll();
                List<Integer> list = map.getOrDefault(num, new ArrayList<>());
                for (Integer integer : list) {
                    if(!visit[integer]) {
                        visit[integer] = true;
                        m[i][integer] = true;
                        queue.add(integer);
                    }
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            boolean pass = true;
            for (int j = 1; j < n + 1; j++) {
                if(i != j && !m[i][j] && !m[j][i]) {
                    pass = false;
                    break;
                }
            }
            if(pass) answer++;
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
